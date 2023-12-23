import java.io.Serializable;

public class Car implements Serializable {

    private String Name, Colour;
    String  RegNo;
    private int RentPerHour=50;


    public Car() {
    }

    public Car(  String Name, String Colour,  String RegNo) {
        this.Name = Name;
        this.Colour = Colour;
        this.RegNo = RegNo;

    }



    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String Colour) {
        this.Colour = Colour;
    }


    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    public int getRentPerHour() {
        return RentPerHour;
    }

    public void setRentPerHour(int RentPerHour) {
        this.RentPerHour = RentPerHour;
    }



    @Override
    public String toString() {
        return 
            "Name = " + getName() + "\n" +
            "Colour = " + getColour() + "\n"+
            "RegNo = " + getRegNo() + "\n"+
            "Rent per Hour= " + getRentPerHour() + "\n" 
;
    }


}

