/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.EmployeeEntity;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

/**
 *
 * @author edwar
 */
//@ManagedBean
@Named(value = "createEmployeeManagedBean")
@RequestScoped

//
public class CreateEmployeeManagedBean implements Serializable {

    @EJB
    EmployeeManagementBeanLocal embl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long staffId;
    private String employeeName;
    private String employeeAddress;
    private String employeeContact;
    private String jobTitle;
    private String status;
    private String employeeEmail;
    private String username;
    private String password;
    private String dummy;

    private List<EmployeeEntity> employees;
    private EmployeeEntity newEmployee;
    private EmployeeEntity selectedEmployee;

    private String serverMessage;

    /**
     * Creates a new instance of CreateEmployeeManagedBean
     */
    public CreateEmployeeManagedBean() {
    }

    @PostConstruct
    public void init() {
        employees = embl.listEmployees();
    }

    public void createNewEmployee() {
        
        System.out.println(employeeEmail);

        //employeeId=embl.createEmployeeTest(username, password);
        try {
            newEmployee = embl.createEmployee(employeeName, username, employeeContact, employeeEmail, employeeAddress, jobTitle, password, status);
            employees.add(newEmployee);
            serverMessage = "New Employee added.";
            clear();
        } catch (Exception ex) {

        }

    }
    
    public void updateEmployee(){
        boolean updateAttempt;
        try{
            updateAttempt = embl.updateEmployee(selectedEmployee, employeeName, employeeEmail, jobTitle, null, null, employeeAddress, employeeContact, username, status);
            if(updateAttempt == true){
                serverMessage = "Employee details updated successfully";
            }
            else{
                serverMessage = "Employee details failed to update";
            }
        }catch(Exception ex){
            serverMessage = "Employee details failed to update";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private void clear(){
        staffId = null;
        selectedEmployee = null;
        employeeName = null;
        username = null;
        employeeContact = null;
        employeeEmail = null;
        employeeAddress = null;
        jobTitle = null;
        password = null;
        status = null;
        
    }

    public EmployeeManagementBeanLocal getEmbl() {
        return embl;
    }

    public void setEmbl(EmployeeManagementBeanLocal embl) {
        this.embl = embl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public EmployeeEntity getNewEmployee() {
        return newEmployee;
    }

    public void setNewEmployee(EmployeeEntity newEmployee) {
        this.newEmployee = newEmployee;
    }

    public EmployeeEntity getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(EmployeeEntity selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }


}
