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
interface Interface {
    
    int seqSearch(String str); 
    /*
    The function searches the inventory for a given string
        which is assumed to be exact match for the name of
        a product stored in the inventory.

    Pre-condition: "str" actual parameter should not be NULL and 
        should be an exact match of one or more product names 
        in the inventory. 
    Post-condition: if one or more exact matches of "str"
        are found in the inventory, the location of first 
        product record is returned, otherwise "-1" is returned 
        indicating a product name with an exact match does not
        not exist in the inventory.   
     */    
    
    void selectionSort();
    /*
    The function sorts the inventory in ascending order by 
    product name.

    Pre-condition: None
    Post-condition: if the inventory has products, then products 
        are sorted alphabetically in ascending order by product
        name.
    */
    
    void inputProduct();
    /*
    The function prompts the user interactively to enter product 
        id, name, price, and brand.

    Pre-condition: None
    Post-condition: adds one product to inventory and increment
        the size of the inventory by 1.
    */
    
    void displayProduct(int loc);
    /*
    The function display on the screen a product found at 
        location "loc".

    Pre-condition: "loc" is an integer greater or equals to zero.
    Post-condition: prints a product record on the screen if 
        0 <= loc < inventory size. Otherwise nothing is printed.
        The product is displayed in one line in the following 
            format:
            id | product name | price | brand.
    */
    
    void listAllItems();
    /*
    The function prints sequentially the content of the inventory 
        to the screen using the displayProduct function.

    Pre-condition: None.
    Post-condition: inventory not changed,
    */
    
}