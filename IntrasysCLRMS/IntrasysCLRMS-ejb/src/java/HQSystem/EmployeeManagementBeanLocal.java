/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.EmployeeEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author edwar
 */
@Local
public interface EmployeeManagementBeanLocal {

    EmployeeEntity createEmployee(String staffName, String staffUsername, String staffContact, String staffEmail, String staffAddress, String jobTitle, String staffPassword, String staffStatus);

    Long createEmployeeTest(String staffName, String staffPassword);

    boolean updateEmployee(EmployeeEntity selectedEmployee, String staffName, String staffEmail, String jobTitle, String location, String retailer, String staffAddress, String staffContact, String staffUsername, String staffStatus);

    List<EmployeeEntity> listEmployees();
    
}
