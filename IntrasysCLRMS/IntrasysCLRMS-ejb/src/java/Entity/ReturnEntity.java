/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
 * @author keane
 */
@Entity
public class ReturnEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long returnId;
    private String returnDesc;
    private List quantity;  
    @OneToOne(cascade={CascadeType.PERSIST})
    private DeliveryOrderEntity deliveryOrder;
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemTypeEntity> itemType = new ArrayList<ItemTypeEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private EmployeeEntity employee;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public ReturnEntity() {
    }

    public ReturnEntity(String returnDesc, List quantity, DeliveryOrderEntity deliveryOrder, Collection<ItemTypeEntity> itemType, EmployeeEntity employee,
        RetailerEntity retailer) {
        this.setReturnDesc(returnDesc);
        this.setQuantity(quantity);
        this.setDeliveryOrder(deliveryOrder);
        this.setItemType(itemType);
        this.setEmployee(employee);
        this.setRetailer(retailer);
    }
    
    

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    public List getQuantity() {
        return quantity;
    }

    public void setQuantity(List quantity) {
        this.quantity = quantity;
    }

    public DeliveryOrderEntity getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(DeliveryOrderEntity deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public Collection<ItemTypeEntity> getItemType() {
        return itemType;
    }

    public void setItemType(Collection<ItemTypeEntity> itemType) {
        this.itemType = itemType;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
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
        hash += (returnId != null ? returnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReturnEntity)) {
            return false;
        }
        ReturnEntity other = (ReturnEntity) object;
        if ((this.returnId == null && other.returnId != null) || (this.returnId != null && !this.returnId.equals(other.returnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ReturnEntity[ id=" + returnId + " ]";
    }
    
}
