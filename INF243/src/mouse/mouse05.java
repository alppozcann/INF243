package mouse;
import java.awt.*;

import java.awt.event.*;

class kanvas05 extends Canvas implements MouseListener, MouseMotionListener

{
    private int x1 = 300, y1 = 100,centerx,centery,width = 300,height = 300;
    private Point m,m1,m2;
    private boolean dragged = false;
    private int prevx,prevy,xdif,ydif;

    public kanvas05()

    {

        setBackground(Color.yellow);

        addMouseListener(this);

        addMouseMotionListener(this);

    }

    public void paint(Graphics p) {
        p.setColor(Color.white);
        p.fillOval(x1, y1, 300, 300);
        centerx = 300 + width/2;
        centery = 100 + height/2;
        if(Math.sqrt(Math.pow(m.x-centerx,2))  + Math.sqrt(Math.pow(m.y-centery,2)) <= 180 && dragged){
            p.setColor(Color.blue);
            p.fillOval(x1, y1, width, height);
        }
        else{
            dragged = false;
        }

        repaint();
    }

    public void mouseMoved(MouseEvent e)
    {
        m = e.getPoint();
        repaint();
    }

    public void mousePressed(MouseEvent e){
        m2 = e.getPoint();
        xdif = m2.x - x1;
        ydif = m2.y - y1;
    }

    public void mouseDragged(MouseEvent e) {
        dragged = true;
        m1 = e.getPoint();
        x1 = m1.x -xdif;
        y1 = m1.y -ydif;
        repaint();


    }

    public void mouseReleased(MouseEvent e) {
        dragged = false;
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

}

public class mouse05 implements WindowListener

{

    private Frame a;

    private kanvas05 k;

    public mouse05()

    {

        a = new Frame();

        k = new kanvas05();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(800,600);

        a.setResizable(false);

        a.setVisible(true);

    }

    public static void main(String args[])

    {

        mouse05 uygulama = new mouse05();

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