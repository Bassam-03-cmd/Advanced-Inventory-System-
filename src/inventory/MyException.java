/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

/**
 *
 * @author DELL
 */
public class MyException extends RuntimeException{
    int arr[];
    public MyException() {
    }
    public MyException(String msg, int arr[]){
        super(msg);
        this.arr = arr;
    }
    
    
    
}
