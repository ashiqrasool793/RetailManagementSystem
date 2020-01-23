/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import Entity.FunctionEntity;
import Entity.RoleEntity;
import javax.ejb.Local;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Kenneth
 */
@Local
public interface RoleManagementBeanLocal {
    
    public RoleEntity createRole(String roleName, String rDesc);
    public void updateRole(Long roleId, String roleName, String rDesc);
    public void deleteRole(Long roleId);
    public List<RoleEntity> listRole();
    public RoleEntity getRoleFromId(Long roleId);
    public RoleEntity getRoleFromName(String roleName);
    public void addFunctionToRole(Long roleId, Long functionId);
    public void removeFunctionFromRole(Long roleId, Long functionId);
}
