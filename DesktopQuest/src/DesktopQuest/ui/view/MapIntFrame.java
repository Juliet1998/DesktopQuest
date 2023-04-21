package DesktopQuest.ui.view;

import DesktopQuest.ui.controller.EventController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class MapIntFrame extends JInternalFrame {

    private JPanel contentPane;
    private EventController EventCon;
    private EventBtn currentEvent;
    private ArrayList<EventBtn> currentOptional;

    public MapIntFrame() {
        title = "World Browser";
        resizable = false;
        closable = true;
        maximizable = false;
        iconable = true;
        contentPane = new JPanel(){ public void paint(Graphics g) {
            super.paint(g);  // fixes the immediate problem.
            Graphics2D g2 = (Graphics2D) g;
            for (int y = 70; y <= 380; y+=120) {
                for (int x = 110; x <= 740-80; x+=120) {
                    if( (x==110 && y==70)){
                        Line2D lin = new Line2D.Double(x+10,y,x+40,y);
                        g2.draw(lin);
                    }else if (x==740-150 && y==310){
                        Line2D lin = new Line2D.Double(x,y,x+30,y);
                        g2.draw(lin);
                    }else {
                        Line2D lin = new Line2D.Double(x, y, x + 40, y);
                        g2.draw(lin);
                    }
                    if ( y==70 && (x==110 || x==740-150)) {
                        Line2D lin2 = new Line2D.Double(x+80,y+40,x+80,y+80);
                        g2.draw(lin2);
                    }
                    if ( y==190 && x==110) {
                        Line2D lin2 = new Line2D.Double(x-40,y+40,x-40,y+80);
                        g2.draw(lin2);
                    }
                    if ( y==190 && x==740-270) {
                        Line2D lin2 = new Line2D.Double(x+80,y+40,x+80,y+80);
                        g2.draw(lin2);
                    }
                }
            }

        }};
        contentPane.setPreferredSize(new Dimension(740,380));
        setContentPane(contentPane);
        pack();
        //Insets insets = this.getInsets();
        //setPreferredSize(new Dimension(700 + insets.left + insets.right,500 + insets.top + insets.bottom));
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = this.getPreferredSize();
        setBounds(screensize.width/2 - size.width/2,screensize.height/2 - size.height/2, size.width,size.height);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setVisible(true);
        initContentPane();
        currentOptional = new ArrayList<EventBtn>();

    }

    private void initContentPane() {
        contentPane.setLayout(null); //use absolute sizing for map
        EventBtn b1 = createStartBtn();
        Dimension pane = contentPane.getPreferredSize();
        EventBtn b2 = createGoalBtn(pane);
        contentPane.add(b1);
        contentPane.add(b2);
        int x = 150;
        EventBtn previous = b1;
        for (int i = 1;i <= 5; i++){
            EventBtn current = createEventBtn();
            current.setBounds(x,30,80,80);
            contentPane.add(current);
            x += 120;
            previous.addAdjoin(current);
            previous = current;
        }
        x = contentPane.getPreferredSize().width-30-80;
        EventBtn b6 = null;
        for (int i = 1;i <= 6; i++){
            EventBtn current = createEventBtn();
            current.setBounds(x,150,80,80);
            contentPane.add(current);
            x -= 120;
            previous.addAdjoin(current);
            current.addAdjoin(previous);
            previous = current;
            if (i==2){
                b6 = previous;
            }
            if (i==5){
                for (EventBtn b : b1.adjoin) {
                   for (EventBtn bb : b.adjoin){
                       bb.addOption(previous);
                       previous.addOption(bb);
                   }
                   b.addAdjoin(previous);
                   previous.addAdjoin(b);
                }
            };
        }
        x = 30;
        for (int i = 1;i <= 5; i++){
            EventBtn current = createEventBtn();
            if (i ==5){
                current = createShopBtn();
            }
            current.setBounds(x,270,80,80);
            contentPane.add(current);
            x += 120;
            previous.addAdjoin(current);
            previous = current;
            
            if (i == 5){
                if(b6 != null){
                    b6.addAdjoin(previous);
                }
            }
        }
        previous.addAdjoin(b2);
    }

    private EventBtn createStartBtn() {
        EventBtn b = new EventBtn("Start");
        b.setEnabled(true);
        Dimension size = b.getPreferredSize();
        b.setBounds( 20, 20,size.width,size.height);
        try {
            ImageIcon q = new ImageIcon(getClass().getResource("/plus48.png"));
            b.setHorizontalTextPosition(JButton.CENTER);
            b.setVerticalTextPosition(JButton.BOTTOM);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setVerticalAlignment(SwingConstants.CENTER);
            b.setIcon(q);
        }catch (Exception ex){};
        return b;
    }

    private EventBtn createGoalBtn(Dimension pane) {
        EventBtn b = new EventBtn("Goal");
        b.setBounds(pane.width-120,pane.height- 120,100,100); //always at the right button corner
        try {
            ImageIcon q = new ImageIcon(getClass().getResource("/goal48.png"));
            b.setHorizontalTextPosition(JButton.CENTER);
            b.setVerticalTextPosition(JButton.BOTTOM);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setVerticalAlignment(SwingConstants.CENTER);
            b.setIcon(q);
        }catch (Exception ex){};
        return b;
    }

    private EventBtn createShopBtn() {
        EventBtn b = new EventBtn("Shop");
        try {
            ImageIcon q = new ImageIcon(getClass().getResource("/shop.png"));
            b.setHorizontalTextPosition(JButton.CENTER);
            b.setVerticalTextPosition(JButton.BOTTOM);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setVerticalAlignment(SwingConstants.CENTER);
            b.setIcon(q);
        }catch (Exception ex){};
        return b;
    }

    private EventBtn createEventBtn() {
        ImageIcon q;
        EventBtn b = new EventBtn("Event");
        b.setBounds(130,20,80,80);
        try {
            q = new ImageIcon(getClass().getResource("/event32.png"));
            b.setIcon(q);
            b.setHorizontalTextPosition(JButton.CENTER);
            b.setVerticalTextPosition(JButton.BOTTOM);
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setVerticalAlignment(SwingConstants.CENTER);
        }catch (Exception ex) {}
        b.setEnabled(false);
        return b;
    }

    public class EventBtn extends JButton{

        //List of adjoined Event buttons
        private ArrayList<EventBtn> adjoin;//child button
        private ArrayList<EventBtn> option; //parallel parent button
        public Boolean isTriggered;
        private ImageIcon ongoing, disable;

        public EventBtn(String text) {
            super(text);
            setEnabled(false);
            setFocusPainted(false);
            setFocusable(false);
            setPreferredSize(new Dimension(100,100));
            isTriggered = false;
            try {
                disable = new ImageIcon(getClass().getResource("/check32.png"));
            }catch (Exception ex){disable = null;}
            try {
                ongoing = new ImageIcon(getClass().getResource("/ongoing32.png"));
            }catch (Exception ex){ongoing = null;}
            this.adjoin = new ArrayList<EventBtn>();
            this.option = new ArrayList<EventBtn>();
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isTriggered = true;
                    setCurrentEvent((EventBtn) e.getSource());
                    if (option != null) {
                        for (EventBtn btn : option) {
                            if (btn != null) {
                                currentOptional.add(btn);
                            }
                        }
                    }
                    for (EventBtn btn : adjoin) { currentOptional.add(btn);}
                    disableOptional();
                    EventIntFrame event;
                    if (text.equals("Start")){event = EventCon.getStartEvent();}
                    else if (text.equals("Goal")){event = EventCon.getFinalEvent();}
                    else if (text.equals("Shop")){event = EventCon.getShopEvent();}
                    else { event = EventCon.fillEvent();}
                    getDesktopPane().add(event);
                    getDesktopPane().getDesktopManager().activateFrame(event);
                    setEnabled(false);
                    if (ongoing != null){ setIcon(ongoing);setDisabledIcon(ongoing);}


                }
            });
        }

        public void passEvent(){
            if (disable != null){ setDisabledIcon(disable);}
            try {
                currentOptional.remove(this);
            }catch (Exception ex){}
            setEnabled(false);
            enableOptional();
            for (EventBtn btn : adjoin){
                if (!btn.isTriggered){btn.setEnabled(true);}
            }
        }

        public void setAdjoin(ArrayList<EventBtn> adjoin) {
            this.adjoin = adjoin;
        }

        public void addAdjoin(EventBtn b){
            this.adjoin.add(b);
        }

        public void setOption(ArrayList<EventBtn> option) {
            this.option = option;
        }
        public void addOption(EventBtn b){
            this.option.add(b);
        }

    }

    public void enableOptional(){
        if (currentOptional != null){
            for (EventBtn b : currentOptional){
                if (!b.isTriggered) {b.setEnabled(true);}
            }
        }
    }

    public void disableOptional(){
        if (currentOptional != null){
            for (EventBtn b : currentOptional){
                b.setEnabled(false);
            }
        }
    }

    public void setEventCon(EventController eventCon) {
        EventCon = eventCon;
        EventCon.setMapIntFrame(this);
    }

    public void setCurrentEvent(EventBtn currentEvent) {
        this.currentEvent = currentEvent;
    }

    public EventBtn getCurrentEvent() {
        return currentEvent;
    }
}
