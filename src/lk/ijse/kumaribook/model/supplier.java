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
public class supplier {

    private int supId;
    private String company;
    private String delerName;
    private String mobile;

    public supplier() {
    }

    public supplier(int supId, String company, String delerName, String mobile) {
        this.supId = supId;
        this.company = company;
        this.delerName = delerName;
        this.mobile = mobile;
    }

    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDelerName() {
        return delerName;
    }

    public void setDelerName(String delerName) {
        this.delerName = delerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "supplier{" + "supId=" + supId + ", company=" + company + ", delerName=" + delerName + ", mobile=" + mobile + '}';
    }
    
}
