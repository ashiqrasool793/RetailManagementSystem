/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.CustomerEntity;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwar
 */
@Stateless
public class CustomerManagementBean implements CustomerManagementBeanLocal, CustomerManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private CustomerEntity customer;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public CustomerEntity createCustomer(String customerName, String customerContact, String customerEmail, String customerAddress, String customerUsername, String customerPassword, int rewardPoints) {
        customer = new CustomerEntity();
        customer.setCustomerName(customerName);
        customer.setCustomerContact(customerContact);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerUsername(customerUsername);
        customer.setCustomerPassword(customerPassword);
        customer.setRewardPoints(rewardPoints);
        em.persist(customer);
        em.flush();
        return customer;
    }

    @Override
    public boolean updateCustomer(CustomerEntity selectedCustomer, String customerName, String customerContact, String customerEmail, String customerAddress, String customerUsername, String customerPassword, int rewardPoints) {
        try {
            customer = selectedCustomer;
            customer.setCustomerName(customerName);
            customer.setCustomerContact(customerContact);
            customer.setCustomerEmail(customerEmail);
            customer.setCustomerAddress(customerAddress);
            customer.setCustomerUsername(customerUsername);
            customer.setCustomerPassword(customerPassword);
            customer.setRewardPoints(rewardPoints);
            em.merge(customer);
            em.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public List<CustomerEntity> listCustomers() {
        Query query = em.createQuery("SELECT c from CustomerEntity c");
        System.out.println(query.getResultList());
        return query.getResultList();
    }
    
    

}
