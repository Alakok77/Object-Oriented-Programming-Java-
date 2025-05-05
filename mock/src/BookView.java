/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BookView implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel p1, p2, p3, p4, p5;
    private JLabel l1, l2, l3;
    private JTextField txt1, txt2, txt3;
    private JButton bn1, bn2, bn3, bn4, bn5;
    private JComboBox<String> combo;
    
    private ArrayList<Book> genList;
    private ArrayList<Book> comList;
    private ArrayList<Book> msList;
    private ArrayList<Book> photoList;
    private ArrayList<Book> currType;
    private Book currBook;
    
    private Book book;
    private insertBook ib;
    private int index = 0;
    
    public BookView(){
        fr = new JFrame("");
        
        fr.addWindowListener(this);
        
        genList = new ArrayList();
        comList = new ArrayList();
        msList = new ArrayList();
        photoList = new ArrayList();
        currType = new ArrayList();
        
        this.loadBook();
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        
        l1 = new JLabel("Name");
        l2 = new JLabel("Price");
        l3 = new JLabel("Type");
        
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        
        txt3.setEditable(false);
        
        txt3.setPreferredSize(new Dimension(80, 20));
                
        bn1 = new JButton("<<<");
        bn2 = new JButton(">>>");
        bn3 = new JButton("Add");
        bn4 = new JButton("Update");
        bn5 = new JButton("Delete");
        
        bn1.addActionListener(this);
        bn2.addActionListener(this);
        bn3.addActionListener(this);
        bn4.addActionListener(this);
        bn5.addActionListener(this);
        
        combo = new JComboBox();
        combo.addActionListener(this);
        
        combo.addItem("General");
        combo.addItem("Computer");
        combo.addItem("Math&Sci");
        combo.addItem("Photo");
        
        fr.setLocation(620, 300);
        fr.setLayout(new GridLayout(5, 1));
        
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);
        fr.add(p5);
        
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new GridLayout(1, 2));
        
        p1.add(l1);
        p1.add(txt1);
        p2.add(l2);
        p2.add(txt2);
        p3.add(l3);
        p3.add(combo);
        
        p4.add(bn1);
        p4.add(txt3);
        p4.add(bn2);
        
        p5.add(bn3);
        p5.add(bn4);
        p5.add(bn5);
        
        this.selectedType();
        this.showBook();
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bn3)){
            ib = new insertBook(this);
        } else if (e.getSource().equals(bn4)){
            this.updateBook();
            this.saveBook();
            JOptionPane.showMessageDialog(fr, "Done it");
        } else if (e.getSource().equals(bn5)){
            this.deleteBook();
            this.saveBook();
            JOptionPane.showMessageDialog(fr, "Done it");
        } else if (e.getSource().equals(bn1)){
            if (index > 0){
                index--;
            }
            this.showBook();
        } else if (e.getSource().equals(bn2)){
            if (index < currType.size() - 1){
                index++;
            }
            this.showBook();
        } else if (e.getSource().equals(combo)){
            this.selectedType();
            index = 0;
            this.showBook();
        }
    }
    
    public void addBook(String name, double price, String type){
        switch (type) {
            case "General":
                genList.add(new Book(name, price, type));
                break;
            case "Computer":
                comList.add(new Book(name, price, type));
                break;
            case "Math&Sci":
                msList.add(new Book(name, price, type));
                break;
            case "Photo":
                photoList.add(new Book(name, price, type));
                break;
            default:
                break;
        }
        
        this.selectedType();
        this.saveBook();
        index = currType.size() - 1;
        this.showBook();
    }
    
    public void selectedType(){
        switch ( (String)combo.getSelectedItem() ) {
            case "General":
                currType = genList;
                break;
            case "Computer":
                currType = comList;
                break;
            case "Math&Sci":
                currType = msList;
                break;
            case "Photo":
                currType = photoList;
                break;
            default:
                currType = new ArrayList<>();
                break;
        }
        
        this.index = 0;
        this.showBook();
    }
    
    public void showBook(){
        if (currType.isEmpty()){
        txt1.setText("");
        txt2.setText("");
        txt3.setText("0");
        return;
    }
        currBook = currType.get(index);
        txt1.setText(currBook.getName());
        txt2.setText(currBook.getPrice() + "");
        txt3.setText(index + "");
    }
    
    public void updateBook(){
        String n = txt1.getText();
        double p = Double.parseDouble(txt2.getText());
        switch ( (String)combo.getSelectedItem() ) {
            case "General":
                genList.get(index).setName(n);
                genList.get(index).setPrice(p);
                break;
            case "Computer":
                comList.get(index).setName(n);
                comList.get(index).setPrice(p);
                break;
            case "Math&Sci":
                msList.get(index).setName(n);
                msList.get(index).setPrice(p);
                break;
            case "Photo":
                photoList.get(index).setName(n);
                photoList.get(index).setPrice(p);
                break;
            default:
                break;
        }
       this.showBook();
       this.saveBook();
    }
    
    
    public void deleteBook(){
        switch ( (String)combo.getSelectedItem() ) {
            case "General":
                genList.remove(index);
                break;
            case "Computer":
                comList.remove(index);
                break;
            case "Math&Sci":
                msList.remove(index);
                break;
            case "Photo":
                photoList.remove(index);
                break;
            default:
                break;
        }
       this.showBook();
    }
    
    public void saveBook(){
        File file = new File("Book.data");
        if (!file.exists()){
            return;
        }
        
        try (
                FileOutputStream fo = new FileOutputStream(file);
                ObjectOutputStream os = new ObjectOutputStream(fo);
                ) {
            os.writeObject(genList);
            os.writeObject(comList);
            os.writeObject(msList);
            os.writeObject(photoList);
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadBook(){
        File file = new File("Book.data");
        if (!file.exists()){
            return;
        }
        
        try (
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                ){
            
            genList = (ArrayList<Book>) oi.readObject();
            comList = (ArrayList<Book>) oi.readObject();
            msList = (ArrayList<Book>) oi.readObject();
            photoList = (ArrayList<Book>) oi.readObject();
            
        } catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.loadBook();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.saveBook();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.saveBook();
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}

