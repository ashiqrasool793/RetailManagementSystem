/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.ItemEntity;
import Entity.ItemTypeEntity;
import Entity.LocationEntity;
import Entity.RetailerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author keane
 */
@Stateless
public class WarehouseInventoryManagementBean implements WarehouseInventoryManagementBeanLocal, WarehouseInventoryManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    private ArrayList<ItemEntity> items;
    private ArrayList<ItemTypeEntity> itemTypes;
    private ItemEntity itemEN;
    private ItemTypeEntity itemTypeEN;
    private LocationEntity locationEN;
    private RetailerEntity retailerEN;

    //Function D.1.1.1 - Create Warehouse Item
    @Override
    public ItemEntity createItem(String rfId, String status, String remarks, RetailerEntity retailerId) {
        itemEN = new ItemEntity();

        itemEN.setRfId(Long.valueOf(rfId));
        itemEN.setRemarks(remarks);
        itemEN.setStatus(status);
        itemEN.setRetailer(retailerId);

        em.persist(itemEN);
        em.flush();

        return itemEN;
    }

    //Function D.1.1.2 - List Warehouse Items
    @Override
    public List<ItemEntity> listWarehouseItems() {
        Query q = em.createQuery("SELECT i FROM ItemEntity i");

        return q.getResultList();
    }

    //Function D.1.1.3 - List Warehouse Item Types
    @Override
    public List<ItemTypeEntity> listWarehouseItemTypes() {
        Query query = em.createQuery("SELECT itemType from ItemTypeEntity itemType");

        return query.getResultList();
    }

    //Function D.1.1.4 - List Warehouse Item Type Stock Quantity 
    @Override
    public List<ArrayList> listWarehouseItemTypeStockQuantity(Long warehouseId) {
        //itemTypes = listWarehouseItemTypes();

        for (int i = 0; i < itemTypes.size(); i++) {
            Query q = em.createQuery("SELECT COUNT i FROM ItemEntity WHERE i.location = location AND i.itemType = itemTypeId");
            q.setParameter("location", warehouseId);
            //q.setParameter("itemType", itemTypes[i]);

        }

        return null;
    }

    //Function D.1.1.5 - List Warehouse Item Type Stock Alert
    //Function D.1.1.6 - View Warehouse Item
    @Override
    public ArrayList<ItemEntity> viewWarehouseItem(Long warehouseId, Long warehouseItemId) {
        Query q = em.createQuery("SELECT location, itemId FROM ItemEntity i WHERE i.location = location AND i.itemId = itemId");
        q.setParameter("location", warehouseId);
        q.setParameter("itemId", warehouseItemId);
        items = (ArrayList) q.getResultList();

        return items;
    }

    //Function D.1.1.7 - View Warehouse Item Type
    @Override
    public ArrayList<ItemTypeEntity> viewWarehouseItemType(Long warehouseId, Long itemTypeId) {
        Query q = em.createQuery("SELECT i FROM ItemEntity WHERE i.location = location AND i.itemTypeId = itemTypeId");
        q.setParameter("location", warehouseId);
        q.setParameter("itemTypeId", itemTypeId);
        itemTypes = (ArrayList) q.getResultList();

        return itemTypes;
    }

    //Function D.1.1.8 - Update Warehouse Item
    @Override
    public boolean updateWarehouseItem(ItemEntity selectedItem, String rfId, String status, String remarks) {

        try {
            itemEN = selectedItem;
            itemEN.setRfId(Long.valueOf(rfId));
            itemEN.setStatus(status);
            itemEN.setRemarks(remarks);

            em.merge(itemEN);
            em.flush();

            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    //Function D.1.1.9 - Update Warehouse Item Type
    @Override
    public boolean updateWarehouseItemType(ItemTypeEntity selectedItemType, String itemName, String itemRemarks) {

        try {
            itemTypeEN = selectedItemType;

            itemTypeEN.setItemName(itemName);
            itemTypeEN.setItemDescription(itemRemarks);

            em.merge(itemTypeEN);
            em.flush();
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //Update Shelf Items.
}
