package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatabaseService {

    public  static DatabaseService instance = new DatabaseService();
    private Statement statement = null;
    private Connection connection;
    private String sqlQuery;
    private DatabaseService(){
    }



    public static DatabaseService getInstance() {
        return instance;
    }
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    private Statement setStatement( ){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return statement;
        }

    }

    public void createQuery(String query){
        this.sqlQuery=query;

    }

    public void executeQuery(){
        setStatement();

        //this.sqlQuery= "SELECT * FROM invoices";
        ResultSet resultSet= null;
        try {
            resultSet = statement.executeQuery(this.sqlQuery);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();


            while(resultSet.next()) {for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void textDbDownload() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/products.txt"));
        String line =br.readLine();
        ArrayList<String> linesFromTextAsStrings=new ArrayList<>();
        while(line !=null){
            //System.out.println(line);
            linesFromTextAsStrings.add(line);
            line = br.readLine();
        }
        Iterator<String> iterator=linesFromTextAsStrings.iterator();
        //it pushes products to hashmap by iteration of arraylist with readed lines
        while(iterator.hasNext()){
            String stringToSplit=iterator.next();
            String[] partsFromSplitedString= stringToSplit.split(",");
            int id=Integer.valueOf(partsFromSplitedString[0]);
            String name=partsFromSplitedString[1];
            float price =Float.valueOf(partsFromSplitedString[2]);
            int barcode=Integer.valueOf(partsFromSplitedString[3]);
            //hashproducts.put(barcode,new Product(id,name,price,barcode));
        }

        br.close();

    }
}