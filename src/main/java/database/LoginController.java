package database;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import jdk.jfr.BooleanFlag;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    @FXML
    TextField dblogin;
    @FXML
    TextField dbpassword;
    @FXML
    TextField dbname;
    @FXML
    TextField dbtype;
    @FXML
    TextField dbadress;
    @FXML
    TextField dbport;

    protected Connection connection = null;

    public void tryConnect(){

         this.connection = null;
        try {

            connection = ConnectionConfig.getConnection( dbadress.getText(), dbport.getText(), dblogin.getText(),  dbpassword.getText(), dbname.getText(), dbtype.getText());
            if(connection != null){
                System.out.println("Connection established!");
                ScreenController.getInstance().activate("Query");
                DatabaseService.getInstance().setConnection(connection);

                 }
        }
        catch(Exception e){e.printStackTrace();}
        /*finally {
            //connections should be disconnected
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
