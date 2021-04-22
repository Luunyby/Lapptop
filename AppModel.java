import javax.swing.JOptionPane;
import java.io.*;


public class AppModel {
    LaptopCollection arrayLaptop;
    StringLoader laptops;
    String fileName;
    
    public AppModel (String filename) {
        laptops = new StringLoader();
        laptops.load(filename);
        this.fileName = filename;
        arrayLaptop = new LaptopCollection(laptops);
    }
    
    public Laptop findLaptop(String id) {
        int holdID = -1;
        Laptop found;
        holdID = errorCheck(id);
        if (holdID > -1) {
            found = arrayLaptop.searchByID(holdID);
        } else {
            found = new Laptop();
        }
        return found;
    }
    
    public int getNumFields() {
        Laptop find = new Laptop();
        return find.getNumAttributes();
    }
    
    public String getNameFields(int arrayNum) {
        Laptop find = new Laptop();
        return find.getAttribute(arrayNum);
    }
    
    public String getFields(int arrayNum) {
        Laptop find = new Laptop();
        return find.getField(arrayNum);
    }
    
    public int length() {
        return arrayLaptop.length();
    }
    
    public void writeLaptop(String holdID) {
        int checkID = -1;
        Laptop found;
        checkID = errorCheck(holdID);
        if (checkID > -1) {
            found = arrayLaptop.searchByID(checkID);
            try {
                FileWriter right = new FileWriter("Laptop" + holdID + ".txt");
                right.write(found.getDescription());
                right.close();
            } catch (Exception deez) {
                System.out.println("ERROR");
            }
        }
    }
    
    public void findPriceRange(String low, String high) {
        int lowHold = errorCheckPrice(low);
        int highHold = errorCheckPrice(high);
        if (lowHold >= 0 && highHold >= 0) {
            arrayLaptop = new PriceRangeArray(laptops, lowHold, highHold);
        }
    }
    
    public int errorCheckPrice(String holdBound) {
        int checkBound = -1;
        try {
            checkBound = Integer.valueOf(holdBound.trim());
        } 
        catch (NumberFormatException e) {
            if (checkBound == -1) {
                JOptionPane.showMessageDialog(null, "Number Expected");
            } else {
                JOptionPane.showMessageDialog(null, "Number Greater Than 0 Expected");
            }
        }
        return checkBound;
    }
    
    public int errorCheck(String holdID) {
        int checkID = -1;
        try {
            checkID = Integer.valueOf(holdID.trim());
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Number Expected");
        }
        if (checkID <= 0 || checkID > arrayLaptop.length() ) {
            JOptionPane.showMessageDialog(null, "Number outside range");
            checkID = -1;
        }
        return checkID;
    }
}
