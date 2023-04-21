package DesktopQuest.ui.view;

import DesktopQuest.ui.controller.MainFrameController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;

public class HelpIntFrame extends JInternalFrame {

    private JSplitPane contentPane;
    private JScrollPane guidepane, contentpane;
    private JLabel content;
    private JTree tree;
    private JMenuBar menuBar;
    private MainFrameController mainFrameController;


    public HelpIntFrame() {
        title = "Desktop Quest Help Guide";
        resizable = true;
        closable = true;
        maximizable = true;
        iconable = true;
        setBounds(400, 200, 800, 400);
        setVisible(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        initContentPane();
        setContentPane(contentPane);
        menuBar = initMenuBar();
        setJMenuBar(menuBar);
    }

    private JMenuBar initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu();
        JMenuItem file;
        menu.setText("<HTML><U>F</U>ile</HTML>");
        menu.getAccessibleContext().setAccessibleDescription(
                "This is the menu of user guidepane");
        file = new JMenuItem("About Desktop Quest");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.setText(intro);
            }
        });
        menu.add(file);
        JMenu submenu = new JMenu("How to Play");
        menu.add(submenu);
        file = new JMenuItem("Basics");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.setText(basics);
            }
        });
        submenu.add(file);
        file = new JMenuItem("Expert");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.setText(expert);
            }
        });
        submenu.add(file);
        menuBar.add(menu);
        menu = new JMenu();
        menu.setText("<HTML><U>O</U>pen</HTML>");
        menu.getAccessibleContext().setAccessibleDescription(
                "Open a Desktop Quest Window");
        menu.setToolTipText("Open a Desktop Quest Window");
        menuBar.add(menu);

        file = new JMenuItem("Player Window");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.Player.setVisible(true);
            }
        });
        menu.add(file);
        file = new JMenuItem("Status Window");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.Status.setVisible(true);
            }
        });
        menu.add(file);
        file = new JMenuItem("My Bag Window");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.MyBag.setVisible(true);
            }
        });
        menu.add(file);
        file = new JMenuItem("World Map Window");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.WorldMap.setVisible(true);
            }
        });
        menu.add(file);

        menu = new JMenu();
        menu.setText("<HTML><U>H</U>elp</HTML>");
        menu.getAccessibleContext().setAccessibleDescription(
                "Open a Desktop Quest Window");
        menu.setToolTipText("Open a Desktop Quest Window");
        menuBar.add(menu);
        file = new JMenuItem("Start New Game");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.DoQuitGame();
            }
        });
        menu.add(file);
        file = new JMenuItem("Quit");
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameController.DoQuitGame();
            }
        });
        menu.add(file);
        return menuBar;
    }

    private void initContentPane() {
        content = new JLabel("Welcome to the world of Desktop Quest.");
        content.setText(intro);
        content.setOpaque(true);
        content.setVerticalAlignment(SwingConstants.TOP);
        content.setBorder(new EmptyBorder(10,10,10,10));
        content.setBackground(Color.WHITE);
        tree = fillGuideTree();
        tree.putClientProperty("JTree.lineStyle","None");
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node == null) return;
                Object nodeInfo = node.getUserObject();
                if (node.isLeaf()) {
                    GuideInfo folder = (GuideInfo) nodeInfo;
                    displayContent(folder.GuideContent);
                }
            }
        });
        guidepane = new JScrollPane(tree);
        contentpane = new JScrollPane(content);
        contentPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, guidepane, contentpane);
        contentPane.setOneTouchExpandable(true);
        contentPane.setDividerLocation(150);

        Dimension min = new Dimension(150,0);
        guidepane.setMinimumSize(min);
        guidepane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(3,0,0,3), BorderFactory.createLoweredBevelBorder()));
        contentpane.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(3,3,0,0), BorderFactory.createLoweredBevelBorder()));

    }

    private void displayContent(String guideContent) {
        content.setText(guideContent);
    }

    private class GuideInfo {
        //a tree node bject class
        public String GuideName;
        public String GuideContent;

        public GuideInfo(String name, String content) {
            GuideName = name;
            GuideContent = content;
        }

        public String toString() {
            return GuideName;
        }
    }
    private JTree fillGuideTree() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Guide Content");
        createNodes(top);
        return new JTree(top);
    }

    private void createNodes(DefaultMutableTreeNode top){
        DefaultMutableTreeNode folder = null;
        DefaultMutableTreeNode subfolder = null;
        DefaultMutableTreeNode file = null;

        file = new DefaultMutableTreeNode(new GuideInfo("Introduction", intro));
        top.add(file);

        folder = new DefaultMutableTreeNode(new GuideInfo("How to Play", NA));
        top.add(folder);

        file = new DefaultMutableTreeNode(new GuideInfo("Basics", basics));
        folder.add(file);

        file = new DefaultMutableTreeNode(new GuideInfo("Expert", expert));
        folder.add(file);

        //folder = new DefaultMutableTreeNode(new GuideInfo("Interface Overview", NA));
        //top.add(folder);

        //subfolder = new DefaultMutableTreeNode(new GuideInfo("Desktop", NA));
        //folder.add(subfolder);

        //file = new DefaultMutableTreeNode(new GuideInfo("Desktop Icon", NA));
        //subfolder.add(file);

        //file = new DefaultMutableTreeNode(new GuideInfo("Resize Screen", NA));
        //subfolder.add(file);

        //subfolder = new DefaultMutableTreeNode(new GuideInfo("Sub-Windows", NA));
        //folder.add(subfolder);

       //file = new DefaultMutableTreeNode(new GuideInfo("Player", NA));
        // folder.add(file);

        //file = new DefaultMutableTreeNode(new GuideInfo("Event", NA));
        //subfolder.add(file);

    }

    public void setMainFrameController(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;
    }

    private String intro = "<html><h2>Welcome to the world of Desktop Quest!</h2>\n" +
            "<p><br />This is the help guide that provides useful information and details about everything in Desktop Quest.</p>\n" +
            "<p><br />It is highly recommended to read the <U><I>How to play</I></U> page if you are the first time playing Desktop Quest.</p>\n" +
            "<p><br />Remember you can check help guide at any time during the game play by clicking on the desktop icon <strong>Help</strong>.</p>\n" +
            "<p><br />You can now <U><I>double click</I></U> on desktop icons on the left to start play the game.</p>" +
            "<p><br /><I><U>It is also highly recommended to open all the windows you could and arrange them in the way you feel comfortable.</U></I></p>" +
            "</html>";

    private String basics = "<html><h3>How to play Desktop Quest?</h3>\n" +
            "<p><br />1. Open windows by double clicking icons on the desktop.</p>\n" +
            "<p><br />2. Follow the intuition used to interacting with real deaktop interface to play with these windows.</p>\n" +
            "<p><br />3. Each of the different windows have its own functionality, but somehow connected as a whole.</p>\n" +
            "<p><br />4. You need to pay the most attention on the <I>Status</I> window. If your HP reaches 0, game will be over.</p>" +
            "<p><br />5. To win the game, you have to complete the last quest in the World Browser, which is labeled as <I>goal</I>.</p>" +
            "<p><br />6. You can choose your path freely to reach the goal, remember you don't have to go over all the events to " +
            "reach the goal.</p>" +
            "<p><br />7. You can only have one quest on your desktop at the time.</p>" +
            "<p><br />8. Complete one quest will open the path to adjoin quests.</p>" +
            "<p><br />9. You can always use items and switch your equipments before you make an action in the quest, they will" +
            " affect the result of event.</p>" +
            "<p><br />10. Be creative and have fun!</p>" +
            "</html>";

    private String expert= "<html><h3>Tips for Experts</h3>\n" +
            "<p><br />1. Shortcut buttons on the Player window can open and reposition Bag and Status Windows.</p>\n" +
            "<p><br />2. Save check means you will take penalty if condition not met, however the reward won't change.</p>\n" +
            "<p><br />3. Hover mouse over an item will trigger the tooltip that quickly tells you the effect of this item.</p>\n" +
            "<p><br />4. Right click on an item will trigger the popup menu, while double clicking on it will directly show the detail.</p>" +
            "<p><br />5. You can also use the Power to restart game at any time.</p>" +
            "<p><br />6. You can open windows and restart/quit game all from the menu bar of Help Guide.</p>" +
            "<p><br />7. There are two secret items in this game, you will get an chance to get them before reach the goal.</p>" +
            "</html>";

    private String NA = "<html>This information is not yet available in the current version</html>";
}
