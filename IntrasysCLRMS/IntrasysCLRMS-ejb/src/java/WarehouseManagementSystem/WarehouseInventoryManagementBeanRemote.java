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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author keane
 */
@Remote
public interface WarehouseInventoryManagementBeanRemote {
    
    public List<ItemTypeEntity> listWarehouseItemTypes();
    
    List<ArrayList> listWarehouseItemTypeStockQuantity(Long warehouseId);

    ArrayList<ItemEntity> viewWarehouseItem(Long warehouseId, Long warehouseItemId);

    public ArrayList<ItemTypeEntity> viewWarehouseItemType(Long warehouseId, Long itemTypeId);

    boolean updateWarehouseItem(ItemEntity itemId, String rfId, String status, String remarks);

    boolean updateWarehouseItemType(ItemTypeEntity selectedItemType, String itemName, String itemRemarks);

    ItemEntity createItem(String rfId, String status, String remarks, RetailerEntity retailerId);

    List<ItemEntity> listWarehouseItems();

    

    

    
    
}
