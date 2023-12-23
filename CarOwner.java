import java.io.Serializable;


public class CarOwner extends Person implements Serializable {

    private int Balance; // increases after every HOUR when Owner's car(s) is booked

    public CarOwner() {
        super();
    }

    public CarOwner(String firstName, String lastName, String email, String phoneNo, String CNIC, int Balance) {
        super(firstName, lastName, email, phoneNo, CNIC);
        this.Balance = Balance;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    @Override
    public String toString() {
        return
            super.toString() +
            "Balance= " + getBalance() + "\n";
    }

}

