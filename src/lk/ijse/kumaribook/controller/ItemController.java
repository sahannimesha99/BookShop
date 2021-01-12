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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.kumaribook.db.DBConnection;
import lk.ijse.kumaribook.model.Item;

/**
 *
 * @author HP
 */
public class ItemController {

    public List<String> getAllItemCodes() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT item_code FROM Item";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery();

        List<String> list = new ArrayList<>();

        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }

    public Item getItem(String id) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE item_code=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Item(
                    set.getInt(1),
                    set.getString(2),
                    set.getString(3),
                    set.getDouble(4),
                    set.getDouble(5)
            );
        }

        return null;
    }
      public List<Item> getItem() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet set = stm.executeQuery();
        List<Item> list = new ArrayList<>();
        while (set.next()) {
            list.add(new Item(set.getInt("Item_code"), set.getString("Name"), set.getString("Company"), set.getDouble("Buy_Price"), set.getDouble("Sell_Price")));
        }
        return list;

    }

    public boolean itemInsert(Item item) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item  VALUES(?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, item.getItemcode());
        stm.setString(2, item.getName());
        stm.setString(3, item.getCompany());
        stm.setDouble(4, item.getBuy());
        stm.setDouble(5, item.getSell());

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;
    }

    public boolean itemUpdate(Item item) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "Update Item set Item_code=?,Name=?,Company=?,buy_price=?, sell_price=?  where Item_code=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, item.getItemcode());
        stm.setString(2, item.getName());
        stm.setString(3, item.getCompany());
        stm.setDouble(4, item.getBuy());
        stm.setDouble(5, item.getSell());
        stm.setInt(6, item.getItemcode());

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;

    }

    public boolean itemRemove(int s) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from Item where cus_id=? ";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, s);

        boolean isAdded = stm.executeUpdate() > 0;

        return isAdded;

    }

  
}
