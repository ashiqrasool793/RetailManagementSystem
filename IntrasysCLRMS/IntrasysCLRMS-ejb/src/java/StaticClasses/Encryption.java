/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaticClasses;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author Kenneth
 */
public class Encryption {
    
    public static String SHA256(String password, String salt) throws NoSuchAlgorithmException {
        // Use SHA256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        byte byteArray[] = md.digest(password.getBytes());
        
        // Convert byte to hex format
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < byteArray.length; i++) {
            sb.append(Integer.toString((byteArray[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return new String(salt);
    }
    
    public static boolean checkPassword(String storedPassword, String inputPassword, String salt) throws NoSuchAlgorithmException {
        String hashedPassword = SHA256(inputPassword, salt);
        if(storedPassword.equals(hashedPassword)) {
            return true;
        }
        else {
            return false;
        }
    }
}
