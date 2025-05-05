
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class Marketplace implements ActionListener, WindowListener{
    private JFrame fr;
    private JButton btn1, btn2, btn3;
    private JLabel l;
    private JTable table;
    private DefaultTableModel model;
    private JPanel p1, p2, p3;
    
    private AddItem addItem;
    private ArrayList <Item> itemList;
    private Edit edit;
    private Login log;
    
    public Marketplace(Login login){
        fr = new JFrame();

        this.log = login;
        itemList = new ArrayList<Item>();

        fr.setLocation(720, 300);
        
        btn1 = new JButton("Add item");
        btn2 = new JButton("Edit item");
        btn3 = new JButton("Logout");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        l = new JLabel("Welcome to Jiso Marketplace");
        
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        fr.setLayout(new GridLayout(2, 1));
        p1.setLayout(new GridLayout(2, 1));
        
        p3.add(btn1);
        p3.add(btn2);
        p3.add(btn3);
        
        p2.add(l);
        p1.add(p2);
        p1.add(p3);
        
        fr.add(p1);
        
        fr.add(setTable());
        this.loadFile();
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
        
    }
    
    public JScrollPane setTable(){
        String[] col = {"ID", "Name", "Price", "Created_on"};
        model = new DefaultTableModel(col, 0);
        
        table = new JTable(model);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        
        return new JScrollPane(table);
    }
    
    public void setItemList(Item item){
        this.itemList.add(item);
    }
    
    public void updateTable(int Id, String name, double price, Date d){
        model.addRow(new Object[]{Id, name, price, d});
        table.setModel(model);
    }
    
    public void updatTable(){
        model.setRowCount(0);
        
        for (Item i : itemList){
            model.addRow(new Object[] {i.getId(), i.getName(), i.getPrice(), i.getCreated_on()});
        }
    }
    
    public Item getItem(int index){
        return this.itemList.get(index);
    }
    
    public int getItemListSize(){
        return this.itemList.size();
    }
    
    public ArrayList getItemList(){
        return this.itemList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn1)){
            addItem = new AddItem(this);
        } else if (e.getSource().equals(btn2)){
            if (itemList.size() > 0){
                edit = new Edit(this);
            }
        } else if (e.getSource().equals(btn3)){
            fr.dispose();
            log.getFrame().dispose();
            new Login();
        }
    }
    
    public void saveFile(){
        File file = new File("new.dat");
        try(
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(itemList);
            System.out.println("save");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadFile(){
        File file = new File("new.dat");
        if (!file.exists()){
            return;
        }
        try(
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            itemList = (ArrayList<Item>) ois.readObject();
            this.updatTable();
            System.out.println("loaded");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.loadFile();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.saveFile();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.saveFile();
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
