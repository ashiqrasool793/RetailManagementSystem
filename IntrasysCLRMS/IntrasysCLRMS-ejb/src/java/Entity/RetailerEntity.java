package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RetailerEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long retailerId;
    private String retailerName;
    private String retailerAddress;
    private Long retailerContact;
    private String retailerEmail;
    private String retailerDescription;
    private int retailerTier;
    private int retailerStatus;
    private int warehouseLimit;
    private int storeLimit;

    public RetailerEntity() {
    }

    public RetailerEntity(String rName, String rAddress, Long rContact, String rEmail, String rDesc, int rTier, int rStatus, int warehouseLimit, int storeLimit) {
        this.setRetailerName(rName);
        this.setRetailerAddress(rAddress);
        this.setRetailerContact(rContact);
        this.setRetailerEmail(rEmail);
        this.setRetailerDescription(rDesc);
        this.setRetailerTier(rTier);
        this.setRetailerStatus(rStatus);
        this.setWarehouseLimit(warehouseLimit);
        this.setStoreLimit(storeLimit);
    }

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getRetailerAddress() {
        return retailerAddress;
    }

    public void setRetailerAddress(String retailerAddress) {
        this.retailerAddress = retailerAddress;
    }

    public Long getRetailerContact() {
        return retailerContact;
    }

    public void setRetailerContact(Long retailerContact) {
        this.retailerContact = retailerContact;
    }

    public String getRetailerEmail() {
        return retailerEmail;
    }

    public void setRetailerEmail(String retailerEmail) {
        this.retailerEmail = retailerEmail;
    }

    public String getRetailerDescription() {
        return retailerDescription;
    }

    public void setRetailerDescription(String retailerDescription) {
        this.retailerDescription = retailerDescription;
    }

    public int getRetailerTier() {
        return retailerTier;
    }

    public void setRetailerTier(int retailerTier) {
        this.retailerTier = retailerTier;
    }

    public int getRetailerStatus() {
        return retailerStatus;
    }

    public void setRetailerStatus(int retailerStatus) {
        this.retailerStatus = retailerStatus;
    }

    public int getWarehouseLimit() {
        return warehouseLimit;
    }

    public void setWarehouseLimit(int warehouseLimit) {
        this.warehouseLimit = warehouseLimit;
    }

    public int getStoreLimit() {
        return storeLimit;
    }

    public void setStoreLimit(int storeLimit) {
        this.storeLimit = storeLimit;
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (retailerId != null ? retailerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetailerEntity)) {
            return false;
        }
        RetailerEntity other = (RetailerEntity) object;
        if ((this.retailerId == null && other.retailerId != null) || (this.retailerId != null && !this.retailerId.equals(other.retailerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RetailerEntity[ id=" + retailerId + " ]";
    }

}
