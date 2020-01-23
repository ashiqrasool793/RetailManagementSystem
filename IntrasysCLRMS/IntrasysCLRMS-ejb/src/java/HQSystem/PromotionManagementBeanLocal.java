/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.PromotionEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Terence
 */
@Local
public interface PromotionManagementBeanLocal {

    Long createPromotion(String promotionCode, String promotionRemarks, String promotionStartTimeInString, String promotionEndTimeInString, String promotionDiscountPercentInString, String promotionDiscountAmountInString, String promotionType, String minPurchaseNumberInString, String itemTypesIdInString, String retailerIdInString, String membershipTypeInString);

    ArrayList<PromotionEntity> viewPromotions(String promotionType, String promotionCode);

    void deletePromotion(String promotionCode);
}
