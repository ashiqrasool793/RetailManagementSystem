/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import Entity.AdministratorEntity;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author Kenneth
 */
@Remote
public interface AdministrativeManagementBeanRemote {
    
    public AdministratorEntity createAdministratorAccount(String adminUsername, String adminPassword, Long adminContact);
    
    public void editAdministratorAccount(Long adminId, String adminUsername, String adminPassword, Long adminContact) throws NoSuchAlgorithmException;
    
    public List<AdministratorEntity> listAllAdmin();
}
