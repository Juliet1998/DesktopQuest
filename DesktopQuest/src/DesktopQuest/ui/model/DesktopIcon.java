package DesktopQuest.ui.model;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

public class DesktopIcon extends JPanel{

    private ImageIcon imageicon;
    private JButton iconBtn;

    private String iconname;

    private int width = 100;
    private int height = 100;

    public DesktopIcon(String IconName, String ImagePath){
        //height = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/8.0);
        setVisible(true);
        setMaximumSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setPreferredSize(new Dimension(width,height));
        iconname = IconName;
        try {
            imageicon = new ImageIcon(getClass().getResource(ImagePath));
            iconBtn = new IconButton(iconname,imageicon);
        }catch (Exception e){
            iconBtn = new IconButton(iconname);
        }
        setLayout(new BorderLayout());
        add(iconBtn);
    }

    public void setInternalFrame(JInternalFrame IntF){
        this.iconBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2){
                    if(!IntF.isVisible()){
                        //debugging
                        //iconBtn.setBackground(Color.RED);
                        IntF.setVisible(true);
                    }
                    else if(IntF.isIcon()){
                        //debugging
                        //iconBtn.setBackground(Color.YELLOW);
                        try {
                            IntF.setIcon(false);
                        } catch (java.beans.PropertyVetoException ex) {
                        }
                    }
                    else if(IntF.isVisible()){
                        //debugging
                        //iconBtn.setBackground(Color.BLUE);
                        IntF.moveToFront();
                        try {
                            IntF.setSelected(true);
                        } catch (java.beans.PropertyVetoException ex) {
                        }
                    }
                }
            }
    });

    }

    private class IconButton extends JButton{

        private IconButton(String text, Icon icon) {
            super(text, icon);
            setForeground(Color.WHITE);
            setFont(new Font("Segoe UI",Font.BOLD,12));
            setBackground(new Color(0,78,152));
            setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            setBorderPainted(false);
            setFocusPainted(false);
            setHorizontalTextPosition(JButton.CENTER);
            setVerticalTextPosition(JButton.BOTTOM);
            setIconTextGap(0);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }

        private IconButton(String text) {
            super(text);
            setForeground(Color.WHITE);
            setFont(new Font("Segoe UI",Font.PLAIN,12));
            setBackground(new Color(0,78,152));
            setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            setBorderPainted(false);
            setFocusPainted(false);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }

    }
    public void setIconname(String IconName) {
        this.iconname = IconName;
    }

    public JButton getIconBtn() {
        return iconBtn;
    }

}
