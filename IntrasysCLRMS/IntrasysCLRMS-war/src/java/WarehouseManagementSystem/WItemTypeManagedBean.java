/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import WarehouseManagementSystem.WarehouseInventoryManagementBeanLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Keane
 */
@Named(value = "wItemTypeManagedBean")
@RequestScoped
public class WItemTypeManagedBean {

    @EJB
    WarehouseInventoryManagementBeanLocal wimbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long itemTypeId;
    private String itemName;
    private String itemQuantity;
    private RetailerEntity retailerId;

    private List<ItemTypeEntity> itemTypesList;
    private ItemTypeEntity newItemType;
    private ItemTypeEntity selectedItemType;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of ItemTypeManagedBean
     */
    public WItemTypeManagedBean() {
    }

    @PostConstruct
    public void init() {
        itemTypesList = wimbl.listWarehouseItemTypes();
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

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<ItemTypeEntity> getItemTypesList() {
        return itemTypesList;
    }

    public void setItemTypesList(List<ItemTypeEntity> itemTypesList) {
        this.itemTypesList = itemTypesList;
    }

    public ItemTypeEntity getNewItemType() {
        return newItemType;
    }

    public void setNewItemType(ItemTypeEntity newItemType) {
        this.newItemType = newItemType;
    }

    public ItemTypeEntity getSelectedItemType() {
        return selectedItemType;
    }

    public void setSelectedItemType(ItemTypeEntity selectedItemType) {
        this.selectedItemType = selectedItemType;
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
