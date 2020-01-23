/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.ItemTypeEntity;
import Entity.RetailerEntity;
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
public class ItemTypeManagementBean implements ItemTypeManagementBeanLocal, ItemTypeManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private ItemTypeEntity itemType;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public ItemTypeEntity createItemType(String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailerId) {
        itemType = new ItemTypeEntity();
        itemType.setItemName(itemName);
        itemType.setItemDescription(itemDescription);
        itemType.setItemCategory(itemCategory);
        itemType.setItemSubCategory(itemSubCategory);
        itemType.setItemPicture(null);
        itemType.setItemBasePrice(itemBasePrice);
        itemType.setItemSalePrice(itemSalePrice);
        itemType.setRetailer(null);
        em.persist(itemType);
        em.flush();
        return itemType;

    }

    @Override
    public boolean updateItemType(ItemTypeEntity selectedItemType, String itemName, String itemDescription, String itemCategory, String itemSubCategory, String itemPicture, double itemBasePrice, double itemSalePrice, RetailerEntity retailerId) {
        try {
            itemType = selectedItemType;
            itemType.setItemName(itemName);
            itemType.setItemDescription(itemDescription);
            itemType.setItemCategory(itemCategory);
            itemType.setItemSubCategory(itemSubCategory);
            itemType.setItemPicture(null);
            itemType.setItemBasePrice(itemBasePrice);
            itemType.setItemSalePrice(itemSalePrice);
            itemType.setRetailer(null);
            em.merge(itemType);
            em.flush();
            

            return true;
        } catch (Exception ex) {

            return false;
        }
    }

    @Override
    public List<ItemTypeEntity> listItemType() {
        Query query = em.createQuery("SELECT itemType from ItemTypeEntity itemType");
        return query.getResultList();
    }

}
