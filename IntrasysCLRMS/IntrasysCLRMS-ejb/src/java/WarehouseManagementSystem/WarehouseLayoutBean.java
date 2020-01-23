/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.LocationEntity;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author keane
 */
@Stateless
public class WarehouseLayoutBean implements WarehouseLayoutBeanLocal, WarehouseLayoutBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private LocationEntity shelf;
    private ArrayList<LocationEntity> shelves;
    
    //Function D.2.1.1 - Create Shelf
    @Override
    public Long createShelf(Long locationId, String locationName, String locationAddress, String locationContact, String locationEmail, String locationDesc, String locationType, String locationStatus, String locationParent, String locationChild) {
        shelf = new LocationEntity();
        shelf.setLocationName(locationName);
        shelf.setLocationAddress(locationAddress);
        shelf.setLocationContact(locationContact);
        shelf.setLocationEmail(locationEmail);
        shelf.setLocationDesc(locationDesc);
        shelf.setLocationType(locationType);
        shelf.setLocationStatus(locationStatus);
        shelf.setLocationParent(locationParent);
        shelf.setLocationChild(locationChild);
        
        em.persist(shelf);
        em.flush();
        return shelf.getLocationId();
    }

    
    //Function D.2.1.2 - List Shelves
    public ArrayList<LocationEntity> listShelves(Long warehouseId) {
        Query q = em.createQuery("SELECT s FROM LocationEntity s WHERE s.locationId = warehouseId AND s.locationChild = child");
        q.setParameter("warehouseId", warehouseId);
        q.setParameter("child", "Shelf");
        
        shelves = (ArrayList<LocationEntity>) q.getResultList();
        
        return shelves;
    }
    
    //Function D.2.1.3 - View Shelf
    
    
}
