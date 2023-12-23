import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerPage extends JFrame implements ActionListener {

    JButton getProfile , changePassword, updateEmail , updatePhone, back;
            
    private String ID;        

    public CustomerPage(String ID) {
        super("Customer Portal");
        this.ID = ID;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(5, 1));

        getProfile = new JButton("Show Profile");
        changePassword = new JButton("Change Password");
        updateEmail = new JButton("Update Email");
        updatePhone = new JButton("Update Phone");
        back = new JButton("Back");

        this.add(getProfile);
        this.add(changePassword);
        this.add(updateEmail);
        this.add(updatePhone);
        this.add(back);

        getProfile.addActionListener(this);
        changePassword.addActionListener(this);
        updateEmail.addActionListener(this);
        updatePhone.addActionListener(this);
        back.addActionListener(this);

    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getProfile) {
            this.dispose();
            new ShowProfile(ID);
        }
        else if (e.getSource() == changePassword) {
            this.dispose();
            new ChangePassword(ID);
        }
        else if (e.getSource() == updateEmail) {
            this.dispose();
            new ChangeEmail(ID);
        }
        else if (e.getSource() == updatePhone) {
            this.dispose();
            new ChangePhone(ID);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Main();
        }
    }
    

    
}
