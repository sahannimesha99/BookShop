/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.kumaribook.model;

import java.util.List;

/**
 *
 * @author HP
 */
public class OrderDetail {
    private String OrderID;
    private int CustId;
    private double Total;
    private String Date;
    private List<Stock> list;

    public OrderDetail() {
    }

    public OrderDetail(String OrderID, int CustId, double Total, String Date, List<Stock> list) {
        this.OrderID = OrderID;
        this.CustId = CustId;
        this.Total = Total;
        this.Date = Date;
        this.list = list;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustId() {
        return CustId;
    }

    public void setCustId(int CustId) {
        this.CustId = CustId;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public List<Stock> getList() {
        return list;
    }

    public void setList(List<Stock> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "OrderID=" + OrderID + ", CustId=" + CustId + ", Total=" + Total + ", Date=" + Date + ", list=" + list + '}';
    }
    
    
}
