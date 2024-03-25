package oyun;
// Yön tuşları ile kontrol

import java.awt.*;
import java.awt.event.*;



class kanvas07 extends Canvas implements KeyListener

{
    private int planex= 10;
    private int bombx,bomby=70;
    private boolean pressed = false,win = false;
    private int t=1;
    private final int targetx = (int)(1000*Math.random());
    public kanvas07()

    {

        setBackground(Color.blue);
        addKeyListener(this);

    }

    public void paint(Graphics p)

    {

        p.setColor(Color.green);
        p.fillRect(0,600,1000,200);


        p.setColor(Color.yellow);
        p.fillRect(targetx,550,150,80);

        p.setColor(Color.darkGray);
        p.fillRect(planex,20,100,50);
        planex += 5;
        if(planex >=1000){
            planex = 10;
        }

        bombx = planex+30;
        p.setColor(Color.red);
        p.fillRect(bombx,bomby,30,10);

        bombreleased();
        if(this.bombx>=1000){
            bombx=planex;
            bomby=70;
            pressed=false;
            t=1;
        }
        if(this.bombx>=targetx-20 && this.bombx<=targetx+150&&bomby>=580){
            bombx=planex;
            bomby=70;
            pressed=false;
            win = true;
            t=1;
        }
        else if((this.bombx<targetx || this.bombx>targetx+150)&&bomby>=580){
            bombx=planex;
            bomby=70;
            pressed = false;
            t=1;

        }
        if(win){
            p.setColor(Color.BLACK);
            p.fillRect(0,0,2000,2000);
            p.setColor(Color.green);
            p.drawString("KAZANDINIZ",500,350);
        }

        try {
            Thread.sleep(20);
        }
        catch (Exception e) {}
        repaint();

    }

    public void bombreleased(){
        if(pressed) {
            this.bombx += 8;
            this.bomby += (5*t*t)/800;
            t++;
        }
    }
    public void keyPressed(KeyEvent e)
    {
        int tus = e.getKeyCode();
        while(!(pressed)){
           if (tus==KeyEvent.VK_DOWN)
           {
                this.pressed = true;
            }
        }
        repaint();

    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

}

public class oyun implements WindowListener {

    private Frame a;

    private kanvas07 k;

    public oyun() {

        a = new Frame();

        k = new kanvas07();

        a.addWindowListener(this);

        a.add(k);

        a.setSize(1000, 700);

        a.setResizable(false);

        a.setVisible(true);

    }


    public static void main(String args[]) {

        oyun uygulama = new oyun();

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