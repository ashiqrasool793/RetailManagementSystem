/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Terence
 */
@Named(value = "navigationHQBean")
@RequestScoped
public class NavigationHQBean {

    public NavigationHQBean() {
    }
    
    /**
     * Go to createPromotion page
     * @return Login page name
     */
    public String toHQCreatePromotion() {
        return "createPromotion.xhtml";
    }
    
    /**
     * Redirect to createPromotion page
     * @return CreatePromotion page name
     */
    public String redirectToHQCreatePromotion() {
        return "createPromotion.xhtml?faces-redirect=true";
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
