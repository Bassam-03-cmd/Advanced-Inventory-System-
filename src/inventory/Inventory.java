/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inventory {
    static int Index = 0;
    Scanner keyboard = new Scanner(System.in);
    private final Product[] inv = new Product[30];

    public void inputProduct() {
        int choice;
        System.out.println("Choose product type: 1)Cable 2)Device");
        choice = keyboard.nextInt();
        while ((choice != 1) && (choice != 2)) {
            try {
                if (choice != 1 && choice != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                choice = keyboard.nextInt();
            }
        }
        if (choice == 1) {
            inv[Index] = new Cable();
        }
        if (choice == 2) {
            inv[Index] = new Device();
        }

        System.out.println("Enter product ID:");
        String id;
        id = keyboard.next();
        inv[Index].setID(id);
        System.out.println("Enter product name: ");
        String name;
        name = keyboard.next();
        inv[Index].setName(name);
        System.out.println("Enter product brand: ");
        String brand;
        brand = keyboard.next();
        inv[Index].setBrand(brand);
        if (choice == 1) {
            System.out.println("Enter product length: ");
            int length;
            length = keyboard.nextInt();
            inv[Index].setLength(length);
        }
        System.out.println("Enter product price: ");
        float price;
        price = keyboard.nextFloat();
        inv[Index].setPrice(price);
        System.out.println("Enter available quantity: ");
        int quantity;
        quantity = keyboard.nextInt();
        inv[Index].setQuantity(quantity);
        inv[Index].setChoice(choice);
        System.out.println("=================================================");
        System.out.println("          Product added successfully!");
        System.out.println("=================================================");
        Index++;
    }

    public void displayProduct(int location) {
        if (location >= 0) {
            System.out.println(inv[location]);
            if (inv[location].getChoice() == 1) {
                System.out.println("Length: " + inv[location].getLength());
            }
        } else {
            System.out.println("Product not found!");
        }
    }

    public void selectionSort() {
        for (int i = 0; i < Index - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < Index; j++) {
                if (inv[j].getName().compareTo(inv[smallestIndex].getName()) < 0) {
                    smallestIndex = j;
                }
            }
            Product temp = inv[smallestIndex];
            inv[smallestIndex] = inv[i];
            inv[i] = temp;
        }
    }
    public int seqSearch(String str) {
        for (int i = 0; i < Index; i++) {
            String name = inv[i].getName();
            if (name.equals(str)) {
                return i;
            }
        }
        return -1;
    }
    
    public void listAllItems() {
        for(int i = 0; i < Index; i++) {
            displayProduct(i);
        }
    }
    public void saveDataToFile() {
        try {
            FileWriter fw = new FileWriter("products.txt", true);
            for (int i = 0; i < Index; i++) {
                fw.write(inv[i].getChoice() + ",");
                fw.write(inv[i].getID() + ",");
                fw.write(inv[i].getName() + ",");
                fw.write(inv[i].getBrand() + ",");
                if (inv[i].getChoice() == 1) {
                    fw.write(inv[i].getLength() + ",");
                } else {
                    fw.write("0,");
                }
                fw.write(inv[i].getPrice() + ",");
                fw.write(inv[i].getQuantity() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile() {
        try {
            Scanner sc = new Scanner(new File("products.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                int choice = Integer.parseInt(parts[0].trim());
                if (choice == 1) {
                    inv[Index] = new Cable();
                } else {
                    inv[Index] = new Device();
                }
                inv[Index].setChoice(choice);
                inv[Index].setID(parts[1].trim());
                inv[Index].setName(parts[2].trim());
                inv[Index].setBrand(parts[3].trim());
                inv[Index].setLength(Integer.parseInt(parts[4].trim()));
                inv[Index].setPrice(Float.parseFloat(parts[5].trim()));
                inv[Index].setQuantity(Integer.parseInt(parts[6].trim()));
                Index++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearFile() {
        try {
            FileWriter fw = new FileWriter("products.txt", false);
            fw.write("");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}