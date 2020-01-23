/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author keane
 */
@Named(value = "warehouseLayoutManagedBean")
@Dependent
public class WarehouseLayoutManagedBean {

    @EJB
    WarehouseLayoutBeanLocal warehouseLayoutBeanLocal;
    
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationWarehouseBean navigationWarehouseBean = new NavigationWarehouseBean();
    
    
    
    
    /**
     * Creates a new instance of WarehouseLayoutManagedBean
     */
    public WarehouseLayoutManagedBean() {
    }
    
}
