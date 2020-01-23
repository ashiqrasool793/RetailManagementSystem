/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import Entity.RetailerEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Exceptions.RetailerNameConflictException; // Include this later on?

/**
 *
 * @author Kenneth
 */
@Stateless
public class RetailerManagementBean implements RetailerManagementBeanLocal, RetailerManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    private RetailerEntity retailer;

    @Override
    public RetailerEntity createRetailerAccount(String retailerName, String retailerAddress, Long retailerContact,
            String retailerEmail, String retailerDescription, int retailerTier, int warehouseLimit, int storeLimit) {
        retailer = new RetailerEntity();

        retailer.setRetailerName(retailerName);
        retailer.setRetailerAddress(retailerAddress);
        retailer.setRetailerContact(retailerContact);
        retailer.setRetailerEmail(retailerEmail);
        retailer.setRetailerDescription(retailerDescription);
        retailer.setRetailerTier(retailerTier);
        retailer.setWarehouseLimit(warehouseLimit);
        retailer.setStoreLimit(storeLimit);
        retailer.setRetailerStatus(1);

        // Set warehouse, store and SKU limit for each tier level
        // Create a new employee with full admin rights
        em.persist(retailer);
        em.flush();

        return retailer;
    }

    @Override
    public boolean updateRetailerAccount(RetailerEntity selectedRetailer, String retailerName, String retailerAddress, Long retailerContact,
            String retailerEmail, String retailerDescription, int retailerTier, int warehouseLimit, int storeLimit) {
        try {
            retailer = selectedRetailer;
            retailer.setRetailerName(retailerName);
            retailer.setRetailerAddress(retailerAddress);
            retailer.setRetailerContact(retailerContact);
            retailer.setRetailerEmail(retailerEmail);
            retailer.setRetailerDescription(retailerDescription);
            retailer.setRetailerTier(retailerTier);
            retailer.setWarehouseLimit(warehouseLimit);
            retailer.setStoreLimit(storeLimit);

            em.merge(retailer);
            em.flush();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean deleteRetailerAccount(RetailerEntity selectedRetailer) {
        try {
            retailer = em.find(RetailerEntity.class, selectedRetailer.getRetailerId());

            em.remove(retailer);
            em.flush();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean checkRetailerNameConflict(String retailerName) {
        Query query = em.createQuery("SELECT r FROM RetailerEntity r WHERE r.retailerName = :retailerName");
        query.setParameter("retailerName", retailerName);
        List resultList = query.getResultList();
        return !resultList.isEmpty();
    }

    @Override
    public void setTier(Long retailerId, int retailerTier) {
        retailer = (RetailerEntity) em.find(RetailerEntity.class, retailerId);
        retailer.setRetailerTier(retailerTier);

        // Set warehouse, store and SKU limit for each tier level
    }

    @Override
    public void activateRetailerAccount(Long retailerId) {
        retailer = (RetailerEntity) em.find(RetailerEntity.class, retailerId);
        retailer.setRetailerStatus(1);
    }

    @Override
    public void deactivateRetailerAccount(Long retailerId) {
        retailer = (RetailerEntity) em.find(RetailerEntity.class, retailerId);
        retailer.setRetailerStatus(0);
    }

    @Override
    public List<RetailerEntity> listAllRetailerAccounts() {
        Query query = em.createQuery("SELECT r FROM RetailerEntity r WHERE r.retailerName IS NOT NULL");
        return query.getResultList();
    }
}
