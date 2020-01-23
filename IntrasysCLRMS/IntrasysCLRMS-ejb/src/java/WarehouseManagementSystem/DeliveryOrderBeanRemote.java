/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.PurchaseOrderEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author keane
 */
@Remote
public interface DeliveryOrderBeanRemote {

    List<PurchaseOrderEntity> listPurchaseOrders();

    PurchaseOrderEntity createPurchase(String status);

    List<PurchaseOrderEntity> listPurchaseOrder();
    
}
