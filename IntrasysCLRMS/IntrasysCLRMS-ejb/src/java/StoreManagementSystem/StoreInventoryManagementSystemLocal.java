/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.ItemEntity;
import Entity.ItemTypeEntity;
import Entity.LocationEntity;
import Entity.RetailerEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ashiq
 */
@Local
public interface StoreInventoryManagementSystemLocal {
    
    public ArrayList<ItemTypeEntity> listStoreItemTypes(Long storeId);
    
    public int findStoreItemTypeStockQuantity(Long storeId, Long itemID);
    
    public ItemEntity listStoreItem(Long storeId, Long storeItemId);
    
    public void updateStoreItem(Long itemId, Long barcodeId, LocationEntity location, ItemTypeEntity itemType, String status, Timestamp date, String remarks, RetailerEntity retailer);
    
    public void updateStoreItemType(Long itemTypeId, String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailer);

    void createStoreItem();
 
}
