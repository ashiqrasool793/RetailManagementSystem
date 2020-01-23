/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.FunctionEntity;
import Entity.RoleEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Kenneth
 */
@Named(value = "functionRoleManagedBean")
@RequestScoped
public class FunctionRoleManagedBean {

    @EJB
    private RoleManagementBeanLocal roleManagementBeanLocal;
    @EJB
    private FunctionManagementBeanLocal functionManagementBeanLocal;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationCIBean navigationCIBean = new NavigationCIBean();

    private List<FunctionEntity> functions;
    private List<FunctionEntity> oldSelectedFunctions;
    private List<FunctionEntity> selectedFunctionsAdd;
    private List<FunctionEntity> selectedFunctionsRemove;
    private List<FunctionEntity> allFunctions;
    private List<RoleEntity> roles;
    private FunctionEntity function;
    private RoleEntity newRole;
    private RoleEntity selectedRole;
    private Long roleId;
    private String roleName;
    private String rDesc;
    private Long functionId;
    private String functionName;
    private String functionDesc;
    private String statusMessage;

    @PostConstruct
    public void init() {
        roles = roleManagementBeanLocal.listRole();
        allFunctions = functionManagementBeanLocal.listAllFunction();

    }

    public void saveNewRole() {
        /**
         * Server Test
         */
        System.out.println("New Role Id: " + roleId);
        System.out.println("New Role Name: " + roleName);
        System.out.println("New Role Description: " + rDesc);

        try {
            newRole = roleManagementBeanLocal.createRole(roleName, rDesc);

            /*
             // Add Functions to Role
             Iterator<FunctionEntity> iterator = functions.iterator();
             while (iterator.hasNext()) {
             function = iterator.next();
             roleManagementBeanLocal.addFunctionToRole(newRole.getRoleId(), function.getFunctionId());
             }
             */
            roles.add(newRole);
            statusMessage = "New Role created successfully.";
            clear();
        } catch (Exception ex) {
        }
    }

    public void deleteRole() {
        /**
         * Server Test
         */
        System.out.println("New Role Id: " + roleId);
        System.out.println("New Role Name: " + roleName);
        System.out.println("New Role Description: " + rDesc);

        try {
            roles.remove(selectedRole);
            roleManagementBeanLocal.deleteRole(selectedRole.getRoleId());
        } catch (Exception ex) {
        }
    }

    public void roleFunctionDetail() {
        functions = new ArrayList(selectedRole.getFunction());
    }

    public void addFunctionDetail() {
        /**
         * Server Test
         */
        System.out.println();
        System.out.println("AddFunctionDetail: ");
        System.out.println("Selected Role Id: " + selectedRole.getRoleId());
        
        functions = new ArrayList(selectedRole.getFunction());

        Iterator<FunctionEntity> iterator = functions.iterator();
        while (iterator.hasNext()) {
            function = iterator.next();
            /**
             * Server Test
             */
            System.out.println("Function Id Remove: " + function.getFunctionId());

            allFunctions.remove(function);
        }
        System.out.println();
        System.out.println();
    }

    public void addFunctionToRole() {

        // Test
        System.out.print("SelectedFunctions size: " + selectedFunctionsAdd.size());

        Iterator<FunctionEntity> iterator = selectedFunctionsAdd.iterator();
        while (iterator.hasNext()) {
            function = iterator.next();
            /**
             * Server Test
             */
            System.out.println("Function Id Add: " + function.getFunctionId());
            
            roleManagementBeanLocal.addFunctionToRole(selectedRole.getRoleId(), function.getFunctionId());
        }
        clearFunction();
    }

    /**
     * For clearing fields after every update as it will appear on form
     */
    private void clearFunction() {
        function = null;
        selectedFunctionsAdd = null;
        selectedFunctionsRemove = null;

    }

    private void clear() {
        function = null;
        newRole = null;
        selectedRole = null;
        roleId = null;
        roleName = null;
        rDesc = null;
        functionId = null;
        functionName = null;
        functionDesc = null;
        statusMessage = null;
    }
    // Getter & Setters

    public List<FunctionEntity> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionEntity> functions) {
        this.functions = functions;
    }

    public List<FunctionEntity> getOldSelectedFunctions() {
        return oldSelectedFunctions;
    }

    public void setOldSelectedFunctions(List<FunctionEntity> oldSelectedFunctions) {
        this.oldSelectedFunctions = oldSelectedFunctions;
    }

    public List<FunctionEntity> getSelectedFunctionsAdd() {
        return selectedFunctionsAdd;
    }

    public void setSelectedFunctionsAdd(List<FunctionEntity> selectedFunctionsAdd) {
        this.selectedFunctionsAdd = selectedFunctionsAdd;
    }

    public List<FunctionEntity> getSelectedFunctionsRemove() {
        return selectedFunctionsRemove;
    }

    public void setSelectedFunctionsRemove(List<FunctionEntity> selectedFunctionsRemove) {
        this.selectedFunctionsRemove = selectedFunctionsRemove;
    }

    public List<FunctionEntity> getAllFunctions() {
        return allFunctions;
    }

    public void setAllFunctions(List<FunctionEntity> allFunctions) {
        this.allFunctions = allFunctions;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public FunctionEntity getFunction() {
        return function;
    }

    public void setFunction(FunctionEntity function) {
        this.function = function;
    }

    public RoleEntity getNewRole() {
        return newRole;
    }

    public void setNewRole(RoleEntity newRole) {
        this.newRole = newRole;
    }

    public RoleEntity getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(RoleEntity selectedRole) {
        this.selectedRole = selectedRole;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getrDesc() {
        return rDesc;
    }

    public void setrDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDesc() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc = functionDesc;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
