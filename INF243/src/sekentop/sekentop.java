package sekentop;

import Grafik.grafik02;

import java.awt.*;
import java.awt.event.*;


class kanvas01 extends Canvas{

    public int angle = (int)(350*(Math.random()));
    private int x_direction = (int)(Math.random());
    private int y_direction = (int)(Math.random());
    private int x_initial = (int)(980*Math.random());
    private int y_initial = (int)(680*Math.random());
    private int x_speed,y_speed;
    private int speed = 10;
    public kanvas01() {
        setBackground(Color.BLACK);
    }

    public void paint(Graphics p) {
        if(x_direction == 0) x_direction = -1;
        if(y_direction == 0) y_direction = -1;
        p.setColor(Color.green);
        p.fillRect(400,100,400,300);
        p.setColor(Color.red);
        p.fillOval(x_initial,y_initial,15,15);
        x_speed = x_direction * (int)(speed*Math.cos(Math.toRadians(angle)));
        y_speed = y_direction * (int)(speed*Math.sin(Math.toRadians(angle)));
        x_initial += x_speed;
        y_initial += y_speed;


        if((y_initial>96 && y_initial<404)&&(x_initial < 403 && x_initial > 400) && 150-angle < 45) x_direction *= -1;
        if((x_initial>396 && x_initial<796)&&(y_initial > 396 && y_initial < 400) && ((angle>45 && angle<135) || (angle<315 && angle>225))) y_direction *= -1;
        if((y_initial>96 && y_initial<404)&&(x_initial < 803 && x_initial > 800) && angle<45)x_direction *=-1;
        if((x_initial>396 && x_initial<804)&&(y_initial < 103 && y_initial > 100) && angle < 45)y_direction *= -1;
        if((x_initial>400 && x_initial<800) && (y_initial > 100 && y_initial < 400)){
            speed = 6;
        }
        else{
            speed = 10;
        }
        if(x_initial >985 || x_initial<0){
            x_direction *= -1;
        }
        if(y_initial < 0 || y_initial > 658){
            y_direction *= -1;
        }

        try {
            Thread.sleep(20);
        }
        catch (Exception e) {}
        repaint();
        System.out.println(angle);
    }
}
    public class sekentop implements WindowListener {
        private Frame a;
        private kanvas01 k;

        public sekentop() {
            a = new Frame();
            k = new kanvas01();
            a.addWindowListener(this);
            a.add(k);
            a.setSize(1000, 700);
            a.setResizable(false);
            a.setVisible(true);
        }

        public static void main(String[] args) {
            sekentop uygulama = new sekentop();
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


