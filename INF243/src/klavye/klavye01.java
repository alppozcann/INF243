package klavye;
// Yön tuşları ile kontrol

import java.awt.*;

import java.awt.event.*;

class kanvas06 extends Canvas implements KeyListener

{

    private int x=400,y=300;

    public kanvas06()

    {

        setBackground(Color.yellow);

        addKeyListener(this);

    }

    public void paint(Graphics p)

    {

        Font tt=new Font("Times New Roman",Font.PLAIN,40);

        p.setFont(tt);

        p.drawString("+",x,y);

    }

    public void keyPressed(KeyEvent e)

    {

        int tus = e.getKeyCode();

        switch(tus)

        {

            case(KeyEvent.VK_UP): y=y-10; break;

            case(KeyEvent.VK_DOWN): y=y+10; break;

            case(KeyEvent.VK_LEFT): x=x-10; break;

            case(KeyEvent.VK_RIGHT): x=x+10; break;

        }

        repaint();

    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

}

public class klavye01 implements WindowListener {

    private Frame a;

    private kanvas06 k;

    public klavye01() {

        a = new Frame();

        k = new kanvas06();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(800, 600);

        a.setResizable(false);

        a.setVisible(true);

    }


    public static void main(String args[]) {

        klavye01 uygulama = new klavye01();

    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowClosing(WindowEvent e) {

        System.exit(0);

    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
}