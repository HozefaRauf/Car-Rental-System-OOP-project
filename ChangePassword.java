
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChangePassword extends JFrame implements ActionListener {

    private JLabel  password;
    private JTextField passwordText;
    private JButton update, back;
    private String ID;

    public ChangePassword(String ID) {
        super("Change Password");
        this.ID = ID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        
        password = new JLabel("Password");
        passwordText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(password);
        this.add(passwordText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            CustomerOperations ho = new CustomerOperations();
            String password = passwordText.getText();

            boolean updated = ho.changePassword(ID, password);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Password Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Password Not Updated");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new CustomerPage(ID);

        }
        
    }
    
}