package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffId;
    private String staffName;
    private String staffUsername;
    private Long staffContact;
    private String staffEmail;
    private String staffAddress;
    private String jobTitle;
    private String staffPassword;
    private String staffStatus;
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<RoleEntity> role = new ArrayList <RoleEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private LocationEntity location;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public EmployeeEntity() {
    }

    public void create(String staffName, String staffUsername, Long staffContact, String staffEmail, String staffAddress, 
            String jobTitle, String staffPassword, Collection<RoleEntity> role, LocationEntity location, RetailerEntity retailer) {
        this.setStaffName(staffName);
        this.setStaffUsername(staffUsername);
        this.setStaffContact(staffContact);
        this.setStaffEmail(staffEmail);
        this.setStaffAddress(staffAddress);
        this.setJobTitle(jobTitle);
        this.setStaffPassword(staffPassword);
        this.setRole(role);
        this.setLocation(location);
        this.setRetailer(retailer);
    }
    
    

    public Long getStaffId() {
        return staffId;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public Long getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(Long staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String staffJobTitle) {
        this.jobTitle = staffJobTitle;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public Collection<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Collection<RoleEntity> role) {
        this.role = role;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEntity)) {
            return false;
        }
        EmployeeEntity other = (EmployeeEntity) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StaffEntity[ id=" + staffId + " ]";
    }
    

    
}
