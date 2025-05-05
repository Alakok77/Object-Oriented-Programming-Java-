/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;

public class CalculatorOneGUI {
    private JFrame fr;
    private JButton bn1, bn2, bn3, bn4;
    private JPanel group;
    private JTextField txt1, txt2, txt3;
   
    public CalculatorOneGUI(){
        fr = new JFrame("เครื่องคิดเลข");
        bn1 = new JButton("บวก");
        bn2 = new JButton("ลบ");
        bn3 = new JButton("คูณ");
        bn4 = new JButton("หาร");
        group = new JPanel();
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        fr.setLayout(new GridLayout(4, 1));
        group.setLayout(new FlowLayout());
        group.add(bn1);
        group.add(bn2);
        group.add(bn3);
        group.add(bn4);
        fr.add(txt1);
        fr.add(txt2);
        fr.add(group);
        fr.add(txt3);
        fr.setSize(300, 150);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
