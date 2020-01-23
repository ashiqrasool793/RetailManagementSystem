        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;

import Entity.EmployeeEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ashiq
 */
@Stateless
public class ManageEmployeeAccountBean implements ManageEmployeeAccountBeanLocal, ManageEmployeeAccountBeanRemote {

    @PersistenceContext
    EntityManager em;

    EmployeeEntity employee;

    @Override
    public boolean loginUser(String staffUsername, String password) {
        Query query = em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.staffUsername=:staffUsername");
        System.out.println("Test1");
        query.setParameter("staffUsername", staffUsername);
        System.out.println("Test2");
        employee = (EmployeeEntity) query.getSingleResult();
        System.out.println("Test3");
        if (employee == null) {
            return false;
        } else if (employee.getStaffPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    @Override
    public boolean updateProfile(String staffUsername, Long contact, String address, String email, String password) {
        try {
        Query query = em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.staffUsername = :staffUsername");
        query.setParameter("staffUsername", staffUsername);
        employee = (EmployeeEntity) query.getSingleResult();
        if (address != null) {
            if (!address.equals("")) {
                employee.setStaffAddress(address);
            }
        }
        if (password != null) {
            if (!password.equals("")) {
                employee.setStaffPassword(password);
            }
        }

        if (contact != null) {
            if (!contact.equals("")) {
                employee.setStaffContact(contact);
            }
        }
        if (email != null) {
            if (!email.equals("")) {
                employee.setStaffEmail(email);
            }
        }
        em.merge(employee);
        em.flush();
        return true;
        }
        catch (Exception ex) {
            return false;
        }
}

    @Override
    public EmployeeEntity getEmployee(String staffUsername) {
        Query query = em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.staffUsername = :staffUsername");
        query.setParameter("staffUsername", staffUsername);
        employee = (EmployeeEntity) query.getSingleResult();
        return employee;
    }
}
