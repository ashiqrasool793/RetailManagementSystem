/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.LayoutEntity;
import Entity.LocationEntity;
import Entity.RetailerEntity;
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
public class LocationManagementBean implements LocationManagementBeanLocal, LocationManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private LocationEntity location;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public LocationEntity createLocation(String locationName, String locationAddress, String locationContact, String locationEmail, String locationDesc,
            String locationType, String locationStatus, String locationParent, String locationChild, 
            LayoutEntity layout, RetailerEntity retailerId) {
        location = new LocationEntity();
        location.setLocationName(locationName);
        location.setLocationAddress(locationAddress);
        location.setLocationContact(locationContact);
        location.setLocationEmail(locationEmail);
        location.setLocationDesc(locationDesc);
        location.setLocationType(locationType);
        location.setLocationStatus(locationStatus);
        location.setLocationParent(locationParent);
        location.setLocationChild(locationChild);
        location.setLayout(layout);
        location.setRetailer(retailerId);

        em.persist(location);
        em.flush();
        return location;
    }

    @Override
    public boolean updateLocation(LocationEntity selectedLocation, String locationName, String locationAddress, String locationContact,
            String locationEmail, String locationDesc, String locationType, String locationStatus,
            String locationParent, String locationChild, LayoutEntity layout) {
        try {
            location = selectedLocation;
            location.setLocationName(locationName);
            location.setLocationAddress(locationAddress);
            location.setLocationContact(locationContact);
            location.setLocationEmail(locationEmail);
            location.setLocationDesc(locationDesc);
            location.setLocationType(locationType);
            location.setLocationStatus(locationStatus);
            location.setLocationParent(locationParent);
            location.setLocationChild(locationChild);
            location.setLayout(layout);
            em.merge(location);
            em.flush();
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<LocationEntity> listLocations() {
        Query query = em.createQuery("SELECT l from LocationEntity l");
        return query.getResultList();
    }
    
    

}
