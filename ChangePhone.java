import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ChangePhone extends JFrame implements ActionListener {

    private JLabel phoneNumber;
    private JTextField phoneNumberText;
    private JButton update, back;
    private String ID;

    public ChangePhone(String ID) {
        super("Update Phone Number");
        this.ID = ID;
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

    
        phoneNumber = new JLabel("Phone Number");
        phoneNumberText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(phoneNumber);
        this.add(phoneNumberText);
        this.add(update);
        this.add(back);

        
        
        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {

            String phoneNumber = phoneNumberText.getText();
            CustomerOperations ho = new CustomerOperations();
            boolean updated = ho.updatePhoneNumber(ID, phoneNumber);

            if (updated) {
                JOptionPane.showMessageDialog(null, "Phone Number Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Phone Number Not Updated");
            }
        }

        else if(e.getSource() == back) {
            this.dispose();
            new CustomerPage(ID);

        }
        
    }
    
}
