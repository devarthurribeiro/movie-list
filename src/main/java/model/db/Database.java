package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    protected Connection connection;

    //private String url = "jdbc:postgresql://ec2-184-73-153-64.compute-1.amazonaws.com:5432/d6ge2oak9ojm48?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    //private String user = "hmdidjdkshjnuo";
    //private String password = "d7bfabe612cf49308df8ee7ba3c09221f4b45760894f0f97f20d3e3185d0d417";
    
    private String url = "jdbc:postgresql://localhost:5432/moviedb";
    private String user = "postgres";
    private String password = "postgres";
    
    public void open() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
