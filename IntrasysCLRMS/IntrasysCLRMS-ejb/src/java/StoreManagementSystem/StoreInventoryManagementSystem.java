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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author ashiq
 */
@Stateless
public class StoreInventoryManagementSystem implements StoreInventoryManagementSystemLocal, StoreInventoryManagementSystemRemote {
    
    @PersistenceContext
    EntityManager em;
    
    private ArrayList<ItemTypeEntity> itemTypes;
    private ArrayList<ItemEntity> items;
    private ItemEntity itemEN;
    private ItemTypeEntity itemTypeEN;
    private LocationEntity locationEN;
    private RetailerEntity retailerEN;
    private int itemQuantity;

    //Function D.1.1.1 - List Store Item Types
    @Override
    public ArrayList<ItemTypeEntity> listStoreItemTypes(Long storeId) {
        Query q = em.createQuery("SELECT i FROM ItemEntity i WHERE i.location = :location");
        q.setParameter("location" , storeId);
        items = (ArrayList) q.getResultList();
        boolean duplicate = false;
        for (int i = 0; i < items.size(); i++) {
            itemEN = (ItemEntity) em.find(ItemEntity.class, items.get(i).getItemId());
            for(int j=0; j<itemTypes.size(); j++) {
                duplicate = false;
                if(itemTypes.get(j) == itemEN.getItemType())
                    duplicate = true;
            }
            if(!duplicate)
            itemTypes.add(i, itemEN.getItemType());
        }
        
        return itemTypes;
    }

    //Function D.1.1.2 - List Store Item Type Stock Quantity 
    @Override
    public int findStoreItemTypeStockQuantity(Long storeId, Long itemID) {
        itemTypes = listStoreItemTypes(storeId);
        itemEN = em.find(ItemEntity.class, itemID);
        for (ItemTypeEntity itemType : itemTypes) {
            Query q = em.createQuery("SELECT COUNT(DISTINCT i.itemType) FROM ItemEntity i WHERE i.location = :location AND i.itemType = :itemTypeId");
            q.setParameter("location", storeId.toString());
            q.setParameter("itemTypeId", itemID.toString());
            itemQuantity = (int) q.getSingleResult();
        }
        
        
        return itemQuantity;
    }
    
    //Function D.1.1.3 - List Store Item Type Stock Alert
    
    //Function D.1.1.4 - View Store Item

    @Override
    public ItemEntity listStoreItem(Long storeId, Long storeItemId) {
        Query q = em.createQuery("SELECT i FROM ItemEntity i WHERE i.location = :location AND i.itemId = :itemId");
        q.setParameter("location", storeId);
        q.setParameter("itemId", storeItemId);
        ItemEntity iT = new ItemEntity();
        iT = (ItemEntity) q.getSingleResult();
        
        return iT;
    }
    
    /*Function D.1.1.5 - View Store Item Type
    @Override
    public ArrayList<ItemEntity> listStoreItemsOfSingleItemType(Long storeId, Long itemTypeId) {
        Query q = em.createQuery("SELECT i FROM ItemEntity i WHERE i.location = :location AND i.itemType.itemTypeId = :itemTypeId");
        q.setParameter("location", storeId);
        q.setParameter("itemTypeId", itemTypeId);
        items = (ArrayList<ItemEntity>) q.getResultList();
        
        return items;
    }
    */
    //Function D.1.1.6 - Update Warehouse Item

    @Override
    public void updateStoreItem(Long itemId, Long barcodeId, LocationEntity location, ItemTypeEntity itemType, String status, Timestamp date, String remarks, RetailerEntity retailer) {
    
        itemEN = (ItemEntity) em.find(ItemEntity.class, itemId);
        
        if (barcodeId!=null) {
            if (!barcodeId.equals(""))
            itemEN.setRfId(barcodeId);
        }
        if (status!=null) {
            if (!status.equals(""))
            itemEN.setStatus(status);
        }
        if (location!=null) {   //if item comes into a store, set the location to the store to track quantity
            if (!location.equals(""))
            itemEN.setLocation(location);
        }
        if (itemType!=null) {
            if (!itemType.equals(""))
            itemEN.setItemType(itemType);
        }
        if (date!=null) {
            if (!date.equals(""))
            itemEN.setDate(date);
        }
        if (remarks!=null) {
            if (!remarks.equals(""))
            itemEN.setRemarks(remarks);
        }
        
        em.merge(itemEN);
        em.flush();
    }
    

    @Override
    public void updateStoreItemType(Long itemTypeId, String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailer) {
        
        itemTypeEN = (ItemTypeEntity) em.find(ItemTypeEntity.class, itemTypeId);
        
        if (itemName!=null) {
            if (!itemName.equals(""))
            itemTypeEN.setItemName(itemName);
        }
        if (itemDescription!=null) {
            if (!itemDescription.equals(""))
            itemTypeEN.setItemDescription(itemDescription);
        }
        if (itemCategory!=null) {
            if (!itemCategory.equals(""))
            itemTypeEN.setItemCategory(itemCategory);
        }
        if (itemSubCategory!=null) {
            if (!itemSubCategory.equals(""))
            itemTypeEN.setItemSubCategory(itemSubCategory);
        }
        if (itemPicture!=null) {
            if (!itemPicture.equals(""))
            itemTypeEN.setItemPicture(itemPicture);
        }
        if (itemBasePrice!=0) { //How to check if base price is changed.
            itemTypeEN.setItemBasePrice(itemBasePrice);
        }
        if (itemSalePrice!=0) {
            itemTypeEN.setItemSalePrice(itemSalePrice);
        }
        
        em.merge(itemTypeEN);
        em.flush();
    }

    @Override
    public void createStoreItem() {
    }
       
}
