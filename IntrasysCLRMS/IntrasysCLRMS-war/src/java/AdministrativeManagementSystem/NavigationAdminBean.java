/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kenneth
 */
@Named(value = "navigationAdminBean")
@RequestScoped
public class NavigationAdminBean {

    public NavigationAdminBean() {
    }
    
    /**
     * Go to Login page
     * @return Login page name
     */
    public String toAdminLogin() {
        return "adminlogin.xhtml";
    }
    
    /**
     * Redirect to login page
     * @return Login page name
     */
    public String redirectToAdminLogin() {
        return "adminlogin.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to Home page
     * @return Home page name
     */
    public String toAdminHome() {
        return "adminhome.xhtml";
    }
    
    /**
     * Redirect to Home page
     * @return Home page name
     */
    public String redirectToAdminHome() {
        return "adminhome.xhtml?faces-redirect=true";
    }
}
