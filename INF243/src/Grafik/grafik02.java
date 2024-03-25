package Grafik;

import java.awt.*;
import java.awt.event.*;

class kanvas2 extends Canvas {
    private int x1 = 0;
    private int sign = 1;

    public kanvas2() {
        setBackground(Color.ORANGE);
    }
    public void paint(Graphics p){
        p.drawString("Merhaba",x1,200);
            x1 += sign*12;
        if(x1 >= 948){
            sign = -1;
        }
        if(x1 <= 0 && sign == -1){
            sign = 1;
        }
        try {
            Thread.sleep(100);
        }
        catch (Exception e) {}
        repaint();
    }
}
public class grafik02 implements WindowListener {


    private Frame a;
    private kanvas2 k;
    public grafik02() {
        a = new Frame();
        k = new kanvas2();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(1000,700);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String[] args) {
        grafik02 uygulama = new grafik02();
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
