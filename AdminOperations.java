import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class AdminOperations {


    private ArrayList<Customer> collectionCustomers;
    private File f = new File("Customers.ser");

    public AdminOperations() {
        collectionCustomers = new ArrayList<Customer>();
    }


    public void addCustomer(Customer s) {
        ObjectOutputStream oos = null;
        // write to file
        try {
            if (!f.exists()) {
                f = new File("Customers.ser");
            }
            if (f.exists()) {

                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(s); // write object to file
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(s); // it will write the object to the file.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        catch (Exception e) {
            System.err.println("Cannot Write Object");
        }

        // For closing File

        if (oos != null) {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Customer> viewAllProfiles() {

        ArrayList<Customer> a = new ArrayList<>();
        ObjectInputStream oo = null;

        if (!f.exists())
            return a;
            
    if (f.exists()) {
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                a.add(s);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {
            }

        }

    }

    return a;
    }

 
    
    public ArrayList<Customer> searchByName(String firstName) {

        ArrayList<Customer> a = new ArrayList<>();

        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }

        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {
                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getFirstName().equalsIgnoreCase(firstName)) {
                    a.add(s);
                
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }


        return a;

    }

    public ArrayList<Customer> searchByCustomerID(String CustomerID) {
        ArrayList<Customer> a = new ArrayList<>();
    
        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getID().equalsIgnoreCase(CustomerID)) {
                    a.add(s);
                    break; 
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

    

        return a;

    }

    
    public ArrayList<Customer> searchByCNIC(String CNIC) {
        ArrayList<Customer> a = new ArrayList<>();
        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getCNIC().equalsIgnoreCase(CNIC)) {
                    a.add(s);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

        return a;
    }

    public ArrayList<Customer> searchByPhone(String phone) {
        ArrayList<Customer> a = new ArrayList<>();
        ObjectInputStream oo = null;
        

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getPhoneNo().equalsIgnoreCase(phone)) {
                    a.add(s);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }


        return a;
    }


    


    public boolean updateCar(String ID, String CarName, String RegNo) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer k = (Customer) oo.readObject();
                    collectionCustomers.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // Manipulating the object for 

        for (int i = 0; i < collectionCustomers.size(); i++) {

            if (collectionCustomers.get(i).getID().equalsIgnoreCase(ID)) {

                found = true;

                collectionCustomers.get(i).getCar().setName(CarName);
                collectionCustomers.get(i).getCar().setRegNo(RegNo);

                // again setting the main bill 
                double totalBill = collectionCustomers.get(i).totalBillOfCustomer();
                collectionCustomers.get(i).setTotalBill(totalBill);       
                
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!

        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionCustomers.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionCustomers.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    

    public boolean updateName(String ID, String firstName, String lastName) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer k = (Customer) oo.readObject();
                    collectionCustomers.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }



        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equalsIgnoreCase(ID)) {

                found = true;
                collectionCustomers.get(i).setFirstName(firstName);
                collectionCustomers.get(i).setLastName(lastName);
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionCustomers.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionCustomers.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    public boolean updateEmail(String ID, String email) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer k = (Customer) oo.readObject();
                    collectionCustomers.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // firstly manipulating the object

        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equalsIgnoreCase(ID)) {

                found = true;
                collectionCustomers.get(i).setEmail(email);
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionCustomers.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionCustomers.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    public boolean updatePhone(String ID, String Phone) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer k = (Customer) oo.readObject();
                    collectionCustomers.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // firstly manipulating the object

        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equalsIgnoreCase(ID)) {

                found = true;
                collectionCustomers.get(i).setFirstName(Phone);
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionCustomers.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionCustomers.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }
    
    
    //! Deletion of DATA 
    //* working 🎉

    public boolean removeCustomer(String ID) {

        boolean found = false;
        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer s = (Customer) oo.readObject();
                    collectionCustomers.add(s);

                }
            } catch (EOFException e) {
                // Move to the next line broda
            }
            // now we will move sequentially..

            oo.close();

            // removing the specified object from the arraylist
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (collectionCustomers.get(i).getID().equals(ID) ) {
                    found = true;
                    collectionCustomers.remove(i);
                }
            }


            // now again writing the Arraylist objects in the file first time we will create a new file and then we will append
            // Object for writing class (ObjectOutputStream)
            ObjectOutputStream oos = null;
            // write to file
            int counter = 0;

            if (collectionCustomers.size() > 0) {
                for (int i = 0; i < collectionCustomers.size(); i++) {

                    System.out.println("Writing again to the file");

                    if (counter > 0) {
                        // when you are running it for the second and afterwards iterations you will append the file
                        oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                        oos.writeObject(collectionCustomers.get(i));

                    } else {
                        // for the first time you will create a new file
                        oos = new ObjectOutputStream(new FileOutputStream(f));
                        oos.writeObject(collectionCustomers.get(i));
                        counter++;
                    }

                }

                // For closing File

                if (oos != null) {
                    oos.close();
                }

            }
            else if (collectionCustomers.size() == 0) {
                // System.out.println("File deleting");
                f.delete();
                // System.out.println("File deleted");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }


        return found;

    }

    public boolean removeCustomer(String firstName , String secondName ) {

        boolean found = false;
        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            try {
                while (true) {

                    Customer s = (Customer) oo.readObject();
                    collectionCustomers.add(s);

                }
            } catch (EOFException e) {
                // Move to the next line broda
            }
            // now we will move sequentially..

            oo.close();

            // removing the specified object from the arraylist
            for (int i = 0; i < collectionCustomers.size(); i++) {
                if (collectionCustomers.get(i).getFirstName().equalsIgnoreCase(firstName) && collectionCustomers.get(i).getLastName().equalsIgnoreCase(secondName)) {
                    found = true;
                    collectionCustomers.remove(i);
                }
            }


            // now again writing the Arraylist objects in the file first time we will create a new file and then we will append
            // Object for writing class (ObjectOutputStream)
            ObjectOutputStream oos = null;
            // write to file
            int counter = 0;

            if (collectionCustomers.size() > 0) {
                for (int i = 0; i < collectionCustomers.size(); i++) {

                    System.out.println("Writing again to the file");

                    if (counter > 0) {
                        // when you are running it for the second and afterwards iterations you will append the file
                        oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                        oos.writeObject(collectionCustomers.get(i));

                    } else {
                        // for the first time you will create a new file
                        oos = new ObjectOutputStream(new FileOutputStream(f));
                        oos.writeObject(collectionCustomers.get(i));
                        counter++;
                    }

                }

                // For closing File

                if (oos != null) {
                    oos.close();
                }

            }
            else if (collectionCustomers.size() == 0) {
                // System.out.println("File deleting");
                f.delete();
                // System.out.println("File deleted");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }


        return found;

    }

    //! Forgot Password
    //* working 🎉
    public String getPass(String ID) {
        StringBuilder passwordDetails = new StringBuilder();
        ObjectInputStream oo = null;

        if (!f.exists()) {
            return "NO Such ID found !";
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getID().equalsIgnoreCase(ID)) {
                    passwordDetails.append("Name :" + s.getFirstName() + " " + s.getLastName() + "\n" + " ID :"
                            + s.getID() + "\n" + "Password : " + s.getPassword());
                    break;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

        String details = passwordDetails.toString();

        return details;

    }
    
    
    //! To check if the current HostelID exists
    public boolean IDExists(String ID) {

        
        ObjectInputStream oo = null;

        if (!f.exists())
            return false;
            
    if (f.exists()) {
        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getID().equalsIgnoreCase(ID)) {
                    return true;
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {
            }

        }

    }

    return false;
    }


 
    

    
}
