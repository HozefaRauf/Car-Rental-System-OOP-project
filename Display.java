

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;



public class Display extends JFrame implements ActionListener {
    
    JButton profiles;
    JButton back;

    public Display() {
        super("View All Profiles");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 1));
        
    
        profiles = new JButton("Profiles");
        back = new JButton("Back");
        
        this.add(profiles);
        this.add(back);


        profiles.addActionListener(this);
        back.addActionListener(this);


        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == profiles) {
            AdminOperations ao = new AdminOperations();
            ArrayList <Customer> s = ao.viewAllProfiles();

            if (s.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Data Found");
            }
            
            if (s.size() >= 1) {
                for (int i = 0; i < s.size(); i++) {
                    String details = s.get(i).toString();
                    JOptionPane.showMessageDialog(null ,details);
                }
            }            

        }
        if (e.getSource() == back) {
            this.dispose();
            new Admin();
        }
        
    }
}

