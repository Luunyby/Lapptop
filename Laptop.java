
import java.util.Arrays;
import java.util.Formatter;

/**
 * Describes a laptop.
 *
 * @author Bradley Gaines
 */
public class Laptop implements Comparable<Laptop>{
    int lapID;
    String company;
    String product;
    String type;
    String cpu;
    String gpu;
    int ram;
    String storage;
    double screenSize;
    String resolution;
    String operatingSystem;
    double weight;
    double price;
    String[] inputArray = new String[13];
    final String space = ", ";
    final String[] attributeTypes = {
      "ID Number", "Company", "Product", "Type", "Screen Size [in]", "Resolution", "CPU", "RAM [GB]",
      "Storage", "GPU", "OS", "Weight [kg]", "Price [€]"
    };
    
    public int compareTo(Laptop compareThis) {
        if (this.lapID > compareThis.getID()) {
            return 1;
        } else if (this.lapID < compareThis.getID()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * Creates a laptop class when only given the ID String.
     * 
     * @param lapID String containing the laptop's ID.
     */
    public Laptop(String lapID){
        this.lapID = Integer.parseInt(lapID);
        this.inputArray[0] = lapID;
        for ( int i = 1; i < inputArray.length ; i++){
            this.inputArray[i] = "N/A" ;
        }
    }
    
    public Laptop(){
        for ( int i = 0; i < inputArray.length ; i++){
            this.inputArray[i] = "N/A" ;
        }
    }
    
    /**
     * Laptop ID getter.
     */
    public int getID(){
        return lapID;
    }
    
    public int getNumAttributes() {
        return attributeTypes.length;
    }
    
    public String getAttribute(int arrayNum) {
        return attributeTypes[arrayNum];
    }
    
    public String getField(int arrayNum) {
        return inputArray[arrayNum];
    }
    
    /**
     * Gets the array that defines the laptop.
     */
    public String[] getArray(){
        return inputArray;
    }
    
    public double getPrice() {
        return price;
    }
    
    /**
     * Gets the value of the internal array at the position num.
     * 
     * @param num Index of array that's being accessed.
     */
    public String getArrayAt(int num){
        return inputArray[num];
    }
    
    /**
     * Constructor for the class when given the full input array.
     * 
     * @param input String array containing the different attributes of the laptop being described.
     */
    
    public Laptop(String[] input){
        if(input.length == 13){
            this.inputArray = Arrays.copyOf(input, 13);
            this.lapID = Integer.parseInt(inputArray[0]);
            this.company = inputArray[1];
            this.product = inputArray[2];
            this.type = inputArray[3];
            this.screenSize = Double.parseDouble(inputArray[4]);
            this.resolution = inputArray[5];
            this.cpu = inputArray[6];
            this.ram = Integer.parseInt(inputArray[7]);
            this.storage = inputArray[8];
            this.gpu = inputArray[9];
            this.operatingSystem = inputArray[10];
            this.weight = Double.parseDouble(inputArray[11]);
            this.price = Double.parseDouble(inputArray[12]);
        } else {
            for ( int i = 0; i < inputArray.length ; i++){
                this.inputArray[i] = "ERROR" ;
            }
        }
    }
    
    public String toString(){
        StringBuilder laptopString = new StringBuilder();
        
        laptopString = laptopString.append(lapID + space + company + space
        + product + space + type + space + screenSize + space + resolution + space + cpu +
        space + ram + space + storage + space + gpu + space +
        operatingSystem + space + weight + space + price);
        
        String finishedString = laptopString.toString();
        return finishedString;
    }
    
    /**
     * Prints a formatted description of the laptop object.
     */
    public String getDescription(){
        
        StringBuilder builder = new StringBuilder();
        Formatter formatString = new Formatter(builder);
        for(int i = 0; i < inputArray.length; i++){
            formatString.format("%-20s [%s]\n", attributeTypes[i], inputArray[i]);
            //formatString.format("|%-60s|%-60s|\n", attributeTypes[i], inputArray[i]);
        }
        String description = builder.toString();
        return description;
    }
    
    
    public boolean equals(Laptop secondLaptop){
        boolean returnedValue = false;
        if(inputArray.length == secondLaptop.getArray().length){
            for(int i = 0; i < inputArray.length - 1; i++){
                String laptopHolder = inputArray[i].toLowerCase();
                String arrayHolder = secondLaptop.getArrayAt(i).toLowerCase();
                if(laptopHolder.equals(arrayHolder)){
                    returnedValue = true;
                } else {
                    returnedValue = false;
                    break;
                }
            }
        }
        return returnedValue;
        }
    
    public static void main(String[] args){
        String[] sample = {"6","Acer","Aspire","Notebook","AMD","Radeon","4",
        "500GB HDD","15.0","1366x768","Windows 10","2.1","400.00"};
        String[] sampleTwo = {"6","Acer","Aspire","Notebook","AMD","Radeon","4",
        "500GB HDD","15.0","1366x768","Windows 10","2.1","400.00"};
        String[] sampleThree = {"6","Acer","Aspire","Laptop","AMD","Radeon","4",
        "500GB HDD","15.0","1366x768","Windows 10","2.1","400.00"};
        Laptop pc = new Laptop(sample);
        Laptop pcTwo = new Laptop(sampleTwo);
        Laptop pcZed = new Laptop(sampleThree);
        Laptop pcThree = new Laptop("7");
        Laptop pcFour = new Laptop("6");
        String output = pc.toString();
        System.out.println(output);
        System.out.println(pc.getID());
        System.out.println(pc.getDescription());
        System.out.println(pcThree.getDescription());
        
        if(pc.equals(pcTwo)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        if(pc.equals(pcZed)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        if(pc.equals(pcThree)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        if(pcThree.equals(pcFour)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
