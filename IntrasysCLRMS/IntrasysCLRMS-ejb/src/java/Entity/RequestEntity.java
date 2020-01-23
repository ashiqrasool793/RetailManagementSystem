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
import java.util.List;
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
 * @author ashiq
 */
@Entity
public class RequestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestId;
    private String requestMessage;
    private String requestType;
    private String requestStatus;
    private Timestamp requestDate;
    private List itemQty; //not sure if this is possible
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemTypeEntity> itemType = new ArrayList<ItemTypeEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private LocationEntity location;
    @OneToOne(cascade={CascadeType.PERSIST})
    private EmployeeEntity employee;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }

    public RequestEntity() {
    }

    public RequestEntity(String requestMessage, String requestType, String requestStatus, Timestamp requestDate, List itemQty, Collection<ItemTypeEntity> itemType, 
            LocationEntity location, EmployeeEntity employee, RetailerEntity retailer) {
        this.setRequestMessage(requestMessage);
        this.setRequestType(requestType);
        this.setRequestStatus(requestStatus);
        this.setRequestDate(requestDate);
        this.setItemQty(itemQty);
        this.setItemType(itemType);
        this.setLocation(location);
        this.setEmployee(employee);
        this.setRetailer(retailer);
        
    }
    
    

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public List getItemQty() {
        return itemQty;
    }

    public Collection<ItemTypeEntity> getItemType() {
        return itemType;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public void setItemQty(List itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemType(Collection<ItemTypeEntity> itemType) {
        this.itemType = itemType;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    
    

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestEntity)) {
            return false;
        }
        RequestEntity other = (RequestEntity) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RequestEntity[ id=" + requestId + " ]";
    }
    
}
