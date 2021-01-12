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
import lk.ijse.kumaribook.db.DBConnection;

/**
 *
 * @author HP
 */
public class EmployeeControler {
     public List<String> getAllEmployee() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT emp_id FROM Employee";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet set = stm.executeQuery();

        List<String> list = new ArrayList<>();
        while (set.next()) {
            list.add(set.getString(1));
        }
        return list;
    }
     
}
