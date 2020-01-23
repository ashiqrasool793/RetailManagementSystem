/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author edwar
 */
@Entity
public class FunctionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long functionId;
    private String function;
    private String functionDesc;
    @ManyToMany(cascade={CascadeType.ALL}, mappedBy="function")
    private Set<RoleEntity> role = new HashSet<RoleEntity>();
    @ManyToOne(cascade={CascadeType.ALL})
    private RetailerEntity retailer = new RetailerEntity(); 

    public FunctionEntity() {
    }
    
    public FunctionEntity(String function, String functionDesc, Set<RoleEntity> role, RetailerEntity retailer) {
        this.setFunction(function);
        this.setFunctionDesc(functionDesc);
        this.setRole(role);
        this.setRetailer(retailer);
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public Set<RoleEntity> getRole() {
        return role;
    }

    public void setRole(Set<RoleEntity> role) {
        this.role = role;
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
        hash += (functionId != null ? functionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunctionEntity)) {
            return false;
        }
        FunctionEntity other = (FunctionEntity) object;
        if ((this.functionId == null && other.functionId != null) || (this.functionId != null && !this.functionId.equals(other.functionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FunctionEntity[ id=" + functionId + " ]";
    }
    
}
