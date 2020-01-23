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
import javax.ejb.Local;

/**
 *
 * @author keane
 */
@Local
public interface WarehouseInventoryManagementBeanLocal {

    public List<ItemTypeEntity> listWarehouseItemTypes();

    public ArrayList<ItemTypeEntity> viewWarehouseItemType(Long warehouseId, Long itemTypeId);

    List<ArrayList> listWarehouseItemTypeStockQuantity(Long warehouseId);

    ArrayList<ItemEntity> viewWarehouseItem(Long warehouseId, Long warehouseItemId);

    boolean updateWarehouseItem(ItemEntity selectedItem, String rfId, String status, String remarks);

    boolean updateWarehouseItemType(ItemTypeEntity selectedItemType, String itemName, String itemRemarks);

    ItemEntity createItem(String rfId, String status, String remarks, RetailerEntity retailerId);

    List<ItemEntity> listWarehouseItems();

}
