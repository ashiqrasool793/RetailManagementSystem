/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author keane
 */
@Entity
public class TransferOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferOrderId;
    private Timestamp currentDate;
    private Timestamp deliveryDate;
    private String status;
    @OneToOne(cascade={CascadeType.PERSIST})
    private EmployeeEntity employee;
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemTypeEntity> itemType = new ArrayList<ItemTypeEntity>();
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public TransferOrderEntity() {
    }

    public TransferOrderEntity(Timestamp currentDate, Timestamp deliveryDate, String status, EmployeeEntity employee, Collection<ItemTypeEntity> itemType, 
            RetailerEntity retailer) {
        this.setCurrentDate(currentDate);
        this.setDeliveryDate(deliveryDate);
        this.setStatus(status);
        this.setEmployee(employee);
        this.setItemType(itemType);
        this.setRetailer(retailer);
    }
    
    

    public Long getTransferOrderId() {
        return transferOrderId;
    }

    public void setTransferOrderId(Long transferOrderId) {
        this.transferOrderId = transferOrderId;
    }

    public Timestamp getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Timestamp currentDate) {
        this.currentDate = currentDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public Collection<ItemTypeEntity> getItemType() {
        return itemType;
    }

    public void setItemType(Collection<ItemTypeEntity> itemType) {
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
        hash += (transferOrderId != null ? transferOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransferOrderEntity)) {
            return false;
        }
        TransferOrderEntity other = (TransferOrderEntity) object;
        if ((this.transferOrderId == null && other.transferOrderId != null) || (this.transferOrderId != null && !this.transferOrderId.equals(other.transferOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransferOrderEntity[ id=" + transferOrderId + " ]";
    }
    
}
