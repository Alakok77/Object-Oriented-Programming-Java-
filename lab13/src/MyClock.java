
import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MyClock extends JLabel implements Runnable{
    
    private int sec = 0;
    private int min = 0;
    private int hour = 0;

    private boolean paused;
    
//    @Override
//    public void run() {
//        while (true){
//            Calendar d = Calendar.getInstance();
//            int sec = d.get(Calendar.SECOND);
//            int min = d.get(Calendar.MINUTE);
//            int hour = d.get(Calendar.HOUR_OF_DAY);
//            
//            this.setFont(new Font("Kodchasan", Font.BOLD,20));
//            
//            String time = String.format("%02d:%02d:%02d", hour, min, sec);
//            this.setText(time);
//            
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//    
//    clock2
    @Override
    public void run() {
        while (true){
            Calendar d = Calendar.getInstance();

            this.setFont(new Font("Kodchasan", Font.BOLD,20));
            
            String time = String.format("%02d:%02d:%02d", hour, min, sec);
            this.setText(time);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            this.checkPuased();
            
            sec++;
            
            if (sec == 60){
                sec = 0;
                min++;
            }
            if (min == 60){
                min = 0;
                hour++;
            }
        }
    }
    
    public void pause(){
        this.paused = true;
    }
    
    public synchronized void resume(){
        this.paused = false;
        this.notify();
    }
    
    public synchronized void checkPuased(){
        while (this.paused){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean getPuased(){
        return this.paused;
    }
}
