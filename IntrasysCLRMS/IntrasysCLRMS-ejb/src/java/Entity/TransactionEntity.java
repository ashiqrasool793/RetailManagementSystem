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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author edwar
 */
@Entity
public class TransactionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private double totalAmount;
    private String paymentMode;
    private Long creditCardTxnNum;
    private Timestamp invoiceDate;
    private double taxesPayable;
    private double totalDiscountAmount;
    private double totalDiscountPercentage;
    private double subtotal;
    private List itemQty;
    private List price;
    private List discountAmt;
    private List discountPercent;
    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<ItemEntity> items = new ArrayList<ItemEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private LocationEntity location;
    @OneToOne(cascade={CascadeType.PERSIST})
    private CustomerEntity customer;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity();

    public TransactionEntity() {
    }

    public TransactionEntity(double totalAmount, String paymentMode, Long creditCardTxnNum, Timestamp invoiceDate, double taxesPayable, 
            double totalDiscountAmount, double totalDiscountPercentage, double subtotal, List itemQty, List price, List discountAmt, 
            List discountPercent, Collection<ItemEntity> items, LocationEntity location, CustomerEntity customer, RetailerEntity retailer) {
        this.setTotalAmount(totalAmount);
        this.setPaymentMode(paymentMode);
        this.setCreditCardTxnNum(creditCardTxnNum);
        this.setInvoiceDate(invoiceDate);
        this.setTaxesPayable(taxesPayable);
        this.setDiscountPercent(discountPercent);
        this.setTotalDiscountAmount(totalDiscountAmount);
        this.setSubtotal(subtotal);
        this.setItemQty(itemQty);
        this.setPrice(price);
        this.setDiscountAmt(discountAmt);
        this.setDiscountPercent(discountPercent);
        this.setItems(items);
        this.setLocation(location);
        this.setCustomer(customer);
        this.setRetailer(retailer);
    }
    
    

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Long getCreditCardTxnNum() {
        return creditCardTxnNum;
    }

    public void setCreditCardTxnNum(Long creditCardTxnNum) {
        this.creditCardTxnNum = creditCardTxnNum;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getTaxesPayable() {
        return taxesPayable;
    }

    public void setTaxesPayable(double taxesPayable) {
        this.taxesPayable = taxesPayable;
    }

    public double getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(double totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public double getTotalDiscountPercentage() {
        return totalDiscountPercentage;
    }

    public void setTotalDiscountPercentage(double totalDiscountPercentage) {
        this.totalDiscountPercentage = totalDiscountPercentage;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public List getItemQty() {
        return itemQty;
    }

    public void setItemQty(List itemQty) {
        this.itemQty = itemQty;
    }

    public List getPrice() {
        return price;
    }

    public void setPrice(List price) {
        this.price = price;
    }

    public List getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(List discountAmt) {
        this.discountAmt = discountAmt;
    }

    public List getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(List discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Collection<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Collection<ItemEntity> items) {
        this.items = items;
    }

//    public Collection<PromotionEntity> getPromotions() {
//        return promotions;
//    }
//
//    public void setPromotions(Collection<PromotionEntity> promotions) {
//        this.promotions = promotions;
//    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
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
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionEntity)) {
            return false;
        }
        TransactionEntity other = (TransactionEntity) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransactionEntity[ id=" + transactionId + " ]";
    }
    
}
