/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrativeManagementSystem;

import Entity.RetailerEntity;
import javax.ejb.Remote;
import java.util.List;

/**
 *
 * @author Kenneth
 */
@Remote
public interface RetailerManagementBeanRemote {
    
    public RetailerEntity createRetailerAccount(String retailerName, String retailerAddress, Long retailerContact,
            String retailerEmail, String retailerDescription, int retailerTier, int warehouseLimit, int storeLimit);
    
    public boolean updateRetailerAccount(RetailerEntity retailer, String retailerName, String retailerAddress, Long retailerContact, 
            String retailerEmail, String retailerDescription, int retailerTier, int warehouseLimit, int storeLimit);
    
    public void setTier(Long rId, int rTier);
    
    public boolean deleteRetailerAccount(RetailerEntity selectedRetailer);
    
    public void activateRetailerAccount(Long rId);
    
    public void deactivateRetailerAccount(Long rId);
    
    public List<RetailerEntity> listAllRetailerAccounts();
}
