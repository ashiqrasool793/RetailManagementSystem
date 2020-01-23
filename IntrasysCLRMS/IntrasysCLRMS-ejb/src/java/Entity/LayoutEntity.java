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
 * @author ashiq
 */
@Entity
public class LayoutEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String layoutName;
    private Long shelveNum;
    private String layoutType;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public LayoutEntity() {
    }

    public LayoutEntity(String layoutName, Long shelveNum, String layoutType, RetailerEntity retailer) {
        this.setLayoutName(layoutName);
        this.setShelveNum(shelveNum);
        this.setLayoutType(layoutType);
        this.setRetailer(retailer);
    }

    public void setLayoutName(String layoutName) {
        this.layoutName = layoutName;
    }

    public void setShelveNum(Long shelveNum) {
        this.shelveNum = shelveNum;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public String getLayoutName() {
        return layoutName;
    }

    public Long getShelveNum() {
        return shelveNum;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LayoutEntity)) {
            return false;
        }
        LayoutEntity other = (LayoutEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StoreLayoutEntity[ id=" + id + " ]";
    }
    
}
