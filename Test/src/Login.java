
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Login implements ActionListener{
    private JFrame fr;
    private JTextField tf1, tf2, tf3;
    private JLabel l1, l2;
    private JButton btn;
    private JPanel p1, p2, p3;
    
    private Marketplace m;
    
    public Login(){
        
        fr = new JFrame();
        fr.setLocation(720, 300);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        l1 = new JLabel("Login");
        l2 = new JLabel("password");
        
        btn = new JButton("Login");
        btn.addActionListener(this);
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        fr.setLayout(new GridLayout(3, 1));
        
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        
        p1.add(l1);
        p1.add(tf1);
        
        p2.add(l2);
        p2.add(tf2);
        
        p3.add(btn);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400, 200);
        fr.setVisible(true);
        
    }
    
    public JFrame getFrame(){
        return this.fr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn)){
            if (tf1.getText().equals("jisoo") && tf2.getText().equals("flower_me")){
                m = new Marketplace(this);
            }
        }
    }
}
