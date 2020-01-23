/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.LocationEntity;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author keane
 */
@Remote
public interface WarehouseLayoutBeanRemote {

    Long createShelf(Long locationId, String locationName, String locationAddress, String locationContact, String locationEmail, String locationDesc, String locationType, String locationStatus, String locationParent, String locationChild);

    ArrayList<LocationEntity> listShelves(Long warehouseId);
    
}
