/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.RetailerEntity;
import Entity.TransferOrderEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author keane
 */
@Remote
public interface PickingBeanRemote {

    List<TransferOrderEntity> downloadPickList();

    boolean updatePickList(TransferOrderEntity selectedPick, String status);

    TransferOrderEntity createPickList(String status, RetailerEntity retailerId);

    List<TransferOrderEntity> listPickList();
    
}
