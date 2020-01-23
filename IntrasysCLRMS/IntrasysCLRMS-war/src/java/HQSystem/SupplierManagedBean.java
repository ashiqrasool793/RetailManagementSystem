/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.RetailerEntity;
import Entity.SupplierEntity;
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
@Named(value = "supplierManagedBean")
@RequestScoped
public class SupplierManagedBean {

    @EJB
    SupplierManagementBeanLocal smbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long supplierId;
    private String supplierName;
    private String supplierUsername;
    private String supplierPassword;
    private String supplierEmail;
    private String supplierContact;
    private RetailerEntity retailerId;

    private List<SupplierEntity> supplierList;
    private SupplierEntity newSupplier;
    private SupplierEntity selectedSupplier;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of SupplierManagedBean
     */
    public SupplierManagedBean() {
    }

    @PostConstruct
    public void init() {
        supplierList = smbl.listSupplier();
    }
    
    public void createNewSupplier(){
        try{
        newSupplier = smbl.createSupplier(supplierName, supplierUsername, "password", supplierEmail, supplierContact, null);
        supplierList.add(newSupplier);
        serverMessage = "New Supplier added.";
        clear();
        }catch (Exception ex){
            
        }
    }
    
    public void updateSupplier(){
        boolean updateAttempt;
        updateAttempt = smbl.updateSupplier(selectedSupplier, supplierName, supplierUsername, supplierEmail, supplierContact);
        try{
            if(updateAttempt == true){
                serverMessage = "Supplier updated successfully";
            }
            else{
                serverMessage = "Supplier failed to update";
            }
            
        }catch (Exception ex){
            serverMessage = "Supplier failed to update";
        }
        
    }
    
    private void clear(){
        supplierId = null;
        selectedSupplier = null;
        supplierName = null;
        supplierUsername = null;
        supplierPassword = null;
        supplierEmail = null;
        supplierContact = null;
        retailerId = null;
    }

    public SupplierManagementBeanLocal getSmbl() {
        return smbl;
    }

    public void setSmbl(SupplierManagementBeanLocal smbl) {
        this.smbl = smbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierUsername() {
        return supplierUsername;
    }

    public void setSupplierUsername(String supplierUsername) {
        this.supplierUsername = supplierUsername;
    }

    public String getSupplierPassword() {
        return supplierPassword;
    }

    public void setSupplierPassword(String supplierPassword) {
        this.supplierPassword = supplierPassword;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<SupplierEntity> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<SupplierEntity> supplierList) {
        this.supplierList = supplierList;
    }

    public SupplierEntity getNewSupplier() {
        return newSupplier;
    }

    public void setNewSupplier(SupplierEntity newSupplier) {
        this.newSupplier = newSupplier;
    }

    public SupplierEntity getSelectedSupplier() {
        return selectedSupplier;
    }

    public void setSelectedSupplier(SupplierEntity selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
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
