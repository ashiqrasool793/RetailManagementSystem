/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonInfrastructure;

import Entity.FunctionEntity;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Kenneth
 */
public interface FunctionManagementBeanLocal {
    
    public FunctionEntity createFunction(String function, String functionDesc);
    
    public Set<FunctionEntity> listFunction(Long roleId);
    
    public List<FunctionEntity> listAllFunction();
    
    public boolean deleteFunction(FunctionEntity selectedFunction);
}
