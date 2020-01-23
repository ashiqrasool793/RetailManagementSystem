/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import Entity.AdministratorEntity;
import static StaticClasses.Encryption.getSalt;
import static StaticClasses.Encryption.SHA256;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kenneth
 */
@Stateless
public class AdministrativeManagementBean implements AdministrativeManagementBeanLocal, AdministrativeManagementBeanRemote{
    
    @PersistenceContext
    EntityManager em;
    
    private AdministratorEntity admin;
    
    @Override
    public AdministratorEntity createAdministratorAccount(String adminUsername, String adminPassword, Long adminContact) {
        
        admin = new AdministratorEntity();
        
        try {
            admin.setAdminUsername(adminUsername);
            admin.setAdminPassword(adminPassword);
            admin.setAdminContact(adminContact);
        } catch (NoSuchAlgorithmException ex) {
        }
        
        em.persist(admin);
        em.flush();
        
        return admin;
    }
    
    @Override
    public void editAdministratorAccount(Long adminId, String adminUsername, String adminPassword, Long adminContact) throws NoSuchAlgorithmException {
        admin = em.find(AdministratorEntity.class, adminId);
        
        try {
        admin.setAdminUsername(adminUsername);
        admin.setAdminPassword(adminPassword);
        admin.setAdminContact(adminContact);
        }
        catch (NoSuchAlgorithmException ex) {
            
        }
        
        em.merge(admin);
        em.flush();
    }
    
    @Override
    public List<AdministratorEntity> listAllAdmin() {
        Query query = em.createQuery("SELECT a FROM AdministratorEntity a");
        return query.getResultList();
    }   
}
