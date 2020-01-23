/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import Entity.AdministratorEntity;
import Entity.RetailerEntity;
import Entity.EmployeeEntity;
import Entity.CustomerEntity;
import static StaticClasses.Encryption.checkPassword;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kenneth
 */
@Stateless
public class LoginManagementBean implements LoginManagementBeanLocal, LoginManagementBeanRemote{
    
    @PersistenceContext
    EntityManager em;
    
    private AdministratorEntity admin;
    private RetailerEntity retailer;
    private EmployeeEntity employee;
    private CustomerEntity customer;
    
    @Override
    public boolean administratorAuthenticate(String adminUsername, String adminPassword) {
        Query query = em.createQuery("SELECT a FROM AdministratorEntity a WHERE a.adminUsername=:adminUsername");
        query.setParameter("adminUsername", adminUsername);
        
        try {
            admin = (AdministratorEntity) query.getSingleResult();
        }
        catch(NoResultException nre) {
            return false;
        }
        
        String correctAdminPassword = admin.getAdminPassword();
        String adminSalt = admin.getAdminSalt();
        try {
            if(checkPassword(correctAdminPassword, adminPassword, adminSalt)) {
                return true;
            } 
            else {
                return false;
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        return false;
    }
    
    @Override
    public boolean employeeAuthenticate(Long retailerId, String staffUsername, String staffPassword) {
        retailer = getRetailerFromRetailerId(retailerId);
        Query query = em.createQuery("SELECT s FROM EmployeeEntity s WHERE s.staffUsername=:staffUsername AND s.retailer=:retailer");
        query.setParameter("staffUsername", staffUsername);
        query.setParameter("retailer", retailer);
        
        try {
            employee = (EmployeeEntity) query.getSingleResult();
        }
        catch(NoResultException nre) {
            return false;
        }
        
        String correctStaffPassword = employee.getStaffPassword();
        // To do: Hash staffPassword
        if(correctStaffPassword.equals(staffPassword)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Or do it by Email authentication?
    @Override
    public boolean customerAuthenticate(Long retailerId, String customerUsername, String customerPassword) {
        retailer = getRetailerFromRetailerId(retailerId);
        Query query = em.createQuery("SELECT s FROM CustomerEntity c WHERE c.customerUsername=:customerUsername AND c.retailer=:retailer");
        query.setParameter("customerUsername", customerUsername);
        query.setParameter("retailer", retailer);
        
        try {
            customer = (CustomerEntity) query.getSingleResult();
        }
        catch(NoResultException nre) {
            return false;
        }
        
        String correctCustomerPassword = customer.getCustomerPassword();
        // To do: Hash staffPassword
        if(correctCustomerPassword.equals(customerPassword)) {
            return true;
        } else {
            return false;
        }
    }
    
    private RetailerEntity getRetailerFromRetailerId(Long rId) {
        Query query = em.createQuery("SELECT r FROM RetailerEntity r WHERE r.rId = :rId");
        query.setParameter("rId", rId);
        return (RetailerEntity) query.getSingleResult();
    }
    
    // To do: Lock out account
    // To do: Unlock account
    // To do: List account
}