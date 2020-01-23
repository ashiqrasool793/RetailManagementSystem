/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author edwar
 */
@Named(value = "itemTypeManagedBean")
@RequestScoped
public class ItemTypeManagedBean {

    @EJB
    ItemTypeManagementBeanLocal imbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long itemTypeId;
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private String itemSubCategory;
    private String itemPicture;
    private double itemBasePrice;
    private double itemSalePrice;
    private RetailerEntity retailerId;

    private List<ItemTypeEntity> itemTypesList;
    private ItemTypeEntity newItemType;
    private ItemTypeEntity selectedItemType;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of ItemTypeManagedBean
     */
    public ItemTypeManagedBean() {
    }

    @PostConstruct
    public void init() {
        itemTypesList = imbl.listItemType();
    }

    public void createNewItemType() {
        try {
            newItemType = imbl.createItemType(itemName, itemDescription, itemCategory, itemSubCategory, itemPicture, itemBasePrice, itemSalePrice, retailerId);
            itemTypesList.add(newItemType);
            serverMessage = "New ItemType added.";
            clear();

        } catch (Exception ex) {

        }
    }

    public void updateItemType() {
        boolean updateAttempt;
        updateAttempt = imbl.updateItemType(selectedItemType, itemName, itemDescription, itemCategory, itemSubCategory, itemPicture, itemBasePrice, itemSalePrice, retailerId);
        try {
            if (updateAttempt == true) {
                serverMessage = "Item Type updated successfully";
            }
            else{
                serverMessage = "Item Type failed to update";
            }
        } catch (Exception ex) {
            serverMessage = "Item Type failed to update";
        }
    }

    private void clear() {
        itemTypeId = null;
        selectedItemType = null;
        itemName = null;
        itemDescription = null;
        itemCategory = null;
        itemSubCategory = null;
        itemPicture = null;
        itemBasePrice = 0;
        itemSalePrice = 0;
        retailerId = null;

    }

    public ItemTypeManagementBeanLocal getImbl() {
        return imbl;
    }

    public void setImbl(ItemTypeManagementBeanLocal imbl) {
        this.imbl = imbl;
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
