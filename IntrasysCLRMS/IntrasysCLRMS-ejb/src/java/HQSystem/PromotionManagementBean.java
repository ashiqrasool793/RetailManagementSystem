/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.ItemTypeEntity;
import Entity.MembershipEntity;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entity.PromotionEntity;
import Entity.RetailerEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Terence
 */
@Stateless
public class PromotionManagementBean implements PromotionManagementBeanRemote, PromotionManagementBeanLocal {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private PromotionEntity promotion;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Long createPromotion(String promotionCode, String promotionRemarks, String promotionStartTimeInString, String promotionEndTimeInString, String promotionDiscountPercentInString, String promotionDiscountAmountInString, String promotionType, String minPurchaseNumberInString, String itemTypesIdInString, String retailerIdInString, String membershipTypeInString) {
        promotion = new PromotionEntity();
        promotion.setPromotionCode(Long.valueOf(promotionCode));
        promotion.setPromotionRemarks(promotionRemarks);
        promotion.setPromotionStartTime(Timestamp.valueOf(promotionStartTimeInString));
        promotion.setPromotionEndTime(Timestamp.valueOf(promotionEndTimeInString));
        promotion.setPromotionDiscountPercent(Double.valueOf(promotionDiscountPercentInString));
        promotion.setPromotionDiscountAmount(Double.valueOf(promotionDiscountAmountInString));
        promotion.setPromotionType(promotionType);
        promotion.setMinPurchaseNumber(Integer.parseInt(minPurchaseNumberInString));
        String[] itemTypesIdInStringArray = itemTypesIdInString.split("+");
        Collection<ItemTypeEntity> itemTypes = new ArrayList<ItemTypeEntity>();
        int index = 0;
        while (itemTypesIdInStringArray[index] != null && !itemTypesIdInStringArray[index].trim().isEmpty()) {
            itemTypes.add(getItemType(Long.valueOf(itemTypesIdInStringArray[index])));
            index++;
        }
        promotion.setItemTypes(itemTypes);
        promotion.setRetailer(getRetailer(Long.valueOf(retailerIdInString)));
        index = 0;
        String[] membershipTypesInStringArray = membershipTypeInString.split("+");
        Collection<MembershipEntity> membershipTypes = new ArrayList<MembershipEntity>();
        while (membershipTypesInStringArray[index] != null && !membershipTypesInStringArray[index].trim().isEmpty()) {
            membershipTypes.add(getMembershipType(membershipTypesInStringArray[index]));
            index++;
        }
        promotion.setMembershipTypes(membershipTypes);
        em.persist(promotion);
        em.flush();
        return promotion.getPromotionId();
    }

    @Override
    public ArrayList<PromotionEntity> viewPromotions(String promotionType, String promotionCode) {
        ArrayList<PromotionEntity> promotions = new ArrayList<PromotionEntity>();
        if (promotionCode != null && !promotionCode.trim().isEmpty()) {
            Query query = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionCode = :promotionCode");
            query.setParameter("promotionCode", promotionCode);
            promotions = (ArrayList<PromotionEntity>) query.getResultList();
        } else if (promotionType != null && !promotionType.trim().isEmpty()) {
            Query query = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionType = :promotionType");
            query.setParameter("promotionType", promotionType);
            promotions = (ArrayList<PromotionEntity>) query.getResultList();
        } else {
            Query query = em.createQuery("SELECT DISTINCT p FROM PromotionEntity p");
            promotions = (ArrayList<PromotionEntity>) query.getResultList();
        }
        return promotions;
    }

    @Override
    public void deletePromotion(String promotionCode) {
        Query query = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionCode = :promotionCode");
        query.setParameter("promotionCode", promotionCode);
        em.remove(query.getSingleResult());
    }

    private ItemTypeEntity getItemType(Long itemTypeId) {

        ItemTypeEntity itemType = new ItemTypeEntity();
        try {
            if (itemTypeId != null) {
                itemType = em.find(ItemTypeEntity.class, itemTypeId);
            }
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return itemType;
    }

    private RetailerEntity getRetailer(Long retailerId) {
        RetailerEntity retailer = new RetailerEntity();
        try {
            if (retailerId != null) {
                retailer = em.find(RetailerEntity.class, retailerId);
            }
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return retailer;
    }

    private MembershipEntity getMembershipType(String membershipType) {
        MembershipEntity membership = new MembershipEntity();
        try {
            if (membershipType != null && !membershipType.trim().isEmpty()) {
                Query query = em.createQuery("SELECT m FROM MembershipEntity m WHERE m.membershipType = :membership");
                query.setParameter("membership", membershipType);
                membership = (MembershipEntity) query.getSingleResult();
            }
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }
        return membership;
    }

}
