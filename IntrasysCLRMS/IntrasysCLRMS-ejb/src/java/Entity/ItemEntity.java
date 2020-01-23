/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author keane
 */
@Entity
public class ItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private Long rfId; //change to RFID
    private String status;
    private Timestamp date;
    private String remarks;
    @OneToOne(cascade={CascadeType.PERSIST})
    private LocationEntity location;
    @ManyToOne(cascade={CascadeType.ALL})
    private ItemTypeEntity itemType = new ItemTypeEntity();
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public ItemEntity() {
    }

    public ItemEntity(Long rfId, String status, Timestamp date, String remarks, LocationEntity location, ItemTypeEntity itemType, RetailerEntity retailer) {
        this.setRfId(rfId);
        this.setStatus(status);
        this.setDate(date);
        this.setRemarks(remarks);
        this.setLocation(location);
        this.setItemType(itemType);
        this.setRetailer(retailer);
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getRfId() {
        return rfId;
    }

    public void setRfId(Long rfId) {
        this.rfId = rfId;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ItemTypeEntity getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypeEntity itemType) {
        this.itemType = itemType;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemEntity)) {
            return false;
        }
        ItemEntity other = (ItemEntity) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ItemEntity[ id=" + itemId + " ]";
    }
    
}
