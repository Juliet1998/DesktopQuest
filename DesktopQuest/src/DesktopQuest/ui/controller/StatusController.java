package DesktopQuest.ui.controller;

import DesktopQuest.ui.model.EventItem;
import DesktopQuest.ui.view.CustomJProgressBar;
import DesktopQuest.ui.view.StatusIntFrame;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class StatusController {

    private StatusIntFrame statusframe;

    private JProgressBar HealthBar, MagicBar;
    private CustomJProgressBar ExperienceBar;
    public Boolean isGameOver;
    private PlayerController playerCon;
    private GameItemController gameCon;
    private int[] HPgrowth;
    private int[] MPgrowth;


    public StatusController(StatusIntFrame Statusframe) {
        this.statusframe = Statusframe;
        HealthBar = statusframe.getHealthBar();
        MagicBar = statusframe.getMagicBar();
        ExperienceBar = statusframe.getExperienceBar();
        isGameOver = false;
        HPgrowth = new int[]{0,3,5,7,9};
        MPgrowth = new int[]{0,2,2,2,2};
    }

    public String DoEventResult(String[] result){
        String faillog = null;
        switch (result[0]){
            case "HP":
                setCurHealth(statusframe.getCurHP()+Integer.valueOf(result[1]));
                isGameOver = isGameover();
                break;
            case "MP":
                int mp = statusframe.getCurMP()+Integer.valueOf(result[1]);
                if (mp < 0){
                    faillog = "You don't have enough magic.";
                }else {
                    setCurMagic(statusframe.getCurMP() + Integer.valueOf(result[1]));
                }
                break;
            case "EXP":
                AddExperience(Integer.valueOf(result[1]));
                break;
            case "GOLD":
                playerCon.setGold(playerCon.getGold()+Integer.valueOf(result[1]));
                break;
            case "ITEM":
                if (result.length == 2) {
                    String i = result[1];
                    gameCon.addItemtoBag(i);
                }else if (result.length > 2){
                    Random rand = new Random();
                    int index = rand.nextInt(result.length-1)+1;
                    gameCon.addItemtoBag(result[index]);
                }
                break;
            case "ITEMST":
                //Items set if choose item advantage
                gameCon.addItemtoBag("coffee");
                gameCon.addItemtoBag("tea");
                gameCon.addItemtoBag("key");
                break;
            case "ITEMR":
                //random item
                int num2 = Integer.valueOf(result[1]);
                for (int k = 0; k<num2; k++) {
                    gameCon.addItemtoBag(gameCon.getConsumable());
                }
                break;
            case "EQUI":
                //random equipment
                int num = Integer.valueOf(result[1]);
                for (int k = 0; k<num; k++) {
                    gameCon.addItemtoBag(gameCon.getEquipment());
                }
                break;
            case "CHECK":
                String item = result[1];
                if (gameCon.isIteminBag(item)){
                    gameCon.removeItem(item);
                }else if (gameCon.isItemEquipped(item)){
                    gameCon.removeEquipment(item);
                }else {
                    String itemname = gameCon.getItem(item).getGameItem().getTitle();
                    faillog = "You don't have a " + itemname + ".";
                }
                //additional reword
                if (result.length >3 && faillog == null){
                    String[] reword = new String[]{};
                    reword  = Arrays.copyOfRange(result,2,result.length);
                    DoEventResult(reword);
                }
                break;
            case "BUY":
                int price = Integer.valueOf(result[1]);
                if (playerCon.getGold() < price){
                    faillog = "You don't have enough money.";
                }else {
                    playerCon.setGold(playerCon.getGold()-price);
                    gameCon.addItemtoBag(result[2]);
                    faillog = null;
                }
                break;
            case "SAVE":
                String state = result[1];
                switch (state){
                    case "STRG":
                        if (playerCon.getStrength() < Integer.valueOf(result[2])){
                            DoEventResult(new String[]{result[3],result[4]});
                            faillog = "Your don't have enough Strength.\nYou take "+ (Integer.valueOf(result[4])*-1) + " damage from the action.";
                        }
                        break;
                    case "CONST":
                        if (playerCon.getConstitution() < Integer.valueOf(result[2])){
                            DoEventResult(new String[]{result[3],result[4]});
                            faillog = "Your don't have enough Vitality.\nYou take "+ (Integer.valueOf(result[4])*-1) + " damage from the action.";
                        }
                        break;
                    case "SPEED":
                        if (playerCon.getSpeed() < Integer.valueOf(result[2])){
                            DoEventResult(new String[]{result[3],result[4]});
                            faillog = "Your don't have enough Speed.\nYou take "+ (Integer.valueOf(result[4])*-1) + " damage from the action.";
                        }
                        break;
                    default:
                        break;
                }
                if (!isGameOver) {
                    if (result.length > 5) {
                        DoEventResult(new String[]{result[5], result[6]});
                        if (faillog != null)
                            faillog += "\nYou still get some rewards from the sacrifice.";
                    }
                    if (result.length > 7) {
                        DoEventResult(new String[]{result[7], result[8]});
                    }
                }
                break;
            default:
                break;
        }
        statusframe.repaint();
        return faillog;
    }

    public Boolean isGameover(){
        if (statusframe.getCurHP() <= 0){
            return true;
        }else {
            return false;
        }
    }

    public void setCurHealth(int curHP){
        statusframe.setCurHP(curHP);
        HealthBar.setValue(curHP);
        if (curHP <= 0) {curHP = 0;}
        HealthBar.setString(curHP + "/" + statusframe.getMaxHP());
    }

    public void setMaxHealth(int maxHP){
        statusframe.setMaxHP(maxHP);
        statusframe.setCurHP(maxHP);
        HealthBar.setMaximum(maxHP);
        HealthBar.setValue(maxHP);
        HealthBar.setString(maxHP + "/" + maxHP);
    }

    public void setMHP(int maxHP){
        statusframe.setMaxHP(maxHP);
        HealthBar.setMaximum(maxHP);
        if (statusframe.getCurHP() > maxHP) {
            statusframe.setCurHP(maxHP);
        }
        HealthBar.setString(statusframe.getCurHP() + "/" + maxHP);
    }

    public void setCurMagic(int curMP){
        statusframe.setCurMP(curMP);
        MagicBar.setValue(curMP);
        if (curMP <= 0) {curMP = 0;}
        MagicBar.setString(curMP + "/" + statusframe.getMaxMP());
    }

    public void setMaxMagic(int maxMP){
        statusframe.setMaxMP(maxMP);
        statusframe.setCurMP(maxMP);
        MagicBar.setMaximum(maxMP);
        MagicBar.setValue(maxMP);
        MagicBar.setString(maxMP + "/" + maxMP);
    }

    public void setMMP(int maxMP){
        statusframe.setMaxMP(maxMP);
        MagicBar.setMaximum(maxMP);
        if (statusframe.getCurMP() > maxMP) {
            statusframe.setCurMP(maxMP);
        }
        MagicBar.setString(statusframe.getCurMP() + "/" + maxMP);
    }



    public void setExperienceBar(int value){
        ExperienceBar.setValue(value);
    }

    public void AddExperience(int value){
        if(ExperienceBar.getValue()+ value > ExperienceBar.getMaximum()){
            ExperienceBar.setValue(ExperienceBar.getValue()+ value - ExperienceBar.getMaximum());
            playerCon.DoLevelup();
            ExperienceBar.setMaximum(playerCon.getMaxExp());
            setMaxHealth(HealthBar.getMaximum()+HPgrowth[playerCon.getLevel()]);
            setMaxMagic(MagicBar.getMaximum()+MPgrowth[playerCon.getLevel()]);

        }else ExperienceBar.setValue(ExperienceBar.getValue()+ value);
        if (playerCon != null){playerCon.setExperience(playerCon.getExp()+ value);}
    }

    public StatusIntFrame getStatusframe() {
        return statusframe;
    }

    public void setPlayerCon(PlayerController playerCon) {
        this.playerCon = playerCon;
    }

    public GameItemController getGameCon() {
        return gameCon;
    }

    public void setGameCon(GameItemController gameCon) {
        this.gameCon = gameCon;
    }
}
