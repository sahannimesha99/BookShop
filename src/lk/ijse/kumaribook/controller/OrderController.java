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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.kumaribook.db.DBConnection;
import lk.ijse.kumaribook.model.OrderDetail;
import lk.ijse.kumaribook.model.Stock;

/**
 *
 * @author HP
 */
public class OrderController {

    public String setInvoiceNo() throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT O_id FROM OrderDetail ORDER BY O_id DESC LIMIT 1";
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return set.getString(1);
        }
        return null;
    }

    public static boolean invoiceOrder(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO OrderDetail (o_id,cus_id,total ) VALUES(?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, orderDetail.getOrderID());
        stm.setInt(2, orderDetail.getCustId());
        stm.setDouble(3, orderDetail.getTotal());

        boolean isAdded = stm.executeUpdate() > 0;

        if (isAdded) {
            boolean bc = updateStock(orderDetail.getList());

        } else {
            return false;
        }
        return true;

    }

    public static boolean updateStock(List<Stock> list) {
        for (Stock stock : list) {
            try {

                PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Update Stock set Qyt=(qyt-?)where item_Code=?");
                stm.setInt(1, stock.getQty());
                stm.setInt(2, stock.getItemCode());
                if (!(stm.executeUpdate() > 0)) {
                    return false;
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return true;
    }

}
