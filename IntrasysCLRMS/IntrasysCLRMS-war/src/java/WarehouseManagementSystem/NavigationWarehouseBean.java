/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author keane
 */
@Stateless
@LocalBean
public class NavigationWarehouseBean {

     /**
     * Go to warehouseManagementHome page
     * @return WarehouseManagementHome page name
     */
    public String toWarehouseManagementHome() {
        return "warehouseManagementHome.xhtml";
    }
    
    /**
     * Redirect to warehouseManagementHome page
     * @return WarehouseManagementHome page name
     */
    public String redirectToWarehouseManagementHome() {
        return "warehouseManagementHome.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to adminhome page
     * @return AdminHome page name
     */
    public String toAdminHome() {
        return "adminhome.xhtml?faces-redirect=true";
    }
    
    /**
     * Redirect to warehouseManagementHome page
     * @return WarehouseManagementHome page name
     */
    public String redirectToAdminHome() {
        return "adminHome.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to viewPromotions page
     * @return viewPromotions page name
     */
    public String toHQViewPromotions() {
        return "viewPromotions.xhtml";
    }
    
    /**
     * Redirect to viewPromotions page
     * @return viewPromotions page name
     */
    public String redirectToHQViewPromotions() {
        return "viewPromotions.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to viewPromotions page
     * @return viewPromotions page name
     */
    public String toHQDeletePromotion() {
        return "deletePromotions.xhtml";
    }
    
    /**
     * Redirect to viewPromotions page
     * @return viewPromotions page name
     */
    public String redirectToHQDeletePromotion() {
        return "deletePromotions.xhtml?faces-redirect=true";
    }
}
