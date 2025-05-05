import java.awt.*;
import javax.swing.*;

public class TellerGUI {
     private JFrame fr;
     private JPanel upper, lower;
     private JLabel label1, label2;
     private JTextField txt1, txt2;
     private JButton bn1, bn2, bn3;
 
     public TellerGUI(){
         fr = new JFrame("Teller GUI");
         upper = new JPanel();
         lower = new JPanel();
         label1 = new JLabel("  Balance");
         label2 = new JLabel("  Amount");
         txt1 = new JTextField();
         txt2 = new JTextField("6000");
         bn1 = new JButton("Deposit");
         bn2 = new JButton("Withdraw");
         bn3 = new JButton("Exit");
         
         txt2.setEditable(false);
         fr.setLayout(new GridLayout(2, 1));
         upper.setLayout(new GridLayout(2,2));
         
         upper.add(label1);
         upper.add(txt2);
         upper.add(label2);
         upper.add(txt1);
         lower.add(bn1);
         lower.add(bn2);
         lower.add(bn3);
         fr.add(upper);
         fr.add(lower);
           
         fr.setSize(300, 200);
         fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         fr.setVisible(true);
     }
}
