import java.awt.*;
import java.awt.event.*;
public class RomanNumbers implements WindowListener, ActionListener {
    private Frame a;
    private Panel b;
    private TextField t1,t2;
    private Button b1;

    public RomanNumbers(){
        a = new Frame();
        b = new Panel();
        t1 = new TextField(30);
        b1 = new Button("Roman Rakama Cevir");
        b.add(t1);
        b.add(b1);
        t2 = new TextField(30);
        b.add(t2);

        b.setBackground(Color.ORANGE);
        a.add(b);
        b1.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(400,300);
        a.setResizable(false);
        a.setVisible(true);
    }
    public static void main(String args[]){
        RomanNumbers uygulama = new RomanNumbers();
    }
    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        int romanVals[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romanLetters[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int val = 0;
        try {
            val = Integer.parseInt(s1);
        } catch (NumberFormatException ex) {
            t2.setText("Lutfen  1 ile 3999 arasi bir sayi girin");
            return;
        }
        String RomanValue = "";
        if (val < 1 || val > 3999) {
            t2.setText("Lutfen  1 ile 3999 arasi bir sayi girin");
        } else {
                for (int i = 0; i < romanVals.length; i++) {
                while (val >= romanVals[i]){
                    RomanValue += romanLetters[i];
                    val -= romanVals[i];
                }

            }
            t2.setText(RomanValue);
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
