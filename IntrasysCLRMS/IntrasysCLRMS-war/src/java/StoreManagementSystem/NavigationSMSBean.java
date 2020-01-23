/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author ashiq
 */
@Named(value = "navigationSMSBean")
@RequestScoped
public class NavigationSMSBean {

    public NavigationSMSBean() {
    }
    
    /**
     * Go to Login page
     * @return Login page name
     */
    public String toSMSLogin() {
        return "smslogin.xhtml";
    }
    
    /**
     * Redirect to login page
     * @return Login page name
     */
    public String redirectToSMSLogin() {
        return "smslogin.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to Home page
     * @return Home page name
     */
    public String toSMSHome() {
        return "smshome.xhtml";
    }
    
    /**
     * Redirect to Home page
     * @return Home page name
     */
    public String redirectToSMSHome() {
        return "smshome.xhtml?faces-redirect=true";
    }
}

