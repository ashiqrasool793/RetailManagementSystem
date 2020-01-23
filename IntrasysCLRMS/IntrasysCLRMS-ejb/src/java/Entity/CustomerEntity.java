package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Nick
 */
@Entity
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private String customerContact;
    private String customerEmail;
    private String customerAddress;
    private String customerUsername;
    private String customerPassword;
    private Timestamp birthDate;
    private Timestamp expiryDate;
    private int rewardPoints;
    @OneToMany(cascade={CascadeType.ALL}, mappedBy="customer")
    private Collection<ShippingAddressEntity> shippingAddress = new ArrayList<ShippingAddressEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private  MembershipEntity membership = new MembershipEntity();   
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public CustomerEntity() {
    }

    public CustomerEntity(String customerName, String customerContact, String customerEmail, String customerAddress, String customerUsername, 
            String customerPassword, Timestamp birthDate, Timestamp expiryDate, int rewardPoints, Collection<ShippingAddressEntity> shippingAddress, MembershipEntity membership, RetailerEntity retailer) {
        this.setCustomerName(customerName);
        this.setCustomerContact(customerContact);
        this.setCustomerEmail(customerEmail);
        this.setCustomerAddress(customerAddress);
        this.setCustomerUsername(customerUsername);
        this.setCustomerPassword(customerPassword);
        this.setBirthDate(birthDate);
        this.setExpiryDate(expiryDate);
        this.setRewardPoints(rewardPoints);
        this.setShippingAddress(shippingAddress);
        this.setMembership(membership);
        this.setRetailer(retailer);
    }
    
    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }
    
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public MembershipEntity getMembership() {
        return membership;
    }

    public void setMembership(MembershipEntity membership) {
        this.membership = membership;
    }

    public Collection<ShippingAddressEntity> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Collection<ShippingAddressEntity> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CustomerEntity[ id=" + customerId + " ]";
    }
    
}
