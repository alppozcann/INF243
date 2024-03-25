import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;

public class Currency implements WindowListener, ActionListener{
    private Frame a;
    private Panel b;
    private TextField t1,t2;
    private Button b1,b2;

    public Currency()
    {
        a = new Frame();
        b = new Panel();
        t1 = new TextField(30);
        b1 = new Button("To USD");
        b.add(t1);
        b.add(b1);
        t2 = new TextField(30);
        b2 = new Button("To TRY");
        b.add(t2);
        b.add(b2);

        b.setBackground(Color.ORANGE);
        a.add(b);
        b1.addActionListener(this);
        b2.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(400,300);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String args[]){
        Currency uygulama = new Currency();
    }
public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("To USD")){
            try {
                String s1 = t1.getText();
                double USD = Double.valueOf(s1);
                if(USD<0){
                    t2.setText("Pozitif sayi giriniz");
                }
                else {
                    double TRY = USD / 30.8649;
                    t2.setText(String.valueOf(TRY));
                }
            }
            catch (NumberFormatException ex){
                t2.setText("Pozitif sayi giriniz");
            }
        }
        else if(s.equals("To TRY")){
            try {
                String s2 = t2.getText();
                double TRY = Double.valueOf(s2);
                if(TRY<0){
                    t1.setText("Pozitif sayi giriniz");
                }
                else {
                    double USD = TRY * 30.8748;
                    t1.setText(String.valueOf(USD));
                }
            }
            catch (NumberFormatException ab){
                t1.setText("Pozitif sayi giriniz");
            }
        }
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