/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import CommonInfrastructure.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import CommonInfrastructure.LoginManagementBeanLocal;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Kenneth
 */
@Named(value = "adminLoginManagedBean")
@RequestScoped
public class AdminLoginManagedBean {

    @EJB
    LoginManagementBeanLocal loginManagementBeanlocal;
    @EJB
    AdministrativeManagementBeanLocal adminManagementBeanLocal;
    
    @ManagedProperty(value="#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();
            
    String adminUser;
    String adminPassword;
    HttpSession session;
    
    public AdminLoginManagedBean() {
    }
    
    public String login() {
        if(loginManagementBeanlocal.administratorAuthenticate(adminUser, adminPassword)) {
            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("adminUser", adminUser);
            return navigationAdminBean.redirectToAdminHome();
        }
        else {
            FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return navigationAdminBean.toAdminLogin();
        }
    }
    
    public String logout() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return navigationAdminBean.toAdminLogin();
    }

    // Getter & Setter
    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
