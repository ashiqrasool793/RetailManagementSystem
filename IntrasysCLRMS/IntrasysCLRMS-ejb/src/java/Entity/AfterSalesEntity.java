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
 * @author ashiq
 */
@Entity
public class AfterSalesEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long afterSalesId;
    private Timestamp afterSalesDate;
    private boolean isDefective;
    private String remarks;
    @OneToOne(cascade={CascadeType.PERSIST})
    private TransactionEntity transaction;
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemEntity> items = new ArrayList<ItemEntity>();
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public AfterSalesEntity() {
    }

    public AfterSalesEntity(Timestamp afterSalesDate, boolean isDefective, String remarks, TransactionEntity transaction) {
        this.setAfterSalesDate(afterSalesDate);
        this.setIsDefective(isDefective);
        this.setRemarks(remarks);
        this.setTransaction(transaction);
    }


    public Long getAfterSalesId() {
        return afterSalesId;
    }

    public void setAfterSalesId(Long afterSalesId) {
        this.afterSalesId = afterSalesId;
    }

    public Timestamp getAfterSalesDate() {
        return afterSalesDate;
    }

    public void setAfterSalesDate(Timestamp afterSalesDate) {
        this.afterSalesDate = afterSalesDate;
    }

    public boolean isIsDefective() {
        return isDefective;
    }

    public void setIsDefective(boolean isDefective) {
        this.isDefective = isDefective;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public Collection<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Collection<ItemEntity> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afterSalesId != null ? afterSalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AfterSalesEntity)) {
            return false;
        }
        AfterSalesEntity other = (AfterSalesEntity) object;
        if ((this.afterSalesId == null && other.afterSalesId != null) || (this.afterSalesId != null && !this.afterSalesId.equals(other.afterSalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AfterSalesEntity[ id=" + afterSalesId + " ]";
    }
    
}
