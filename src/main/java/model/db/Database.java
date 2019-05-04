package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    protected Connection connection;

    private String url = "jdbc:postgresql://ec2-50-19-127-115.compute-1.amazonaws.com:5432/d6ge2oak9ojm48?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private String user = "mrtnjxkztdadrl";
    private String password = "69777b9e8824478e63f7a0c5acced830ec9a9a3edfba1dfbf6bad9cf9e99ea98";
    
    //private String url = "jdbc:postgresql://localhost:5432/moviedb";
    //private String user = "postgres";
    //private String password = "postgres";
    
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
