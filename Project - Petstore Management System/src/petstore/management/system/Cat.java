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
* A class representing a cat pet that extends the Pet class.
*/
public class Cat extends Pet {
    // Instance variable 
    private String breed; // instance variable breed for Cat
    
    /**
    * Creates a new instance of Cat.
    * @param name the name of the cat.
    * @param breed the breed of the cat.
    * @param gender the gender of the cat.
    * @param age the age of the cat.
    * @param weight the weight of the cat.
    * @param ID the ID number of the cat.
    * @param price the price of the cat.
    * @param stock the number of cats in stock.
    */
    public Cat(String name, String breed, String gender, int age, double weight, int ID, double price, int stock) {
        super (name, "Cat", gender, age, weight, ID, price, stock);
        this.breed = breed;
      
    }
    /**
    * Gets the breed of the cat.
    *
    * @return breed of the cat.
    */
    public String getBreed() {
        return breed;
    }

    /**
    * Sets the breed of the cat.
    *
    * @param breed The new breed of the cat.
    */
    public void setBreed(String breed) {
        this.breed = breed;
    }
    
    /*
    * Returns a String representation of the cat.
    *
    * @return A string representation of the cat.
    */
    @Override
    public String toString() {
        return "Cat[ID: " + getID() + ", Name: " + getName() + ", Breed: " + getBreed() + ", Gender: " + getGender() + ", Age: " + getAge() + ", Weight: " + getWeight() + " lbs " + ", Price: $" +  getPrice() + ", Stock: " + getStock() +"]";
    }
} // End Cat class

