/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author edwar
 */
@Entity
public class QuotationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quotationId;
    private Timestamp quotationDate;
    private double quotationTotal;
    private boolean quotationValidity;
    private String quotationFileLocation;
    @OneToOne(cascade={CascadeType.PERSIST})
    private SupplierEntity supplier;
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public QuotationEntity() {
    }

    public QuotationEntity(Timestamp quotationDate, double quotationTotal, boolean quotationValidity, String quotationFileLocation, 
            SupplierEntity supplier, RetailerEntity retailer) {
        this.setQuotationDate(quotationDate);
        this.setQuotationTotal(quotationTotal);
        this.setQuotationValidity(quotationValidity);
        this.setQuotationFileLocation(quotationFileLocation);
        this.setSupplier(supplier);
        this.setRetailer(retailer);
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public Timestamp getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Timestamp quotationDate) {
        this.quotationDate = quotationDate;
    }

    public double getQuotationTotal() {
        return quotationTotal;
    }

    public void setQuotationTotal(double quotationTotal) {
        this.quotationTotal = quotationTotal;
    }

    public boolean isQuotationValidity() {
        return quotationValidity;
    }

    public void setQuotationValidity(boolean quotationValidity) {
        this.quotationValidity = quotationValidity;
    }

    public String getQuotationFileLocation() {
        return quotationFileLocation;
    }

    public void setQuotationFileLocation(String quotationFileLocation) {
        this.quotationFileLocation = quotationFileLocation;
    }

    public RetailerEntity getRetailer() {
        return retailer;
    }

    public void setRetailer(RetailerEntity retailer) {
        this.retailer = retailer;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quotationId != null ? quotationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuotationEntity)) {
            return false;
        }
        QuotationEntity other = (QuotationEntity) object;
        if ((this.quotationId == null && other.quotationId != null) || (this.quotationId != null && !this.quotationId.equals(other.quotationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.QuotationEntity[ id=" + quotationId + " ]";
    }
    
}
