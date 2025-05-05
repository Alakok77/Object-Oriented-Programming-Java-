import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoringConstructor implements ActionListener{
    
    private JFrame frame;
    private  JButton button;
    private Poring poring;
    
    public PoringConstructor(){
        frame = new JFrame("");
        button = new JButton("Add");
        button.addActionListener(this);
        button.setSize(20, 20);
        
        frame.setLayout(new FlowLayout());
        frame.add(button);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(button)){
            Poring.increaseCount();
            poring = new Poring();
            Thread t1 = new Thread(poring);
            t1.start();
        }
    }
    
}
