package DesktopQuest.ui.view;

import DesktopQuest.ui.controller.GameItemController;
import DesktopQuest.ui.model.ItemIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BagIntFrame extends JInternalFrame {

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private GameItemController gameItemController;

    public BagIntFrame(){
        title = "My Bag";
        resizable = true;
        closable = true;
        maximizable = false;
        iconable = true;
        setBounds(100, 20, 236, 250);
        setPreferredSize(new Dimension(236, 240));
        setMinimumSize(new Dimension(236,0));
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        initContentPane();
        scrollPane = new JScrollPane(contentPane,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //setContentPane(contentPane);
        setContentPane(scrollPane);
    }

    private void initContentPane() {
        contentPane = new JPanel();
        contentPane.setMinimumSize(new Dimension(236, 210));
        contentPane.setBackground(Color.white);
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public void addItem(String item){
        if (gameItemController != null){
            contentPane.add(gameItemController.getItem(item));
        }
        UpdateContentPanePreferredSize();
    }

    public void addItem(ItemIcon item){
        if (gameItemController != null){
            contentPane.add(item);
        }
        UpdateContentPanePreferredSize();
    }

    private void UpdateContentPanePreferredSize() {
        contentPane.revalidate();
        contentPane.doLayout();
        if (contentPane.getComponentCount()!=0) {
            Component last = contentPane.getComponents()[contentPane.getComponentCount() - 1];
            contentPane.setPreferredSize(new Dimension(236, last.getHeight() + last.getY()));
        }
    }

    public void removeItem(String item){
        for (Component c : contentPane.getComponents()){
            if (c instanceof ItemIcon && (((ItemIcon)c).getGameItem().getName().equals(item))){
                contentPane.remove((ItemIcon)c);
                contentPane.repaint();
                contentPane.revalidate();
                contentPane.doLayout();
                UpdateContentPanePreferredSize();
                break;
            }
        }
    }

    public boolean isIteminBag(String name){
        for (Component c : contentPane.getComponents()){
            if (c instanceof ItemIcon && (((ItemIcon)c).getGameItem().getName().equals(name))){
                return true;
            }
        }
        return false;
    }

    public void setGameItemController(GameItemController gameItemController) {
        this.gameItemController = gameItemController;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }
}
