/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.CustomerEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author edwar
 */
@Local
public interface CustomerManagementBeanLocal {

    CustomerEntity createCustomer(String customerName, String customerContact, String customerEmail, String customerAddress, String customerUsername, String customerPassword, int rewardPoints);

    boolean updateCustomer(CustomerEntity selectedCustomer, String customerName, String customerContact, String customerEmail, String customerAddress, String customerUsername, String customerPassword, int rewardPoints);

    List<CustomerEntity> listCustomers();
    
}
