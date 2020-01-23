/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.PurchaseOrderEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author keane
 */
@Local
public interface DeliveryOrderBeanLocal {

    boolean updatePurchaseOrder(PurchaseOrderEntity selectedPurchase, String status);

    List<PurchaseOrderEntity> listPurchaseOrders();

    PurchaseOrderEntity createPurchase(String status);

    List<PurchaseOrderEntity> listPurchaseOrder();
    
}
