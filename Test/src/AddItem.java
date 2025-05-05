/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Date;
import javax.swing.*;

public class AddItem implements ActionListener{
    private JFrame fr;
    private JTextField tf1, tf2, tf3;
    private JLabel l1, l2, l3;
    private JButton btn;
    private JPanel p1, p2, p3, p4;
    private Item item;
    
    private Marketplace m;
    
    public AddItem(Marketplace m){
        this.m = m;
        fr = new JFrame();
        fr.setLocation(720, 300);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        l1 = new JLabel("Id");
        l2 = new JLabel("Name");
        l3 = new JLabel("Price");
        
        btn = new JButton("Insert Item");
        btn.addActionListener(this);
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        fr.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        
        p1.add(l1);
        p1.add(tf1);
        
        p2.add(l2);
        p2.add(tf2);
        
        p3.add(l3);
        p3.add(tf3);
        
        p4.add(btn);
        
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(250, 200);
        fr.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.insertItem();
        JOptionPane.showMessageDialog(fr, "Done it");
        fr.dispose();
    }
    
    public void insertItem(){
        int id = Integer.parseInt(tf1.getText());
        String name = tf2.getText();
        double price = Double.parseDouble(tf3.getText());
        Date created_on = Date.from(Instant.now());
        
        
        item = new Item(id, name, price, created_on);
        m.updateTable(id, name, price, created_on);
        m.setItemList(item);
        m.saveFile();
        System.out.println("complete");
    }
}
