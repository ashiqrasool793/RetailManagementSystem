/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.PromotionEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author Terence
 */
@Remote
public interface PromotionManagementBeanRemote {

    Long createPromotion(String promotionCode, String promotionRemarks, String promotionStartTimeInString, String promotionEndTimeInString, String promotionDiscountPercentInString, String promotionDiscountAmountInString, String promotionType, String minPurchaseNumberInString, String itemTypesIdInString, String retailerIdInString, String membershipTypeInString);

    ArrayList<PromotionEntity> viewPromotions(String promotionType, String promotionCode);

    void deletePromotion(String promotionCode);
}
