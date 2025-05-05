
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poring implements Runnable, MouseListener{
    
    private JFrame frame;
    private ImageIcon poring;
    private JLabel label;
    private static int count = 0;
    private int x, y;
    private boolean running = true;
    
    @Override
    public void run() {
        frame = new JFrame("");
                
        poring = new ImageIcon(getClass().getResource("/poring.png"));
        Image img = poring.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        poring = new ImageIcon(img);
        label = new JLabel(poring);
        label.addMouseListener(this);
        this.showCount();
                
        frame.setLayout(new FlowLayout());
        frame.add(label);
        
        x = (int)(Math.random() * 1240);
        y = (int)(Math.random() * 720);
            
        frame.setLocation(x, y);
        
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(200, 150);
        frame.setVisible(true);
        
        this.move();

    }
    
    public static void increaseCount(){
        count++;
    }
    
    public void showCount(){
        label.setText(count + "");

    }
    
    public void move(){
        while (running){
            x += (int)(Math.random() * 11) - 5;
            y += (int)(Math.random() * 11) - 5;
            
            frame.setLocation(x, y);
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(label)){
            frame.dispose();
            running = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
