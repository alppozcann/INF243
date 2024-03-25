package ucaksavar;
// Yön tuşları ile kontrol

import java.awt.*;
import java.awt.event.*;
import java.security.Key;


class kanvas08 extends Canvas implements KeyListener

{
    private int planex= 10;
    private final int basis = (int)(890*Math.random());
    private int bomby=530;
    private int bombx;
    private int bomblaucnherx;
    private int hiz_x,hiz_y;
    private double speed;
    private boolean released = false, win = false, keylock = false;
    private int lambda = 0;
    public kanvas08()

    {

        setBackground(Color.blue);
        addKeyListener(this);

    }

    public void paint(Graphics g)

    {
        Graphics2D p = (Graphics2D) g;


        g.setColor(Color.green);
        g.fillRect(0,600,1000,200);

        g.setColor(Color.darkGray);
        g.fillRect(planex,20,100,50);
        planex += 10;
        if(planex >=1000){
            planex = 5;
        }

        g.setColor(Color.black);
        g.fillRect(basis,580,100,40);


        bomblaucnherx = basis + 45;
        bombx = bomblaucnherx -10;
        p.setColor(Color.black);
        p.rotate(Math.toRadians(lambda),bomblaucnherx+1,590);
        p.fillRect(bomblaucnherx,540,2,70);


        if(released){
            p.setColor(Color.red);
            speed = 20.0;

            hiz_x = (int)(speed * Math.cos(Math.toRadians(lambda+90)));
            hiz_y = (int)(speed * Math.sin(Math.toRadians(lambda+90)));


            /*if(lambda == 0){
                hiz_y = -10;
                hiz_x = 0;
            }*/

            bombx += hiz_x;
            bomby -= hiz_y;
            p.fillOval(bombx,bomby,10,10);
        }

        if(this.bomby < -10 || this.bomby > 1010){
            bomby = 530;
            bombx = bomblaucnherx -10;
            released = false;
            keylock = false;
        }
        if(this.bombx < -10 || this.bombx > 1010){
            bomby = 530;
            bombx = bomblaucnherx -10;
            released = false;
            keylock = false;
        }
        if ((this.bombx > planex-10 && this.bombx < planex + 100) && (this.bomby > 0 && this.bomby <= 70)) {
            win = true;
            bomby = 530;
            bombx = bomblaucnherx -10;
            lambda = 0;
            released = false;
            keylock = true;
        }

        if (win) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 2000, 2000);
            g.setColor(Color.green);
            g.drawString("KAZANDINIZ", 500, 350);
        }




        try {
            Thread.sleep(20);
        }
        catch (Exception e) {}
        repaint();

    }


    public void keyPressed(KeyEvent e) {
        int tus = e.getKeyCode();
        if(!(keylock)) {
            switch (tus) {

                case (KeyEvent.VK_RIGHT):
                        if(lambda <= 80) {
                            lambda += 10;
                        }
                    break;
                        case (KeyEvent.VK_LEFT):
                            if(lambda >= -80) {
                                lambda -= 10;
                            }
                    break;
                case (KeyEvent.VK_SPACE):
                    this.released = true;
                    keylock = true;
                    break;
            }
            repaint();

        }
    }
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

}

public class ucaksavar implements WindowListener {

    private Frame a;

    private kanvas08 k;

    public ucaksavar() {

        a = new Frame();

        k = new kanvas08();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(1000, 800);

        a.setResizable(false);

        a.setVisible(true);

    }


    public static void main(String args[]) {

        ucaksavar uygulama = new ucaksavar();



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