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
import java.awt.event.*;
import java.util.ArrayList;

public class insertBook implements ActionListener{
    private JFrame fr;
    private JPanel p1, p2, p3, p4;
    private JLabel l1, l2, l3;
    private JTextField txt1, txt2;
    private JComboBox<String> combo;
    private JButton insert;
    
    private Book book;
    
    private BookView bookView;
    
    public insertBook(BookView bookview){
        fr = new JFrame("");
        
        this.bookView = bookview;
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        l1 = new JLabel("Name");
        l2 = new JLabel("Price");
        l3 = new JLabel("Type");
        
        txt1 = new JTextField();
        txt2 = new JTextField();
        
        combo = new JComboBox<>();
        
        combo.addItem("General");
        combo.addItem("Computer");
        combo.addItem("Math&Sci");
        combo.addItem("Photo");
        
        insert = new JButton("insert");
        insert.addActionListener(this);
        
        fr.setLayout(new GridLayout(4, 1));
        fr.setLocation(620, 400);
        
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        
        p1.add(l1);
        p1.add(txt1);
        
        p2.add(l2);
        p2.add(txt2);
        
        p3.add(l3);
        p3.add(combo);
        
        p4.add(insert);
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 150);
        fr.setVisible(true);
    }
    
    public JTextField getFieldName(){
        return this.txt1;
    }
    
    public JTextField getFieldPrice(){
        return this.txt2;
    }
    
    public JComboBox getCombo(){
        return this.combo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(insert)){
            if (this.bookView != null){
                bookView.addBook(txt1.getText(), Double.parseDouble(txt2.getText()), (String)combo.getSelectedItem());
                bookView.selectedType();
                bookView.showBook();
                
                bookView.saveBook();
                
                JOptionPane.showMessageDialog(fr,"Done it.", "", JOptionPane.INFORMATION_MESSAGE);

                fr.dispose();
            }
        }
        
    }
        
}
