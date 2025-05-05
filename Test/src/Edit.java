
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Date;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Edit implements ActionListener{
    
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5;
    private JTextField tf1, tf2 ,tf3;
    private JLabel l1, l2, l3;
    private JButton btn1, btn2, btn3, btn4, btn5;
    
    private Marketplace m;
    private int index = 0;
    private Item item;
    
    public Edit(Marketplace m){
        this.m = m;
        
        fr = new JFrame();
        fr.setLocation(720, 300);
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        item = m.getItem(0);
        
        tf1.setText(item.getId() + "");
        tf2.setText(item.getName());
        tf3.setText(item.getPrice() + "");
        
        l1 = new JLabel("Id");
        l2 = new JLabel("Name");
        l3 = new JLabel("Price");
        
        btn1 = new JButton("<<");
        btn2 = new JButton(">>");
        btn3 = new JButton("Delete Item");
        btn4 = new JButton("Update Item");
        btn5 = new JButton("Close Item");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        
        fr.setLayout(new GridLayout(5, 1));
        
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        
        p1.add(l1);
        p1.add(tf1);
        
        p2.add(l2);
        p2.add(tf2);
        
        p3.add(l3);
        p3.add(tf3);
        
        p4.add(btn1);
        p4.add(btn2);
        
        p5.add(btn3);
        p5.add(btn4);
        p5.add(btn5);
        
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        fr.add(p5);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 250);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource().equals(btn1)){
           this.prevoiusItem();
       } else if (e.getSource().equals(btn2)){
           this.nextItem();
       } else if (e.getSource().equals(btn3)){
           this.deleteItem();
           JOptionPane.showMessageDialog(fr, "Done it");
           m.updatTable();
           fr.dispose();
       } else if (e.getSource().equals(btn4)){
           this.updateItem();
           JOptionPane.showMessageDialog(fr, "Done it");
           m.updatTable();
           fr.dispose();
       } else if (e.getSource().equals(btn5)){
           fr.dispose();
       }
    }
    
    public void prevoiusItem(){
        if (index > 0){
            index --;
        }
        item = m.getItem(index);
        tf1.setText(item.getId() + "");
        tf2.setText(item.getName());
        tf3.setText(item.getPrice() + "");
    }
    
    public void nextItem(){
        if (m.getItemListSize() - 1 > index){
            index ++;
        }
        item = m.getItem(index);
        tf1.setText(item.getId() + "");
        tf2.setText(item.getName());
        tf3.setText(item.getPrice() + "");
    }
    
    public void deleteItem(){
        m.getItemList().remove(index);
        m.saveFile();
    }
    
    public void updateItem(){
        m.getItem(index).setId(Integer.parseInt(tf1.getText()));
        m.getItem(index).setName(tf2.getText());
        m.getItem(index).setPrice(Double.parseDouble(tf3.getText()));
        m.getItem(index).setCreated_on(Date.from(Instant.now()));
        m.saveFile();
        m.saveFile();
    }
}
