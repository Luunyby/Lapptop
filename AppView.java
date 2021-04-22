import java.awt.*;

public class AppView extends Panel {
    Label[] labels;
    TextField[] textFields;
    Panel jr;
    AppModel modelApp;
    AppView viewApp;

    public AppView (AppModel modelApp) {
        this.modelApp = modelApp;
        jr = new Panel();
        labels = new Label[modelApp.getNumFields()];
        textFields = new TextField[modelApp.getNumFields()];
        for (int i = 0; i < labels.length ; i++) {
            labels[i] = new Label(modelApp.getNameFields(i));
            textFields[i] = new TextField(modelApp.getFields((i)));
        }
        for (int z = 0; z < labels.length ; z++) {
            this.add(labels[z]);
            this.add(textFields[z]);
        }
    }
    
    public void setFields(String id) {
        Laptop found = modelApp.findLaptop(id);
        for (int i = 0 ; i < textFields.length; i++) {
            textFields[i].setText(found.getField(i));
        }
    }
    
    public void update(AppModel modelApp) {
        this.modelApp = modelApp;
    }
}