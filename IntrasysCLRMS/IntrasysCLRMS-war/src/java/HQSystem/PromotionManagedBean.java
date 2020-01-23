/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import CommonInfrastructure.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import CommonInfrastructure.LoginManagementBeanLocal;
import Entity.PromotionEntity;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Terence
 */
@Named(value = "promotionManagedBean")
@RequestScoped
public class PromotionManagedBean {

    @EJB
    PromotionManagementBeanLocal promotionManagementBeanLocal;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationHQBean navigationHQBean = new NavigationHQBean();

    HttpSession session;
    String promotionCode;
    String promotionRemarks;
    String promotionStartTime;
    String promotionEndTime;
    String promotionDiscountPercent;
    String promotionDiscountAmount;
    String promotionType;
    String minPurchaseNumber;
    String itemTypesId;
    String retailerId;
    String membershipTypes;

    public String createPromotion() {
        session.setAttribute("promotionCode", promotionCode);
        session.setAttribute("promotionRemarks", promotionRemarks);
        session.setAttribute("promotionStartTime", promotionStartTime);
        session.setAttribute("promotionEndTime", promotionEndTime);
        session.setAttribute("promotionDiscountPercent", promotionDiscountPercent);
        session.setAttribute("promotionDiscountAmount", promotionDiscountAmount);
        session.setAttribute("minPurchaseNumber", minPurchaseNumber);
        session.setAttribute("itemTypesId", itemTypesId);
        session.setAttribute("retailerId", retailerId);
        session.setAttribute("membershipTypes", membershipTypes);
        promotionManagementBeanLocal.createPromotion(promotionCode, promotionRemarks, promotionStartTime, promotionEndTime, promotionDiscountPercent, promotionDiscountAmount, promotionType, minPurchaseNumber, itemTypesId, retailerId, membershipTypes);
        return navigationHQBean.redirectToHQViewPromotions();
    }

    public ArrayList<PromotionEntity> viewPromotions() {
        session.setAttribute("promotionCode", promotionCode);
        session.setAttribute("promotionType", promotionType);
        return promotionManagementBeanLocal.viewPromotions(promotionType, promotionCode);
    }
    
    public String deletePromotion() {
        session.setAttribute("promotionCode", promotionCode);
        promotionManagementBeanLocal.deletePromotion(promotionCode);
        return navigationHQBean.redirectToHQDeletePromotion();
    }
    
    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionRemarks() {
        return promotionRemarks;
    }

    public void setPromotionRemarks(String promotionRemarks) {
        this.promotionRemarks = promotionRemarks;
    }

    public String getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(String promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public String getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(String promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public String getPromotionDiscountPercent() {
        return promotionDiscountPercent;
    }

    public void setPromotionDiscountPercent(String promotionDiscountPercent) {
        this.promotionDiscountPercent = promotionDiscountPercent;
    }

    public String getPromotionDiscountAmount() {
        return promotionDiscountAmount;
    }

    public void setPromotionDiscountAmount(String promotionDiscountAmount) {
        this.promotionDiscountAmount = promotionDiscountAmount;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getMinPurchaseNumber() {
        return minPurchaseNumber;
    }

    public void setMinPurchaseNumber(String minPurchaseNumber) {
        this.minPurchaseNumber = minPurchaseNumber;
    }

    public String getItemTypesId() {
        return itemTypesId;
    }

    public void setItemTypesId(String itemTypesId) {
        this.itemTypesId = itemTypesId;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(String membershipTypes) {
        this.membershipTypes = membershipTypes;
    }

    public PromotionManagedBean() {
    }

}
