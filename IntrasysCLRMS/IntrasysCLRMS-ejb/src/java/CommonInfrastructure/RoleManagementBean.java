/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import Entity.RoleEntity;
import Entity.FunctionEntity;
import Entity.EmployeeEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;

/**
 *
 * @author Kenneth
 */
@Stateless
public class RoleManagementBean implements RoleManagementBeanLocal, RoleManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    private EmployeeEntity employee;
    private FunctionEntity function;
    private RoleEntity role;
    private List<EmployeeEntity> employeeList;
    private List<FunctionEntity> functionList;

    @Override
    public RoleEntity createRole(String roleName, String rDesc) {
        // To do: Check for duplicate that isn't deleted

        role = new RoleEntity();
        role.setRoleName(roleName);
        role.setrDesc(rDesc);

        em.persist(role);
        em.flush();

        return role;
    }
    
    @Override
    public void updateRole(Long roleId, String roleName, String rDesc) {
        role = em.find(RoleEntity.class, roleId);
        role.setRoleName(roleName);
        role.setrDesc(rDesc);
        
        em.persist(role);
        em.flush();
    }
    
    @Override
    public void deleteRole(Long roleId) {

        Query query;
        role = em.find(RoleEntity.class, roleId);

        // Remove Role from Employee
        query = em.createQuery("SELECT e FROM EmployeeEntity e"); // Add Retailer selection in Query
        employeeList = query.getResultList();
        Iterator<EmployeeEntity> iteratorEmployee = employeeList.iterator();
        while (iteratorEmployee.hasNext()) {
            employee = iteratorEmployee.next();
            employee.getRole().remove(role); // Add roleList to employeeEntity
            em.merge(employee);
            em.flush();
        }

        // Remove Role from Function
        query = em.createQuery("SELECT f FROM FunctionEntity f");
        functionList = query.getResultList();
        Iterator<FunctionEntity> iteratorFunction = functionList.iterator();
        while (iteratorFunction.hasNext()) {
            function = iteratorFunction.next();
            function.getRole().remove(role);
            em.merge(function);
            em.flush();
        }

        em.remove(role);
        em.flush();
    }
    
    @Override
    public List<RoleEntity> listRole() {
        Query q = em.createQuery("SELECT r " + "FROM RoleEntity r");
        return q.getResultList();
    }

    @Override
    public RoleEntity getRoleFromId(Long roleId) {
        role = em.find(RoleEntity.class, roleId);
        return role;
    }

    @Override
    public RoleEntity getRoleFromName(String roleName) {
        Query query = em.createQuery("FROM RoleEntity r where r.roleName=:roleName");
        query.setParameter("name", roleName);
        return (RoleEntity) query.getSingleResult();
    }

    @Override
    public void addFunctionToRole(Long roleId, Long functionId) {
        role = em.find(RoleEntity.class, roleId);
        function = em.find(FunctionEntity.class, functionId);
        role.getFunction().add(function);
        function.getRole().add(role);
        em.persist(role);
        em.persist(function);
        em.flush();
    }

    @Override
    public void removeFunctionFromRole(Long roleId, Long functionId) {
        role = em.find(RoleEntity.class, roleId);
        function = em.find(FunctionEntity.class, functionId);
        role.getFunction().remove(function);
        function.getRole().remove(role);
        em.persist(role);
        em.persist(function);
        em.flush();
    }
}
