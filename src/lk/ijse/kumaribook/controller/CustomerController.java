/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.kumaribook.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.UIManager;
import lk.ijse.kumaribook.db.DBConnection;
import lk.ijse.kumaribook.model.Customer;

/**
 *
 * @author HP
 */
public class CustomerController {

    public List<String> getAllCustomerIds() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT cus_id FROM Customer";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery();

        List<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    public List<Customer> getCustomer() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet set = stm.executeQuery();
        List<Customer> list = new ArrayList<>();
        while (set.next()) {
            list.add(new Customer(set.getInt("cus_Id"), set.getString("Name"), set.getString("Address"), set.getString("Mobile")));
        }
        return list;
    }

    public boolean custInsert(Customer customer) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer  VALUES(?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, customer.getCusid());
        stm.setString(2, customer.getName());
        stm.setString(3, customer.getAddress());
        stm.setString(4, customer.getMobile());

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;
    }

    public boolean custUpdate(Customer customer) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "Update customer set cus_id=?,name=?,address=?,mobile=? where Cus_id=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, customer.getCusid());
        stm.setString(2, customer.getName());
        stm.setString(3, customer.getAddress());
        stm.setString(4, customer.getMobile());
        stm.setInt(5, customer.getCusid());

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;

    }
     public boolean custRemove(int s) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from customer where cus_id=? ";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, s);
        

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;

    }
}
