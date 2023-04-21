package DesktopQuest.ui.view;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CustomJProgressBar extends JPanel {
    private static final long serialVersionUID = 1L;
    private Color color;
    private int width, height;
    private int minimum = 0;
    private int maximum = 100;

    private int value = 10;

    private int step = 10;

    public CustomJProgressBar(Color color) {
        super();
        this.color = color;
        setBackground(Color.white);
        setBounds(0, 0, width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //border
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);

        //progress
        //width of each cell
        int drawAmount = (int)(((double)getWidth())/((double)step));
        //num of cells to draw
        int num = (int)((double)(value*getWidth())/(double) ((drawAmount-3)* maximum));
        //draw cells
        if (num >=1) {
            int x = 2;
            for (int i = 1; i <= num; i++) {
                g.setColor(color);
                if ((x+drawAmount-4) >= getWidth()-1)
                    g.fillRect(x, 2, getWidth()-x-2, getHeight() - 4);//-2 to account for border
                else
                    g.fillRect(x, 2, drawAmount-4, getHeight() - 4); //-4 for more steps
                x += drawAmount-3;
            }

        }

    }

    public void setColor(Color _color){
        this.color = _color;
    }

    public void setMinimum(int _minimum){
        this.minimum = _minimum;
    }


    public void setMaximum(int _maximum){
        this.maximum = _maximum;
    }
    public int getMaximum() {
        return maximum;
    }

    public void setValue(int _value){
        this.value = _value;
    }

    public int getValue() {
        return value;
    }
    public void setStep(int step) {
        this.step = step;
    }
}
