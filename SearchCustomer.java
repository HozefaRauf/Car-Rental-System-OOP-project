 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SearchCustomer extends JFrame implements ActionListener {
    private JLabel lID;
    private JTextField IDText;
    private JButton search;
    private JButton back;

    public SearchCustomer() {
        super("Search Customer");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 2));

        lID = new JLabel(" ID");
        IDText = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(lID);
        this.add(IDText);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search) {
            AdminOperations ao = new AdminOperations();
            String ID = IDText.getText();

            ArrayList<Customer> arr = ao.searchByCustomerID(ID);

            if (arr.size() == 0) {
                JOptionPane.showMessageDialog(null, "No Such ID Found!");
            }
            else {
                for (int i = 0; i < arr.size(); i++) {
                    String details = arr.get(i).toString();
                    JOptionPane.showMessageDialog(null,details);
                }
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
    }
    
}
