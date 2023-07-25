/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore.management.system;

import java.util.ArrayList;

/**
 *
 * @author Saul
 */

/**
* A class that represents a premium member of the pet store
* Premium members have access to additional benefits, such as discounts.
*
*
*/
public class PremiumMember extends Member {
    
    private boolean duesPaid;

    /**
    * Constructs a new PremiumMember object with the specified name, member ID, newsletter subscription status,
    * and dues paid status.
    *
    * @param name the name of the premium member.
    * @param memberID the ID number of the premium member.
    * @param newsletterSubscribed true if the premium member has subscribed to the store's newsletter.
    * @param duesPaid true if the premium member has paid their dues; false otherwise
    * */

    public PremiumMember(String name, int memberID, boolean newsletterSubscribed, boolean duesPaid) {
        super(name, memberID, newsletterSubscribed);
        this.duesPaid = duesPaid;
    }
    /**
    * Returns true if the premium member has paid their dues; false otherwise.
    *
    * @return true if the premium member has paid their dues; false otherwise.
    */ 
    public boolean isDuesPaid() {
        return duesPaid;
    }
    
    /**
    * Sets the dues paid status of the premium member.
    *
    * @param duesPaid true if the premium member has paid their dues; false otherwise.
    */ 
    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }
    
    /**
    * Returns a String representation of PremiumMember object, including the members
    * ID number, name, membership type, and the list of pets they own
    * @return A String representation of the PremiumMember object 
    */
    @Override
    public String toString() {
        String petInfo = "";
        if (getDogsOwned().size() > 0) {
            petInfo += "Dogs:\n";
            for (Dog dog : getDogsOwned()) {
                petInfo += "\t" + dog.getName() + "\n";
            }
        }
        
        if (getCatsOwned().size() > 0) {
            petInfo += "Cats:\n";
            for (Cat cat : getCatsOwned()) {
                petInfo += "\t" + cat.getName() + "\n";
            }
        }

        if (getExoticPetsOwned().size() > 0) {
            petInfo += "Exotic pets:\n";
            for (ExoticPet exoticPet : getExoticPetsOwned()) {
                petInfo += "\t" + exoticPet.getName();
            }
        }
        
        return "Member ID: " + getMemberID() + "\n" +
        "Name: " + getName() + "\n" + 
        "Membership type: Premium" + "\n" +
        "Pets owned: " + petInfo; 
    }
} // End PremiumMember class

