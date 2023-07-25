/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore.management.system;

/**
 *
 * @author Saul
 */
/**
* The Pet class represents a pet that can be bought, sold, or adopted by a customers in the pet store.
* This is an abstract class, so it cannot be instantiated directly
* but it provides a common interface and implementation for all types of pets.
*/

public abstract class Pet implements Comparable<Pet> {
    // instance variables
    private String name;
    private double price;
    private int stock;
    private String species; 
    private String gender; 
    private int age; 
    private double weight;
    private int ID; 

    /**
    * Constructor for the Pet class
    *
    * @param name The name of the pet.
    * @param species the species of the pet.
    * @param gender The gender of the pet
    * @param age The age of the pet.
    * @param weight The weight of the pet.
    * @param ID The ID of the pet.
    * @param price The price of the pet.
    # @param stock The amount of the pet in stock.
    */
    public Pet(String name, String species, String gender, int age, double weight, int ID,  double price, int stock) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price = price;
        this.stock = stock;
    }

    //Getters and Setters

    /**
    * Gets the name of the pet.
    *
    * @return The name of the pet.
    */ 
    public String getName() {
        return name;
    }

    /**
    * Sets the name of the pet.
    *
    * @param name The new name of the pet.
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
    * Gets the price of the pet.
    *
    * @return The price of the pet.
    */
    public double getPrice() {
        return price;
    }

    /**
    * Sets the price of the pet.
    *
    * @param price The new price of the pet.
    */ 
    public void setPrice(double price) {
        this.price = price;
    }

    /**
    * Get the amount of the pet in stock.
    *
    * @return The amount of the pet in stock.
    */
    public int getStock() {
        return stock;
    }

    /** 
    * Set the amount of the pet in stock.
    *
    * @param stock The new amount of the pet in stock.
    */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
    * Gets the species of the pet.
    *
    * @return The species of the pet.
    */
    public String getSpecies() {
        return species;
    }
    
    /**
    * Set the species of the pet.
    *
    * @param species The new species of the pet. 
    */ 
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
    * Gets the gender of the pet.
    *
    * @return The gender of the pet.
    */ 
    public String getGender() {
        return gender;
    }

    /**
    * Set the gender of the pet.
    *
    * @param gender The new gender of the pet.
    */ 
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
    * Get the age of the pet.
    *
    * @return The age of the pet.
    */
    public int getAge() {
        return age;
    }

    /**
    * Sets the age of the pet.
    *
    * @param age The new age of the pet.
    */
    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    /**
    * Sets the weight of the pet.
    *
    * @param weight The new weight of the pet.
    */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
    * Get the ID number of the pet.
    *
    * @return The ID number of the pet.
    */
    public int getID() {
        return ID;
    }

    /**
    * Sets the ID number of the pet.
    *
    * @param ID The new ID number of the pet.
    */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
    * Compares the Pet object with another Pet object based on their price.
    * @param other The Pet object to compare to.
    * @return a negative number, zero, or a positive intger as this Pet is less than, equal to, or greater than the specified Pet
    */
    @Override
    public int compareTo(Pet other) {
        return Double.compare(this.price, other.price);
    }
} // End Pet class


