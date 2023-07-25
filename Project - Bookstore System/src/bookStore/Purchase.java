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
 * A class representing a purchase made by a member for a certain product and quantity.
 */
public class Purchase {
    private Member member; // the member who made the purchase
    private Product product; // the product that was purchased
    private int quantity; // the quantity of the product that was purchased
    
    /**
     * Constructs a new Purchase object with the specified member, product, and quantity.
     * @param member the member who made the purchase
     * @param product the product that was purchased
     * @param quantity the quantity of the product that was purchased
     */
    public Purchase(Member member, Product product, int quantity) {
        this.member = member;
        this.product = product;
        this.quantity = quantity;
    }
     /**
     * Returns the member who made the purchase.
     * @return the member who made the purchase
     */
    public Member getMember() {
        return member;
    }
     /**
     * Returns the product that was purchased.
     * @return the product that was purchased
     */
    public Product getProduct() {
        return product;
    }
    
     /**
     * Returns the quantity of the product that was purchased.
     * @return the quantity of the product that was purchased
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates and returns the total cost of the purchase.
     * @return the total cost of the purchase
     */
    public double getTotalCost() {
        return product.getPrice() * quantity;
    }
    
     /**
     * Completes the purchase by removing the purchased quantity from the product's inventory
     * and updating the member's total spent amount.
     */
    public void completePurchase() {
        product.removeFromInventory(quantity);
        member.updateTotalSpent(getTotalCost());
    }
}