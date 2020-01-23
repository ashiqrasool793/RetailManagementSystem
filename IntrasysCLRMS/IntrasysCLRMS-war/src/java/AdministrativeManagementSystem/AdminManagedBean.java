/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import Entity.AdministratorEntity;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kenneth
 */
@Named(value = "adminManagedBean")
@RequestScoped
public class AdminManagedBean {
    
    @EJB
    private AdministrativeManagementBeanLocal adminManagementBeanLocal;
    
    private List<AdministratorEntity> admins;
    private AdministratorEntity selectedAdmin;
    private AdministratorEntity newAdmin;
    private Long adminId;
    private String adminUsername;
    private String adminPassword;
    private Long adminContact;
    
    @PostConstruct
    public void init() {
        admins = adminManagementBeanLocal.listAllAdmin();
    }
    
    public void createAdmin() {
        newAdmin = adminManagementBeanLocal.createAdministratorAccount(adminUsername, adminPassword, adminContact);
        admins.add(newAdmin);
    }
    
    public void editAdmin() throws NoSuchAlgorithmException {
        adminManagementBeanLocal.editAdministratorAccount(selectedAdmin.getAdminId(), adminUsername, adminPassword, adminContact);
    }
    
    private void clear() {
        selectedAdmin = null;
        adminId = null;
        adminUsername = null;
        adminPassword = null;
        adminContact = null;
    }
    
    // Getter and Setter

    public List<AdministratorEntity> getAdmins() {
        return admins;
    }

    public void setAdmins(List<AdministratorEntity> admins) {
        this.admins = admins;
    }

    public AdministratorEntity getSelectedAdmin() {
        return selectedAdmin;
    }

    public void setSelectedAdmin(AdministratorEntity selectedAdmin) {
        this.selectedAdmin = selectedAdmin;
    }

    public AdministratorEntity getNewAdmin() {
        return newAdmin;
    }

    public void setNewAdmin(AdministratorEntity newAdmin) {
        this.newAdmin = newAdmin;
    }
    
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Long getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(Long adminContact) {
        this.adminContact = adminContact;
    }
}
