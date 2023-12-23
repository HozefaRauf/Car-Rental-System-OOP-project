import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AddCustomer extends JFrame implements ActionListener {
    private JLabel lID, lpassword, lFirstName, lSecondName, lEmail, lPhoneNumber,
            lCNIC, lDayForRent,lBookingID, lCarName, lCarColour, lRegNo;

    private JTextField tID, tpassword, tFirstName, tSecondName, tEmail, tPhoneNumber,
            tCNIC,  tDayForRent, tBookingID, tCarName, tCarColour, tRegNo;

    private JButton Add, Back;

    public AddCustomer() {
        super("Add Customer");
        this.setSize(600, 600);
        this.setForeground(Color.BLACK);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(13, 2));

        lID = new JLabel("Customer ID");
        lpassword = new JLabel("Password");
        lFirstName = new JLabel("First Name");
        lSecondName = new JLabel("Second Name");
        lEmail = new JLabel("Email");
        lPhoneNumber = new JLabel("Phone Number");
        lCNIC = new JLabel("CNIC");
        lBookingID= new JLabel("BookingID ID");
        lDayForRent= new JLabel("Days For Rent");
        lCarName= new JLabel("Car ID");
        lCarColour= new JLabel("Car Colour");
        lRegNo= new JLabel("Car Reg No");


        tID = new JTextField();
        tpassword = new JTextField();
        tFirstName = new JTextField();
        tSecondName = new JTextField();
        tEmail = new JTextField();
        tPhoneNumber = new JTextField();
        tCNIC = new JTextField();
        tBookingID = new JTextField();
        tDayForRent = new JTextField();
        tCarName = new JTextField();
        tCarColour = new JTextField();
        tRegNo= new JTextField();



        Add = new JButton("Add");
        Back = new JButton("Back");

        this.add(lID);
        this.add(tID);
        this.add(lpassword);
        this.add(tpassword);
        this.add(lFirstName);
        this.add(tFirstName);
        this.add(lSecondName);
        this.add(tSecondName);
        this.add(lEmail);
        this.add(tEmail);
        this.add(lPhoneNumber);
        this.add(tPhoneNumber);
        this.add(lCNIC);
        this.add(tCNIC);
        this.add(lBookingID);
        this.add(tBookingID);
        this.add(lDayForRent);
        this.add(tDayForRent);
        this.add(lCarName);
        this.add(tCarName);
        this.add(lCarColour);
        this.add(tCarColour);
        this.add(lRegNo);
        this.add(tRegNo);

        this.add(Add);
        this.add(Back);

        Add.addActionListener(this);
        Back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add) {
            // now checking if the input HostelID exists or not
            String password = tpassword.getText();
            String firstName = tFirstName.getText();
            String secondName = tSecondName.getText();
            String ID = tID.getText();
            String email = tEmail.getText();
            String phoneNumber = tPhoneNumber.getText();
            String CNIC= tCNIC.getText();
            String BookingID = tBookingID.getText();
            String DayForRent = tDayForRent.getText();
            String CarName = tCarName.getText();
            String CarColour = tCarColour.getText();
            String carRegNO = tRegNo.getText(); 
            AdminOperations a = new AdminOperations();

            
            // getting input from the user for Customer

            if(ID.equals("")||password.equalsIgnoreCase("") || firstName.equalsIgnoreCase("") || secondName.equalsIgnoreCase("") || email.equalsIgnoreCase("") || phoneNumber.equalsIgnoreCase("") || CNIC.equalsIgnoreCase("") || DayForRent.equalsIgnoreCase("") || CarName.equalsIgnoreCase("")|| CarColour.equalsIgnoreCase("") || carRegNO.equalsIgnoreCase("") || BookingID.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Kindly Fill all text fields to add the Customer");
            }

            else if (a.IDExists(ID)) {
                JOptionPane.showMessageDialog(null, "This Id already Exists !");
            }

            else{
            
            // making Objects
            Car m =new Car(CarName, CarColour, carRegNO);

            // making Customer
            Customer h = new Customer(firstName, secondName, email, phoneNumber, CNIC ,ID, m, BookingID, DayForRent, password);

            // making AdminFile Operations Object
            AdminOperations ao = new AdminOperations();
            ao.addCustomer(h);
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");

        }

    }

        else if (e.getSource() == Back) {
            dispose();
            new Admin();
        }
    }

}
    
