package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Statement setStatement(Connection connection){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return statement;
        }

    }


    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }
    private Statement statement = null;
    private Database() {
    }
}
