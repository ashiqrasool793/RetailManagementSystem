/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
public class ItemTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemTypeId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private String itemSubCategory;
    private String itemPicture;
    private double itemBasePrice;
    private double itemSalePrice;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<StockThresholdEntity> stockThreshold = new ArrayList <StockThresholdEntity>();

    public ItemTypeEntity() {
    }

    public ItemTypeEntity(String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, 
            double itemBasePrice, double itemSalePrice, RetailerEntity retailer) {
        this.setItemName(itemName);
        this.setItemDescription(itemDescription);
        this.setItemCategory(itemCategory);
        this.setItemSubCategory(itemSubCategory);
        this.setItemPicture(itemPicture);
        this.setItemBasePrice(itemBasePrice);
        this.setItemSalePrice(itemSalePrice);
        this.setRetailer(retailer);   
    }

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemId) {
        this.itemTypeId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemSubCategory() {
        return itemSubCategory;
    }

    public void setItemSubCategory(String itemSubCategory) {
        this.itemSubCategory = itemSubCategory;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    public double getItemBasePrice() {
        return itemBasePrice;
    }

    public void setItemBasePrice(double itemBasePrice) {
        this.itemBasePrice = itemBasePrice;
    }

    public double getItemSalePrice() {
        return itemSalePrice;
    }

    public void setItemSalePrice(double itemSalePrice) {
        this.itemSalePrice = itemSalePrice;
    }

    public Collection<StockThresholdEntity> getStockThreshold() {
        return stockThreshold;
    }

    public void setStockThreshold(Collection<StockThresholdEntity> stockThreshold) {
        this.stockThreshold = stockThreshold;
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
        hash += (itemTypeId != null ? itemTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemTypeEntity)) {
            return false;
        }
        ItemTypeEntity other = (ItemTypeEntity) object;
        if ((this.itemTypeId == null && other.itemTypeId != null) || (this.itemTypeId != null && !this.itemTypeId.equals(other.itemTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ItemTypeEntity[ id=" + itemTypeId + " ]";
    }
    
}
