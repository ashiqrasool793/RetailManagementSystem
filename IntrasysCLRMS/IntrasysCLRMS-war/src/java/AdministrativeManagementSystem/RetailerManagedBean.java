/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import AdministrativeManagementSystem.RetailerManagementBean;
import Entity.RetailerEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Kenneth
 */
@Named(value = "retailerManagedBean")
@RequestScoped
public class RetailerManagedBean {
    
    @EJB
    private RetailerManagementBeanLocal retailerManagementBeanLocal;
    
    @ManagedProperty(value="#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();
    
    private List<RetailerEntity> retailers;
    private RetailerEntity selectedRetailer;
    private RetailerEntity newRetailer;
    private Long retailerId;
    private String retailerName;
    private String retailerAddress;
    private Long retailerContact;
    private String retailerEmail;
    private String retailerDescription;
    private int retailerTier;
    private int warehouseLimit;
    private int storeLimit;
    private String statusMessage;

    @PostConstruct
    public void init() {
        retailers = retailerManagementBeanLocal.listAllRetailerAccounts();
    }
    
    public void saveNewRetailer() {
        /**
         * Server Test
         */
        System.out.println("New Retailer name: " + retailerName);
        System.out.println("New Retailer address: " + retailerAddress);
        System.out.println("New Retailer contact: " + retailerContact);
        System.out.println("New Retailer email: " + retailerEmail);
        System.out.println("New Retailer desciption: " + retailerDescription);
        System.out.println("New Retailer tier: " + retailerTier);
        System.out.println("New Warehouse limit: " + warehouseLimit);
        System.out.println("New Store limit: " + storeLimit);
        
        try {
            newRetailer = retailerManagementBeanLocal.createRetailerAccount(retailerName, retailerAddress, retailerContact, 
            retailerEmail, retailerDescription, retailerTier, warehouseLimit, storeLimit);
            
            retailers.add(newRetailer);
            statusMessage = "New Retailer Account created successfully.";
            clear();
        }
        catch (Exception ex) {
        }
    }
    
    public void saveRetailerUpdate() {
        boolean updateAttempt;
        /**
         * Server test
         */
        System.out.println("Retailer Id: " + retailerId);
        System.out.println("New Retailer name: " + retailerName);
        System.out.println("New Retailer address: " + retailerAddress);
        System.out.println("New Retailer contact: " + retailerContact);
        System.out.println("New Retailer email: " + retailerEmail);
        System.out.println("New Retailer desciption: " + retailerDescription);
        System.out.println("New Retailer tier: " + retailerTier);
        System.out.println("New Warehouse limit: " + warehouseLimit);
        System.out.println("New Store limit: " + storeLimit);
        
        try {
            updateAttempt = retailerManagementBeanLocal.updateRetailerAccount(selectedRetailer, retailerName, retailerAddress, retailerContact, 
            retailerEmail, retailerDescription, retailerTier, warehouseLimit, storeLimit);
            
            if(updateAttempt == true) {
                statusMessage = "Retailer Account updated successfully";
            }
            else {
                statusMessage = "Retailer Account update attempt failed";
            }
            clear();
        }
        catch (Exception ex) {
            statusMessage = "Retailer Account update attempt failed";
        }
        
    }
    
    public void deleteRetailer() {
        boolean deleteAttempt;
        
        /**
         * Server Test
         */
        System.out.println("Retailer Id: " + selectedRetailer.getRetailerId());
        for(int i = 0; i < retailers.size(); i++) {
            System.out.println("List retailers before: " + retailers.get(i).getRetailerId());
        }
        
        try {
            retailers.remove(selectedRetailer);
            deleteAttempt = retailerManagementBeanLocal.deleteRetailerAccount(selectedRetailer);
            
            /**
             * Server Test
             */
            for(int i = 0; i < retailers.size(); i++) {
                System.out.println("List retailers after: " + retailers.get(i).getRetailerId());
            }
            
            if(deleteAttempt == true) {
                statusMessage = "Retailer Account deleted successfully";
            }
            else {
                statusMessage = "Retailer Account delete attempt failed";
            }
        }
        catch (Exception ex) {
            statusMessage = "Retailer Account delete attempt failed";
        }
    }
    
    /**
     * For clearing fields after every update as it will appear on form
     */
    private void clear() {
        selectedRetailer = null;
        retailerId = null;
        retailerName = null;
        retailerAddress = null;
        retailerContact = null;
        retailerEmail = null;
        retailerDescription = null;
        retailerTier = 0;
        warehouseLimit = 0;
        storeLimit = 0;
    }
    
    // Getter & Setters

    public List<RetailerEntity> getRetailers() {
        return retailers;
    }

    public void setRetailers(List<RetailerEntity> retailers) {
        this.retailers = retailers;
    }
    
    public RetailerEntity getSelectedRetailer() {
        return selectedRetailer;
    }

    public void setSelectedRetailer(RetailerEntity selectedRetailer) {
        this.selectedRetailer = selectedRetailer;
    }

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }
    
    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getRetailerAddress() {
        return retailerAddress;
    }

    public void setRetailerAddress(String retailerAddress) {
        this.retailerAddress = retailerAddress;
    }

    public Long getRetailerContact() {
        return retailerContact;
    }

    public void setRetailerContact(Long retailerContact) {
        this.retailerContact = retailerContact;
    }

    public String getRetailerEmail() {
        return retailerEmail;
    }

    public void setRetailerEmail(String retailerEmail) {
        this.retailerEmail = retailerEmail;
    }

    public String getRetailerDescription() {
        return retailerDescription;
    }

    public void setRetailerDescription(String retailerDescription) {
        this.retailerDescription = retailerDescription;
    }
    
    public int getRetailerTier() {
        return retailerTier;
    }

    public void setRetailerTier(int retailerTier) {
        this.retailerTier = retailerTier;
    }

    public int getWarehouseLimit() {
        return warehouseLimit;
    }

    public void setWarehouseLimit(int warehouseLimit) {
        this.warehouseLimit = warehouseLimit;
    }

    public int getStoreLimit() {
        return storeLimit;
    }

    public void setStoreLimit(int storeLimit) {
        this.storeLimit = storeLimit;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
