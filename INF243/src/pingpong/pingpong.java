package pingpong;

import java.awt.*;
import java.awt.event.*;

class Person {
    private int y_position = 270;
    private int score = 0;
    public int get_y_position(){
        return this.y_position;
    }
    public int get_score(){
        return this.score;
    }
    public void set_y_position(int y_position){
        this.y_position = y_position;
    }
    public void set_score(int score){
        this.score = score;
    }
    public void plus_the_score(){
        this.score++;
    }
    public void plus_y_position(int plus){
        this.y_position += plus;
    }
}
class kanvas01 extends Canvas implements KeyListener {
    Person player1 = new Person();
    Person player2 = new Person();
    private int angle = (int)(360*Math.random());
    private int ball_x_position = 485, ball_y_position = 335,speed = 7;
    private int ball_x_speed,ball_y_speed;
    private int x_direction = (int)(Math.random()),y_direction=(int)(Math.random());
    private boolean a = false, z = false, up = false, down = false ;

    public kanvas01(){
        setBackground(Color.black);
        addKeyListener(this);
    }

    public void paint(Graphics p) {
        Font font = new Font("Helvetica",Font.BOLD,25);
        check_angle();
        if(x_direction == 0) x_direction = -1;
        if(y_direction == 0) y_direction = -1;
        p.setColor(Color.white);
        p.fillRect(100,0,5,1000);
        p.setColor(Color.white);
        p.fillRect(900,0,5,1000);
        p.setColor(Color.white);

        p.setFont(font);
        p.drawString(String.valueOf(player1.get_score()),20,50);
        p.setFont(font);
        p.drawString(String.valueOf(player2.get_score()),960,50);

        p.fillRect(120,player1.get_y_position(),10,150);
        p.setColor(Color.white);
        p.fillRect(880,player2.get_y_position(),10,150);
        p.setColor(Color.red);
        p.fillOval(ball_x_position,ball_y_position,15,15);
        move();
        ball_x_speed = x_direction*(int)(speed*Math.cos(Math.toRadians(angle+90)));
        ball_y_speed = y_direction*(int)(speed*Math.sin(Math.toRadians(angle+90)));
        ball_x_position += ball_x_speed;
        ball_y_position += ball_y_speed;

        if(ball_y_position<0 || ball_y_position>650) y_direction *= -1;
        if(ball_x_position<100) {
            player2.plus_the_score();
            player1.set_y_position(270);
            player2.set_y_position(270);
            ball_x_position = 485;
            ball_y_position = 335;
            x_direction *= -1;
            set_angle();
            check_angle();
        }
        if(ball_x_position>905) {
            player1.plus_the_score();
            player1.set_y_position(270);
            player2.set_y_position(270);
            ball_x_position = 485;
            ball_y_position = 335;
            x_direction *= -1;
            set_angle();
            check_angle();
        }
        if((ball_x_position>120 && ball_x_position<130)&&(ball_y_position>player1.get_y_position()&&ball_y_position<player1.get_y_position()+150)){
            x_direction *= -1;
        }
        if((ball_x_position<872 && ball_x_position>868)&&(ball_y_position>player2.get_y_position()&&ball_y_position<player2.get_y_position()+150)){
            x_direction *= -1;
        }
        if(player2.get_score() == 5){
            p.setColor(Color.ORANGE);
            p.fillRect(0,0,2000,2000);
            p.setColor(Color.BLACK);
            p.drawString("PLAYER TWO WINS",480,350);
        }
        if(player1.get_score() == 5){
            p.setColor(Color.ORANGE);
            p.fillRect(0,0,2000,2000);
            p.setColor(Color.BLACK);
            p.drawString("PLAYER ONE WINS",480,350);
        }
        try {
            Thread.sleep(14);
        }
        catch (Exception e) {}
        repaint();
    }
    public void move(){
        if(a){
            if(player1.get_y_position()>15) {
                player1.plus_y_position(-10);
            }
        }
        if(z){
            if(player1.get_y_position()<505) {
                player1.plus_y_position(10);
            }
        }
        if(up){
            if(player2.get_y_position()>15) {
                player2.plus_y_position(-10);
            }
        }
        if(down){
            if(player2.get_y_position()<505) {
                player2.plus_y_position(10);
            }
        }
    }
    public void set_angle(){
         angle = (int)(360*Math.random());
    }
    public void check_angle(){
        if ((angle <= 360 && angle >= 345 )|| (angle <= 285 && angle >= 255) || (angle <= 195 && angle >=165) || (angle <= 105 && angle >= 75 )|| (angle <= 15 && angle >= 0)) {
            angle = (int) (360 * Math.random());
        }
    }
    public void keyPressed(KeyEvent e) {
        int tus = e.getKeyCode();
        switch (tus){
            case(KeyEvent.VK_A):
                    a = true;
                break;
            case(KeyEvent.VK_Z):
                   z = true;

                break;
            case(KeyEvent.VK_UP):
                    up = true;
                break;
            case (KeyEvent.VK_DOWN):
                    down = true;
                break;
        }
        repaint();
    }
    public void keyReleased(KeyEvent e) {
        int tus = e.getKeyCode();
        switch (tus){
            case(KeyEvent.VK_A):
                    a = false;
                break;
            case(KeyEvent.VK_Z):
                    z = false;
                break;
            case(KeyEvent.VK_UP):
                    up = false;
                break;
            case (KeyEvent.VK_DOWN):
                    down = false;
                break;
        }
        repaint();
    }
    public void keyTyped(KeyEvent e) {}
}
public class pingpong implements WindowListener{
    private Frame a;
    private kanvas01 k;
    public pingpong(){
        a = new Frame();
        k = new kanvas01();
        a.addWindowListener(this);
        a.add(k);
        a.setSize(1000, 700);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String[] args){
        pingpong uygulama = new pingpong();
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
