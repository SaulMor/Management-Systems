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
* A class representing a dog pet that extends the Pet class.
*/
public class Dog extends Pet {

    private String breed;
    /**
    * Creates a new instance of Dog.
    * @param name the name of the dog.
    * @param breed the breed of the dog.
    * @param sex the sex of the dog.
    * @param age the age of the dog.
    * @param weight the weight of the dog.
    * @param ID the ID number of the dog.
    * @param price the price of the dog.
    * @param stock the number of dogs in stock.
    */
    public Dog(String name, String breed, String gender, int age, double weight, int ID, double price, int stock) {
      super (name, "Dog", gender, age, weight, ID, price, stock);
      this.breed = breed;
    }

    /**
    * Gets the breed of the dog.
    *
    * @return breed of the dog.
    */
    public String getBreed() {
        return breed;
    }
    /**
    * Sets the breed of the dog.
    *
    * @param breed The new breed of the dog.
    */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /*
    * Returns a String representation of the dog.
    *
    * @return A string representation of the dog.
    */
    @Override
    public String toString() {
        return "Dog[ID: " + getID() + ", Name: " + getName() + ", Breed: " + getBreed() + ", Gender: " + getGender() + ", Age: " + getAge() + ", Weight: " + getWeight() + " lbs " + ", Price: $" +  getPrice() + ", Stock: " + getStock() +"]";
    }

} // End Dog class
