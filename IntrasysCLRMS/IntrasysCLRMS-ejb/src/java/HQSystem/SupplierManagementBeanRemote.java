/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.RetailerEntity;
import Entity.SupplierEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author edwar
 */
@Remote
public interface SupplierManagementBeanRemote {

    SupplierEntity createSupplier(String supplierName, String supplierUsername, String supplierPassword, String supplierEmail, String supplierContact, RetailerEntity retailerID);

    List<SupplierEntity> listSupplier();

    boolean updateSupplier(SupplierEntity selectedSupplier, String supplierName, String supplierUsername, String supplierEmail, String supplierContact);
    
}
