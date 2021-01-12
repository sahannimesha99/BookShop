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
public class Item {
     private int itemcode;
   private String name ;
   private String Company ;
   private double sell;
   private double buy;

    public Item() {
    }

    public Item(int itemcode, String name, String Company, double sell, double buy) {
        this.itemcode = itemcode;
        this.name = name;
        this.Company = Company;
        this.sell = sell;
        this.buy = buy;
    }

    public int getItemcode() {
        return itemcode;
    }

    public void setItemcode(int itemcode) {
        this.itemcode = itemcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "Item{" + "itemcode=" + itemcode + ", name=" + name + ", Company=" + Company + ", sell=" + sell + ", buy=" + buy + '}';
    }
   
}