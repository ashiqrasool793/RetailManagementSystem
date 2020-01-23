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

/**
 *
 * @author edwar
 */
@Entity
public class MembershipEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long membershipId;
    private String membershipType;
    private double membershipFee;
    private String membershipRemarks;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public MembershipEntity() {
    }

    public MembershipEntity(String membershipType, double membershipFee, String membershipRemarks, RetailerEntity retailer) {
        this.setMembershipType(membershipType);
        this.setMembershipFee(membershipFee);
        this.setMembershipRemarks(membershipRemarks);
        this.setRetailer(retailer);
    }
    
    
    
    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public String getMembershipRemarks() {
        return membershipRemarks;
    }

    public void setMembershipRemarks(String membershipRemarks) {
        this.membershipRemarks = membershipRemarks;
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
        hash += (membershipId != null ? membershipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MembershipEntity)) {
            return false;
        }
        MembershipEntity other = (MembershipEntity) object;
        if ((this.membershipId == null && other.membershipId != null) || (this.membershipId != null && !this.membershipId.equals(other.membershipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.MembershipEntity[ id=" + membershipId + " ]";
    }
    
}
