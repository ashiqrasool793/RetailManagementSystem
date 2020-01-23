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

/**
 *
 * @author edwar
 */
@Entity
public class CreditCardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long creditCardId;
    private String creditCardType;
    private Long creditCardNum;
    private String creditCardName;
    private Timestamp creditCardExpiry;
    @ManyToOne(cascade={CascadeType.ALL})
    private CustomerEntity customer = new CustomerEntity();

    public CreditCardEntity() {
    }

    public CreditCardEntity(String creditCardType, Long creditCardNum, String creditCardName, Timestamp creditCardExpiry) {
        this.setCreditCardType(creditCardType);
        this.setCreditCardName(creditCardName);
        this.setCreditCardNum(creditCardNum);
        this.setCreditCardExpiry(creditCardExpiry);
    }

    public Long getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public Long getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(Long creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public Timestamp getCreditCardExpiry() {
        return creditCardExpiry;
    }

    public void setCreditCardExpiry(Timestamp creditCardExpiry) {
        this.creditCardExpiry = creditCardExpiry;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditCardId != null ? creditCardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCardEntity)) {
            return false;
        }
        CreditCardEntity other = (CreditCardEntity) object;
        if ((this.creditCardId == null && other.creditCardId != null) || (this.creditCardId != null && !this.creditCardId.equals(other.creditCardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CreditCardEntity[ id=" + creditCardId + " ]";
    }
    
}
