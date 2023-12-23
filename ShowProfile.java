import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ShowProfile extends JFrame implements ActionListener {

    JButton profileInfo, back;
    private String ID;

    public ShowProfile(String ID) {
        super("Profile");
        this.ID = ID;
        this.setSize(500, 500);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setLayout(new GridLayout(2, 1));

        profileInfo = new JButton("Profile Info");
        back = new JButton("Back");

        this.add(profileInfo);
        this.add(back);

        back.addActionListener(this);
        profileInfo.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back) {
            this.dispose();
            new CustomerPage(ID);
        }
        else if (e.getSource() == profileInfo) {
            CustomerOperations h = new CustomerOperations();
            String profile = h.getProfileInfo(ID);
            JOptionPane.showMessageDialog(null,profile);
        }
        
    }

}