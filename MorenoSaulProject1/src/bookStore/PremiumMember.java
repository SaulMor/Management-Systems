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
 * A class representing a premium member in the bookstore's membership program.
 * Extends the Member class and adds additional properties and methods specific to premium members.
 */
public class PremiumMember extends Member {
    // Static counter used to generate unique IDs for each member
    private static int counter = 0;
    // The unique ID of the premium member
    private int id;
     // The type of the member (e.g. "Premium")
    private String type;
    // The payment method used by the member
    private String paymentMethod;
    // Whether or not the monthly fee has been paid for the current month
    private boolean monthlyFeePaid;
    
     /**
     * Constructor for creating a new PremiumMember object.
     * @param name The name of the member.
     * @param type The type of the member (e.g. "Premium").
     */
    public PremiumMember(String name, String type) {
        super(0, name, type); // Calls the constructor of the Member class with 0 points
        this.id = ++counter; // Generates a new unique ID for the member
        this.monthlyFeePaid = false; // The member has not paid their monthly fee by default
    }
    
     /**
     * Returns the unique ID of the premium member.
     * @return The unique ID of the premium member.
     */
    @Override
    public int getId() {
        return id;
    }
    
     /**
     * Returns the type of the member (e.g. "Premium").
     * @return The type of the member.
     */
    public String getType() {
        return type;
    }
    /**
     * Returns the payment method used by the member.
     * @return The payment method used by the member.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }
    /**
     * Sets the payment method used by the member.
     * @param paymentMethod The payment method to set.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
     /**
     * Returns whether or not the monthly fee has been paid for the current month.
     * @return True if the monthly fee has been paid, false otherwise.
     */
    public boolean isMonthlyFeePaid() {
        return monthlyFeePaid;
    }
     /**
     * Sets whether or not the monthly fee has been paid for the current month.
     * @param monthlyFeePaid True if the monthly fee has been paid, false otherwise.
     */
    public void setMonthlyFeePaid(boolean monthlyFeePaid) {
        this.monthlyFeePaid = monthlyFeePaid;
    }
    
     /**
     * Updates the monthly fee status of the member.
     * @param status True if the monthly fee has been paid, false otherwise.
     */
    public void updateMonthlyFeeStatus(boolean status) {
        this.monthlyFeePaid = status;
    }
}