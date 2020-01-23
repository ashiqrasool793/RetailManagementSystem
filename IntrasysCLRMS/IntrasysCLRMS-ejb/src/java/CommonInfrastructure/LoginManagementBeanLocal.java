/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import javax.ejb.Local;

/**
 *
 * @author Kenneth
 */
@Local
public interface LoginManagementBeanLocal {
    
    public boolean administratorAuthenticate(String adminUsername, String adminPassword);
    
    public boolean employeeAuthenticate(Long retailerId, String staffUsername, String staffPassword);
    
    public boolean customerAuthenticate(Long retailerId, String customerUsername, String customerPassword);
    
}
