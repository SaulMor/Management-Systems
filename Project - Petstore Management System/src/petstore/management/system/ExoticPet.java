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
* The ExoticPet class represents a type of "Pet" that is exotic. It extends the Pet class and inherits its properties.
* It contains a species field, which is a String that represents the exotic pets species.
*/
public class ExoticPet extends Pet {
    
    private String species;
 
     /**
    * Creates a new instance of ExoticPet.
    * @param name the name of the exotic pet.
    * @param species the species of the exotic pet.
    * @param gender the gender of the exotic pet.
    * @param age the age of the exotic pet.
    * @param weight the weight of the exotic pet.
    * @param ID the ID number of the exotic pet.
    * @param price the price of the exotic pet.
    * @param stock the number of exotic pets in stock.
    */
    public ExoticPet(String name, String species, String gender, int age, double weight, int ID, double price, int stock) {
        super(name, species, gender, age, weight, ID, price, stock);
        this.species = species;
    }

     /**
    * Gets the species of the exotic pet.
    *
    * @return species of the exotic pet.
    */
    public String getSpecies() {
        return species;
    }

    /**
    * Sets the species of the exotic pet.
    *
    * @param species The new species of the exotic pet.
    */
    public void setSpecies(String species) {
        this.species = species;
    }

    /*
    * Returns a String representation of the exotic pet.
    *
    * @return A string representation of the exotic pet.
    */
    @Override
    public String toString() {
        return "ExoticPet[ID: " + getID() + ", Name: " + getName() + ", Species: " + getSpecies() + ", Gender: " + getGender() + ", Age: " + getAge() + ", Weight: " + getWeight() + " lbs " + ", Price: $" +  getPrice() + ", Stock: " + getStock() +"]";
    }
} // End ExoticPet class

