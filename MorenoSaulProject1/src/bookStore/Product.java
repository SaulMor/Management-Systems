/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookStore;

/**
 *
 * @author Saul
 */
/**
 * A class representing a product in the bookstore inventory.
 */
public class Product {
    private final String name;  // the name of the product
    private final double price; // the price of the product
    private int inventoryCount; // the number of items in inventory

     /**
     * Constructs a new Product object with the given name and price.
     * The inventory count is set to zero initially.
     * @param name the name of the product
     * @param price the price of the product
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.inventoryCount = 0;
    }
    
     /**
     * Returns the name of the product.
     * @return the name of the product
     */
    public String getName() {
        return name;
    }
     /**
     * Returns the price of the product.
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }
    
     /**
     * Returns the current inventory count for the product.
     * @return the current inventory count for the product
     */
    public int getInventoryCount() {
        return inventoryCount;
    }
    
     /**
     * Sets the inventory count for the product.
     * @param inventoryCount the new inventory count for the product
     */
    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
    
     /**
     * Removes the specified quantity of the product from inventory.
     * Throws an exception if the specified quantity exceeds the current inventory count.
     * @param quantity the quantity of product to remove from inventory
     * @throws IllegalArgumentException if the specified quantity exceeds the current inventory count
     */
    public void removeFromInventory(int quantity) {
        if (inventoryCount >= quantity) {
            inventoryCount -= quantity;
        } else {
            throw new IllegalArgumentException("Quantity exceeds inventory count");
        }
    }
    
}