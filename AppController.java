import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class AppController implements ActionListener{
    JFrame appFrame;
    TextArea detailArea;
    TextField idArea;
    TextField setLow;
    TextField setHigh;
    Label priceRangeSize;
    Button idButton;
    Button writeButton;
    Button priceRange;
    AppModel modelApp;
    AppView viewApp;
    
    
    public AppController(String fileName) {
        modelApp = new AppModel(fileName);
        viewApp = new AppView(modelApp);
        appFrame = new JFrame("Laptop Databse");
        appFrame.add(viewApp);
        appFrame.setLayout(new FlowLayout());
        Label idLabel = new Label("Laptop ID:");
        idArea = new TextField("       0", 16);
        priceRangeSize = new Label("     ");
        setLow = new TextField("    0", 6);
        setHigh = new TextField("99999", 6);
        idButton = new Button("Search");
        writeButton = new Button("Write");
        priceRange = new Button("Price Range");
        Panel control = new Panel();
        appFrame.add(control);
        idButton.addActionListener(this);
        writeButton.addActionListener(this);
        priceRange.addActionListener(this);
        control.add(setLow);
        control.add(setHigh);
        control.add(priceRangeSize);
        control.add(priceRange);
        control.add(idLabel);
        control.add(idArea);
        control.add(idButton);
        control.add(writeButton);
        appFrame.pack();
        appFrame.setVisible(true);
    }
    
    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == idButton) {
            viewApp.setFields(idArea.getText());
        }
        if (event.getSource() == writeButton) {
            modelApp.writeLaptop(idArea.getText());
        }
        if (event.getSource() == priceRange) {
            modelApp.findPriceRange(setLow.getText(), setHigh.getText());
            priceRangeSize.setText("" + modelApp.length());
            viewApp.update(modelApp);
        }
    }
    
    public static void main() {
        AppController running = new AppController("laptop_price.csv");
    }
}