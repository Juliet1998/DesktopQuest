package DesktopQuest;

import DesktopQuest.ui.controller.MainFrameController;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Runner {
    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch (Exception ex){
            System.out.print("Cannot get Theme" + ex.getMessage());
        }
        MainFrameController mainFrameController = new MainFrameController();
        mainFrameController.showMainFrame();
    }
}
