/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.CustomerEntity;
import Entity.MembershipEntity;
import Entity.RetailerEntity;
import java.sql.Timestamp;
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
@Named(value = "customerManagedBean")
@RequestScoped
public class CustomerManagedBean {

    @EJB
    CustomerManagementBeanLocal cmbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long customerId;
    private String customerName;
    private String customerContact;
    private String customerEmail;
    private String customerAddress;
    private String customerUsername;
    private String customerPassword;
    private Timestamp birthDate;
    private Timestamp expiryDate;
    private int rewardPoints;
    private MembershipEntity membership;
    private RetailerEntity retailerId;

    private List<CustomerEntity> customerList;
    private CustomerEntity newCustomer;
    private CustomerEntity selectedCustomer;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }

    @PostConstruct
    public void init() {
        customerList = cmbl.listCustomers();
    }
    
    public void updateCustomer(){
        boolean updateAttempt= cmbl.updateCustomer(selectedCustomer, customerName, customerContact, customerEmail, customerAddress, customerUsername, customerPassword, rewardPoints);
        try{
            if(updateAttempt == true){
                serverMessage = "Customer updated successfully";
            }
            else{
                serverMessage = "Customer failed to update";
            }
        }catch (Exception ex){
            serverMessage = "Customer failed to update";
        }
    }

    public CustomerManagementBeanLocal getCmbl() {
        return cmbl;
    }

    public void setCmbl(CustomerManagementBeanLocal cmbl) {
        this.cmbl = cmbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public MembershipEntity getMembership() {
        return membership;
    }

    public void setMembership(MembershipEntity membership) {
        this.membership = membership;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<CustomerEntity> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerEntity> customerList) {
        this.customerList = customerList;
    }

    public CustomerEntity getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(CustomerEntity newCustomer) {
        this.newCustomer = newCustomer;
    }

    public CustomerEntity getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(CustomerEntity selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
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
