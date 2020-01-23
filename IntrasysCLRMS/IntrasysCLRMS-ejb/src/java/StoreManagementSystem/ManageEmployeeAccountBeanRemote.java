/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.EmployeeEntity;
import javax.ejb.Remote;

/**
 *
 * @author ashiq
 */
@Remote
public interface ManageEmployeeAccountBeanRemote {

    boolean updateProfile(String staffUsername, Long contact, String address, String email, String password);
     
    boolean loginUser(String staffUsername, String password);

    EmployeeEntity getEmployee(String staffUsername);
}
