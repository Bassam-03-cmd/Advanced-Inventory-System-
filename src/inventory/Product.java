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
public abstract class Product implements Interface {
    private String id;
    private String productName;
    private String brand;
    private float price;
    private int quantity;
    private int choice;

    public Product() {
        id = "null";
        productName = "null";
        brand = "null";
        price = 0.0f;
        quantity = 0;
        choice = 0;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getID() {
        return this.id;
    }

    public void setName(String n) {
        this.productName = n;
    }

    public String getName() {
        return this.productName;
    }

    public void setBrand(String b) {
        this.brand = b;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setPrice(float p) {
        this.price = p;
    }

    public float getPrice() {
        return this.price;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public abstract void setLength(int length);
    public abstract int getLength();

    @Override
    public String toString() {
        return this.id + " | " + this.productName + " | " + this.brand + " | " + this.price + " | " + this.quantity;
    }
}