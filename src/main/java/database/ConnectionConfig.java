package database;

//mysql jdbc is required to use methods below

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {



    public static java.sql.Connection getConnection(String dbadress,String dbport,String dbuser, String dbpassword,String dbname,String dbtype){  //it required mysql jdbc driver!
        java.sql.Connection connection = null;
        //try to connect with mysql database

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://"+dbadress+":"+dbport+"/"+dbname+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",dbuser,dbpassword);
        }
        catch(Exception e){e.printStackTrace();}
        return connection;

    }

}