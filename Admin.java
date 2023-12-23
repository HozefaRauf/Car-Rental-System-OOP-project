import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements ActionListener {
    private JButton addCustomer,readAllCustomers, searchCustomer, updateCustomer, deleteCustomer,ShowPasswords, monthButton;
    private JButton back;

    public Admin() {
        super("Admin Screen");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 1));

        addCustomer = new JButton("Add Profile");
        readAllCustomers = new JButton("View All Customers");
        searchCustomer = new JButton("Search Info");
        updateCustomer = new JButton("Update Info");
        deleteCustomer = new JButton("Delete Profile");
        ShowPasswords = new JButton("Get Passwords");
        monthButton=new JButton("More than Month");
        back = new JButton("Back");


        this.add(addCustomer);
        this.add(readAllCustomers);
        this.add(searchCustomer);
        this.add(updateCustomer);
        this.add(deleteCustomer);
        this.add(ShowPasswords);
        this.add(monthButton);
        this.add(back);

        addCustomer.addActionListener(this);
        readAllCustomers.addActionListener(this);
        searchCustomer.addActionListener(this);
        updateCustomer.addActionListener(this);
        deleteCustomer.addActionListener(this);
        ShowPasswords.addActionListener(this);
        monthButton.addActionListener(this);
        back.addActionListener(this);


    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCustomer) {
            this.dispose();
            new AddCustomer();
        }
        
        else if (e.getSource() == readAllCustomers) {
            this.dispose();
            new Display();

        }
        else if(e.getSource() == searchCustomer) {
            this.dispose();
            new SearchCustomer();
        }
        else if(e.getSource() == updateCustomer) {
            this.dispose();
            new UpdateCustomer();
        }
        else if(e.getSource() == deleteCustomer) {
            this.dispose();
            new DeleteCustomer();
        }
        
        else if (e.getSource() == ShowPasswords) {
            this.dispose();
            new ShowPassword();
        }
        else if (e.getSource() == monthButton) {
            this.dispose();
            new Month();
        }
        
        else if(e.getSource() == back) {
            this.dispose();
            new Main();
        }
        
    } 
    
}

