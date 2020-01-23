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
public class PurchaseOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseOrderId;
    private boolean approval;
    private Long invoiceNum;
    private String paymentTerms;
    private Timestamp deliveryDate;
    private Long contractID;
    private List itemQuantity;
    private List itemPrice;
    private double orderAmount;
    private String remarks;
    @OneToOne(cascade={CascadeType.PERSIST})
    private QuotationEntity quotation;
    @OneToMany(cascade={CascadeType.PERSIST})
    public Collection<ItemTypeEntity>  itemType = new ArrayList<ItemTypeEntity>();
    @OneToOne(cascade={CascadeType.PERSIST})
    private SupplierEntity supplier;
    @OneToOne(cascade={CascadeType.PERSIST})
    private EmployeeEntity employee;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public PurchaseOrderEntity() {
    }

    public PurchaseOrderEntity(boolean approval, Long invoiceNum, String paymentTerms, Timestamp deliveryDate, 
            Long contractID, List itemQuantity, List itemPrice, double orderAmount, String remarks, 
            QuotationEntity quotation, Collection<ItemTypeEntity> itemType, SupplierEntity supplier, EmployeeEntity employee, RetailerEntity retailer) {
        this.setApproval(approval);
        this.setInvoiceNum(invoiceNum);
        this.setPaymentTerms(paymentTerms);
        this.setDeliveryDate(deliveryDate);
        this.setContractID(contractID);
        this.setItemQuantity(itemQuantity);
        this.setItemPrice(itemPrice);
        this.setOrderAmount(orderAmount);
        this.setRemarks(remarks);
        this.setQuotation(quotation);
        this.setItemType(itemType);
        this.setSupplier(supplier);
        this.setEmployee(employee);
        this.setRetailer(retailer);
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public Long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(Long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getContractID() {
        return contractID;
    }

    public void setContractID(Long contractID) {
        this.contractID = contractID;
    }

    public List getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(List itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public List getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(List itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public QuotationEntity getQuotation() {
        return quotation;
    }

    public void setQuotation(QuotationEntity quotation) {
        this.quotation = quotation;
    }

    public Collection<ItemTypeEntity> getItemType() {
        return itemType;
    }

    public void setItemType(Collection<ItemTypeEntity> itemType) {
        this.itemType = itemType;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderId != null ? purchaseOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderEntity)) {
            return false;
        }
        PurchaseOrderEntity other = (PurchaseOrderEntity) object;
        if ((this.purchaseOrderId == null && other.purchaseOrderId != null) || (this.purchaseOrderId != null && !this.purchaseOrderId.equals(other.purchaseOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PurchaseOrderEntity[ id=" + purchaseOrderId + " ]";
    }
    
}
