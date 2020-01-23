/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagementsystemclient;

import StoreManagementSystem.*;
import Entity.*;
import java.sql.Timestamp;
import java.util.*;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author ashiq
 */
public class Main {
    @EJB
    private static ManageEmployeeAccountBeanRemote manageEmployeeAccountBean;
    @EJB
    private static ManageStoreInventoryAlertsBeanRemote manageAlerts;
    @EJB
    private static StoreInventoryManagementSystemRemote invManager;
    private EmployeeEntity employee;
    private RetailerEntity retailer;
    private LocationEntity location;
    private ItemEntity item;
    public Scanner sc = new Scanner(System.in);
    
    @PersistenceContext
    EntityManager em;
    
    public static void main(String[] args) {
        Main client = new Main();
        client.getUserChoice();
    }   
        private void getUserChoice() {
        String userInput = "";
        do {
            System.out.println();
            displayMenu();
            userInput = sc.nextLine();
            if (userInput.equals("1")) {
                login();
            } else if (userInput.equals("2")) {
                viewProfile();
            } else if (userInput.equals("3")) {
                updateProfile();
            } else if (userInput.equals("4")) {
                viewStockAlerts();
            } else if (userInput.equals("5")) {
                viewStockLevels();
            } else if (userInput.equals("6")) {
                updateStockLevel();         
            } else if (userInput.equals("7")) {
                viewProductDetails();
            }  else if (userInput.equals("8")) {
                viewActiveAlerts();
            } else if (userInput.equals("9")) {
                viewResolvedAlerts();
            } else if (userInput.equals("10")) {
                updateAlerts();
            } else if ((!userInput.equals("Q") && !userInput.equals("q"))) {
                showError();
            }
        } while (userInput == null || (!userInput.equals("Q") && !userInput.equals("q")));
    }

        
        
        
        public void displayMenu(){
        System.out.println();
        System.out.println("*************************************");
        System.out.println("Welcome to Store Management System");
        System.out.println("*************************************");
        System.out.println();
        System.out.println("Please enter your choice:");
        System.out.println("1. Login.");
        System.out.println("2. View Profile.");
        System.out.println("3. Update Profile.");
        System.out.println("4. View All Stock Alerts");
        System.out.println("5. View Stock Levels");
        System.out.println("6. Update Stock Levels");
        System.out.println("7. View Product Details");
        System.out.println("8. View Active Stock Alert Details");
        System.out.println("9. View Resolved Stock Alert Details");
        System.out.println("10. Update Alert");
        System.out.println("Type q or Q to exit.");
        }
        public void login(){
            try {
            System.out.println("Login:");
            System.out.println();
            System.out.print("Enter Username: ");
            String userName = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            if(manageEmployeeAccountBean.loginUser(userName, password)) {
                employee = (EmployeeEntity)manageEmployeeAccountBean.getEmployee(userName);
                location = employee.getLocation();
                retailer = employee.getRetailer();
            }   System.out.println("Login Successful");
        } catch (Exception e) {
            System.err.println("Caught an unexpected error");
            e.printStackTrace();
        }
        }
        public void viewProfile(){
            System.out.println("Username: " + employee.getStaffUsername());
            System.out.println("Password: " + employee.getStaffPassword());
            System.out.println("Contact: " + employee.getStaffContact());
            System.out.println("Address: " + employee.getStaffAddress());
            System.out.println("Email: " + employee.getStaffEmail());
            System.out.println("Job Title: " + employee.getJobTitle());
            System.out.println("Location:" + employee.getLocation().getLocationName());
            System.out.println("Retailer:" + employee.getRetailer().getRetailerName());
            
        }
        public void updateProfile(){
             try {
            System.out.println("Update User Account:");
            System.out.println();
                System.out.print("Enter default password: ");
                String password = sc.nextLine();
                System.out.print("Enter contact number: ");
                String contact = sc.nextLine();
                Long ctc = Long.parseLong(contact);
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter address: ");
                String address = sc.nextLine();
                if(manageEmployeeAccountBean.updateProfile(employee.getStaffUsername(), ctc, address, email, password))
                System.out.println("Profile Updated");
                else {
                System.out.println();
                System.out.println("Error! Update Failed");
            }
        } catch (Exception e) {
            System.err.println("Caught an unexpected error");
            e.printStackTrace();
        }
        }
        
        
        public void viewStockAlerts(){
            List<ArrayList> totalList = manageAlerts.viewAllAlerts(location.getLocationId());
            for(int i=0; i<totalList.size(); i++) {
                System.out.print("Stock Alert ID: ");
                System.out.println(totalList.get(i).get(0));
                System.out.print("Item ID: ");
                System.out.println(totalList.get(i).get(1));
                System.out.print("Item Name: ");
                System.out.println(totalList.get(i).get(2));
                System.out.print("Date: ");
                System.out.println(totalList.get(i).get(3));
                System.out.print("Quantity available currently: ");
                System.out.println(totalList.get(i).get(4));
                System.out.print("Location Name: ");
                System.out.println(totalList.get(i).get(5));
                System.out.print("Stock Alert Status: ");
                System.out.println(totalList.get(i).get(6));
                System.out.println("+++++++++++++++++++++++");
                System.out.println("+++++++++++++++++++++++");
            }
            
            
        }
        
