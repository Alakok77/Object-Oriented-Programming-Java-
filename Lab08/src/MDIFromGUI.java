import javax.swing.*;
import java.awt.*;
public class MDIFromGUI {
    private JFrame fr;
    private JMenuBar mb;
    private JMenu m1, m2, m3, ms1;
    private JMenuItem mi1, mi2, mi3, mis1, mis2;
    private JInternalFrame fr1, fr2, fr3;
    private JDesktopPane desktop;
    
    public MDIFromGUI(){
        fr = new JFrame("SubMenuItem Demo");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        desktop = new JDesktopPane();
        fr.setContentPane(desktop);
        
        fr1 = new JInternalFrame("Application 01", true, true, true, true);
        fr2 = new JInternalFrame("Application 02", true, true, true, true);
        fr3 = new JInternalFrame("Application 03", true, true, true, true);
        
        
        fr1.setLocation(50, 200);
        fr2.setLocation(200, 100);
        fr3.setLocation(400, 200);
    
        fr.add(fr1);
        fr.add(fr2);
        fr.add(fr3);
      
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        ms1 = new JMenu("New");
        
        fr.setJMenuBar(mb);
        
        mi1 = new JMenuItem("Open");
        mi2 = new JMenuItem("Save");
        mi3 = new JMenuItem("Exit");
        mis1 = new JMenuItem("Window");
        mis2 = new JMenuItem("Message");
        

        ms1.add(mis1);
        ms1.addSeparator();
        ms1.add(mis2);
        
        m1.add(ms1);
        m1.addSeparator();
        m1.add(mi1);
        m1.addSeparator();
        m1.add(mi2);
        m1.addSeparator();
        m1.add(mi3);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setSize(100, 80);
        fr1.setVisible(true);
        
        fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr2.setSize(100, 100);
        fr2.setVisible(true);
        
        fr3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr3.setSize(150, 200);
        fr3.setVisible(true);
     
        fr.setSize(600, 400);
        fr.setVisible(true);
        
    }
}
