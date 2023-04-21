package DesktopQuest.ui.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemIcon extends JPanel {
    private ImageIcon imageicon;
    private JButton iconBtn;
    private JPopupMenu popupMenu;
    private GameItem gameItem;

    private String iconname;
    private String iconpath;

    private int width = 50;
    private int height = 50;

    public ItemIcon(GameItem g) {
        setVisible(true);
        setMaximumSize(new Dimension(width,height));
        setMinimumSize(new Dimension(width,height));
        setPreferredSize(new Dimension(width,height));
        gameItem = g;
        iconname = g.getTitle();
        iconpath = g.getPath();
        try {
            imageicon = new ImageIcon(getClass().getResource(iconpath));
            iconBtn = new IconButton(iconname,imageicon);
        }catch (Exception e){
            iconBtn = new IconButton(iconname);
        }
        setLayout(new BorderLayout());
        add(iconBtn);
    }

    private class IconButton extends JButton {

        private IconButton(String text, Icon icon) {
            super(text, icon);
            setForeground(Color.BLACK);
            setFont(new Font("Segoe UI", Font.BOLD, 10));
            setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
            setBorderPainted(false);
            setFocusPainted(false);
            setBackground(Color.WHITE);
            setHorizontalTextPosition(JButton.CENTER);
            setVerticalTextPosition(JButton.BOTTOM);
            setIconTextGap(0);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setToolTipText("<html>Effect:<br>"+gameItem.getEffect()+"</html>");
        }

        private IconButton(String text) {
            super(text);
            setForeground(Color.BLACK);
            setFont(new Font("Segoe UI", Font.PLAIN, 10));
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            setBorderPainted(false);
            setFocusPainted(false);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }
    }

    public JLabel getIcon(){
        JLabel icon;
        try {
            icon = new JLabel(imageicon);
        }catch (Exception e){
            icon = new JLabel(iconname);
        }
        icon.setToolTipText("<html><I>"+ gameItem.getTitle()+"</I><br>Effect:<br>"+gameItem.getEffect()+"</html>");
        return icon;
    }

    public JButton getIconBtn() {
        return iconBtn;
    }

    public JPopupMenu getPopupMenu() {
        return popupMenu;
    }

    public void setPopupMenu(JPopupMenu popupMenu) {
        this.popupMenu = popupMenu;
    }

    public ImageIcon getImageicon() {
        return imageicon;
    }

    public GameItem getGameItem() {
        return gameItem;
    }
}
