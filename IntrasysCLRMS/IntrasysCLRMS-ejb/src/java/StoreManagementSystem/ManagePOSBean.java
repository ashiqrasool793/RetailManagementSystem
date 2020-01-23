/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.CustomerEntity;
import Entity.ItemEntity;
import Entity.ItemTypeEntity;
import Entity.LocationEntity;
import Entity.MembershipEntity;
import Entity.PromotionEntity;
import Entity.RetailerEntity;
import Entity.TransactionEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ashiq
 */
@Stateless
@WebService
public class ManagePOSBean implements ManagePOSBeanLocal, ManagePOSBeanRemote {

    @PersistenceContext
    EntityManager em;

    ItemTypeEntity itemType;
    ItemEntity item;
    PromotionEntity promo;
    CustomerEntity customer;
    ArrayList<Long> bulkDiscAdded = new ArrayList<Long>();

    @Override
    @WebMethod(operationName = "getItemDetails")
    public ArrayList getItem(@WebParam(name = "itemId") Long itemId) {
        ArrayList itemDetails = new ArrayList();
        item = em.find(ItemEntity.class, itemId);
        itemDetails.add(item.getItemId());
        itemDetails.add(item.getItemType().getItemName());
        itemDetails.add(item.getItemType().getItemSalePrice());
        for (int i = 0; i < itemDetails.size() - 1; i++) {
            System.out.println(itemDetails.get(i));
        }
        return itemDetails;
    }

    @Override
    @WebMethod(operationName = "checkBulkDiscountAmount")
    public double checkBulkDiscountAmount(@WebParam(name = "itemId") Long itemId, @WebParam(name = "itemQty") int itemQty) {
        System.out.println("method started");

        double discountAmt = 0;
        Query q = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionType=:Bulk");
        q.setParameter("Bulk", "Bulk");
        List promotionList = q.getResultList();
        for (int i = 0; i < promotionList.size(); i++) {
            System.out.println("Loop started");
            promo = (PromotionEntity) promotionList.get(i);
            Collection<ItemTypeEntity> itemTypes = promo.getItemTypes();
            List itemTypeList = new ArrayList(itemTypes);
            System.out.println("ItemTypeList generated");
            for (int j = 0; j < itemTypeList.size(); j++) {
                item = em.find(ItemEntity.class, itemId);
                if (itemTypeList.get(j) == item.getItemType()) {
                    System.out.println("itemMatched");
                    if (itemQty >= promo.getMinPurchaseNumber()) {
                        System.out.println(promo.getMinPurchaseNumber());
                        discountAmt = promo.getPromotionDiscountPercent();
                    } else {
                        discountAmt = 0.0;
                    }
                }
            }
        }
        System.out.println(discountAmt);
        return discountAmt;
    }

    @Override
    @WebMethod(operationName = "checkItemAItemBDiscount")
    public double checkItemAItemBDiscount(Long itemId, ArrayList itemList) {
        ArrayList cart = itemList;
        double discountPercent = 0;
        Query q = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionType=:BuyAGetBAtDiscount");
        q.setParameter("BuyAGetBAtDiscount", "BuyAGetBAtDiscount");
        List promotionList = q.getResultList();
           for (int i = 0; i < promotionList.size(); i++) {
            System.out.println("Loop started");
            promo = (PromotionEntity) promotionList.get(i);
            Collection<ItemTypeEntity> itemTypes = promo.getItemTypes();
            List itemTypeList = new ArrayList(itemTypes);
            System.out.println("ItemTypeList generated");
            for (int j = 0; j < itemTypeList.size(); j++) {
                item = em.find(ItemEntity.class, itemId);
                if (itemTypeList.get(j) == item.getItemType()){
                    if(cartHasPromoItem(itemTypeList, cart, item)) {
                        discountPercent = promo.getPromotionDiscountPercent();
                        }
                    }
                }      
            }
        
        return discountPercent;
    }
    
    public boolean cartHasPromoItem(List itemTypeList, ArrayList cart, ItemEntity item) {
        
            for(int j=0; j<cart.size(); j++) {
                for(int i=0; i<itemTypeList.size();i++){
                    ItemEntity itemPromo = new ItemEntity();
                    itemPromo = em.find(ItemEntity.class, cart.get(j));
                    if(itemPromo.getItemType() == itemTypeList.get(i) && itemPromo.getItemType()!=item.getItemType())
                        return true;
            }
        }
        
        return false;
    }

