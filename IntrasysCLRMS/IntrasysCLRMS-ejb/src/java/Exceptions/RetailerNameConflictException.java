/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Kenneth
 */
public class RetailerNameConflictException extends Exception{
    public RetailerNameConflictException() {
    }
    
    public RetailerNameConflictException(String msg) {
        super(msg);
    }
}
