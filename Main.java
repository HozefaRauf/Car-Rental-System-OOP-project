import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JLabel heading;
    private JButton Admin;
    private JButton Customer;

    public Main() {
        super("Car Rental System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        heading = new JLabel("Weclome to Car Rental System");
        heading.setBounds(140, 50, 300, 50);
        add(heading);

        Admin = new JButton("Admin");
        Admin.setBounds(50, 150, 350, 120);
        add(Admin);

        Customer = new JButton("Customer");
        Customer.setBounds(50, 300, 350, 120);
        add(Customer);

        Admin.addActionListener(this);
        Customer.addActionListener(this);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Admin) {
            new AdminLogin();
        }

        else if (e.getSource() == Customer) {
            new CustomerLogin();
        }     
    }
}