    @Override
    @WebMethod(operationName = "overallMembershipDiscount")
    public double overallMembershipDiscount(@WebParam(name = "customerId")Long customerId) {
        
        double discountPercent = 0;
        
        Query q = em.createQuery("SELECT p FROM PromotionEntity p WHERE p.promotionType=:StandardMembershipDiscount");
        q.setParameter("StandardMembershipDiscount", "StandardMembershipDiscount");
        List promotionList = q.getResultList();
        for (int i = 0; i < promotionList.size(); i++) {
            System.out.println("Loop started");
            promo = (PromotionEntity) promotionList.get(i);
            Collection<MembershipEntity> memberTypes = promo.getMembershipTypes();
            List memberTypesList= new ArrayList(memberTypes);
            System.out.println("MemberTypeList generated");
            System.out.println(memberTypesList.get(0));
             for (int j = 0; j < memberTypesList.size(); j++) {
                customer = em.find(CustomerEntity.class, customerId);
                if (memberTypesList.get(j) == customer.getMembership()) {
                    System.out.println("membershipMatched");
                        discountPercent = promo.getPromotionDiscountPercent();
                }
            }
        }
        return discountPercent;
    }

    @WebMethod(operationName = "saveTransaction")
    @Override
    public Long saveTransaction(@WebParam(name = "iTid")ArrayList iTid, 
            @WebParam(name = "iQty")ArrayList iQty, 
            @WebParam(name = "idiscAmt")ArrayList idiscAmt,
            @WebParam(name = "idiscP")ArrayList idiscP,
            @WebParam(name = "iTPrice")ArrayList iTPrice,
            @WebParam(name = "transactionDetails")ArrayList transactionDetails) {
        System.out.println("test1");
        TransactionEntity tx = new TransactionEntity();
        Collection<ItemEntity> items = new ArrayList<ItemEntity>();
        for(int i=0; i<iTid.size(); i++) {
            items.add(em.find(ItemEntity.class, (Long)iTid.get(i)));
        }
        
        tx.setItems(items);
        tx.setItemQty(iQty);
        tx.setDiscountAmt(idiscAmt);
        tx.setDiscountPercent(iTPrice);
        tx.setPrice(iTPrice);
        System.out.println("test2");
        tx.setSubtotal((Double)transactionDetails.get(0));
        System.out.println("test3");
        tx.setTotalDiscountAmount((Double)transactionDetails.get(1));
        System.out.println("test4");
        tx.setTotalDiscountPercentage((Double)transactionDetails.get(2));
        System.out.println("test5");
        tx.setTaxesPayable((Double)transactionDetails.get(3));
        System.out.println("test6");
        tx.setTotalAmount((Double)transactionDetails.get(4));
        System.out.println("test7");
        if((Long)transactionDetails.get(5) != -1L) {
            CustomerEntity c = new CustomerEntity();
            c = em.find(CustomerEntity.class, (Long)transactionDetails.get(5));
            tx.setCustomer(c);
        }
        System.out.println("test8");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        tx.setInvoiceDate(timestamp);
        System.out.println("test9");
        /*RetailerEntity r = new RetailerEntity();
        r = em.find(RetailerEntity.class, (new Long (1)));
        tx.setRetailer(r);
        System.out.println("test10");
        LocationEntity l = new LocationEntity();
        l = em.find(LocationEntity.class, 1);
        tx.setLocation(l);
        */
        em.persist(tx);
        
        Long txId = tx.getTransactionId();
       //subtotal, totalDiscountAmt, totalDiscountPercentage, tax, grandtotal, customerId, timestamp
        return txId;
    }
    

    @WebMethod(operationName = "setPaymentDetails")
    @Override
    public void setPaymentDetails(@WebParam(name = "paymentMethod")String paymentMethod, @WebParam(name = "transactionID")Long transactionID) {
    
    TransactionEntity tx = new TransactionEntity();
    tx = em.find(TransactionEntity.class, transactionID);
    tx.setPaymentMode(paymentMethod);
    
    }
    
    
    
    

}
