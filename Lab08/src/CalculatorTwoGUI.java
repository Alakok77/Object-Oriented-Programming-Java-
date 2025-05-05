import java.awt.*;
import javax.swing.*;

public class CalculatorTwoGUI {
    private JFrame fr;
    private JPanel pn;
    private JTextField txt;
    private JButton bn1, bn2, bn3, bn4, bn5, bn6, bn7, bn8, bn9, bn10, bn11, bn12, bn13, bn14, bn15, bn16;
    
    public CalculatorTwoGUI(){
        fr = new JFrame("My Calculator");
        pn = new JPanel();
        txt = new JTextField();
        bn1 = new JButton("7");
        bn2 = new JButton("8");
        bn3 = new JButton("9");
        bn4 = new JButton("*");
        bn5 = new JButton("4");
        bn6 = new JButton("5");
        bn7 = new JButton("6");
        bn8 = new JButton("-");
        bn9 = new JButton("1");
        bn10 = new JButton("2");
        bn11 = new JButton("3");
        bn12 = new JButton("x");
        bn13 = new JButton("0");
        bn14 = new JButton("c");
        bn15 = new JButton("=");
        bn16 = new JButton("/");
        
        txt.setSize(300, 30);
        pn.setLayout(new GridLayout(4, 4));
        pn.add(bn1);
        pn.add(bn2);
        pn.add(bn3);
        pn.add(bn4);
        pn.add(bn5);
        pn.add(bn6);
        pn.add(bn7);
        pn.add(bn8);
        pn.add(bn9);
        pn.add(bn10);
        pn.add(bn11);
        pn.add(bn12);
        pn.add(bn13);
        pn.add(bn14);
        pn.add(bn15);
        pn.add(bn16);
        
        fr.setLayout(new BorderLayout());
        fr.add(txt, BorderLayout.NORTH);
        fr.add(pn);
        
        fr.setSize(300, 300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
