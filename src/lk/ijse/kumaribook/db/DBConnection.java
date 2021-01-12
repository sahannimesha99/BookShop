/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.kumaribook.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBConnection {
    private static DBConnection dbconnection;
    private final Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/kumariBookshop", "root", "sana");
    }

    public static DBConnection getInstance() throws ClassNotFoundException, SQLException {
        return (dbconnection == null) ? (dbconnection = new DBConnection()) : (dbconnection);
    }

    public Connection getConnection() {
        return connection;
    }
}
