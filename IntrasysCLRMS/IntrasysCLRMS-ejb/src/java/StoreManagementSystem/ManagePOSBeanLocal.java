/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.jws.WebParam;

/**
 *
 * @author ashiq
 */
@Local
public interface ManagePOSBeanLocal {

    ArrayList getItem(Long itemId);

    double checkBulkDiscountAmount(Long itemId, int itemQty);

    double checkItemAItemBDiscount(Long itemId, ArrayList itemList);

    double overallMembershipDiscount(Long customerId);
    
    Long saveTransaction(ArrayList iTid, 
            ArrayList iQty, 
            ArrayList idiscAmt,
            ArrayList idiscP,
            ArrayList iTPrice,
            ArrayList transactionDetails);

    void setPaymentDetails(String paymentMethod, Long transactionID);

    
}
