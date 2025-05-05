
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class StudentView implements ActionListener{
    private JFrame frame;
    private JPanel panel1, panel2, panel3, panel4;
    private JLabel lab1, lab2, lab3;
    private JTextField tf1, tf2, tf3;
    private JButton dep, with;
    private Student s;
    
    public StudentView(){
        frame = new JFrame("");
        frame.setLayout(new GridLayout(4, 1));
        
        s = this.loadFromFile();
                
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.setLayout(new GridLayout(1, 2));
        panel2.setLayout(new GridLayout(1, 2));
        panel3.setLayout(new GridLayout(1, 2));
        
        lab1 = new JLabel("ID: ");
        lab2 = new JLabel("Name: ");
        lab3 = new JLabel("Money: ");
        
        tf1 = new JTextField(s.getID() + "");
        tf2 = new JTextField(s.getName());
        tf3 = new JTextField(s.getMoney() + "");

        tf3.setEditable(false);
        
        dep = new JButton("Deposit");
        with = new JButton("Withdraw");
        dep.addActionListener(this);
        with.addActionListener(this);
        
        panel1.add(lab1);
        panel1.add(tf1);
        panel2.add(lab2);
        panel2.add(tf2);
        panel3.add(lab3);
        panel3.add(tf3);
        panel4.add(dep);
        panel4.add(with);
        
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int money = Integer.parseInt(tf3.getText());
        if (e.getSource().equals(dep)){
            money += 100;
        } else if (e.getSource().equals(with)){
            if (money > 0){
                money -= 100;
            }
        }
        s.setMoney(money);
        tf3.setText(money + "");
        this.saveToFile(s);
    }
    
    public void saveToFile(Student s){
        try (
                FileOutputStream fout = new FileOutputStream("StudentM.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fout);
                        ){
            s.setID(Integer.parseInt(tf1.getText()));
            s.setName(tf2.getText());
            s.setMoney(Integer.parseInt(tf3.getText()));
            oout.writeObject(s);
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public Student loadFromFile() {
        Student s = new Student();
        File file = new File("StudentM.dat");

        if (!file.exists()) return s; 

        try (
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(fin);
        ) {
            s = (Student) oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    
        return s;
    }

}
