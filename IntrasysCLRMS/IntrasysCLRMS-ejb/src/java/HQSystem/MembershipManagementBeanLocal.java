/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import Entity.MembershipEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author edwar
 */
@Local
public interface MembershipManagementBeanLocal {

    MembershipEntity createMembership(String membershipType, double membershipFee, String membershipRemarks, RetailerEntity retailerId);

    boolean updateMembership(MembershipEntity selectedMembership, String membershipType, double membershipFee, String membershipRemarks);

    List<MembershipEntity> listMembership();
    
}
