package mouse;
import java.awt.*;

import java.awt.event.*;

class kanvas03 extends Canvas implements MouseListener, MouseMotionListener

{

    private Point m;

    public kanvas03()

    {

        setBackground(Color.red);

        addMouseListener(this);

        addMouseMotionListener(this);

    }

    public void paint(Graphics p)

    {

    p.setColor(Color.yellow);
    p.fillRect(100,100,500,300);
    if(m.x >= 100 && m.x<= 600 && m.y>=100 && m.y <= 400){
        p.setColor(Color.blue);
        p.fillRect(100,100,500,300);
        setBackground(Color.red);
    }
    else{
        setBackground(Color.white);
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

public class mouse03 implements WindowListener

{

    private Frame a;

    private kanvas03 k;

    public mouse03()

    {

        a = new Frame();

        k = new kanvas03();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(800,600);

        a.setResizable(false);

        a.setVisible(true);

    }

    public static void main(String args[])

    {

        mouse03 uygulama = new mouse03();

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