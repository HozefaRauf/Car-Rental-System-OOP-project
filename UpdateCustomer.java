
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UpdateCustomer extends JFrame implements ActionListener {

    private JLabel lID, CarNo, CarReg;
    private JTextField tID, CarNoText, CarRegText;
    private JButton update, back;

    public UpdateCustomer() {
        super("Update Customer Car");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4, 2));

        lID = new JLabel(" ID");
        CarNo = new JLabel("Car Name");
        CarReg = new JLabel("Car Reg ");

        tID = new JTextField();
        CarNoText = new JTextField();
        CarRegText = new JTextField();

        update = new JButton("Update");
        back = new JButton("Back");

        this.add(lID);
        this.add(tID);
        this.add(CarNo);
        this.add(CarNoText);
        this.add(CarReg);
        this.add(CarRegText);
        this.add(update);
        this.add(back);

        update.addActionListener(this);
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update) {
            String ID = tID.getText();
            String CarNo = CarNoText.getText();
            String RegNo = CarRegText.getText();

            AdminOperations ao = new AdminOperations();
            boolean found = ao.updateCar(ID, CarNo, RegNo);

            if (found) {
                JOptionPane.showMessageDialog(null, "car updated successfully");
            } 
            else {
                JOptionPane.showMessageDialog(null, "No such ID Found ");
            }
        }
        else if(e.getSource() == back) {
            this.dispose();
            new Admin();
        }
        
    }
    
}

