package mouse;
import java.awt.*;

import java.awt.event.*;

class kanvas04 extends Canvas implements MouseListener, MouseMotionListener

{
    private int width = 300, height = 300;
    private int centerx,centery;
    private Point m;

    public kanvas04()

    {

        setBackground(Color.white);

        addMouseListener(this);

        addMouseMotionListener(this);

    }

    public void paint(Graphics p) {

        p.setColor(Color.yellow);
        p.fillOval(300, 100, width, height);
        centerx = 300 + width/2;
        centery = 100 + height/2;
        if(Math.sqrt(Math.pow(m.x-centerx,2))  + Math.sqrt(Math.pow(m.y-centery,2)) <= 180){
            p.setColor(Color.red);
            p.fillOval(300, 100, 300, 300);
        }
    }

    public void mouseMoved(MouseEvent e)

    {

        m=e.getPoint();

        repaint();

    }

    public void mousePressed(MouseEvent e){}

    public void mouseDragged(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}

public class mouse04 implements WindowListener

{

    private Frame a;

    private kanvas04 k;

    public mouse04()

    {

        a = new Frame();

        k = new kanvas04();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(800,600);

        a.setResizable(false);

        a.setVisible(true);

    }

    public static void main(String args[])

    {

        mouse04 uygulama = new mouse04();

    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e)

    {

        System.exit(0);

    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

}