package DesktopQuest.ui.view;

import DesktopQuest.ui.model.ItemIcon;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerIntFrame extends JInternalFrame {

    private JPanel contentPane;
    private JButton Bag, Status;
    private StatePane statePane;
    private EquipmentPane equipmentPane;

    public PlayerIntFrame() {
        title = "Player";
        resizable = false;
        closable = true;
        maximizable = false;
        iconable = true;
        setBounds(20, 20, 300, 250);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        initContentPane();
        setContentPane(contentPane);
    }

    private void initContentPane() {
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        equipmentPane = new EquipmentPane();
        contentPane.add(equipmentPane);
        contentPane.add(Box.createRigidArea(new Dimension(10,0)));
        statePane = new StatePane();
        contentPane.add(statePane);
        contentPane.add(Box.createRigidArea(new Dimension(20,0)));
    }

    public class StatePane extends JPanel {

        private StateLabel Name;
        private StateLabel Level, Strength, Constitution, Speed;
        private StateLabel Damage, Defence;
        private StateLabel Gold, Experience;

        private StatePane(){
            initStateLabels();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            //add(Box.createRigidArea(new Dimension(0,5)));
            add(Name);
            add(new StateLabel("  ----------------  "));
            add(Level);
            add(Strength);
            add(Constitution);
            add(Speed);
            add(new StateLabel("  ----------------  "));
            add(Damage);
            add(Defence);
            add(new StateLabel("  ----------------  "));
            add(Gold);
            add(Experience);

        }

        private void initStateLabels() {
            Name = new StateLabel("Name","Juliet");
            Level = new StateLabel("Level",1);
            Strength = new StateLabel("Strength",5);
            Constitution = new StateLabel("Vitality",5);
            Speed = new StateLabel("Speed",5);
            Damage = new StateLabel("Damage","2-4");
            Defence = new StateLabel("Defence", 2);
            Gold = new StateLabel("Gold", 0);
            Experience = new StateLabel("Experience", 0);
        }

        public StateLabel getLabel() {
            return Name;
        }

        public StateLabel getLevel() {
            return Level;
        }

        public StateLabel getStrength() {
            return Strength;
        }

        public StateLabel getConstitution() {
            return Constitution;
        }

        public StateLabel getSpeed() {
            return Speed;
        }

        public StateLabel getDamage() {
            return Damage;
        }

        public StateLabel getDefence() {
            return Defence;
        }

        public StateLabel getGold() {
            return Gold;
        }

        public StateLabel getExperience() {
            return Experience;
        }
    }

    public class StateLabel extends JLabel{

        private String labelname;
        private int intValue;
        private String strValue;

        private StateLabel (String name, String value) {
            setAlignmentX(Component.RIGHT_ALIGNMENT);
            labelname = name;
            switch (labelname){
                case "Name":
                    setText(String.format("Name:  %s",value));
                    break;
                case "Damage":
                    setText(String.format("Damage:%4s",value));
                    break;
                default:
                    break;
            }
            strValue = value;
        }

        private StateLabel (String name, int value) {
            setAlignmentX(Component.RIGHT_ALIGNMENT);
            labelname = name;
            switch (labelname){
                case "Level":
                    setText(String.format("Level:%4d",value));
                    break;
                case "Strength":
                    setText(String.format("Strength:%4d",value));
                    break;
                case "Vitality":
                    setText(String.format("Vitality:%4d",value));
                    break;
                case "Speed":
                    setText(String.format("Speed:%4d",value));
                    break;
                case "Damage":
                    setText(String.format("Damage:%4d",value));
                    break;
                case "Defence":
                    setText(String.format("Defence:%4d",value));
                    break;
                case "Gold":
                    setText(String.format("Gold:%4d",value));
                    break;
                case "Experience" :
                    setText(String.format("Experience:%4d", value));
                    break;
                default:
                    break;
            }
            intValue = value;
        }

        private StateLabel (String dash){
            setAlignmentX(Component.RIGHT_ALIGNMENT);
            setText(dash);
        }

        public void setValue (String value){
            switch (labelname){
                case "Name":
                    setText(String.format("Name:  %s",value));
                    break;
                case "Damage":
                    setText(String.format("Damage:%4s",value));
                    break;
                default:
                    break;
            }
            strValue = value;
        }

        public void setValue (int value){
            switch (labelname){
                case "Level":
                    setText(String.format("Level:%4d",value));
                    break;
                case "Strength":
                    setText(String.format("Strength:%4d",value));
                    break;
                case "Vitality":
                    setText(String.format("Vitality:%4d",value));
                    break;
                case "Speed":
                    setText(String.format("Speed:%4d",value));
                    break;
                case "Damage":
                    setText(String.format("Damage:%4d",value));
                    break;
                case "Defence":
                    setText(String.format("Defence:%4d",value));
                    break;
                case "Gold":
                    setText(String.format("Gold:%4d",value));
                    break;
                case "Experience" :
                    setText(String.format("Experience:%4d", value));
                    break;
                default:
                    break;
            }

            intValue = value;
        }

        public int getIntValue() {
            return intValue;
        }

        public String getStrValue() {
            return strValue;
        }
    }
    public class EquipmentPane extends JPanel{

        private JPanel EquipsPane, BtnPane;
        private SingleEquipPane head, body, foot, lefthand, righthand;

        private EquipmentPane(){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            initEquipsPane();
            add(EquipsPane);
            initBtnPane();
            //add(Box.createRigidArea(new Dimension(0,5)));
            add(BtnPane);
            add(Box.createRigidArea(new Dimension(0,10)));
        }

        private void initEquipsPane() {
            EquipsPane = new JPanel();
            EquipsPane.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            SingleEquipPane Equip;
            head = new SingleEquipPane();
            c.fill = GridBagConstraints.HORIZONTAL;
            c.insets = new Insets(5,5,5,5);
            c.gridx = 1;
            c.gridy = 0;
            EquipsPane.add(head,c);

            lefthand = new SingleEquipPane();
            c.gridx = 0;
            c.gridy = 1;
            //c.insets = new Insets(0,0,0,0);
            EquipsPane.add(lefthand,c);

            body = new SingleEquipPane();
            c.gridx = 1;
            c.gridy = 1;
            //c.insets = new Insets(10,10,10,10);
            EquipsPane.add(body,c);

            righthand = new SingleEquipPane();
            c.gridx = 2;
            c.gridy = 1;
            //c.insets = new Insets(0,0,0,0);
            EquipsPane.add(righthand,c);

            foot = new SingleEquipPane();
            c.gridx = 1;
            c.gridy = 2;
            //c.insets = new Insets(10,0,0,0);
            EquipsPane.add(foot,c);

            //EquipsPane.setBorder(new LineBorder(Color.black));
        }

        private void initBtnPane() {
            BtnPane = new JPanel();
            Bag = new JButton("Bag");
            Bag.setFocusPainted(false);
            Bag.setMinimumSize(new Dimension(70,25));
            Bag.setPreferredSize(new Dimension(70,25));
            Bag.setMaximumSize(new Dimension(70,25));
            Status = new JButton("Status");
            Status.setFocusPainted(false);
            BtnPane.setLayout(new BoxLayout(BtnPane, BoxLayout.X_AXIS));
            BtnPane.add(Bag);
            BtnPane.add(Box.createRigidArea(new Dimension(10,0)));
            BtnPane.add(Status);
        }

        public SingleEquipPane getHead() {
            return head;
        }

        public SingleEquipPane getBody() {
            return body;
        }

        public SingleEquipPane getFoot() {
            return foot;
        }

        public SingleEquipPane getLefthand() {
            return lefthand;
        }

        public SingleEquipPane getRighthand() {
            return righthand;
        }
    }


    public class SingleEquipPane extends JPanel {

        private int width = 45;
        private int height = 45;

        private SingleEquipPane(){
            setBorder(BorderFactory.createLoweredBevelBorder());
            setPreferredSize(new Dimension(width,height));
            setMinimumSize(new Dimension(width,height));
            setMaximumSize(new Dimension(width,height));
        }
    }

    public EquipmentPane getEquipmentPane() {
        return equipmentPane;
    }

    public StatePane getStatePane() {
        return statePane;
    }

    public JButton getBagBtn() {
        return Bag;
    }

    public JButton getStatusBtn() {
        return Status;
    }
}
