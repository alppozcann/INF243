
import java.awt.*;
import java.awt.event.*;
public class Main implements WindowListener, ActionListener {
    private Frame a;
    private Panel b;
    private TextField t1, t2;
    private Button d;

    public Main() {
        a = new Frame();
        b = new Panel();
        t1 = new TextField(30);
        b.add(t1);
        d = new Button("OK");
        b.add(d);
        t2 = new TextField(30);
        b.add(t2);

        b.setBackground(Color.PINK);
        a.add(b);
        d.addActionListener(this);
        a.addWindowListener(this);
        a.pack();
        a.setSize(400, 300);
        a.setResizable(false);
        a.setVisible(true);
    }

    public static void main(String[] args) {
        Main uygulama = new Main();
    }

    public void actionPerformed(ActionEvent e) {
        String s = t1.getText();
        int value = Integer.valueOf(s);
        if(isPrimeorNot(value)){
            t2.setText("Not Prime");
        }
        else{
            t2.setText("Prime");
        }

    }

    public boolean isPrimeorNot(int value){
        if(value <2) {
            return false;
        }
        boolean isprime = false;
        for(int i=2;i<Math.sqrt(value);i++){
            if(value % i == 0){
                isprime = true;
                break;
            }
        }
        if(isprime){
            return true;
        }
        else{
            return false;
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