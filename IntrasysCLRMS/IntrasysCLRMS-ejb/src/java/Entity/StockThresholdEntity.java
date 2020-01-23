/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author ashiq
 */
@Entity
public class StockThresholdEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockThresholdId;
    private double stockThresholdQty;
    @OneToOne
    LocationEntity location = new LocationEntity();
    
   

    public Long getStockThresholdId() {
        return stockThresholdId;
    }

    public void setStockThresholdId(Long stockThresholdId) {
        this.stockThresholdId = stockThresholdId;
    }

    public double getStockThresholdQty() {
        return stockThresholdQty;
    }

    public void setStockThresholdQty(double stockThresholdQty) {
        this.stockThresholdQty = stockThresholdQty;
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
        hash += (stockThresholdId != null ? stockThresholdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockThresholdEntity)) {
            return false;
        }
        StockThresholdEntity other = (StockThresholdEntity) object;
        if ((this.stockThresholdId == null && other.stockThresholdId != null) || (this.stockThresholdId != null && !this.stockThresholdId.equals(other.stockThresholdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StockThresholdEntity[ id=" + stockThresholdId + " ]";
    }
    
}
