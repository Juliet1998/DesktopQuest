package DesktopQuest.ui.view;

import javafx.geometry.Orientation;
import javafx.scene.control.ProgressBar;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class StatusIntFrame extends JInternalFrame{
    private JPanel contentPane;
    private JProgressBar Health, Magic;

    private CustomJProgressBar ExperienceBar;

    private int MaxHP, MaxMP, MaxEXP;

    private int CurHP, CurMP, CurEXP;

    public StatusIntFrame(){
        title = "Status";
        resizable = false;
        closable = true;
        maximizable = false;
        iconable = true;
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int)screensize.getWidth()-200,(int)screensize.getHeight()-300, 200,200);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        initContentPane();
        setContentPane(contentPane);

    }
    private void initContentPane() {
        initHPMP();
        JLabel HP = new JLabel("Health:");
        HP.setAlignmentX(Component.CENTER_ALIGNMENT);
        Health = new JProgressBar(0,MaxHP);
        Health.setValue(CurHP);
        Health.setMaximumSize(new Dimension(600,25));
        Health.setUI(new BasicProgressBarUI(){
            protected Color getSelectionBackground(){return Color.white;}
            protected Color getSelectionForeground() { return Color.white; }
        });
        Health.setBackground(Color.darkGray);
        Health.setForeground(Color.red);
        Health.setString(CurHP + "/" + MaxHP);
        Health.setStringPainted(true);
        JLabel MP = new JLabel("Magic: ");
        MP.setAlignmentX(Component.CENTER_ALIGNMENT);
        Magic = new JProgressBar(0,MaxMP);
        Magic.setValue(CurMP);
        Magic.setBackground(Color.darkGray);
        Magic.setForeground(Color.blue);
        Magic.setString(CurMP + "/" + MaxMP);
        Magic.setStringPainted(true);
        Magic.setMaximumSize(new Dimension(600,25));
        Magic.setUI(new BasicProgressBarUI(){
            protected Color getSelectionBackground(){return Color.white;}
            protected Color getSelectionForeground() { return Color.white; }
        });
        JLabel Experience = new JLabel("Experience/Next Level: ");
        Experience.setAlignmentX(Component.CENTER_ALIGNMENT);
        ExperienceBar = new CustomJProgressBar(new Color(55,144,55));
        ExperienceBar.setMaximumSize(new Dimension(600,25));
        ExperienceBar.setMaximum(MaxEXP);
        ExperienceBar.setValue(CurEXP);
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        contentPane.add(HP);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(Health);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(MP);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(Magic);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(Experience);
        contentPane.add(Box.createRigidArea(new Dimension(0,5)));
        contentPane.add(ExperienceBar);
    }

    private void initHPMP() {
        MaxHP = 12;
        CurHP = 12;
        MaxMP = 10;
        CurMP= 10;
        CurEXP = 0;
        MaxEXP = 50;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public int getMaxMP() {
        return MaxMP;
    }

    public void setMaxMP(int maxMP) {
        MaxMP = maxMP;
    }

    public int getCurHP() {
        return CurHP;
    }

    public void setCurHP(int curHP) {
        CurHP = curHP;
    }

    public int getCurMP() {
        return CurMP;
    }

    public void setCurMP(int curMP) {
        CurMP = curMP;
    }

    public int getMaxEXP() {
        return MaxEXP;
    }

    public void setMaxEXP(int maxEXP) {
        MaxEXP = maxEXP;
    }

    public int getCurEXP() {
        return CurEXP;
    }

    public void setCurEXP(int curEXP) {
        CurEXP = curEXP;
    }

    public JProgressBar getHealthBar() {
        return Health;
    }

    public JProgressBar getMagicBar() {
        return Magic;
    }

    public CustomJProgressBar getExperienceBar() {
        return ExperienceBar;
    }

    public void setExperienceBar(CustomJProgressBar experienceBar) {
        ExperienceBar = experienceBar;
    }
}
