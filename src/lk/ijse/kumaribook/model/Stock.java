/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.kumaribook.model;

/**
 *
 * @author HP
 */
public class Stock {
   private int qty;
   private int itemCode;

    public Stock() {
    }

    public Stock(int qty, int itemCode) {
        this.qty = qty;
        this.itemCode = itemCode;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Stock{" + "qty=" + qty + ", itemCode=" + itemCode + '}';
    }
   
   
}
