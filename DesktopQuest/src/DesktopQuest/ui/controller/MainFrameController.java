package DesktopQuest.ui.controller;

import DesktopQuest.ui.model.EventItem;
import DesktopQuest.ui.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainFrameController {


    private MainFrame mainframe;
    private JDesktopPane desktopPane;
    public JInternalFrame Player, MyBag, Status,Events, Help,WorldMap;
    private JButton BagBtn, StatusBtn;
    private PlayerController PlayerCon;
    private StatusController StatCon;
    private EventController EventCon;
    private GameItemController GameCon;

    public MainFrameController() {
        initComponents();
        initListeners();

    }

    public void showMainFrame(){
        mainframe.setVisible(true);
    }

    private void initComponents() {
        mainframe = new MainFrame();
        desktopPane = mainframe.getDesktopPane();
        Player = ((DesktopPane) desktopPane).getPlayer();
        MyBag = ((DesktopPane) desktopPane).getMyBag();
        Status = ((DesktopPane) desktopPane).getStatus();
        Help = ((DesktopPane) desktopPane).getHelp();
        Help.setLocation(mainframe.getWidth()/2-Help.getWidth()/2,mainframe.getHeight()/2-Help.getHeight()/2);
        BagBtn = ((PlayerIntFrame)Player).getBagBtn();
        StatusBtn = ((PlayerIntFrame)Player).getStatusBtn();
        PlayerCon = new PlayerController((PlayerIntFrame) Player);
        StatCon = new StatusController((StatusIntFrame) Status);
        StatCon.setPlayerCon(PlayerCon);
        EventCon = new EventController();
        EventCon.setMainFrameController(this);
        EventCon.setStatusCon(StatCon);
        WorldMap = ((DesktopPane) desktopPane).getWorldMap();
        GameCon = new GameItemController(StatCon, PlayerCon, (BagIntFrame) MyBag);
        StatCon.setGameCon(GameCon);
        ((BagIntFrame)MyBag).setGameItemController(GameCon);
        ((HelpIntFrame)Help).setMainFrameController(this);
        //GameCon.test();

        ((MapIntFrame)WorldMap).setEventCon(EventCon);
        initExit();


    }

    private void initExit() {
        JButton b = ((DesktopPane) desktopPane).getPower().getIconBtn();
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DoQuitGame();
                }
            }
        });
    }


    private void initListeners() {

        BagBtn.addActionListener(new BagBtnListener());
        StatusBtn.addActionListener(new StatusBtnListener());
    }

    private class IntActionListener implements ActionListener {
        private JInternalFrame BindedFrame;
        public IntActionListener(JInternalFrame frame) {
            BindedFrame = frame;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (BindedFrame.isIcon()){
                desktopPane.getDesktopManager().maximizeFrame(BindedFrame);
            }
            else if (!BindedFrame.isVisible()){
                BindedFrame.setVisible(true);
            }
            desktopPane.getDesktopManager().activateFrame(BindedFrame);
    }
    }

    public void DoGameOver(){
        Object[] options = {"Restart","Shut Down"};
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getResource("/fail.png"));
        }catch (Exception ex){}
        final JOptionPane optionPane = new JOptionPane("Game Over.\nYou did not pass all the quests.",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                icon,
                options,options[0]);
        final JDialog dialog = new JDialog(mainframe,"Game Over",true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String prop = evt.getPropertyName();
                if (dialog.isVisible()
                        && (evt.getSource() == optionPane)
                        && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                    //If you were going to check something
                    //before closing the window, you'd do
                    //it here.
                    dialog.setVisible(false);
                }
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(mainframe);
        dialog.setVisible(true);
        Object value = optionPane.getValue();
        if (value == options[0]) {
            mainframe.dispose();
            initComponents();
            initListeners();
            mainframe.setVisible(true);
        }
        else if (value == options[1]){
            System.exit(1);
        };

    }

    public void DoGameWin(){
        Object[] options = {"Restart","Shut Down"};
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getResource("/check32.png"));
        }catch (Exception ex){}
        final JOptionPane optionPane = new JOptionPane("Congratulations,\nyou have completed all quests.\nThank you for playing!",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                icon,
                options,options[0]);
        final JDialog dialog = new JDialog(mainframe,"Quest Completed",true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String prop = evt.getPropertyName();
                if (dialog.isVisible()
                        && (evt.getSource() == optionPane)
                        && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                    //If you were going to check something
                    //before closing the window, you'd do
                    //it here.
                    dialog.setVisible(false);
                }
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(mainframe);
        dialog.setVisible(true);
        Object value = optionPane.getValue();
        if (value == options[0]) {
            mainframe.dispose();
            initComponents();
            initListeners();
            mainframe.setVisible(true);
        }
        else if (value == options[1]){
            System.exit(1);
        };

    }

    public void DoQuitGame(){

        Object[] options = {"Restart","Shut Down"};

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(getClass().getResource("/power.png"));
        }catch (Exception ex){}
        final JOptionPane optionPane = new JOptionPane("Do you want to quit Desktop Quest?",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                icon,
                options,options[1]);
        final JDialog dialog = new JDialog(mainframe,"Quit Game",true);
        dialog.setContentPane(optionPane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        optionPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String prop = evt.getPropertyName();
                if (dialog.isVisible()
                        && (evt.getSource() == optionPane)
                        && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                    //If you were going to check something
                    //before closing the window, you'd do
                    //it here.
                    dialog.setVisible(false);
                }
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(mainframe);
        dialog.setVisible(true);
        Object value = optionPane.getValue();
        if (value == options[0]) {
            mainframe.dispose();
            initComponents();
            initListeners();
            mainframe.setVisible(true);
        }
        else if (value == options[1]){
            System.exit(1);
        };

    }

    private class BagBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (MyBag.isIcon()){
                desktopPane.getDesktopManager().maximizeFrame(MyBag);
            }
            else if (!MyBag.isVisible()){
                MyBag.setVisible(true);
            }
            MyBag.setLocation(Player.getX(),Player.getY()+Player.getHeight());
            desktopPane.getDesktopManager().activateFrame(MyBag);
        }
    }

    private class StatusBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Status.isIcon()){
                desktopPane.getDesktopManager().maximizeFrame(Status);
            }
            else if (!Status.isVisible()){
                Status.setVisible(true);
            }
            Status.setLocation(Player.getX()+Player.getWidth()-Status.getWidth(),Player.getY()+Player.getHeight());
            desktopPane.getDesktopManager().activateFrame(Status);
        }
    }
}
