/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author edwar
 */
@Entity
public class SupplierEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierID;
    private String supplierName;
    private String supplierPassword;
    private String supplierUsername;
    private String supplierEmail;
    private String supplierContact;
    @ManyToOne(cascade = {CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public SupplierEntity() {
    }

    public SupplierEntity(String supplierName, String supplierPassword, String supplierUsername, String supplierEmail, String supplierContact, RetailerEntity retailer) {
        this.setSupplierName(supplierName);
        this.setSupplierPassword(supplierPassword);
        this.setSupplierUsername(supplierUsername);
        this.setSupplierEmail(supplierEmail);
        this.setSupplierContact(supplierContact);
        this.setRetailer(retailer);
    }

    public Long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Long supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPassword() {
        return supplierPassword;
    }

    public void setSupplierPassword(String supplierPassword) {
        this.supplierPassword = supplierPassword;
    }

    public String getSupplierUsername() {
        return supplierUsername;
    }

    public void setSupplierUsername(String supplierUsername) {
        this.supplierUsername = supplierUsername;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierID != null ? supplierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierEntity)) {
            return false;
        }
        SupplierEntity other = (SupplierEntity) object;
        if ((this.supplierID == null && other.supplierID != null) || (this.supplierID != null && !this.supplierID.equals(other.supplierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.SupplierEntity[ id=" + supplierID + " ]";
    }
    
}
