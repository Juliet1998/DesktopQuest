package DesktopQuest.ui.controller;

import DesktopQuest.ui.model.GameItem;
import DesktopQuest.ui.model.ItemIcon;
import DesktopQuest.ui.view.BagIntFrame;
import DesktopQuest.ui.view.MainFrame;
import DesktopQuest.ui.view.StatusIntFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GameItemController {

    private StatusController statusController;
    private PlayerController playerController;
    private BagIntFrame bagIntFrame;
    private HashMap<String, GameItem> itemDictionary;
    private ArrayList<String> Equipmentlist;

    public GameItemController(StatusController statusController, PlayerController playerController, BagIntFrame bagIntFrame) {
        this.statusController = statusController;
        this.playerController = playerController;
        this.bagIntFrame = bagIntFrame;
        itemDictionary = new HashMap<String, GameItem>();
        FillGameItems();
        Equipmentlist = new ArrayList<String>();
        for (String key : itemDictionary.keySet()){
            if (itemDictionary.get(key).getType() == GameItem.EQUIPMENT){
                Equipmentlist.add(key);
            }
        }
    }

    private void FillGameItems() {
        GameItem gameItem = new GameItem("java");
        gameItem.setPath("/Java.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("\"Coffee\"");
        gameItem.setEffect("On equip, +5 Max Magic");
        gameItem.setDescription("A cup of \"coffee\", but is it really just coffee?");
        gameItem.setAction(new String[]{"MMP","5"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("bread");
        gameItem.setPath("/bread.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Bread");
        gameItem.setEffect("On equip, +5 Strength.");
        gameItem.setDescription("A French Baguette that is too hard to eat.");
        gameItem.setAction(new String[]{"STRG","5"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("mouse");
        gameItem.setPath("/mouse.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Mouse");
        gameItem.setEffect("On equip, +5 Speed.");
        gameItem.setDescription("A Mouse. Another \"You\" on the desktop.");
        gameItem.setAction(new String[]{"SPEED","5"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("shield");
        gameItem.setPath("/protect.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Shield");
        gameItem.setEffect("On equip, +10 Vitality.");
        gameItem.setDescription("A solid, durable shield that protects not only your computer, but you.");
        gameItem.setAction(new String[]{"CONST","10"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("CD");
        gameItem.setPath("/cd.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("CD");
        gameItem.setEffect("On equip, +10 Strength.");
        gameItem.setDescription("A metal circle donut. Cut things without mercy.");
        gameItem.setAction(new String[]{"STRG","10"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("Search");
        gameItem.setPath("/search.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Search");
        gameItem.setEffect("On equip, +10 Speed.");
        gameItem.setDescription("Whenever you need to find something.");
        gameItem.setAction(new String[]{"SPEED","10"});
        gameItem.setEquiplist(new String[]{gameItem.LEFTHAND,gameItem.RIGHTHAND});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("python");
        gameItem.setPath("/python.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("python");
        gameItem.setEffect("On equip, +5 Max Health");
        gameItem.setDescription("Two different types of snakes entangled together, however compatible.");
        gameItem.setEquiplist(new String[]{gameItem.BODY});
        gameItem.setAction(new String[]{"MHP","5"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("battery");
        gameItem.setPath("/battery.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Battery");
        gameItem.setEffect("On equip, +5 Vitality.");
        gameItem.setDescription("A battery. Let things stay longer.");
        gameItem.setEquiplist(new String[]{gameItem.BODY});
        gameItem.setAction(new String[]{"CONST","5"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("boot");
        gameItem.setPath("/boot.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Boots");
        gameItem.setEffect("On equip, +3 Speed.");
        gameItem.setDescription("A boot drive that lets you move faster, literally.");
        gameItem.setEquiplist(new String[]{gameItem.FEET});
        gameItem.setAction(new String[]{"SPEED","3"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("flip");
        gameItem.setPath("/flip.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Flip-flop");
        gameItem.setEffect("On equip, +3 Strength.");
        gameItem.setDescription("This might not be the flip-flop you think of, but you can still wear it because of metaphor.");
        gameItem.setEquiplist(new String[]{gameItem.FEET});
        gameItem.setAction(new String[]{"STRG","3"});
        itemDictionary.put(gameItem.getName(),gameItem);


        gameItem = new GameItem("ios");
        gameItem.setPath("/apple.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("IOS");
        gameItem.setEffect("On equip, +2 Vitality.");
        gameItem.setDescription("An apple with a bite on it, which is commonly recognized as \"IOS\" for some reason.");
        gameItem.setEquiplist(new String[]{gameItem.HEAD});
        gameItem.setAction(new String[]{"CONST","2"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("can");
        gameItem.setPath("/trash.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("Recycle Bin");
        gameItem.setEffect("On equip, +8 Vitality.");
        gameItem.setDescription("A Recycle Bin, physically. Provides the best protection of your head.");
        gameItem.setEquiplist(new String[]{gameItem.HEAD});
        gameItem.setAction(new String[]{"CONST","8"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("tea");
        gameItem.setPath("/tea.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setTitle("Tea");
        gameItem.setEffect("On use, restore 5 Magic Points.");
        gameItem.setDescription("A cup of hot green tea. Drink it can restore your magical power.");
        gameItem.setAction(new String[]{"MP","5"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("coffee");
        gameItem.setPath("/Coffee.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setTitle("Coffee");
        gameItem.setEffect("On use, restore 10 Health Points.");
        gameItem.setDescription("A cup of coffee. Drink it can restore your health.");
        gameItem.setAction(new String[]{"HP","5"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("donut");
        gameItem.setPath("/donuts.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setTitle("Donuts");
        gameItem.setEffect("On use, restore 10 Health Points and 5 Magic Points.");
        gameItem.setDescription("Two sweet, delicious donuts.Restore both health and magic.");
        gameItem.setAction(new String[]{"HMP","10"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("key");
        gameItem.setPath("/key.png");
        gameItem.setTitle("Key");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setEffect("Used in event to open a locked door.");
        gameItem.setDescription("An enter key, take it literally. Can be used to open a locked door.");
        gameItem.setAction(new String[]{"null","null"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("check");
        gameItem.setPath("/check.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setTitle("Check");
        gameItem.setEffect("On use, gain 50 gold.");
        gameItem.setDescription("A more modern and safe way to store your money.");
        gameItem.setAction(new String[]{"GOLD","50"});
        itemDictionary.put(gameItem.getName(),gameItem);

        gameItem = new GameItem("SSD");
        gameItem.setPath("/SSD.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setEffect("On use, gain 50 experiences.");
        gameItem.setDescription("A solid-state drive that uses integrated circuit assemblies as memory.\nProvide better performances.");
        gameItem.setAction(new String[]{"EXP","50"});
        itemDictionary.put(gameItem.getName(),gameItem);

    }

    public ItemIcon getWindows95(){
        GameItem gameItem = new GameItem("win95");
        gameItem.setPath("/windows95.png");
        gameItem.setType(gameItem.CONSUME);
        gameItem.setTitle("Win95");
        gameItem.setEffect("On use, you become a windows 95 user.");
        gameItem.setDescription("The old golden classic windows 95. Aww.\nThis item can not be deleted.");
        gameItem.setAction(new String[]{"WIN95","null"});
        ItemIcon win95 = fillaitem(gameItem);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem view = new JMenuItem("View");
        String details = createDetail(gameItem);
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(win95,
                            details,
                            "Item Details",
                            JOptionPane.INFORMATION_MESSAGE,
                            win95.getImageicon());
                }
            });
        JMenuItem use = new JMenuItem("Use");
        use.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Container container = win95.getParent();
                container.remove(win95);
                container.repaint();
                container.revalidate();
                container.doLayout();
            }
        });
        popupMenu.add(use);
        popupMenu.add(view);
        win95.setPopupMenu(popupMenu);
        win95.setComponentPopupMenu(popupMenu);
        return win95;
    }

    public ItemIcon getpaperclip() {
        GameItem gameItem = new GameItem("clip");
        gameItem.setPath("/clip.png");
        gameItem.setType(gameItem.EQUIPMENT);
        gameItem.setTitle("YouKnowWho");
        gameItem.setEffect("You know what it does.");
        gameItem.setDescription("Do so at your own cost.\nThis Item cannot be deleted.");
        gameItem.setAction(new String[]{"CLIP", "null"});
        gameItem.setEquiplist(new String[]{GameItem.BODY});
        ItemIcon clip = fillaitem(gameItem);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem view = new JMenuItem("View");
        String details = createDetail(gameItem);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(clip,
                        details,
                        "Item Details",
                        JOptionPane.INFORMATION_MESSAGE,
                        clip.getImageicon());
            }
        });
        JMenuItem equip = new JMenuItem("Equip");
        equip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container container = clip.getParent();
                container.remove(clip);
                container.repaint();
                container.revalidate();
                container.doLayout();
            }
        });
        popupMenu.add(equip);
        popupMenu.add(view);
        clip.setPopupMenu(popupMenu);
        clip.setComponentPopupMenu(popupMenu);
        return clip;
    }

    public ItemIcon getItem(String name){
        if (itemDictionary.get(name) != null) {
            return fillaitem(itemDictionary.get(name));
        }
        else
            return null;
    }

    public void removeItem(String item){
        bagIntFrame.removeItem(item);
    }

    public boolean isIteminBag(String item){
        return bagIntFrame.isIteminBag(item);
    }

    public void removeEquipment(String item){
        playerController.removeEquipment(item);
    }

    public boolean isItemEquipped(String item){
        return playerController.isItemEquipped(item);
    }

    private ItemIcon fillaitem(GameItem gameItem) {
        ItemIcon itemIcon = new ItemIcon(gameItem);
        JButton button = itemIcon.getIconBtn();
        PopupMenu popupMenu = new PopupMenu(itemIcon);
        itemIcon.setPopupMenu(popupMenu);
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2){
                    String details = createDetail(gameItem);
                    JOptionPane.showMessageDialog(itemIcon,
                            details,
                            "Item Details",
                            JOptionPane.INFORMATION_MESSAGE,
                            itemIcon.getImageicon());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()){
                    itemIcon.getPopupMenu().show(button,e.getX(),e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()){
                    itemIcon.getPopupMenu().show(button,e.getX(),e.getY());
                }
            }
        });
        return itemIcon;
    }

    public void DoItemEffect(String[] action){
        
        switch (action[0]){
            case "HP":
                int totalhp = Statusframe().getCurHP()+Integer.valueOf(action[1]);
                if (totalhp > Statusframe().getMaxHP()) {
                    totalhp = Statusframe().getMaxHP();
                }
                statusController.setCurHealth(totalhp);
                break;
            case "MP":
                int totalmp = Statusframe().getCurMP()+Integer.valueOf(action[1]);
                if (totalmp > Statusframe().getMaxMP()) {
                    totalmp = Statusframe().getMaxMP();
                }
                statusController.setCurMagic(totalmp);
                break;
            case "HMP":
                int t = Statusframe().getCurHP()+ 10;
                if (t > Statusframe().getMaxHP()) {
                    t = Statusframe().getMaxHP();
                }
                int m = Statusframe().getCurMP()+ 5;
                if (m > Statusframe().getMaxMP()) {
                    m = Statusframe().getMaxMP();
                }
                statusController.setCurMagic(m);
                statusController.setCurHealth(t);
                break;
            case "EXP":
                statusController.AddExperience(Integer.valueOf(action[1]));
                break;
            case "MHP":
                statusController.setMHP(Statusframe().getMaxHP()+Integer.valueOf(action[1]));
                break;
            case "MMP":
                statusController.setMMP(Statusframe().getMaxMP()+Integer.valueOf(action[1]));
                break;
            case "GOLD":
                playerController.setGold(playerController.getGold()+Integer.valueOf(action[1]));
                playerController.setGold(playerController.getGold()+Integer.valueOf(action[1]));
                break;
            case "STRG":
                playerController.setStrength(playerController.getStrength()+Integer.valueOf(action[1]));
                break;
            case "SPEED":
                playerController.setSpeed(playerController.getSpeed()+Integer.valueOf(action[1]));
                break;
            case "CONST":
                playerController.setConstitution(playerController.getConstitution()+Integer.valueOf(action[1]));
                break;
            default:
                break;
        }
        Statusframe().repaint();

    }

    public void DoUnequipEffect(String[] action){

        switch (action[0]){
            case "MHP":
                statusController.setMHP(Statusframe().getMaxHP()-Integer.valueOf(action[1]));
                break;
            case "MMP":
                statusController.setMMP(Statusframe().getMaxMP()-Integer.valueOf(action[1]));
                break;
            case "STRG":
                playerController.setStrength(playerController.getStrength()-Integer.valueOf(action[1]));
                break;
            case "SPEED":
                playerController.setSpeed(playerController.getSpeed()- Integer.valueOf(action[1]));
                break;
            case "CONST":
                playerController.setConstitution(playerController.getConstitution() - Integer.valueOf(action[1]));
                break;
            default:
                break;
        }
        Statusframe().repaint();

    }

    public void test(){
        for (String key : itemDictionary.keySet()){
            addItemtoBag(key);
        }
        bagIntFrame.addItem(getWindows95());
        bagIntFrame.addItem(getpaperclip());
    }

    public void addItemtoBag(String item){
        if (item.equals("win95")){
            bagIntFrame.addItem(getWindows95());
        }else if (item.equals("clip")){
            bagIntFrame.addItem(getpaperclip());
        }else {
            bagIntFrame.addItem(item);
        }
    }

    private StatusIntFrame Statusframe() {
        return statusController.getStatusframe();
    }

    private class PopupMenu extends JPopupMenu {
        JMenuItem view, use, equip, delete;
        GameItem gameItem ;

        public PopupMenu(ItemIcon itemIcon) {
            gameItem = itemIcon.getGameItem();
            view = new JMenuItem("View");
            String details = createDetail(gameItem);
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(itemIcon,
                            details,
                            "Item Details",
                            JOptionPane.INFORMATION_MESSAGE,
                            itemIcon.getImageicon());
                }
            });
            if (gameItem.getType() == gameItem.EQUIPMENT){
                equip = new JMenu("Equip");
                JMenuItem subitem;
                for (String type : gameItem.getEquiplist()) {
                    subitem  = new JMenuItem(type);
                    subitem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JLabel icon = itemIcon.getIcon();
                            UnequipPopup PopupMenu = new UnequipPopup(itemIcon, icon);
                            icon.setComponentPopupMenu(PopupMenu);
                            JLabel returnedIcon = null;
                            switch (type){
                                case "Head":
                                    returnedIcon = playerController.setHead(icon);
                                    break;
                                case "Body":
                                    returnedIcon = playerController.setBody(icon);
                                    break;
                                case "Feet":
                                    returnedIcon = playerController.setFoot(icon);
                                    break;
                                case "Left Hand":
                                    returnedIcon = playerController.setLefthand(icon);
                                    break;
                                case "Right Hand":
                                    returnedIcon = playerController.setRighthand(icon);
                                    break;
                                default:
                                    break;
                            }
                            DoItemEffect(gameItem.getAction());
                            Container container = itemIcon.getParent();
                            container.remove(itemIcon);
                            if (returnedIcon != null) {
                                container.add(getItem(returnedIcon.getComponentPopupMenu().getName()));
                                DoUnequipEffect(((UnequipPopup)returnedIcon.getComponentPopupMenu()).getGameItem().getAction());
                            }
                            container.repaint();
                            container.revalidate();
                            container.doLayout();
                        }
                    });
                    equip.add(subitem);
                }
                add(equip);
            }else if (gameItem.getType() == gameItem.CONSUME) {
                use = new JMenuItem("Use");
                use.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DoItemEffect(gameItem.getAction());
                        if (gameItem.getAction()[0].equals("null")) {
                            //do nothing
                        } else {
                            Container container = itemIcon.getParent();
                            container.remove(itemIcon);
                            container.repaint();
                            container.revalidate();
                            container.doLayout();
                        }
                    }
                });
                add(use);
            }

            delete = new JMenuItem("Delete");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Container container = itemIcon.getParent();
                    container.remove(itemIcon);
                    container.repaint();
                    container.doLayout();
                }
            });
            add(view);
            add(delete);
        }


    }
    private String createDetail(GameItem gameItem){
        String detail = gameItem.getTitle() + "\n";
        if (gameItem.getType() == gameItem.CONSUME) {
            detail += "Type:\nConsumable. Right click to use.\n";
        }else if (gameItem.getType() == gameItem.EQUIPMENT){
            detail += "Type:\nEquipment. Right click to equip.\n";
        }
        detail += "Effect:\n" + gameItem.getEffect() + "\n";
        detail += "Description:\n" + gameItem.getDescription() + "\n";
        return detail;
    }
    private class UnequipPopup extends JPopupMenu {

        JMenuItem unequip;
        GameItem gameItem;
        ItemIcon itemIcon;
        private String name;
        public UnequipPopup(ItemIcon i, JLabel l) {
            itemIcon = i;
            gameItem = itemIcon.getGameItem();
            name = gameItem.getName();
            unequip = new JMenuItem("Unequip");
            unequip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bagIntFrame.addItem(name);
                    bagIntFrame.getContentPane().repaint();
                    bagIntFrame.getContentPane().revalidate();
                    bagIntFrame.getContentPane().doLayout();
                    DoUnequipEffect(gameItem.getAction());
                    Container container = l.getParent();
                    container.remove(l);
                    container.repaint();
                    container.doLayout();
                }
            });
            add(unequip);

        }

        @Override
        public String getName() {
            return name;
        }

        public GameItem getGameItem() {
            return gameItem;
        }

    }
    public String getConsumable(){
        ArrayList<String> Itemlist = new ArrayList<String>();
        for (String key : itemDictionary.keySet()){
            if (itemDictionary.get(key).getType() == GameItem.CONSUME){
                Itemlist.add(key);
            }
        }
        Random rand = new Random();
        String item = Itemlist.get(rand.nextInt(Itemlist.size()));
        return item;
    }

    public String getEquipment(){
        Random rand = new Random();
        String item = Equipmentlist.get(rand.nextInt(Equipmentlist.size()));
        String type = itemDictionary.get(item).getEquiplist()[0];
        if (type.equals(GameItem.HEAD) || type.equals(GameItem.BODY) || type.equals(GameItem.FEET)) {
            Equipmentlist.remove(item);
        }
        return item;
    }
}
