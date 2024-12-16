package inventory;

import java.util.Scanner;
import java.util.InputMismatchException;
public class MainInventory {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        int choice = 0;
        Scanner obj = new Scanner(System.in);
        while (true) {
            System.out.println("1. List Inventory");
            System.out.println("2. Search for a product");
            System.out.println("3. Add new product");
            System.out.println("4. Sort inventory");
            System.out.println("5. Save data to file");
            System.out.println("6. Load data from file");
            System.out.println("7. Clear file");
            System.out.println("8. Quit");
            System.out.println("");
            System.out.println("Enter your choice: ");
            choice = obj.nextInt();
            int are[]= {1,2,3};
            while (choice < 1 || choice > 8){
                try{
                    throw new MyException("Out of range1", are);
                }catch (MyException e){
                    for(int i = 0; i < e.arr.length; i++){
                        System.out.println(e.arr[i]);
                    }
                    choice = obj.nextInt();
                }    
            }
            
            if (choice == 1) {
                System.out.println("==============================================");
                System.out.println("          Listing all product.....");
                System.out.println("==============================================");
                inventory.listAllItems();
                System.out.println("");
            }
            if (choice == 2) {
                System.out.println("==============================================");
                System.out.println("          searching for product.....");
                System.out.println("==============================================");
                System.out.println("");
                System.out.println("Enter item name: ");
                String search = obj.next();
                int loc = inventory.seqSearch(search);
                inventory.displayProduct(loc);
                System.out.println("");
                System.out.println("");
            }
            if (choice == 3) {
                System.out.println("==============================================");
                System.out.println("          Adding new product.....");
                System.out.println("==============================================");
                inventory.inputProduct();
                System.out.println("");
                System.out.println("");
            }
            if (choice == 4) {
                inventory.selectionSort();
                System.out.println("==============================================");
                System.out.println("          Inventory has been sorted!");
                System.out.println("==============================================");
            }
            if (choice == 5) {
                inventory.saveDataToFile();
                System.out.println("==============================================");
                System.out.println("          Data saved to file!");
                System.out.println("==============================================");
            }
            if (choice == 6) {
                inventory.loadDataFromFile();
                System.out.println("==============================================");
                System.out.println("          Data loaded from file!");
                System.out.println("==============================================");
            }
            if (choice == 7) {
                inventory.clearFile();
                System.out.println("==============================================");
                System.out.println("          File cleared!");
                System.out.println("==============================================");
            }
            if (choice == 8) {
                break;
            }
        }
    }

}