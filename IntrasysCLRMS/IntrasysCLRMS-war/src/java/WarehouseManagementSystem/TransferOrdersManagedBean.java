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
@Named(value = "transferOrdersManagedBean")
@RequestScoped
public class TransferOrdersManagedBean {
    
    @EJB
    TransferOrderBeanLocal tobl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();
    
    private Long transferOrderId;
    private String transferOrderStatus;
    private RetailerEntity retailerId;
    
    private List<TransferOrderEntity> transferOrderList;
    private TransferOrderEntity newTransferOrder;
    private TransferOrderEntity selectedTransferOrder;
    
    private String serverMessage;
    private String dummy;
    
    /**
     * Creates a new instance of TransferOrdersManagedBean
     */
    public TransferOrdersManagedBean() {
    }
    
    @PostConstruct
    public void init() {
        transferOrderList = tobl.listTransferOrders();
    }
    
    public void createTransferOrder() {
        try {
            newTransferOrder = tobl.createTransferOrder(transferOrderStatus, null);
            transferOrderList.add(newTransferOrder);
            clear();
        }
        catch (Exception ex) {
            
        }
    }
    
    public void updateTransferOrder() {
        boolean updateAttempt;
        try {
            updateAttempt = tobl.updateTransferOrder(selectedTransferOrder, transferOrderStatus);
            if (updateAttempt == true) {
                serverMessage = "TO Updated.";
            }
            else { 
                serverMessage = "TO failed to update";
            }
        }
        catch (Exception ex) {
                    
        }
    }
    
    private void clear() {
        transferOrderId = null;
        selectedTransferOrder = null;
        transferOrderStatus = null;
        retailerId = null;
    }

    public TransferOrderBeanLocal getTobl() {
        return tobl;
    }

    public void setTobl(TransferOrderBeanLocal tobl) {
        this.tobl = tobl;
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

    public String getTransferOrderStatus() {
        return transferOrderStatus;
    }

    public void setTransferOrderStatus(String transferOrderStatus) {
        this.transferOrderStatus = transferOrderStatus;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<TransferOrderEntity> getTransferOrderList() {
        return transferOrderList;
    }

    public void setTransferOrderList(List<TransferOrderEntity> transferOrderList) {
        this.transferOrderList = transferOrderList;
    }

    public TransferOrderEntity getNewTransferOrder() {
        return newTransferOrder;
    }

    public void setNewTransferOrder(TransferOrderEntity newTransferOrder) {
        this.newTransferOrder = newTransferOrder;
    }

    public TransferOrderEntity getSelectedTransferOrder() {
        return selectedTransferOrder;
    }

    public void setSelectedTransferOrder(TransferOrderEntity selectedTransferOrder) {
        this.selectedTransferOrder = selectedTransferOrder;
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
