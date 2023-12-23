import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;




public class CustomerOperations {

    private ArrayList<Customer> collectionCustomers;
    private File f = new File("Customers.ser");


    public CustomerOperations() {
        collectionCustomers = new ArrayList<Customer>();
    }

    public String getProfileInfo(String ID) {

        StringBuilder details = new StringBuilder();

        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {

                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getID().equals(ID)) {
                    details.append(s.toString());
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

        return details.toString();

    }



    public boolean changePassword(String ID, String password) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equals(ID)) {
                found = true;
                collectionCustomers.get(i).setPassword(password);
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionCustomers.size(); i++) {
                // System.out.println("After Manipulation reading loop - size of arraylist"+ i);
                if (counter > 0) {
                    // System.out.println("counter greater then 0");
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionCustomers.get(i));

                } else {
                    // System.out.println("counter is 0");
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


        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equals(ID)) {
                found = true;
                collectionCustomers.get(i).setEmail(email);
            }
        }

 
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

    public boolean updatePhoneNumber(String ID, String phoneNo) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionCustomers.size(); i++) {
            if (collectionCustomers.get(i).getID().equals(ID)) {
                found = true;
                collectionCustomers.get(i).setPhoneNo(phoneNo);
            }
        }


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

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }


    public boolean credentialsFound(String ID, String password) {
        boolean found = false;
        ObjectInputStream oo = null;


        try {
            oo = new ObjectInputStream(new FileInputStream("Customers.ser"));

            while (true) {
                // Reading object is below
                Customer s = (Customer) oo.readObject();
                if (s.getID().equalsIgnoreCase(ID) && s.getPassword().equalsIgnoreCase(password)) {
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

        return found;

    }






}

