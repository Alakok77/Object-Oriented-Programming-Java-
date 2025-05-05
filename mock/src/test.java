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
import java.io.*;
import java.util.Calendar;

public class test implements Runnable{

    private JFrame fr;
    private JLabel lb;
    
    public test() {
        fr = new JFrame();
        
        lb = new JLabel();
        
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        int s = c.get(Calendar.SECOND);
        
        String time = String.format("%02d%02d%02d", h, m, s);
        
        lb.setText(time);
        
        fr.add(lb);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200, 200);
        fr.setVisible(true);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());        
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        test t1 = new test();
        Thread t = new Thread(t1);
        t.start();
        
        
    }

    @Override
    public void run() {
        new test();
    }

   
}
