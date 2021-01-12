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
public class Customer {
  
   private int cusid;
   private String name;
   private String address;
   private String mobile;

    public Customer(int cusid, String name, String address, String mobile) {
        this.cusid = cusid;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public Customer() {
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusid=" + cusid + ", name=" + name + ", address=" + address + ", mobile=" + mobile + '}';
    }
   
   
   
          
}
