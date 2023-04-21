package DesktopQuest.ui.view;

import DesktopQuest.ui.controller.MainFrameController;
import DesktopQuest.ui.controller.StatusController;
import DesktopQuest.ui.model.EventItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EventIntFrame extends JInternalFrame {

    private JPanel contentPane;
    private JPanel buttonPane;
    private JTextArea EventLog;
    private EventItem eventItem;
    private String iconPath = "/event16.png";
    private StatusController StatusCon;
    private MapIntFrame.EventBtn CurrentEvent;
    private MainFrameController mainFrameController;
    private Boolean isLast;
    private JScrollPane Eventlogpane;

    public EventIntFrame(EventItem event) {//must hava a event data object to create the content
        eventItem = event;
        title = "Event";
        resizable = false;
        closable = false;
        maximizable = false;
        iconable = true;
        isLast = false;
        setPreferredSize(new Dimension(350,300));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = this.getPreferredSize();
        setBounds(screensize.width/2 - size.width/2,screensize.height/2 - size.height/2, size.width,size.height);
        setVisible(true);
        try {
            setFrameIcon(new ImageIcon(getClass().getResource(iconPath)));
        }catch (Exception e){}
        initContentPane();
        setContentPane(contentPane);
    }

    private void initContentPane() {
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        initEventLog();
        Eventlogpane = new JScrollPane(EventLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(Eventlogpane);
        //contentPane.add(EventLog);
        initButtonPane();
        contentPane.add(Box.createRigidArea(new Dimension(0,10)));
        contentPane.add(buttonPane);
    }

    private void initEventLog() {
        EventLog = new JTextArea(eventItem.getEventLog());
        EventLog.setMinimumSize(new Dimension(150,200));
        EventLog.setMaximumSize(new Dimension(300,200));
        //EventLog.setPreferredSize(new Dimension(150,200));
        EventLog.setAlignmentX(Component.CENTER_ALIGNMENT);
        EventLog.setWrapStyleWord(true);
        EventLog.setLineWrap(true);
        EventLog.setEditable(false);
        EventLog.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),new EmptyBorder(3,3,0,0)));
    }

    private void initButtonPane() {
        HashMap<String, EventItem.Eventresult>eventActions = eventItem.getEventActions();
        buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.Y_AXIS));
        EventOptionBtn optionBtn =  new EventOptionBtn("");
        for (String key : eventActions.keySet()){
           optionBtn = new EventOptionBtn(key);
           optionBtn.setEventresult(eventActions.get(key));
           optionBtn.AddActionListener(EventLog);
           buttonPane.add(optionBtn);
        }
    }

    private class EventOptionBtn extends JButton {

        private String action;
        private EventItem.Eventresult eventresult;

        public EventOptionBtn(String opt) {
            setMaximumSize(new Dimension(EventIntFrame.this.getWidth(),50));
            setPreferredSize(new Dimension(100,20));
            action = opt;
            setText("<HTML><FONT color=\"#000099\">"+ action +"</FONT>"
                    + "</HTML>");
            setAlignmentX(Component.CENTER_ALIGNMENT);
            setHorizontalTextPosition(SwingConstants.CENTER);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setBackground(Color.WHITE);
            setToolTipText("Make this action");
            addMouseListener(new MouseAdapter() {
                                 @Override
                                 public void mouseEntered(MouseEvent e) {
                                     super.mouseEntered(e);
                                     setText("<HTML><FONT color=\"#000099\"><U>"+ action +"</U></FONT>"
                                             + "</HTML>");
                                     setCursor(new Cursor(Cursor.HAND_CURSOR));
                                 }

                                 @Override
                                 public void mouseExited(MouseEvent e) {
                                     super.mouseExited(e);
                                     setText("<HTML><FONT color=\"#000099\">"+ action +"</FONT>"
                                             + "</HTML>");
                                 }
                             }
            );
        }

        public void setEventresult(EventItem.Eventresult eventresult) {
            this.eventresult = eventresult;
        }

        public void AddActionListener(JTextArea EventLog){
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (StatusCon != null){
                        String faillog = StatusCon.DoEventResult(eventresult.getResultAction());
                        if (StatusCon.isGameOver){
                            //Game over
                            if (!isLast){
                                String result = EventLog.getText() + "\n\n\"" + action + "\"\n\n" + faillog;
                                EventLog.setText( result + "\n\nYou HP reaches 0.\nGame Over");
                            }else {
                                if (faillog == null)  faillog = "";
                                EventLog.setText(EventLog.getText() + "\n\n\"" + action + "\"\n\n" + faillog + "You HP reaches 0.\nGame Over");
                            }
                            mainFrameController.DoGameOver();

                        }else if (faillog != null && eventresult.getResultAction()[0].equals("SAVE")){
                            //Event failed save check, pass with penalty
                            EventLog.setText(EventLog.getText() + "\n\n\"" + action + "\"\n\n" + faillog);
                            buttonPane.setVisible(false);
                            contentPane.remove(buttonPane);
                            if (isLast){contentPane.add(WinPane());}
                            else {contentPane.add(LeavePane());}
                        } else if (faillog != null && eventresult.getResultAction()[0].equals("BUY")) {
                            //Shop event, don't quit for first two option
                            EventLog.setText(EventLog.getText() + "\n\n\"" + action + "\"\n\n" + faillog);
                            EventLog.doLayout();
                            EventLog.revalidate();
                            EventLog.setPreferredSize(new Dimension(EventLog.getPreferredSize().width, EventLog.getPreferredSize().height+50));
                        } else if (faillog != null){
                            //Event failed with missing item/condition, disable option
                            EventLog.setText(EventLog.getText() + "\n\n\"" + action + "\"\n\n" + faillog);
                            setEnabled(false);
                        }
                        else {
                            //Event passed
                            EventLog.setText(EventLog.getText() + "\n\n\"" + action + "\"\n\n" + eventresult.getResultLog());
                            buttonPane.setVisible(false);
                            contentPane.remove(buttonPane);
                            if (isLast){contentPane.add(WinPane());}
                            else {contentPane.add(LeavePane());}
                        }
                        JScrollBar vertical = Eventlogpane.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                    };
                }
            });
        }
    }

    private JPanel LeavePane(){
        JPanel leavePane = new JPanel();
        leavePane.setLayout(new BoxLayout(leavePane,BoxLayout.Y_AXIS));
        JButton leave = new EventOptionBtn("Leave.");
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentEvent.passEvent();
                dispose();
            }
        });
        leave.setAlignmentY(Component.CENTER_ALIGNMENT);
        leave.setToolTipText("Leave.");
        leavePane.add(leave);
        leavePane.setVisible(true);
        return leavePane;
    }

    private JPanel WinPane(){
        JPanel leavePane = new JPanel();
        leavePane.setLayout(new BoxLayout(leavePane,BoxLayout.Y_AXIS));
        JButton leave = new EventOptionBtn("Complete Quest");
        leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentEvent.passEvent();
                mainFrameController.DoGameWin();
                dispose();
            }
        });
        leave.setAlignmentY(Component.CENTER_ALIGNMENT);
        leave.setToolTipText("Leave.");
        leavePane.add(leave);
        leavePane.setVisible(true);
        return leavePane;
    }

    public void setEventItem(EventItem eventItem) {
        this.eventItem = eventItem;
    }

    public void setStatusCon(StatusController statusCon) {
        StatusCon = statusCon;
    }

    public void setCurrentEvent(MapIntFrame.EventBtn currentEvent) {
        CurrentEvent = currentEvent;
    }

    public void setGoal (){isLast = true;};

    public void setMainFrameController(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;
    }

}
