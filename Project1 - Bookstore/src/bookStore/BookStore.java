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
 * Represents a bookstore.
 */
public class BookStore {
  private List<Member> members;
    private List<Product> products;
    private List<Purchase> purchases;
  
  /**
   * Constructs a new bookstore with empty lists of members, products, and purchases.
   */
  public BookStore() {
        this.members = new ArrayList<>();
        this.products = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }
  
   /**
   * Finds a member with the given ID.
   *
   * @param memberId the ID of the member to find.
   * @return the member with the given ID, or null if not found.
   */
  public Member getMemberById(int memberId) {
    for (Member member : members) {
      if (member.getId() == memberId) {
        return member;
      }
    }
    return null;
  }
   /**
   * Adds a purchase to the bookstore's list of purchases.
   *
   * @param purchase the purchase to add.
   */
  public void addPurchase(Purchase purchase) {
    purchases.add(purchase);
}
   /**
   * Adds a member to the bookstore's list of members.
   *
   * @param member the member to add.
   */
 public void addMember(Member member) {
        members.add(member);
    }

}
