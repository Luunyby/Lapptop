import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LaptopCollection {
    public ArrayList<Laptop> arrayz;
    
    public LaptopCollection(StringLoader stringer){
        int rowsInStringer = stringer.getNumRows();
        this.arrayz = new ArrayList<Laptop>();
        for( int i = 0 ; i < rowsInStringer ; i++) {
            Laptop loaded = new Laptop(stringer.getRow(i));
            this.arrayz.add(loaded);
        }
    }
    
    public LaptopCollection(StringLoader stringer, char random){
        int rowsInStringer = stringer.getNumRows();
        Random randomRow = new Random();
        this.arrayz = new ArrayList<Laptop>();
        for( int i = 0 ; i < rowsInStringer ; i++) {
            int randomizedRow = randomRow.nextInt(1303);
            Laptop loaded = new Laptop(stringer.getRow(randomizedRow));
            this.arrayz.add(loaded);
        }
    }
    
    public String toString(){
        return Arrays.deepToString(arrayz.toArray());
    }
    
    public Laptop getAt(int index){
        return arrayz.get(index);
    }
    
    public int length() {
        return arrayz.size();
    }
    
    public void sortByID() {
        Collections.sort(arrayz);
    }
    
    public Laptop searchByID(int id) {
        Laptop laptopIdHolder = new Laptop(""+id);
        int location = Collections.binarySearch(arrayz, laptopIdHolder);
        if (location >= 0) {
            return arrayz.get(location);
        } else {
            return laptopIdHolder;
        }
    }
    
    public boolean equals(LaptopCollection equalTo) {
        boolean check = false;
        if( arrayz.size() == equalTo.length() ) {
            for (int i = 0 ; i < equalTo.length() ; i++) {
                if (arrayz.get(i).equals(equalTo.getAt(i))){
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
    
    public Laptop getLaptop(int id){
        Laptop finder = new Laptop(""+id);
        int location = Arrays.binarySearch(arrayz.toArray() , finder);
        if (location >= 0) {
            return arrayz.get(location);
        } else {
            return finder;
        }
    }
    
    public static void main () {
        StringLoader amazonEmployee = new StringLoader();
        StringLoader upsEmployee = new StringLoader();
        upsEmployee.load("laptop_price.csv");
        amazonEmployee.load("laptop_price.csv");
        
        LaptopCollection amazonTruck = new LaptopCollection(amazonEmployee);
        LaptopCollection amazonTruckRandom = new LaptopCollection(amazonEmployee, 'v');
        
        System.out.println(amazonTruckRandom.toString());
        amazonTruckRandom.sortByID();
        System.out.println(amazonTruckRandom.toString());
        LaptopCollection upsTruck = new LaptopCollection(upsEmployee);
        System.out.println(amazonTruck.getAt(28).getDescription());
        System.out.println(amazonTruck.getLaptop(6).getDescription());
        System.out.println(amazonTruck.searchByID(1320).getDescription());
        System.out.println(amazonTruck.searchByID(398).getDescription());
        System.out.println(amazonTruck.toString());
        System.out.println(amazonTruck.length());
        System.out.println(amazonTruck.equals(upsTruck));
        System.out.println(upsTruck.equals(amazonTruck));
        amazonTruck.sortByID();
        System.out.println(amazonTruck.searchByID(28));
        System.out.println(amazonTruckRandom.searchByID(1303).getDescription());
        System.out.println(amazonTruckRandom.getAt(1302).getDescription());
    }
}
