/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.RetailerEntity;
import Entity.SupplierEntity;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwar
 */
@Stateless
public class SupplierManagementBean implements SupplierManagementBeanLocal, SupplierManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private SupplierEntity supplier;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public SupplierEntity createSupplier(String supplierName, String supplierUsername, String supplierPassword, String supplierEmail, String supplierContact, RetailerEntity retailerID) {
        supplier = new SupplierEntity();
        supplier.setSupplierName(supplierName);
        supplier.setSupplierUsername(supplierUsername);
        supplier.setSupplierPassword(supplierPassword);
        supplier.setSupplierEmail(supplierEmail);
        supplier.setSupplierContact(supplierContact);
        supplier.setRetailer(retailerID);
        em.persist(supplier);
        em.flush();

        return supplier;
    }

    @Override
    public boolean updateSupplier(SupplierEntity selectedSupplier, String supplierName, String supplierUsername, String supplierEmail, String supplierContact) {
        try {
            supplier = selectedSupplier;
            supplier.setSupplierName(supplierName);
            supplier.setSupplierUsername(supplierUsername);
            supplier.setSupplierEmail(supplierEmail);
            supplier.setSupplierContact(supplierContact);
            em.merge(supplier);
            em.flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<SupplierEntity> listSupplier() {
        Query query = em.createQuery("SELECT s FROM SupplierEntity s");
        return query.getResultList();
    }

}
