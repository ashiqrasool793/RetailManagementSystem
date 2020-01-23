/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author ashiq
 */
@Entity
public class LocationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
//    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "location")
//    private Set<LocationEntity> location = new HashSet<LocationEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private LayoutEntity layout;   
    @ManyToOne(cascade = {CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();
    
    public LocationEntity(){
        
    }
    
    public void create(String locationName, String locationAddress, String locationContact, 
            String locationEmail, String locationDesc, String locationType, String locationStatus, 
            String locationParent, String locationChild, LayoutEntity layout, RetailerEntity retailer){
        
        this.setLocationName(locationName);
        this.setLocationAddress(locationAddress);
        this.setLocationContact(locationContact);
        this.setLocationEmail(locationEmail);
        this.setLocationDesc(locationDesc);
        this.setLocationType(locationType);
        this.setLocationStatus(locationStatus);
        this.setLocationParent(locationParent);
        this.setLocationChild(locationChild);
        this.setLayout(layout);
        this.setRetailer(retailer);
    }

    public Long getLocationId() {
        return locationId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationContact() {
        return locationContact;
    }

    public String getLocationEmail() {
        return locationEmail;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public String getLocationParent() {
        return locationParent;
    }

    public String getLocationChild() {
        return locationChild;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setLocationContact(String locationContact) {
        this.locationContact = locationContact;
    }

    public void setLocationEmail(String locationEmail) {
        this.locationEmail = locationEmail;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public void setLocationParent(String locationParent) {
        this.locationParent = locationParent;
    }

    public void setLocationChild(String locationChild) {
        this.locationChild = locationChild;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

//    public Set<LocationEntity> getLocation() {
//        return location;
//    }
//
//    public void setLocation(Set<LocationEntity> location) {
//        this.location = location;
//    }
//    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    public LayoutEntity getLayout() {
        return layout;
    }

    public void setLayout(LayoutEntity layout) {
        this.layout = layout;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationEntity)) {
            return false;
        }
        LocationEntity other = (LocationEntity) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.LocationEntity[ id=" + locationId + " ]";
    }

}
