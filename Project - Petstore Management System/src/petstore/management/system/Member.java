/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore.management.system;

/**
 *
 * @author Saul
 */

import java.util.ArrayList;
/**
* The member class represents a member of the pet store's membership program
*/
public class Member {
    /** The name of the member. */
    private String name;
    /** The unique ID number of the member. */
    private int memberID;
    /** Wheter or not a member is subscribed to the store's newsletter. */
    private boolean newsletterSubscribed;
    /** The list of dogs owned by the member.  */
    private ArrayList<Dog> dogsOwned = new ArrayList();
    /** The list of cats owned by the member */
    private ArrayList<Cat> catsOwned = new ArrayList();
    /** The list of exotic pets owned by the member. */
    private ArrayList<ExoticPet> exoticPetsOwned = new ArrayList();
    /** The amount of money the member has spent at the store. */
    private double amountSpent = 0;
    /** 
    * Constructor for the Member class
    *
    * @param name The name of the member.
    * @param memberID The unique ID number of the member.
    * @param newsletterSubscribed Whether or not the member is subscribed to the store's newsletter.
    */
    public Member(String name, int memberID, boolean newsletterSubscribed) {
        this.name = name;
        this.memberID = memberID;
        this.newsletterSubscribed = newsletterSubscribed;
    }
    /**
    * Returns the name of the member. 
    *
    * @return The name of the member.
    */
    public String getName() {
        return name;
    }

    /**
    * Returns the unique ID number of the member.
    *
    * @return The unique ID number of the number.
    */
    public int getMemberID() {
        return memberID;
    }

    /**
    * Returns whether or not the member is subscribed to the store's newsletter.
    *
    * @return Whether or not the member is subscribed to the store's newsletter.
    */ 
    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    /**
    * Returns the list of dogs owned by the member.
    *
    * @return The list of dogs owned by the member.
    */
    public ArrayList<Dog> getDogsOwned() {
        return dogsOwned;
    }

    /**
    * Returns the list of cats owned by the member.
    *
    * @return The list of cats owned by the member.
    */
    public ArrayList<Cat> getCatsOwned() {
        return catsOwned;
    }

    /**
    * Returns the list of exotic pet's owned by the member.
    *
    * @return The list of exotic pet's owned by the member.
    */
    public ArrayList<ExoticPet> getExoticPetsOwned() {
        return exoticPetsOwned;
    }
    
    /** 
    * Returns the amount of money the member has spent at the store.
    *
    * @return The amount of money the member has spent at the store.
    */
    public double getAmountSpent() {
        return amountSpent;
    }

    /**
    * Sets the name of the member.
    *
    * @param name The new name of the member.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Sets the unique ID number of the member.
    *
    * @param memberID The unique ID numbe of the member.
    */
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    /**
    * Sets whether or not the member is subscribed to the store's newsletter.
    *
    * @param newsletterSubscribed a boolean representing whether or not the member is subscribed to the store's newsletter.
    */
    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
    * Adds an amount to the total amount spent by the member.
    *
    * @param amountSpent a double representing the amount to be added to the total amount.
    */
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = this.amountSpent + amountSpent;
    }
    
    /**
    * Adds a dog to the list of dogs owned by the member.
    *
    * @param dog the dog to be added to the list of dogs owned by the member.
    */
    public void addDog(Dog dog) {
         dogsOwned.add(dog);
    }

    /**
    * Adds a cat to the list of cats owned by the member.
    *
    * @param cat the cat to be added to the list of cats owned by the member.
    */
    public void addCat(Cat cat) {
         catsOwned.add(cat);
    }
    /**
    * Adds an exotic pet to the list of exotic pets owned by the member.
    *
    * @param exoticPet the exotic pet to be added to the list of cats owned by the member.
    */
    public void addExoticPet(ExoticPet exoticPet) {
         exoticPetsOwned.add(exoticPet);
    }

    /**
    * Returns a String representation of Member object, including the members
    * ID number, name, membership type, and the list of pets they own
    * @return A String representation of the Member object 
    */
    @Override
    public String toString() {
        String petInfo = "";
        if (dogsOwned.size() > 0) {
            petInfo += "Dogs:\n";
            for (Dog dog : dogsOwned) {
                petInfo += "\t" + dog.getName() + "\n";
            }
        }
        
        if (catsOwned.size() > 0) {
            petInfo += "Cats:\n";
            for (Cat cat : catsOwned) {
                petInfo += "\t" + cat.getName() + "\n";
            }
        }

        if (exoticPetsOwned.size() > 0) {
            petInfo += "Exotic pets:\n";
            for (ExoticPet exoticPet : exoticPetsOwned) {
                petInfo += "\t" + exoticPet.getName() + "\n";
            }
        }
        
        return "Member ID: " + getMemberID() + "\n" +
        "Name: " + getName() + "\n" + 
        "Membership type: Free tier" + "\n" +
        "Pets owned: " + petInfo; 
    }
} // End Member class
