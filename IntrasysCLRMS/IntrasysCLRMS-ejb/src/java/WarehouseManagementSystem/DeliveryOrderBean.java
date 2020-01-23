/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.PurchaseOrderEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author keane
 */
@Stateless
public class DeliveryOrderBean implements DeliveryOrderBeanLocal, DeliveryOrderBeanRemote {

    @PersistenceContext
    EntityManager em;

    private PurchaseOrderEntity purchaseOrderEN;
    private ArrayList purchases;
    
    
    
    @Override
    public boolean updatePurchaseOrder(PurchaseOrderEntity selectedPurchase, String status) {
        try {
            purchaseOrderEN = selectedPurchase;
            purchaseOrderEN.setRemarks(status);

            em.merge(purchaseOrderEN);
            em.flush();
            
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    

    @Override
    public PurchaseOrderEntity createPurchase(String status) {
        purchaseOrderEN = new PurchaseOrderEntity();
        
        purchaseOrderEN.setRemarks(status);
        em.persist(purchaseOrderEN);
        em.flush();
        
        return purchaseOrderEN;
    }

    @Override
    public List<PurchaseOrderEntity> listPurchaseOrder() {
        Query q = em.createQuery("SELECT p FROM PurchaseOrderEntity p");
        return q.getResultList();
    }

    @Override
    public List<PurchaseOrderEntity> listPurchaseOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
