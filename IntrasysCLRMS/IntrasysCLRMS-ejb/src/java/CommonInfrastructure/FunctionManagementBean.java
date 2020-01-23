/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import Entity.FunctionEntity;
import Entity.RoleEntity;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kenneth
 */
@Stateless
public class FunctionManagementBean implements FunctionManagementBeanLocal, FunctionManagementBeanRemote {
    
    @PersistenceContext
    EntityManager em;
    
    private FunctionEntity function;
    private RoleEntity role;
    
    public FunctionEntity createFunction(String function, String functionDesc) {
        this.function = new FunctionEntity();
        this.function.setFunction(function);
        this.function.setFunctionDesc(functionDesc);
        
        em.persist(this.function);
        em.flush();
        
        return this.function;
    }
    
    public Set<FunctionEntity> listFunction(Long roleId) {
        role = em.find(RoleEntity.class, roleId);
        return role.getFunction();
    }
    
    public List<FunctionEntity> listAllFunction() {
        Query q = em.createQuery("SELECT f " + "FROM FunctionEntity f");
        return q.getResultList();
    }
    
    public boolean deleteFunction(FunctionEntity selectedFunction) {
        try {
            function = em.find(FunctionEntity.class, selectedFunction.getFunctionId());

            em.remove(function);
            em.flush();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}