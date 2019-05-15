package database;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class SetQueryController {

    @FXML
    TextField Userquery;

    public void executeQuerry(){
    DatabaseService.getInstance().createQuery(this.Userquery.getText());
    DatabaseService.getInstance().executeQuery();
    }
}
