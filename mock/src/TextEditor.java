/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class TextEditor implements ActionListener{
    
    private JFrame fr;
    private JMenuBar mb;
    private JMenu m;
    private JMenuItem mi1, mi2, mi3, mi4;
    private JTextArea txt;
    private JFileChooser fc;
    
    public TextEditor(){
        fr = new JFrame("My Text Editor");
        
        mb = new JMenuBar();
        m = new JMenu("File");
        mi1 = new JMenuItem("New");
        mi2 = new JMenuItem("Open");
        mi3 = new JMenuItem("Save");
        mi4 = new JMenuItem("Close");
        
        txt = new JTextArea();
        
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        
        fr.setJMenuBar(mb);
        mb.add(m);
        
        fr.add(txt);
        
        m.add(mi1);
        m.add(mi2);
        m.add(mi3);
        m.add(mi4);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 300);
        fr.setVisible(true);
        
    }
    
    public void saveFile(){
        fc = new JFileChooser();
        fc.showSaveDialog(fr);
        File file = fc.getSelectedFile();
        try (
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                ){
            String str = this.txt.getText();
            bw.write(str);
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadFile(){
        fc = new JFileChooser();
        fc.showOpenDialog(fr);
        File file = fc.getSelectedFile();
        if (!file.exists()){
            return;
        }
        try (
            FileReader fir = new FileReader(file);
            BufferedReader br = new BufferedReader(fir);
                ) {
            String line = br.readLine();
            while (line != null){
                this.txt.append(line + "\n");
                line = br.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(mi4)){
            System.exit(0);
        } else if (e.getSource().equals(mi1)){
            this.txt.setText("");
            this.saveFile();
        } else if (e.getSource().equals(mi2)){
            this.loadFile();
        } else if (e.getSource().equals(mi3)){
            this.saveFile();
        }
    }
}
