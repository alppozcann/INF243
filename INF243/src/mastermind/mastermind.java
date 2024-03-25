package mastermind;

import java.awt.*;
import java.awt.event.*;


public class mastermind implements WindowListener, ActionListener {
    private Frame a;
    private Panel b;
    private TextField t1,t2;
    private Button b1;
    private int targetNumber = (int)(10000*Math.random());
    private int target[] = new int[4];
    private int temp,multiplier = 1;
    private int userinput[] = new int[4];
    private int plusVal=0,negativeVal=0;

    public mastermind(){
        if(targetNumber <=1234 || targetNumber >= 9876){
            targetNumber= (int)(10000*Math.random());
        }
        basamaklaraAyir(targetNumber,target);
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                if(target[j] == target[i]){
                    target[i] = (int)(10*Math.random());
                    break;
                }
            }
        }
        targetNumber = 0;
        for(int i=0;i<4;i++){
                targetNumber += target[i] * multiplier;
                multiplier *=10;
        }

        System.out.println(targetNumber);
        a = new Frame();
        b = new Panel();
        t1 = new TextField(30);
        b1 = new Button("OK");
        b.add(t1);
        b.add(b1);
        t2 = new TextField(50);
        b.add(t2);
        b.setBackground(Color.ORANGE);
        a.add(b);
        b1.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(600,600);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String args[]){
        mastermind uygulama = new mastermind();
    }
    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        int val = 0;
        try {
            val = Integer.parseInt(s1);
        } catch (NumberFormatException ex) {
            t2.setText("Lutfen  1234 ile 9876 arasi basamaklari farkli bir sayi girin");
            return;
        }
        if(val <1234 || val >9876){
            t2.setText("Lutfen  1234 ile 9876 arasi basamaklari farkli bir sayi girin");
            return;
        }
        basamaklaraAyir(val,userinput);
        if(!(checkDup(userinput))){
            t2.setText("Lutfen  1234 ile 9876 arasi basamaklari farkli bir sayi girin");
            return;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(target[i] == userinput[j]){
                    if(i == j) plusVal++;
                    else negativeVal++;
                }
            }
        }
        if(plusVal==0 && negativeVal==0){
            t2.setText("0");
            return;
        }
        else if(plusVal==0 && negativeVal !=0){
            t2.setText("-"+negativeVal);
            negativeVal=0;
            return;
        }
        else if(plusVal!=0 && negativeVal ==0){
            t2.setText("+"+plusVal);
            plusVal=0;
            return;
        }
        else if(plusVal!=0 && negativeVal !=0){
            if(plusVal ==4){
                t2.setText("Correct guess!");
                return;

            }
            t2.setText("-"+negativeVal+" +"+plusVal);
            negativeVal=0;
            plusVal=0;
            return;
        }
    }
    public void basamaklaraAyir(int val, int userinput[]){
        int temp = val;
        for(int i=0;i<4;i++){
            userinput[i] = temp%10;
            temp /= 10;
        }
    }
    public boolean checkDup(int userinput[]){
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                if(userinput[j] == userinput[i]){
                    return false;
                }
            }
        }
        return true;
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
