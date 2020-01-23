/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.EmployeeEntity;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author edwar
 */
@Stateless
public class EmployeeManagementBean implements EmployeeManagementBeanLocal, EmployeeManagementBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;
    

    @Resource
    SessionContext ctx;
    private EmployeeEntity employee;

    @Override
    public EmployeeEntity createEmployee(String staffName, String staffUsername, String staffContact, String staffEmail, String staffAddress, String jobTitle, String staffPassword, String staffStatus) {
        employee = new EmployeeEntity();
        employee.setStaffName(staffName);
        employee.setStaffPassword(staffPassword);
        employee.setStaffEmail(staffEmail);
        employee.setJobTitle(jobTitle);
        employee.setLocation(null);
        employee.setRetailer(null);
        employee.setRole(null);
        employee.setStaffAddress(staffAddress);
        employee.setStaffContact(Long.valueOf(staffContact));
        employee.setStaffUsername(staffUsername);
        employee.setStaffStatus(staffStatus);
        em.persist(employee);
        em.flush();
        return employee;
    }

    @Override
    public Long createEmployeeTest(String staffName, String staffPassword) {
        employee = new EmployeeEntity();
        employee.setStaffName(staffName);
        employee.setStaffPassword(staffPassword);
        employee.setJobTitle(null);
        employee.setLocation(null);
        employee.setRetailer(null);
        employee.setRole(null);
        employee.setStaffAddress(null);
        employee.setStaffContact(Long.valueOf("98764321"));
        em.persist(employee);
        em.flush();
        return employee.getStaffId();
    }

    @Override
    public boolean updateEmployee(EmployeeEntity selectedEmployee, String staffName, String staffEmail, String jobTitle, String location, String retailer, String staffAddress, String staffContact, String staffUsername, String staffStatus) {
        try {
            employee = selectedEmployee;
            employee.setStaffName(staffName);
            employee.setStaffEmail(staffEmail);
            employee.setJobTitle(jobTitle);
            employee.setLocation(null);
            employee.setRetailer(null);
            employee.setRole(null);
            employee.setStaffAddress(staffAddress);
            employee.setStaffContact(Long.valueOf(staffContact));
            employee.setStaffUsername(staffUsername);
            employee.setStaffStatus(staffStatus);
            em.merge(employee);
            em.flush();
            return true;

        } catch (Exception ex) {

            return false;
        }
    }

    @Override
    public List<EmployeeEntity> listEmployees() {
        Query query = em.createQuery("SELECT e from EmployeeEntity e");
        return query.getResultList();
    }

}
