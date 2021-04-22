import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PriceRangeArray extends LaptopCollection {
    String stringerHold;
    int priceLow;
    int priceHigh;
    
    public PriceRangeArray(StringLoader stringer, int low, int high){
        super(stringer);
        int test = stringer.getNumRows();
        this.priceLow = low;
        this.priceHigh = high;
        this.arrayz = new ArrayList<Laptop>();
        for( int i = 0 ; i < test ; i++) {
            Laptop loaded = new Laptop(stringer.getRow(i));
            if (low <= loaded.getPrice() && loaded.getPrice() <= high) {
                this.arrayz.add(loaded);
            }
        }
    }
    
    public static void main() {
        StringLoader amazonEmployee = new StringLoader();
        //StringLoader upsEmployee = new StringLoader();
        
        amazonEmployee.load("laptop_price.csv");
        //upsEmployee.load("laptop_price.csv");
        
        PriceRangeArray amazonTruck = new PriceRangeArray(amazonEmployee, 200, 300);
        //LaptopArray upsTruck = new LaptopArray(upsEmployee);
        
        System.out.println(amazonTruck.getAt(28).getDescription());
        System.out.println(amazonTruck.getLaptop(6).getDescription());
        System.out.println(amazonTruck.getLaptop(1320).getDescription());
        System.out.println(amazonTruck.getLaptop(398).getDescription());
        System.out.println(amazonTruck.toString());
        System.out.println(amazonTruck.length());
        
    }
}