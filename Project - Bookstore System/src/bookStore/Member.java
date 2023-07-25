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
 * The Member class represents a bookstore member with a name, membership type, and total and current amount spent.
 * It also has an ID which uniquely identifies the member.
 */
public class Member {
    private final String name;
    private final String membershipType;
    private double totalSpent;
    private double amountSpent;
    private final int id;
    
    /**
     * Constructs a new Member object with the given ID, name, and membership type. Initializes totalSpent to 0.0.
     * @param id The ID of the member.
     * @param name The name of the member.
     * @param membershipType The type of membership for the member.
     */
    public Member(int id, String name, String membershipType) {
        this.id = id;
        this.name = name;
        this.membershipType = membershipType;
        this.totalSpent = 0.0;
    }
    
    /**
     * Constructs a new Member object with the given ID, name, and membership type. Initializes totalSpent to 0.0.
     * @param id The ID of the member.
     * @param name The name of the member.
     * @param membershipType The type of membership for the member.
     */
    public String getName() {
        return name;
    }
    
     /**
     * Returns the type of membership for the member.
     * @return The type of membership for the member.
     */
    public String getMembershipType() {
        return membershipType;
    }
    
     /**
     * Returns the total amount spent by the member.
     * @return The total amount spent by the member.
     */
    public double getTotalSpent() {
        return totalSpent;
    }
    
    /**
     * Updates the total amount spent by the member by adding the given amount.
     * @param amount The amount to add to the total spent by the member.
     */
    public void updateTotalSpent(double amount) {
        this.totalSpent += amount;
    }
    
     /**
     * Returns the current amount spent by the member.
     * @return The current amount spent by the member.
     */
    public double getAmountSpent() {
        return amountSpent;
    }
    
    /**
     * Adds the given amount to the current amount spent by the member.
     * @param amount The amount to add to the current amount spent by the member.
     */
    public void addToTotalSpent(double amount) {
        this.amountSpent += amount;
    }
    
      /**
     * Returns the ID of the member.
     * @return The ID of the member.
     */
    public int getId() {
        return this.id;
    }

}


