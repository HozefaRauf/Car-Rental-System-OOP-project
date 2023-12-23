

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DeleteCustomer extends JFrame implements ActionListener {


    private JLabel ID;
    private JTextField IDText;
    private JButton delete , back;

    public DeleteCustomer() {
        super("Delete By ID");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        ID = new JLabel("Customer ID");
        IDText = new JTextField();
        delete = new JButton("Delete");
        back = new JButton("Back");

        this.add(ID);
        this.add(IDText);
        this.add(delete);
        this.add(back);

        delete.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            AdminOperations ao = new AdminOperations();
            String ID = IDText.getText();

            boolean found = ao.removeCustomer(ID);

            if (found) {
                JOptionPane.showMessageDialog(null, " deleted successfully");
            } 
            else {
                JOptionPane.showMessageDialog(null, "user not found");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }

    }
    
}
