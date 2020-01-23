/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.RetailerEntity;
import Entity.TransferOrderEntity;
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
public class PickingBean implements PickingBeanLocal, PickingBeanRemote {

    @PersistenceContext
    EntityManager em;

    private TransferOrderEntity transferOrderEN;
    private ArrayList transfers;

    @Override
    public List<TransferOrderEntity> listPickList() {
        Query q = em.createQuery("SELECT t FROM TransferOrderEntity t");

        return q.getResultList();
    }
    
    //Function D.2.1.10 Download Pick List
    @Override
    public List<TransferOrderEntity> downloadPickList() {
        Query q = em.createQuery("SELECT t FROM TransferOrderEntity t");
        
        return q.getResultList();
    }

    
    //Function D.2.1.11 Upload Pick List

    @Override
    public boolean updatePickList(TransferOrderEntity selectedPick, String status) {
        
        try {
            transferOrderEN = selectedPick;
            transferOrderEN.setStatus(status);

            em.merge(transferOrderEN);
            em.flush();
            
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public TransferOrderEntity createPickList(String status, RetailerEntity retailerId) {
        transferOrderEN = new TransferOrderEntity();
        transferOrderEN.setStatus(status);
        transferOrderEN.setRetailer(retailerId);
        return transferOrderEN;
    }

    
    
    
}
