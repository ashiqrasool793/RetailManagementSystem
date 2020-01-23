/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.LayoutEntity;
import Entity.LocationEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author edwar
 */
@Named(value = "locationManagedBean")
@RequestScoped
public class LocationManagedBean {

    @EJB
    LocationManagementBeanLocal lmbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long locationId;
    private String locationName;
    private String locationAddress;
    private String locationContact;
    private String locationEmail;
    private String locationDesc;
    private String locationType;
    private String locationStatus;
    private String locationParent;
    private String locationChild;
    private LayoutEntity layout;
    private RetailerEntity retailerId;

    private List<LocationEntity> locationList;
    private LocationEntity newLocation;
    private LocationEntity selectedLocation;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of LocationManagedBean
     */
    public LocationManagedBean() {
    }

    @PostConstruct
    public void init() {
        locationList = lmbl.listLocations();
    }
    
    public void createLocation(){
        try{
            System.out.println("Creating");
            newLocation = lmbl.createLocation(locationName, locationAddress, locationContact, 
                    locationEmail, locationDesc, locationType, locationStatus, locationParent, 
                    locationChild, null, null);
            locationList.add(newLocation);
            serverMessage = "New Location Added";
            clear();
            
        }catch (Exception ex){
            
        }
    }
    
    public void updateLocation(){
        boolean updateAttempt;
        updateAttempt = lmbl.updateLocation(selectedLocation, locationName, 
                locationAddress, locationContact, locationEmail, locationDesc, locationType, 
                locationStatus, locationParent, locationChild, null);
        try{
            if(updateAttempt == true){
                serverMessage = "Location updated successfully";
            }
            else {
                serverMessage = "Location failed to update";
            }
        }catch(Exception ex){
            serverMessage = "Location failed to update";
        }
    }
    
    public void clear(){
        locationId = null;
        selectedLocation = null;
        locationName = null;
        locationAddress = null;
        locationContact = null;
        locationEmail = null;
        locationDesc = null;
        locationType = null;
        locationStatus = null;
        locationParent = null;
        locationChild = null;
        layout = null;
        retailerId = null;
    }

    public LocationManagementBeanLocal getLmbl() {
        return lmbl;
    }

    public void setLmbl(LocationManagementBeanLocal lmbl) {
        this.lmbl = lmbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationContact() {
        return locationContact;
    }

    public void setLocationContact(String locationContact) {
        this.locationContact = locationContact;
    }

    public String getLocationEmail() {
        return locationEmail;
    }

    public void setLocationEmail(String locationEmail) {
        this.locationEmail = locationEmail;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public String getLocationParent() {
        return locationParent;
    }

    public void setLocationParent(String locationParent) {
        this.locationParent = locationParent;
    }

    public String getLocationChild() {
        return locationChild;
    }

    public void setLocationChild(String locationChild) {
        this.locationChild = locationChild;
    }

    public LayoutEntity getLayout() {
        return layout;
    }

    public void setLayout(LayoutEntity layoutId) {
        this.layout = layoutId;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<LocationEntity> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<LocationEntity> locationList) {
        this.locationList = locationList;
    }

    public LocationEntity getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(LocationEntity newLocation) {
        this.newLocation = newLocation;
    }

    public LocationEntity getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(LocationEntity selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

    
}
