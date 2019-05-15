package database;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/DBapplicationLogin.fxml"));
        primaryStage.setTitle("DataBase");
        Scene first=new Scene(root, 600, 400);
        ScreenController.getInstance().setMain(first);
        ScreenController.getInstance().addScreen("Login", FXMLLoader.load(getClass().getResource( "/DBapplicationLogin.fxml" )));
        ScreenController.getInstance().addScreen("Query", FXMLLoader.load(getClass().getResource( "/DBsetQuery.fxml" )));
        ScreenController.getInstance().activate("Login");
        System.out.println(ScreenController.getInstance().getMain());
        primaryStage.setScene(ScreenController.getInstance().getMain());
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }

}
