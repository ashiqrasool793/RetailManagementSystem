/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kenneth
 */
@Named(value = "navigationCIBean")
@RequestScoped
public class NavigationCIBean {

    public NavigationCIBean() {
    }
    
    /**
     * Go to Login page
     * @return Login page name
     */
    public String toManageRoles() {
        return "manageroles.xhtml";
    }
    
    /**
     * Redirect to login page
     * @return Login page name
     */
    public String redirectToManageRoles() {
        return "manageroles.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to Home page
     * @return Home page name
     */
    public String toRoleFunction() {
        return "rolefunction.xhtml";
    }
    
    /**
     * Redirect to Home page
     * @return Home page name
     */
    public String redirectToRoleFunction() {
        return "rolefunction.xhtml?faces-redirect=true";
    }
}

