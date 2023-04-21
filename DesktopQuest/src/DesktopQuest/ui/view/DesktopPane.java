package DesktopQuest.ui.view;

import DesktopQuest.ui.model.DesktopIcon;

import javax.swing.*;
import javax.swing.plaf.DesktopIconUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.MouseMotionListener;

public class DesktopPane extends JDesktopPane {

    private JInternalFrame Player;
    private JInternalFrame MyBag;
    private JInternalFrame Status;

    private JInternalFrame Events;
    private JInternalFrame Help;

    private JInternalFrame WorldMap;
    private JInternalFrame Shop;
    private DesktopIcon power;

    public DesktopPane(){
        setBackground(new Color(0,78,152));
        Player = new PlayerIntFrame();
        MyBag = new BagIntFrame();
        Status = new StatusIntFrame();
        Help = new HelpIntFrame();
        WorldMap = new MapIntFrame();

        DesktopIcon i = CreateDesktopIcon("Status","/computer.png");
        LinkIconFrame(i,Status,"/computer16.png");
        i.setBounds(20,20,90,90);
        add(i);
        i = CreateDesktopIcon("Player","/User.png");
        LinkIconFrame(i,Player,"/User16.png");
        i.setBounds(20,120,90,90);
        add(i);
        i = CreateDesktopIcon("Inventory","/item.png");
        LinkIconFrame(i,MyBag,"/item16.png");
        i.setBounds(20,220,90,90);
        add(i);
        i = CreateDesktopIcon("World Browser","/world.png");
        LinkIconFrame(i,WorldMap,"/world16.png");
        i.setBounds(20,320,90,90);
        add(i);
        i = CreateDesktopIcon("Help","/help.png");
        LinkIconFrame(i,Help,"/help16.png");
        i.setBounds(20,420,90,90);
        add(i);
        add(Player);
        Player.setVisible(false);
        add(MyBag);
        MyBag.setVisible(false);
        add(Status);
        Status.setVisible(false);
        add(Help);
        add(WorldMap);
        WorldMap.setVisible(false);
        power = new DesktopIcon("Power","/power.png");
        power.setBounds(20,520,90,90);
        add(power);
        setDesktopManager(new DefaultDesktopManager(){
            @Override
            public void iconifyFrame(JInternalFrame f) {
                JInternalFrame.JDesktopIcon desktopIcon = f.getDesktopIcon();
                //DesktopIconUI ui = desktopIcon.getUI().;
                super.iconifyFrame(f);

            }

            @Override
            public void beginDraggingFrame(JComponent f) {
                if (f instanceof JInternalFrame.JDesktopIcon){
                    //do nothing
                }else {
                    super.beginDraggingFrame(f);
                }
            }

            @Override
            public void dragFrame(JComponent f, int newX, int newY) {
                if (f instanceof JInternalFrame.JDesktopIcon){
                    //do nothing
                }else {
                    super.dragFrame(f, newX, newY);
                }
            }

            @Override
            public void endDraggingFrame(JComponent f) {
                if (f instanceof JInternalFrame.JDesktopIcon){
                        //do nothing
                    }else {
                    super.endDraggingFrame(f);
                }
            }
        });
    }

    private DesktopIcon CreateDesktopIcon(String name, String ImagePath) {
        return new DesktopIcon(name,ImagePath);
    }

    private void LinkIconFrame(DesktopIcon icon, JInternalFrame frame, String frameIcon) {
        icon.setInternalFrame(frame);
        try {
            frame.setFrameIcon(new ImageIcon(getClass().getResource(frameIcon)));
        }catch (Exception e){}

    }


    public JInternalFrame getPlayer() {
        return Player;
    }

    public JInternalFrame getMyBag() {
        return MyBag;
    }

    public JInternalFrame getStatus() {
        return Status;
    }

    public JInternalFrame getEvents() {
        return Events;
    }

    public JInternalFrame getHelp() {
        return Help;
    }

    public JInternalFrame getWorldMap() {
        return WorldMap;
    }

    public JInternalFrame getShop() {
        return Shop;
    }

    public DesktopIcon getPower() {
        return power;
    }
}
