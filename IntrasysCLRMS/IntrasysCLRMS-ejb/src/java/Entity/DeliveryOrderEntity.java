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

/**
 *
 * @author keane
 */
@Entity
public class DeliveryOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryOrderId;
    private Timestamp date;
    //fileLocation referes to the directory of where the scanned image of the DO is stored.
    private String fileLocation; 
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemTypeEntity> itemType = new ArrayList<ItemTypeEntity>();
    @ManyToOne(cascade={CascadeType.ALL})
    private PurchaseOrderEntity purchaseOrder = new PurchaseOrderEntity();
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public DeliveryOrderEntity() {
    }

    public DeliveryOrderEntity(Timestamp date, String fileLocation, Collection<ItemTypeEntity> itemType, PurchaseOrderEntity purchaseOrder, RetailerEntity retailer) {
        this.setDate(date);
        this.setFileLocation(fileLocation);
        this.setItemType(itemType);
        this.setPurchaseOrder(purchaseOrder);
        this.setRetailer(retailer);
        
    }
    
    public Long getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Long deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public PurchaseOrderEntity getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrderEntity purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
    
    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public Collection<ItemTypeEntity> getItemType() {
        return itemType;
    }

    public void setItemType(Collection<ItemTypeEntity> itemType) {
        this.itemType = itemType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryOrderId != null ? deliveryOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryOrderEntity)) {
            return false;
        }
        DeliveryOrderEntity other = (DeliveryOrderEntity) object;
        if ((this.deliveryOrderId == null && other.deliveryOrderId != null) || (this.deliveryOrderId != null && !this.deliveryOrderId.equals(other.deliveryOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DeliveryOrderEntity[ id=" + deliveryOrderId + " ]";
    }
    
}
