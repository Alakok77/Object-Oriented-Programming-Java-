
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lenovo
 */
public class ChatDemo implements ActionListener{
    private JFrame frame;
    private JTextArea textArea;
    private JTextField textField;
    private JButton submit, reset;
    private JPanel buttom;
    private DateTimeFormatter dtf;
    
    public ChatDemo(){
        frame = new JFrame("");
        textArea = new JTextArea(20, 45);
        textField = new JTextField(45);
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        buttom = new JPanel();
        
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        frame.setLayout(new FlowLayout());
        
        textArea.setEditable(false);
        loadTextFromFile();
        
        submit.addActionListener(this);
        reset.addActionListener(this);
        
        buttom.add(submit);
        buttom.add(reset);
        
        frame.add(textArea);
        frame.add(textField);
        frame.add(buttom);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470,430);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submit)){
            if (!textField.getText().isEmpty()) {
                textArea.append(dtf.format(LocalDateTime.now()) + " : " + textField.getText() + "\n");
                saveTextToFile(dtf.format(LocalDateTime.now()) + " : " + textField.getText() + "\n");
                textField.setText("");
            }
        } else if (e.getSource().equals(reset)){
            textArea.setText("");
            delete();
        }
    }
    
    public void saveTextToFile(String str){
        try (
                FileWriter fw = new FileWriter("ChatDemo.dat", true);
                BufferedWriter bw = new BufferedWriter(fw);
                )
        {
            if (!str.isEmpty()){
                bw.write(str);
                bw.newLine();
            }
         } catch (IOException e){
            System.out.println(e);
        }
    }
    
    public void loadTextFromFile() {
        
        File file = new File("ChatDemo.dat");
        if (!file.exists()){
            return;
        }
        
        try (
            FileReader fr = new FileReader("ChatDemo.dat");
            BufferedReader br = new BufferedReader(fr)
        ) {
            String line = br.readLine();
            while (line != null) {
                if (!line.isEmpty()){
                    textArea.append(line + "\n");
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void delete(){
        try (
                FileWriter fw = new FileWriter("ChatDemo.dat", false);
                BufferedWriter bw = new BufferedWriter(fw);
                )
        {
            bw.write("");
            bw.newLine();
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
