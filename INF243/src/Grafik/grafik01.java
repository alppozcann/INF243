package Grafik;

import java.awt.*;
import java.awt.event.*;

class kanvas1 extends Canvas {
    private int x1 = 0;
    private int y1 = 500;

    public kanvas1() {
        setBackground(Color.ORANGE);
    }
    public void paint(Graphics p){
        p.drawString("Mer",x1,200);
        p.drawString("haba",743,y1);
        if(x1!=800 && y1 != 200){
            x1 = x1 + 12;
            y1 =  y1 - 5;
        }


        try {
            Thread.sleep(100);
        }
        catch (Exception e) {}
        repaint();
    }
}

public class grafik01 implements WindowListener {


    private Frame a;
    private kanvas1 k;
    public grafik01() {
        a = new Frame();
        k = new kanvas1();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(1000,700);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String[] args) {
        grafik01 uygulama = new grafik01();
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
