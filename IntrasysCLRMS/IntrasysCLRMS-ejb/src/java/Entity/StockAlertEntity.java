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
 * @author ashiq
 */
@Entity
public class StockAlertEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockAlertId;
    private Timestamp stockAlertDate;
    private int itemQty;
    private String alertStatus; //ACTIVE or RESOLVED
    @OneToOne
    private ItemTypeEntity itemType = new ItemTypeEntity();
    @OneToOne
    LocationEntity location = new LocationEntity();

    public Long getStockAlertId() {
        return stockAlertId;
    }

    public void setStockAlertId(Long stockAlertId) {
        this.stockAlertId = stockAlertId;
    }

    public Timestamp getStockAlertDate() {
        return stockAlertDate;
    }

    public void setStockAlertDate(Timestamp stockAlertDate) {
        this.stockAlertDate = stockAlertDate;
    }

    public String getAlertStatus() {
        return alertStatus;
    }

    public void setAlertStatus(String alertStatus) {
        this.alertStatus = alertStatus;
    }

    public ItemTypeEntity getItemType() {
        return itemType;
    }

    public void setItemType(ItemTypeEntity itemType) {
        this.itemType = itemType;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockAlertId != null ? stockAlertId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockAlertEntity)) {
            return false;
        }
        StockAlertEntity other = (StockAlertEntity) object;
        if ((this.stockAlertId == null && other.stockAlertId != null) || (this.stockAlertId != null && !this.stockAlertId.equals(other.stockAlertId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StockAlertEntity[ id=" + stockAlertId + " ]";
    }
    
}
