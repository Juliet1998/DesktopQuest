package DesktopQuest.ui.controller;

import DesktopQuest.ui.model.ItemIcon;
import DesktopQuest.ui.view.PlayerIntFrame;

import javax.swing.*;
import java.awt.*;

public class PlayerController {
    
    private PlayerIntFrame player;
    private PlayerIntFrame.EquipmentPane equipmentPane;
    private PlayerIntFrame.SingleEquipPane head, body, foot, lefthand, righthand;
    private PlayerIntFrame.StatePane statepane;
    private PlayerIntFrame.StateLabel Name;
    private PlayerIntFrame.StateLabel Level, Strength, Constitution, Speed;
    private PlayerIntFrame.StateLabel Damage, Defence;
    private PlayerIntFrame.StateLabel Gold, Experience;
    private int [] exp;
    private String [] damage;

    public static int Equipped = 0;
    public static int notEquipped = 1;

    public PlayerController(PlayerIntFrame playerIntFrame) {
        player = playerIntFrame;
        equipmentPane = player.getEquipmentPane();
        head = equipmentPane.getHead();
        lefthand = equipmentPane.getLefthand();
        righthand = equipmentPane.getRighthand();
        body = equipmentPane.getBody();
        foot = equipmentPane.getFoot();
        statepane = player.getStatePane();
        Name = statepane.getLabel();
        Level = statepane.getLevel();
        Strength = statepane.getStrength();
        Constitution = statepane.getConstitution();
        Speed = statepane.getSpeed();
        Damage = statepane.getDamage();
        Defence = statepane.getDefence();
        Gold = statepane.getGold();
        Experience = statepane.getExperience();
        exp = new int[]{0,50,100,150,200,250};
        damage = new String[]{"null","2-4","3-5","6-8","8-10","10-12"};
        
    }

    public void DoLevelup(){
        int level = Level.getIntValue()+1;
        Level.setValue(level);
        Strength.setValue(Strength.getIntValue()+2);
        Constitution.setValue(Constitution.getIntValue()+2);
        Speed.setValue(Speed.getIntValue()+1);
        Damage.setValue(damage[level]);
        Defence.setValue(Defence.getIntValue()+2);
    }

    public boolean isItemEquipped(String item){
        PlayerIntFrame.SingleEquipPane[] Equips = new PlayerIntFrame.SingleEquipPane[]{head,body,foot,lefthand,righthand};
        for (PlayerIntFrame.SingleEquipPane eq :Equips){
            if (eq.getComponentCount() != 0 ){
                JLabel icon = (JLabel) eq.getComponent(0);
                if (icon.getComponentPopupMenu().getName().equals(item)){
                    return true;
                }
            }
        }
        return false;
    }

    public void removeEquipment(String item){
        PlayerIntFrame.SingleEquipPane[] Equips = new PlayerIntFrame.SingleEquipPane[]{head,body,foot,lefthand,righthand};
        for (PlayerIntFrame.SingleEquipPane eq :Equips){
            if (eq.getComponentCount() != 0 ){
                JLabel icon = (JLabel) eq.getComponent(0);
                if (icon.getComponentPopupMenu().getName().equals(item)){
                    Container container = icon.getParent();
                    container.remove(icon);
                    container.repaint();
                    container.doLayout();
                    break;
                }
            }
        }
    }


    public PlayerIntFrame getPlayer() {
        return player;
    }

    public void setPlayer(PlayerIntFrame player) {
        this.player = player;
    }

    public void setName(String name) {
        Name.setValue(name);
    }

    public void setLevel(int level) {
        Level.setValue(level);
    }

    public void setStrength(int strength) {
        Strength.setValue(strength);
    }

    public void setConstitution(int constitution) {
        Constitution.setValue(constitution);
    }

    public void setSpeed(int speed) {
        Speed.setValue(speed);
    }

    public void setDamage(String damage) {
        Damage.setValue(damage);
    }

    public void setDefence(int defence) {
        Defence.setValue(defence);
    }

    public void setGold(int gold) {
        Gold.setValue(gold);
    }

    public void setExperience(int experience) {
        Experience.setValue(experience);
    }

    public int getLevel(){
        return Level.getIntValue();
    }

    public int getMaxExp() {
        return exp[getLevel()];
    }

    public int getExp(){
        return Experience.getIntValue();
    }

    public int getGold() {
        return Gold.getIntValue();
    }

    public int getSpeed() {
        return Speed.getIntValue();
    }

    public int getStrength() {
        return Strength.getIntValue();
    }

    public int getConstitution() {
        return Constitution.getIntValue();
    }

    public JLabel setHead(JLabel head) {
        JLabel icon = null;
        if (this.head.getComponentCount() == 0) {
            this.head.add(head);
        }else {
            icon = (JLabel) this.head.getComponent(0);
            this.head.remove(icon);
            this.head.add(head);
        }
        this.head.repaint();
        this.head.doLayout();
        return icon;
    }

    public JLabel setBody(JLabel body) {
        JLabel icon = null;
        if (this.body.getComponentCount() == 0) {
            this.body.add(body);
        }else {
            icon = (JLabel) this.body.getComponent(0);
            this.body.remove(icon);
            this.body.add(body);
        }
        this.body.repaint();
        this.body.doLayout();
        return icon;
    }

    public JLabel setFoot(JLabel foot) {
        JLabel icon = null;
        if (this.foot.getComponentCount() == 0) {
            this.foot.add(foot);
        }else {
            icon = (JLabel) this.foot.getComponent(0);
            this.foot.remove(icon);
            this.foot.add(foot);
        }
        this.foot.repaint();
        this.foot.doLayout();
        return icon;
    }

    public JLabel setLefthand(JLabel lefthand) {
        JLabel icon = null;
        if (this.lefthand.getComponentCount() == 0) {
            this.lefthand.add(lefthand);
        }else {
            icon = (JLabel) this.lefthand.getComponent(0);
            this.lefthand.remove(icon);
            this.lefthand.add(lefthand);
        }
        this.lefthand.repaint();
        this.lefthand.doLayout();
        return icon;
    }

    public JLabel setRighthand(JLabel righthand) {
        JLabel icon = null;
        if (this.righthand.getComponentCount() == 0) {
            this.righthand.add(righthand);
        }else {
            icon = (JLabel) this.righthand.getComponent(0);
            this.righthand.remove(icon);
            this.righthand.add(righthand);
        }
        this.righthand.repaint();
        this.righthand.doLayout();
        return icon;
    }

}
