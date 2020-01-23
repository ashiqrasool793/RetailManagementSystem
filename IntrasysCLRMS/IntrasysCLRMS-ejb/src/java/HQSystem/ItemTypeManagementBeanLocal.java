/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author edwar
 */
@Local
public interface ItemTypeManagementBeanLocal {

    ItemTypeEntity createItemType(String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailerId);

    List<ItemTypeEntity> listItemType();

    boolean updateItemType(ItemTypeEntity selectedItemType, String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailerId);
    
}
