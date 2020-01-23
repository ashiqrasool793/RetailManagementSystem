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
import javax.ejb.Local;

/**
 *
 * @author edwar
 */
@Local
public interface LocationManagementBeanLocal {

    LocationEntity createLocation(String locationName, String locationAddress, String locationContact, String locationEmail, String locationDesc, String locationType, String locationStatus, String locationParent, String locationChild, LayoutEntity layoutId, RetailerEntity retailerId);

    boolean updateLocation(LocationEntity selectedLocation, String locationName, String locationAddress, String locationContact, String locationEmail, String locationDesc, String locationType, String locationStatus, String locationParent, String locationChild, LayoutEntity layout);

    List<LocationEntity> listLocations();
    
}
