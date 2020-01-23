/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.ItemTypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ashiq
 */
@Remote
public interface ManageStoreInventoryAlertsBeanRemote {

    void checkForAlertActivation(Long itemId, Long storeId);
    
    void updateStockAlertStatus(Long stockAlertId);

    List<ArrayList> viewAllAlerts(Long storeId);

    List<ArrayList> viewActiveAlerts(Long storeId);

    List<ArrayList> viewResolvedAlerts(Long storeId);
    
}
