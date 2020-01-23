/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nick
 */
@Entity

public class PromotionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long promotionId; //refers to the Id of the promotion
    private Long promotionCode; //refers to the code that is used to identify the promotion
    private String promotionRemarks;
    private Timestamp promotionStartTime; //start time of promotional campaign
    private Timestamp promotionEndTime; //end time of promotional campaign
    private double promotionDiscountPercent;
    private double promotionDiscountAmount;
    private String promotionType; //Bulk, BuyAGetBAtDiscount, BuyAGetBForFree, StandardMembershipDiscount, AdditionalMembershipPromotions
    private int minPurchaseNumber; //Used for bulk purchases
    @ManyToMany(cascade = {CascadeType.ALL})
    private Collection<ItemTypeEntity> itemTypes = new ArrayList<ItemTypeEntity>(); //Item(s) involved in promotion
    @ManyToOne(cascade = {CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();
    @ManyToMany(cascade = {CascadeType.ALL})
    private Collection<MembershipEntity> membershipTypes = new ArrayList<MembershipEntity>();

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(Long promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionRemarks() {
        return promotionRemarks;
    }

    public void setPromotionRemarks(String promotionRemarks) {
        this.promotionRemarks = promotionRemarks;
    }

    public Timestamp getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Timestamp promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Timestamp getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Timestamp promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public double getPromotionDiscountPercent() {
        return promotionDiscountPercent;
    }

    public void setPromotionDiscountPercent(double promotionDiscountPercent) {
        this.promotionDiscountPercent = promotionDiscountPercent;
    }

    public double getPromotionDiscountAmount() {
        return promotionDiscountAmount;
    }

    public void setPromotionDiscountAmount(double promotionDiscountAmount) {
        this.promotionDiscountAmount = promotionDiscountAmount;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public int getMinPurchaseNumber() {
        return minPurchaseNumber;
    }

    public void setMinPurchaseNumber(int minPurchaseNumber) {
        this.minPurchaseNumber = minPurchaseNumber;
    }

    public Collection<ItemTypeEntity> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(Collection<ItemTypeEntity> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public Collection<MembershipEntity> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(Collection<MembershipEntity> membershipTypes) {
        this.membershipTypes = membershipTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionId != null ? promotionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PromotionEntity)) {
            return false;
        }
        PromotionEntity other = (PromotionEntity) object;
        if ((this.promotionId == null && other.promotionId != null) || (this.promotionId != null && !this.promotionId.equals(other.promotionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PromotionEntity[ id=" + promotionId + " ]";
    }
}
