/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.EmployeeEntity;
import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import Entity.TransferOrderEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
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
public class TransferOrderBean implements TransferOrderBeanLocal, TransferOrderBeanRemote {

    @PersistenceContext
    EntityManager em;

    private TransferOrderEntity transferOrderEN;
    private ArrayList transfers;

    
    //Function D.2.1.2 - List Transfer Orders
    @Override
    public List<TransferOrderEntity> listTransferOrders() {
        Query q = em.createQuery("SELECT t FROM TransferOrderEntity t");

        return q.getResultList();
    }

    //Function D.2.1.4 - View Transfer Order
    @Override
    public List<ArrayList> viewTransferOrder(long transferOrderId) {
        Query q = em.createQuery("SELECT t FROM TransferOrderEntity t WHERE t.transferOrderId = transferOrderId");
        q.setParameter("transferOrderId", transferOrderId);
        transfers = (ArrayList) q.getResultList();

        return transfers;
    }

    //Function D.2.1.6 - Update Transfer Order
    public boolean updateTransferOrder(TransferOrderEntity selectedTransferOrder, String status) {

        try {
            transferOrderEN = selectedTransferOrder;
            transferOrderEN.setStatus(status);

            em.merge(transferOrderEN);
            em.flush();
            
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }


    //Temp method.
    @Override
    public TransferOrderEntity createTransferOrder(String status, RetailerEntity retailerId) {
        transferOrderEN = new TransferOrderEntity();
        transferOrderEN.setStatus(status);
        transferOrderEN.setRetailer(retailerId);
        
        em.persist(transferOrderEN);
        em.flush();
        
        return transferOrderEN;
    }

}
