/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.MembershipEntity;
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
public class MembershipManagementBean implements MembershipManagementBeanLocal, MembershipManagementBeanRemote {

    @PersistenceContext
    EntityManager em;

    @Resource
    SessionContext ctx;
    private MembershipEntity membership;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public MembershipEntity createMembership(String membershipType, double membershipFee, String membershipRemarks, RetailerEntity retailerId) {
        membership = new MembershipEntity();
        membership.setMembershipType(membershipType);
        membership.setMembershipFee(membershipFee);
        membership.setMembershipRemarks(membershipRemarks);
        membership.setRetailer(retailerId);
        em.persist(membership);
        em.flush();
        return membership;
    }

    @Override
    public boolean updateMembership(MembershipEntity selectedMembership, String membershipType, double membershipFee, String membershipRemarks) {
        try {
            membership = selectedMembership;
            membership.setMembershipType(membershipType);
            membership.setMembershipFee(membershipFee);
            membership.setMembershipRemarks(membershipRemarks);
            em.merge(membership);
            em.flush();
            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<MembershipEntity> listMembership() {
        Query query = em.createQuery("SELECT m from MembershipEntity m");
        return query.getResultList();
    }
    
    

}
