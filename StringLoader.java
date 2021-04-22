import java.io.*;
import java.util.*;
public class StringLoader {
    String[][] data;
    String [] header;
    String DELIMITER;
    boolean ready;
    

    // TO DO: method to show ready state
    // TO DO: method to dump data to console for debugging
    // TO DO: method to return header
    // TO DO: method to show num rows loaded
    // TO DO: method to get one row of data by row num 

    public StringLoader () {
        DELIMITER = ","; // assume CSV
    }

    public void load (String filename) {
        int rows = countRows(filename);
        ready = loadData(filename,rows);
    }
    
    private int countRows (String filename) {
        int countRows = -1;
        try {
            String line;
            BufferedReader reader = 
                new BufferedReader(new FileReader(filename));
            while((line=reader.readLine())!=null){
                countRows++;
                if (countRows==0) {
                    header= line.split(DELIMITER);
                }
            }
        } catch (Exception e) {
            System.err.println("There was a problem reading the metadata.");
            System.err.println(e);
            return -1;
        }
        return countRows;
    }

    private boolean loadData (String filename, int rows) {
        if (rows<0) {
            return false;
        }
        data = new String[rows][];
        String [] record;
        int row = -1; // header=-1, data starts at 0
        try {
            String line;
            BufferedReader reader = 
                new BufferedReader(new FileReader(filename));
            while((line=reader.readLine())!=null){
                // don't store the header as data
                if (row>=0) {
                    String [] fields = line.split(DELIMITER);
                    data[row]=fields;
                }
                row++;
            }
        } catch (Exception e) {
            System.err.println("There was a problem reading the data.");
            System.err.println(e);
            return false;
        }
        return true;
    }

    public boolean isReady() {
        return ready;
    }
    
    public int getNumRows() {
        if (data==null) {
            return -1;
        }
        return data.length;
    }
    
    public String[] getHeader () {
        return header;
    }
    
    public String[] getRow (int row) {
        int rows = getNumRows();
        if (row<0 || row>=rows) {
            return null;
        }
        return data[row];
    }
    
    public static void main () {
        StringLoader loader = new StringLoader ();
        loader.load("laptop_price.csv");
        System.out.println("Ready state is "+loader.isReady());
        System.out.println("Number of rows is "+loader.getNumRows());
        System.out.println("Header is "+Arrays.toString(loader.getHeader()));
        System.out.println("Sample row is "+Arrays.toString(loader.getRow(5)));
    }

}
