/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intrasyspos;

import javax.swing.UIManager;

/**
 *
 * @author ashiq
 */
public class IntrasysPOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    new Thread(){
       public void run() {
                
                try {
                    Thread.sleep(3500);
                    System.out.println("dd");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                new LoginUI().setVisible(true);
            }
       
    }.start();
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        } catch (Exception ex) {
            
        }
    }
    
}