        public void viewStockLevels(){
            System.out.println("Enter Item Id: ");
            String iD = sc.nextLine();
            Long itemId = Long.parseLong(iD);
            //item = em.find(ItemEntity.class, itemId);
            double qty = invManager.findStoreItemTypeStockQuantity(location.getLocationId(), itemId);
            System.out.println("Success");
            System.out.println("Current stock level for ItemID: " + itemId + "Name: " +item.getItemType().getItemName());
            System.out.println(qty);
        }
        
        public void viewProductDetails(){
            System.out.println("Enter Item Id: ");
            String iD = sc.nextLine();
            Long itemID = Long.parseLong(iD);
            item = em.find(ItemEntity.class, itemID);
            ItemEntity iTm = new ItemEntity();
            iTm = invManager.listStoreItem(location.getLocationId(), itemID);
            System.out.print("Test321");
            System.out.println("Item ID: " + iTm.getItemId());
            //System.out.println("Barcode ID: " + iTm.getBarcodeId());
            System.out.println("Status: " + iTm.getStatus());
            System.out.println("Item Name: " + iTm.getItemType().getItemName());
            System.out.println("Item Description: " + iTm.getItemType().getItemDescription());
            System.out.println("Item Category: " + iTm.getItemType().getItemCategory());
            System.out.println("Item Subcategory: " + iTm.getItemType().getItemSubCategory());
            System.out.println("Item Selling Price: " +  iTm.getItemType().getItemSalePrice());
            System.out.println("Item Cost Price: " + iTm.getItemType().getItemBasePrice());
            
        }
        public void  updateStockLevel(){
            String iD = sc.nextLine();
            Long itemID = Long.parseLong(iD);
            item = em.find(ItemEntity.class, itemID);
            System.out.println("Barcode ID: " );
            String bID = sc.nextLine();
            Long barcodeID = Long.parseLong(bID);
            //item.getRfId(barcodeID);
            System.out.println("Item Status: " );
            String itemStatus = sc.nextLine();
            item.setStatus(itemStatus);
            System.out.println("Item Location ID: " );
            String locID = sc.nextLine();
            Long locnID = Long.parseLong(locID);
            LocationEntity lE = new LocationEntity();
            lE = em.find(LocationEntity.class, locnID);
            item.setLocation(lE);
            System.out.println("Item Remarks: " );
            String remarks = sc.nextLine();
            item.setRemarks(remarks);
        }
        
        public void viewActiveAlerts(){
                 List<ArrayList> totalList = manageAlerts.viewActiveAlerts(location.getLocationId());
            for(int i=0; i<totalList.size(); i++) {
                System.out.print("Stock Alert ID: ");
                System.out.println(totalList.get(i).get(0));
                System.out.print("Item ID: ");
                System.out.println(totalList.get(i).get(1));
                System.out.print("Item Name: ");
                System.out.println(totalList.get(i).get(2));
                System.out.print("Date: ");
                System.out.println(totalList.get(i).get(3));
                System.out.print("Quantity available currently: ");
                System.out.println(totalList.get(i).get(4));
                System.out.print("Location Name: ");
                System.out.println(totalList.get(i).get(5));
                System.out.print("Stock Alert Status: ");
                System.out.println(totalList.get(i).get(6));
                
            }
        }
        public void viewResolvedAlerts(){
                 List<ArrayList> totalList = manageAlerts.viewResolvedAlerts(location.getLocationId());
            for(int i=0; i<totalList.size(); i++) {
                System.out.print("Stock Alert ID: ");
                System.out.println(totalList.get(i).get(0));
                System.out.print("Item ID: ");
                System.out.println(totalList.get(i).get(1));
                System.out.print("Item Name: ");
                System.out.println(totalList.get(i).get(2));
                System.out.print("Date: ");
                System.out.println(totalList.get(i).get(3));
                System.out.print("Quantity available currently: ");
                System.out.println(totalList.get(i).get(4));
                System.out.print("Location Name: ");
                System.out.println(totalList.get(i).get(5));
                System.out.print("Stock Alert Status: ");
                System.out.println(totalList.get(i).get(6));
                
            }
            
        }
        
        public void updateAlerts() {
            System.out.println("Enter Stock Alert ID: ");
            String sID = sc.nextLine();
            Long alertID = Long.parseLong(sID);
            String newStatus = sc.nextLine();
            manageAlerts.updateStockAlertStatus(alertID);
            
            System.out.println("Stock Alert set to Resolved");
            
        }
        
        public void  showError(){
        System.out.println();
        System.out.println("Error! Please input a number between 1-12 or 'q'/'Q' to exit!");
        }
    }

