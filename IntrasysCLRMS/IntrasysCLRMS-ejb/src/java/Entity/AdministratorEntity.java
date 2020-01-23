package Entity;

import java.io.Serializable;
import static StaticClasses.Encryption.getSalt;
import static StaticClasses.Encryption.SHA256;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdministratorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String adminUsername;
    private String adminSalt;
    private String adminPassword;
    private Long adminContact;

    public AdministratorEntity() {
    }

    public void create(String adminUsername, String adminSalt, String adminPassword, Long adminContact) throws NoSuchAlgorithmException {
        this.setAdminUsername(adminUsername);
        this.setAdminSalt(adminSalt);
        this.setAdminPassword(adminPassword);
        this.setAdminContact(adminContact);
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }
    
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) throws NoSuchAlgorithmException {
        adminSalt = getSalt();
        String hashedPassword = SHA256(adminPassword, adminSalt);
        this.adminPassword = hashedPassword;
    }

    public Long getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(Long adminContact) {
        this.adminContact = adminContact;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministratorEntity)) {
            return false;
        }
        AdministratorEntity other = (AdministratorEntity) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AdministratorEntity[ id=" + adminId + " ]";
    }
}
