/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author edwar
 */
@Entity
public class AnnouncementEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementId;
    private String message;
    private String status;
    private Timestamp startdate;
    private Timestamp endDate;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public AnnouncementEntity() {
    }

    public AnnouncementEntity(String message, String status, Timestamp startdate, Timestamp endDate, RetailerEntity retailer) {
        this.setMessage(message);
        this.setStatus(status);
        this.setStartdate(startdate);
        this.setEndDate(endDate);
        this.setRetailer(retailer);
    }

    public Long getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (announcementId != null ? announcementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnouncementEntity)) {
            return false;
        }
        AnnouncementEntity other = (AnnouncementEntity) object;
        if ((this.announcementId == null && other.announcementId != null) || (this.announcementId != null && !this.announcementId.equals(other.announcementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AnnouncementEntity[ id=" + announcementId + " ]";
    }
    
}
