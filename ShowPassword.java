
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShowPassword extends JFrame implements ActionListener {
    
    private JLabel ID;
    private JTextField IDTextField;
    private JButton search, back;

    public ShowPassword() {
        
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 2));

        ID = new JLabel("Customer ID");
        IDTextField = new JTextField();
        search = new JButton("Search");
        back = new JButton("Back");

        this.add(ID);
        this.add(IDTextField);
        this.add(search);
        this.add(back);

        search.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            AdminOperations ao = new AdminOperations();
            String ID = IDTextField.getText();
            String details = ao.getPass(ID);
            
            JOptionPane.showMessageDialog(null, details);
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();            
        }
    }
    
}
