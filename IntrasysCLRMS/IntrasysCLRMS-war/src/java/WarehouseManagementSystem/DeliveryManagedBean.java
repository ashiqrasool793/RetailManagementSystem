/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.PurchaseOrderEntity;
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
@Named(value = "deliveryManagedBean")
@RequestScoped
public class DeliveryManagedBean {
    
    @EJB
    DeliveryOrderBeanLocal dobl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();
    
    private Long purchaseOrderId;
    private String purchaseOrderStatus;
    private RetailerEntity retailerId;
    
    private List<PurchaseOrderEntity> purchaseOrderList;
    private PurchaseOrderEntity newPurchaseOrder;
    private PurchaseOrderEntity selectedPurchaseOrder;
    
    private String serverMessage;
    private String dummy;
    
    /**
     * Creates a new instance of TransferOrdersManagedBean
     */
    public DeliveryManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        //purchaseOrderList = dobl.listPurchaseOrders();
    }
    
    
    public void createPurchaseOrder() {
        try {
            newPurchaseOrder = dobl.createPurchase(null);
            purchaseOrderList.add(newPurchaseOrder);
        }
        catch (Exception ex) {
            
        }
    }
    
    public void updatePurchaseOrder() {
        boolean updateAttempt;
        try {
            updateAttempt = dobl.updatePurchaseOrder(selectedPurchaseOrder, purchaseOrderStatus);
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
    
    public DeliveryOrderBeanLocal getDobl() {
        return dobl;
    }

    public void setDobl(DeliveryOrderBeanLocal dobl) {
        this.dobl = dobl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(String purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<PurchaseOrderEntity> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(List<PurchaseOrderEntity> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }

    public PurchaseOrderEntity getNewPurchaseOrder() {
        return newPurchaseOrder;
    }

    public void setNewPurchaseOrder(PurchaseOrderEntity newPurchaseOrder) {
        this.newPurchaseOrder = newPurchaseOrder;
    }

    public PurchaseOrderEntity getSelectedPurchaseOrder() {
        return selectedPurchaseOrder;
    }

    public void setSelectedPurchaseOrder(PurchaseOrderEntity selectedPurchaseOrder) {
        this.selectedPurchaseOrder = selectedPurchaseOrder;
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
