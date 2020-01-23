/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.ItemEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author keane
 */
@Named(value = "inventoryManagedBean")
@RequestScoped
public class InventoryManagedBean {

    @EJB
    WarehouseInventoryManagementBeanLocal wimbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    Long itemId;
    String rfId;
    String itemTypeId;
    String status;
    String date;
    String remarks;
    String dummy;
    RetailerEntity retailerId;

    List<ItemEntity> itemList;
    private ItemEntity newItem;
    private ItemEntity selectedItem;

    /**
     * Creates a new instance of InventoryManagedBean
     */
    public InventoryManagedBean() {
    }

    @PostConstruct
    public void init() {
        itemList = wimbl.listWarehouseItems();
    }
    
    public void createItem(){
        try{
            newItem = wimbl.createItem(rfId, status, remarks, null);
            itemList.add(newItem);
        }catch (Exception ex){
            
        }
    }
    
    public void updateItem(){
        boolean updateAttempt;
        updateAttempt = wimbl.updateWarehouseItem(selectedItem, rfId, status, remarks);
        
        try {
            if(updateAttempt == true){
                
            }
        }catch(Exception ex){
            
        }
    }
    
    public void clear(){
        itemId = null;
        status = null;
        remarks = null;
        retailerId = null;
    }

    public WarehouseInventoryManagementBeanLocal getWimbl() {
        return wimbl;
    }

    public void setWimbl(WarehouseInventoryManagementBeanLocal wimbl) {
        this.wimbl = wimbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
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

    public String getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(String itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<ItemEntity> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemEntity> itemList) {
        this.itemList = itemList;
    }

    public ItemEntity getNewItem() {
        return newItem;
    }

    public void setNewItem(ItemEntity newItem) {
        this.newItem = newItem;
    }

    public ItemEntity getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemEntity selectedItem) {
        this.selectedItem = selectedItem;
    }

}
