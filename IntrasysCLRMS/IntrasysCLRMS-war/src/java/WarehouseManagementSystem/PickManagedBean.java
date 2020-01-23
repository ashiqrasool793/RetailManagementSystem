/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.EmployeeEntity;
import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import Entity.TransferOrderEntity;
import HQSystem.ItemTypeManagementBeanLocal;
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
@Named(value = "pickManagedBean")
@RequestScoped
public class PickManagedBean {
    
    @EJB
    PickingBeanLocal pbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();
    
    private Long transferOrderId;
    private String items;
    private String pickStatus;
    private RetailerEntity retailerId;
    
    private List<TransferOrderEntity> pickList;
    private TransferOrderEntity newPick;
    private TransferOrderEntity selectedPick;
    
    private String serverMessage;
    private String dummy;
    
    /**
     * Creates a new instance of TransferOrdersManagedBean
     */
    public PickManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        pickList = pbl.listPickList();
    }
    
    public void createPickList() {
        try {
            newPick = pbl.createPickList(pickStatus, null);
            pickList.add(newPick);
            clear();
        }
        catch (Exception ex) {
            
        }
    }
    
    public void updatePickList() {
        boolean updateAttempt;
        try {
            updateAttempt = pbl.updatePickList(selectedPick, pickStatus);
            if (updateAttempt == true) {
                serverMessage = "PL Updated.";
            }
            else { 
                serverMessage = "PL failed to update";
            }
        }
        catch (Exception ex) {
                    
        }
    }
    
    public void downloadPickList() {
        
    }
    
    private void clear() {
        transferOrderId = null;
        items = null;
        selectedPick = null;
        pickStatus = null;
        retailerId = null;
    }

    public PickingBeanLocal getPbl() {
        return pbl;
    }

    public void setPbl(PickingBeanLocal pbl) {
        this.pbl = pbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getTransferOrderId() {
        return transferOrderId;
    }

    public void setTransferOrderId(Long transferOrderId) {
        this.transferOrderId = transferOrderId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getPickStatus() {
        return pickStatus;
    }

    public void setPickStatus(String pickStatus) {
        this.pickStatus = pickStatus;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<TransferOrderEntity> getPickList() {
        return pickList;
    }

    public void setPickList(List<TransferOrderEntity> pickList) {
        this.pickList = pickList;
    }

    public TransferOrderEntity getNewPick() {
        return newPick;
    }

    public void setNewPick(TransferOrderEntity newPick) {
        this.newPick = newPick;
    }

    public TransferOrderEntity getSelectedPick() {
        return selectedPick;
    }

    public void setSelectedPick(TransferOrderEntity selectedPick) {
        this.selectedPick = selectedPick;
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
