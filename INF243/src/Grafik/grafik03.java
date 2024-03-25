package Grafik;

import java.awt.*;
import java.awt.event.*;

class kanvas3 extends Canvas {
    private int y1 = 200;
    private int y2 = 400;
    private int y3 = 100;
    private int x1 = 100;
    private int x2 = 400;
    private int x3 = 700;
    private int randval;
    public kanvas3() {
        setBackground(Color.green);
    }
    public void paint(Graphics p){
        p.setColor(Color.red);
        p.fillOval(x1,y1,10,10);
        p.setColor(Color.yellow);
        p.fillOval(x2,y2,20,20);
        p.setColor(Color.blue);
        p.fillOval(x3,y3,15,15);

        if(y1 != 700){
            y1 +=10;
        }
        if(y2 != 700){
            y2 += 20;
        }
        if(y3 != 700){
            y3 += 15;
        }
        if(y1 == 700){
            x1 = (int)(1000*Math.random());
            y1 = 0;
        }
        if(y2 == 700){
            x2 = (int)(1000*Math.random());
            y2 = 0;
        }
        if(y3 >= 700){
            x3 = (int)(1000*Math.random());
            y3 = 0;
        }

        try {
            Thread.sleep(60);
        }
        catch (Exception e) {}
        repaint();
    }
}

public class grafik03 implements WindowListener {


    private Frame a;
    private kanvas3 k;
    public grafik03() {
        a = new Frame();
        k = new kanvas3();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(1000,700);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String[] args) {
        grafik03 uygulama = new grafik03();
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
