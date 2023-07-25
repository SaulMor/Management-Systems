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
* This interface defines the specifications for a pet store, which includes for conducting
* an adoption drive and computing the inventory value.
*/
public interface PetStoreSpecification {
    /**
    * Conducts an adoption drive for the pet store with the given list of pets
    * and a specified discount.
    * @param pets an ArrayList of pets available for adoption
    * @param discount a double value representing the discount percentage for
    * the adoption drive.
    */ 
    public void adoptionDrive(ArrayList<Object> pets, double discount);

    /**
    * calculates and returns the total value of the pet store's inventory.
    * @return a double value representing the inventory value.
    */
   public double inventoryValue();
  

}
