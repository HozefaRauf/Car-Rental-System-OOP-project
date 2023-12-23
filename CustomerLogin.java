import javax.swing.*;
//import CustomerOperations;
import java.awt.*;
import java.awt.event.*;

public class CustomerLogin extends JFrame implements ActionListener {
    private JLabel CustomerID, Password;
    private JTextField CustomerIDText, passwordText;
    private JButton LoginButton, backButton;
    private JButton forgotPassword;



    public CustomerLogin() {

        super("Customer Login ");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        CustomerID = new JLabel("Customer ID");
        Password = new JLabel("Password");
        CustomerIDText = new JTextField();
        passwordText = new JTextField();
        LoginButton = new JButton("Login");
        forgotPassword = new JButton("forgot Password");
        backButton = new JButton("Back");

        this.add(CustomerID);
        this.add(CustomerIDText);
        this.add(Password);
        this.add(passwordText);
        this.add(LoginButton);
        this.add(backButton);
        this.add(forgotPassword);

        LoginButton.addActionListener(this);
        backButton.addActionListener(this);
        forgotPassword.addActionListener(this);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginButton) {
            CustomerOperations ho = new CustomerOperations();
            
            String CustomerID = CustomerIDText.getText();
            String password = passwordText.getText();
            boolean login = ho.credentialsFound(CustomerID, password);

            if (login) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                this.dispose();
                new CustomerPage(CustomerID);
            } 
            else {
                JOptionPane.showMessageDialog(null, "Login Failed Try Again!");
            }
        }
        
        else if (e.getSource() == backButton) {
            this.dispose();
            new Main();
        }
        
        else if (e.getSource() == forgotPassword) {
            this.dispose();
            new AdminLogin();

        }
    }
}
