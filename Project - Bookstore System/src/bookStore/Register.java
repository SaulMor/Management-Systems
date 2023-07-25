/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookStore;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saul
 */
/**
This class represents a register that manages the products and members in the bookstore.
*/
public class Register {
private List<Product> products; // list of products in the store
private List<Member> members; // list of members in the store

/**
Constructs a Register object with empty lists of products and members.
*/
    public Register() {
       products = new ArrayList<>();
       members = new ArrayList<>();
    }

/**
Adds a product to the list of products in the store.
@param product the product to add to the list
*/
    public void addProduct(Product product) {
     products.add(product);
    }

/**
Adds a member to the list of members in the store.
@param member the member to add to the list
*/
    public void addMember(Member member) {
      members.add(member);
    }

/**
Retrieves the list of products in the store.
@return the list of products
*/
    public List<Product> getProducts() {
     return products;
    }

/**
Retrieves the list of members in the store.
@return the list of members
*/
    public List<Member> getMembers() {
       return members;
    }

/**
Finds a product in the list of products by name.
@param productName the name of the product to find
@return the product with the given name, or null if not found
*/
    public Product findProduct(String productName) {
      for (Product product : products) {
        if (product.getName().equals(productName)) {
            return product;
          }
      }
    return null;
    }

/**
Finds a member in the list of members by name.
@param memberName the name of the member to find
@return the member with the given name, or null if not found
*/
    public Member findMember(String memberName) {
     for (Member member : members) {
        if (member.getName().equals(memberName)) {
            return member;
        }
     }
        return null;
    }

/**
Completes a purchase by updating the inventory count of the product and
the total amount spent by the member.
@param memberName the name of the member making the purchase
@param productName the name of the product being purchased
@param quantity the quantity of the product being purchased
*/
    public void completePurchase(String memberName, String productName, int quantity) {
    Member member = findMember(memberName);
    Product product = findProduct(productName);
    Purchase purchase = new Purchase(member, product, quantity);
    purchase.completePurchase();
    }

/**
Registers a premium member by creating a PremiumMember object and adding it to the list of members.
@param name the name of the premium member to register
*/
    public void registerPremiumMember(String name) {
    PremiumMember premiumMember = new PremiumMember(name, "Premium");
    addMember(premiumMember);
    }
}