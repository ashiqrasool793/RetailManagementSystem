/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.ItemEntity;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Keane
 */
@Named(value = "WarehouseInventoryManagedBean")
@RequestScoped
public class WarehouseInventoryManagedBean {

    @EJB
    WarehouseInventoryManagementBeanLocal warehouseInventoryMBLocal;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationWarehouseBean navigationWarehouseBean = new NavigationWarehouseBean();

    String warehouseId;
    Long itemId;
    String rfId;
    String itemTypeId;
    String status;
    String date;
    String remarks;
    String dummy;

    private List<ItemEntity> items;
//    private List<ItemTypeEntity> itemTypes;
    private ItemEntity newItem;
    private ItemEntity selectedItem;
//    private ItemTypeEntity newItemType;
//    private ItemTypeEntity selectedItemType;

    private String serverMessage;
    
    @PostConstruct
    public void init() {
        items = warehouseInventoryMBLocal.listWarehouseItems();
    }
    //D.1.1.1
    public void createWarehouseItem() {

        try {
            newItem = warehouseInventoryMBLocal.createItem("987", "tesT", "test", null);
            items.add(newItem);
        } catch (Exception ex) {

        }

    }
//
//    public ArrayList<ItemTypeEntity> listWarehouseItemTypes() {
//        session.setAttribute("locationId", warehouseId);
//
//        return null; //warehouseInventoryMBLocal.listWarehouseItemTypes(warehouseId);
//    }

    //D.1.1.2
    //D.1.1.3
    //D.1.1.4
    /*
    public ArrayList<ItemEntity> viewWarehouseItem() {
        session.setAttribute("locationId", warehouseId);
        session.setAttribute("itemId", warehouseItemId);

        return warehouseInventoryMBLocal.viewWarehouseItem(warehouseId, warehouseItemId);
    }
    */
    //D.1.1.5
    /*
    public ArrayList<ItemTypeEntity> viewWarehouseItemType() {
        session.setAttribute("locationId", warehouseId);
        session.setAttribute("itemTypeId", itemTypeId);

        return warehouseInventoryMBLocal.viewWarehouseItemType(warehouseId, itemTypeId);
    } */

    //D.1.1.6
    public void updateWarehouseItem() {
        boolean updateAttempt;

        try {
            updateAttempt = warehouseInventoryMBLocal.updateWarehouseItem(selectedItem, rfId, status, remarks);
            if (updateAttempt == true) {
                serverMessage = "Item details updated successfully";
            } else {
                serverMessage = "Item details failed to update";
            }
        } catch (Exception ex) {
            serverMessage = "Item details failed to update";
        }

    }

    public WarehouseInventoryManagementBeanLocal getWarehouseInventoryMBLocal() {
        return warehouseInventoryMBLocal;
    }
    
    public void setWarehouseInventoryMBLocal (WarehouseInventoryManagementBeanLocal warehouseInventoryMBLocal) {
        this.warehouseInventoryMBLocal = warehouseInventoryMBLocal;
    }
    
    public NavigationWarehouseBean getNavigationWarehouseBean() {
        return navigationWarehouseBean;
    }
    
    public Long getItemId() {
        return itemId;
    }
    
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    public String getRfId() {
        return rfId;
    }
    
    public void setRfId(String rfId) {
        this.rfId = rfId;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String setRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public List<ItemEntity> getItems() {
        return items;
    }
    
    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
    
    public ItemEntity getSelectedItem() {
        return selectedItem;
    }
    
    public void setSelectedItem(ItemEntity selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public String getServerMessage() {
        return serverMessage;
    }
    
    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
    
    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }
}
