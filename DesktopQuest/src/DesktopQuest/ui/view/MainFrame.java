package DesktopQuest.ui.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public class MainFrame extends JFrame {

    private DesktopPane desktop;

    private JButton startBtn;

    public MainFrame() {

        //setSize(800,500);
        setTitle("Desktop Quest");
        setMinimumSize(new Dimension(800,600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setVisible(true);
        desktop = new DesktopPane();
        desktop.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setContentPane(desktop);
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if ((e.getNewState() & MAXIMIZED_BOTH) == MAXIMIZED_BOTH){
                    setContentPane(desktop);
                }
                else {
                        JScrollPane content = new JScrollPane(desktop);
                        setContentPane(content);
                }
            }
        });
    }

    public DesktopPane getDesktopPane() {
        return desktop;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

}
