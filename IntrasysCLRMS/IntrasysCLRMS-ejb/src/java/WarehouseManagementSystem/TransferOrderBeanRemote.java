/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WarehouseManagementSystem;

import Entity.EmployeeEntity;
import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import Entity.TransferOrderEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author keane
 */
@Remote
public interface TransferOrderBeanRemote {

    List<TransferOrderEntity> listTransferOrders();

    List<ArrayList> viewTransferOrder(long transferOrderId);

    boolean updateTransferOrder(TransferOrderEntity transferOrderId, String status);

    TransferOrderEntity createTransferOrder(String status, RetailerEntity retailerId);
    
}
