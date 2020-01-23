/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.ItemEntity;
import Entity.ItemTypeEntity;
import Entity.LocationEntity;
import Entity.StockAlertEntity;
import Entity.StockThresholdEntity;
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
 * @author ashiq
 */
@Stateless
public class ManageStoreInventoryAlertsBean implements ManageStoreInventoryAlertsBeanLocal, ManageStoreInventoryAlertsBeanRemote {

    @PersistenceContext
    EntityManager em;
    
    StoreInventoryManagementSystemLocal siml;
    
    ItemEntity item;
    ItemTypeEntity itemType;
    StockAlertEntity stockAlert;
    LocationEntity location;
    StockThresholdEntity stockThreshold;
    
    
    int itemTypeQty;

    
    @Override
    public void checkForAlertActivation(Long itemId, Long storeId) {
        location = (LocationEntity)em.find(LocationEntity.class, storeId);
        item = (ItemEntity)em.find(ItemEntity.class, itemId);
        ///itemTypeQty = siml.findStoreItemTypeStockQuantity(storeId, item);
        itemType = em.find(ItemTypeEntity.class, item.getItemType().getItemTypeId());
        Collection<StockThresholdEntity> qtyList = itemType.getStockThreshold();
        List qtyTypeList = new ArrayList(qtyList);
        for (int j = 0; j < qtyTypeList.size(); j++) {
            stockThreshold = (StockThresholdEntity) qtyTypeList.get(j);
            if(stockThreshold.getLocation().getLocationId()==storeId) {
                if(itemTypeQty<stockThreshold.getStockThresholdQty()) {
                    activateStockAlert(itemType, storeId);
                }
            }
        }
    }
    

    public void activateStockAlert(ItemTypeEntity itemType, Long storeId) {
        StockAlertEntity alert = new StockAlertEntity();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        alert.setStockAlertDate(timestamp);
        alert.setItemQty(itemTypeQty);
        alert.setAlertStatus("ACTIVE");
        alert.setLocation(location);
        
    }

    @Override
    public void updateStockAlertStatus(Long stockAlertId) {
        StockAlertEntity alert = new StockAlertEntity();
        alert = (StockAlertEntity)em.find(StockAlertEntity.class, stockAlertId);
        alert.setAlertStatus("Resolved");
        
    }

    @Override
    public List<ArrayList> viewAllAlerts(Long storeId) {
        location = (LocationEntity)em.find(LocationEntity.class, storeId);
        Query q = em.createQuery("SELECT a FROM StockAlertEntity a");
        ArrayList alertList = new ArrayList();
        List<ArrayList> totalList = new ArrayList();
        for (Object o : q.getResultList()) {
            StockAlertEntity alert = (StockAlertEntity) o;
            
            if (alert.getLocation()==location) {
                alertList.add(0, alert.getStockAlertId());
                alertList.add(1, alert.getItemType().getItemTypeId());
                alertList.add(2, alert.getItemType().getItemName());
                alertList.add(3, alert.getStockAlertDate());
                alertList.add(4, alert.getItemQty());
                alertList.add(5, alert.getLocation().getLocationName());
                alertList.add(6, alert.getAlertStatus());
                totalList.add(alertList);
            }
        }
        
        return totalList;
    }

    @Override
    public List<ArrayList> viewActiveAlerts(Long storeId) {
        location = (LocationEntity)em.find(LocationEntity.class, storeId);
        Query q = em.createQuery("SELECT a FROM StockAlertEntity a");
        ArrayList alertList = new ArrayList();
        for (Object o : q.getResultList()) {
            StockAlertEntity alert = (StockAlertEntity) o;
            
            if (alert.getLocation()==location && alert.getAlertStatus().equals("ACTIVE")) {
                alertList.add(0, alert.getStockAlertId());
                alertList.add(1, alert.getItemType().getItemTypeId());
                alertList.add(2, alert.getItemType().getItemName());
                alertList.add(3, alert.getStockAlertDate());
                alertList.add(4, alert.getItemQty());
                alertList.add(5, alert.getLocation().getLocationName());
                alertList.add(6, alert.getAlertStatus());
            }
        }
        
        return alertList;
    }

    @Override
    public List<ArrayList> viewResolvedAlerts(Long storeId) {
        location = (LocationEntity)em.find(LocationEntity.class, storeId);
               Query q = em.createQuery("SELECT a FROM StockAlertEntity a");
        ArrayList alertList = new ArrayList();
        for (Object o : q.getResultList()) {
            StockAlertEntity alert = (StockAlertEntity) o;
            
            if (alert.getLocation()==location && alert.getAlertStatus().equals("RESOLVED")) {
                alertList.add(0, alert.getStockAlertId());
                alertList.add(1, alert.getItemType().getItemTypeId());
                alertList.add(2, alert.getItemType().getItemName());
                alertList.add(3, alert.getStockAlertDate());
                alertList.add(4, alert.getItemQty());
                alertList.add(5, alert.getLocation().getLocationName());
                alertList.add(6, alert.getAlertStatus());
            }
        }
        
        return alertList;
    }
    

    
}
