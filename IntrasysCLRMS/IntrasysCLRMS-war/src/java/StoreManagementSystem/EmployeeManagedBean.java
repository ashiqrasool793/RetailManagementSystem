/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreManagementSystem;


import StoreManagementSystem.ManageEmployeeAccountBean;
import Entity.EmployeeEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ashiq
 */
@Named(value = "ManageEmployeeAccountBean")
@RequestScoped
public class EmployeeManagedBean {
    
     @EJB
    private ManageEmployeeAccountBeanLocal manageEmployeeAccountBeanLocal;
     
      @ManagedProperty(value="#{navigationBean}")
    private NavigationSMSBean navigationSMSBean = new NavigationSMSBean();
      
    private List<EmployeeEntity> employees;
    private EmployeeEntity employee;
    private String staffUsername = "ashiq";
    private Long staffContact;
    private String staffEmail;
    private String staffAddress;
    private String staffPassword;
    private String statusMessage;
    HttpSession session;
    
    @PostConstruct
    public void init() {
        employee = manageEmployeeAccountBeanLocal.getEmployee(staffUsername);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     public String login() {
        if(manageEmployeeAccountBeanLocal.loginUser(staffUsername, staffPassword)) {
            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("staffUsername", staffUsername);
            return navigationSMSBean.redirectToSMSHome();
        }
        else {
            FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return navigationSMSBean.toSMSLogin();
        }
    }
    
    public String logout() {
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return navigationSMSBean.toSMSLogin();
    }
    
    
    
    
    public void saveEmployeeUpdate() {
        boolean updateAttempt;

        try {
            updateAttempt = manageEmployeeAccountBeanLocal.updateProfile(staffUsername, staffContact, staffAddress, staffEmail, staffPassword);
            
            if(updateAttempt == true) {
                statusMessage = "Retailer Account updated successfully";
            }
            else {
                statusMessage = "Retailer Account update attempt failed";
            }
        }
        catch (Exception ex) {
            statusMessage = "Retailer Account update attempt failed";
        }
        
    }

    public ManageEmployeeAccountBeanLocal getManageEmployeeAccountBeanLocal() {
        return manageEmployeeAccountBeanLocal;
    }

    public void setManageEmployeeAccountBeanLocal(ManageEmployeeAccountBeanLocal manageEmployeeAccountBeanLocal) {
        this.manageEmployeeAccountBeanLocal = manageEmployeeAccountBeanLocal;
    }

    public NavigationSMSBean getNavigationSMSBean() {
        return navigationSMSBean;
    }

    public void setNavigationSMSBean(NavigationSMSBean navigationSMSBean) {
        this.navigationSMSBean = navigationSMSBean;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public Long getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(Long staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
        
        
}
