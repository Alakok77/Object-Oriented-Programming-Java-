import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame implements MouseListener{
    private MyClock clock;
    public void main(){
        JFrame frame = new JFrame();
        clock = new MyClock();
        clock.addMouseListener(this);
        Thread t = new Thread(clock);
        t.start();
        
        frame.setLayout(new FlowLayout());
        frame.add(clock);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(clock)){
            if (clock.getPuased()){
                clock.resume();
            } else {
                clock.pause();
            }
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
