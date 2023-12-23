import java.io.Serializable;

public class Customer extends Person implements Serializable {

    private String ID;
    private String password;
    private Car car;
    private double totalBill;
    private String BookingID;
    private String dayForRent; 

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String email, String phoneNo, String CNIC, String ID, Car car, String BookingID, String dayForRent, String password) {
        super(firstName, lastName, email, phoneNo, CNIC);
        this.ID=ID;
        this.password=password;
        this.car=car;
        this.BookingID=BookingID;
        this.dayForRent=dayForRent;

    }

    

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    


    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String bookingID) {
        BookingID = bookingID;
    }

    

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDayForRent() {
        return dayForRent;
    }

    public void setDayForRent(String dayForRent) {
        this.dayForRent = dayForRent;
    }


    


    public int totalBillOfCustomer() {
        long totalTime = Integer.parseInt(dayForRent)*24;

        int rentPerHour = this.getCar().getRentPerHour();
        if (totalTime != 0) {
            return (int) (rentPerHour * totalTime);
        } else {
            return rentPerHour;
        }
    }

    @Override
    public String toString() {
        return
            super.toString() +
            "ID= " + getID() + "\n"+
            "Car= "+ getCar() + "\n" +
            "Total Bill= "+ totalBillOfCustomer() + "\n" +
            "Booking ID= "+ getBookingID() + "\n" +
            "Rent Time= "+ getDayForRent() + "\n"   ;

    }




    



    


}

