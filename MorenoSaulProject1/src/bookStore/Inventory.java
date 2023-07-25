/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookStore;

import java.util.ArrayList;

/**
 *
 * @author Saul
 */
/**
 * The Inventory class represents the inventory of products available in the store.
 * It contains methods for adding products, getting and updating product inventory count.
 */
public class Inventory {
    private ArrayList<Product> products;
    
    /**
     * Constructor for Inventory class. Initializes an empty list of products.
     */
    public Inventory() {
        this.products = new ArrayList<>();
    }
    
    /**
     * Adds a product to the list of products in the inventory.
     *
     * @param product The product to be added to the inventory.
     */
    public void addProduct(Product product) {
        products.add(product);
    }
    
     /**
     * Returns the current inventory count of a product.
     *
     * @param product The product whose inventory count is to be returned.
     * @return The inventory count of the product.
     */
    public int getProductInventoryCount(Product product) {
        return product.getInventoryCount();
    }
    
    /**
     * Updates the inventory count of a product.
     *
     * @param product The product whose inventory count is to be updated.
     * @param count   The new inventory count of the product.
     */
    public void updateProductInventoryCount(Product product, int count) {
        int currentCount = product.getInventoryCount();
        product.setInventoryCount(currentCount + count);
    }
    
     /**
     * Decrements the inventory count of a product by a specified amount.
     *
     * @param product The product whose inventory count is to be decremented.
     * @param count   The amount by which to decrement the inventory count.
     */
    public void decrementProductInventoryCount(Product product, int count) {
        int currentCount = product.getInventoryCount();
        if (currentCount < count) {
            System.out.println("Not enough stock.");
            return;
        }
        product.setInventoryCount(currentCount - count);
    }
}