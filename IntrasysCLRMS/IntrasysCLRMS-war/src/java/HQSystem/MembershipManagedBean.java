/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HQSystem;

import AdministrativeManagementSystem.NavigationAdminBean;
import Entity.MembershipEntity;
import Entity.RetailerEntity;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author edwar
 */
@Named(value = "membershipManagedBean")
@RequestScoped
public class MembershipManagedBean {

    @EJB
    MembershipManagementBeanLocal mmbl;
    @ManagedProperty(value = "#{navigationBean}")
    private NavigationAdminBean navigationAdminBean = new NavigationAdminBean();

    private Long membershipId;
    private String membershipType;
    private double membershipFee;
    private String membershipRemarks;
    private RetailerEntity retailerId;

    private List<MembershipEntity> membershipList;
    private MembershipEntity newMembership;
    private MembershipEntity selectedMembership;

    private String serverMessage;
    private String dummy;

    /**
     * Creates a new instance of MembershipManagedBean
     */
    public MembershipManagedBean() {
    }

    @PostConstruct
    public void init() {
        membershipList = mmbl.listMembership();
    }
    
    public void createMembership(){
        try{
            newMembership = mmbl.createMembership(membershipType, membershipFee, membershipRemarks, retailerId);
            membershipList.add(newMembership);
            serverMessage = "New membership added.";
            clear();
        }catch(Exception ex){
            
        }
    }
    
    public void updateMembership(){
        boolean updateAttempt;
        updateAttempt = mmbl.updateMembership(selectedMembership, membershipType, membershipFee, membershipRemarks);
        try{
            if(updateAttempt == true){
                serverMessage = "Membership updated successfully";
            }
            else{
                serverMessage = "Membership failed to update";
            }
        }catch(Exception ex){
            serverMessage = "Membership failed to update";
        }
        
    }
    
    public void clear(){
        membershipId = null;
        membershipType = null;
        membershipFee = 0.0;
        membershipRemarks = null;
        retailerId = null;
    }

    public MembershipManagementBeanLocal getMmbl() {
        return mmbl;
    }

    public void setMmbl(MembershipManagementBeanLocal mmbl) {
        this.mmbl = mmbl;
    }

    public NavigationAdminBean getNavigationAdminBean() {
        return navigationAdminBean;
    }

    public void setNavigationAdminBean(NavigationAdminBean navigationAdminBean) {
        this.navigationAdminBean = navigationAdminBean;
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public String getMembershipRemarks() {
        return membershipRemarks;
    }

    public void setMembershipRemarks(String membershipRemarks) {
        this.membershipRemarks = membershipRemarks;
    }

    public RetailerEntity getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(RetailerEntity retailerId) {
        this.retailerId = retailerId;
    }

    public List<MembershipEntity> getMembershipList() {
        return membershipList;
    }

    public void setMembershipList(List<MembershipEntity> membershipList) {
        this.membershipList = membershipList;
    }

    public MembershipEntity getNewMembership() {
        return newMembership;
    }

    public void setNewMembership(MembershipEntity newMembership) {
        this.newMembership = newMembership;
    }

    public MembershipEntity getSelectedMembership() {
        return selectedMembership;
    }

    public void setSelectedMembership(MembershipEntity selectedMembership) {
        this.selectedMembership = selectedMembership;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy = dummy;
    }

}
