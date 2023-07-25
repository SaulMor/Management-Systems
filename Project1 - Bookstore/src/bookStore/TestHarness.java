/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookStore;
/**
 *
 * @author Saul
 */
import java.util.Scanner;

public class TestHarness {

    private static final Scanner sc = new Scanner(System.in);
    private static Member member;
    private static final Inventory inventory = new Inventory();

    public static void main(String[] args) {
        // Add products to the inventory
        Product book = new Product("Book", 10.99);
        Product cd = new Product("CD", 15.99);
        Product dvd = new Product("DVD", 19.99);
        inventory.addProduct(book);
        inventory.addProduct(cd);
        inventory.addProduct(dvd);
        // Set the number of products 
         book.setInventoryCount(20);
         cd.setInventoryCount(20);
         dvd.setInventoryCount(20);
        // Menu options for user to select
        while (true) {
            System.out.println("Enter 1 to register as member");
            System.out.println("Enter 2 to register as premium member");
            System.out.println("Enter 3 to purchase products such as books, CDs, or DVDs");
            System.out.println("Enter 4 to check the total amount spent so far");
            System.out.println("Enter 5 to exit");
            System.out.println("Enter 6 to check the quantity of each product");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
            // Users Register as a regular member
                    System.out.print("Enter your name: ");
                    String name = sc.next();
                    member = new Member(0, name, "Regular");
                    System.out.println("You have successfully registered as a regular member with ID " + member.getId());
                    break;
                case 2:
              //Users Register as a premium member
        System.out.print("Enter your name: ");
        name = sc.next();
        System.out.print("Enter your payment method: ");
        String paymentMethod = sc.next();
        member = new PremiumMember(name, "Premium");
         // Set the payment method for the premium member
        ((PremiumMember) member).setPaymentMethod(paymentMethod);
        // Premium member is asked if they have paid their monthly fee
        System.out.print("Have you paid your monthly fee? (yes/no): ");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("no")) {
         member.addToTotalSpent(5);
        System.out.println("You have not paid your monthly fee. A fee of $5 will be charged to your account.");
        } else {
        System.out.println("You have successfully registered as a premium member with ID " + member.getId());
         break;
        }
        break;
                case 3:
        if (member == null) {
        System.out.println("Please register as a member first");
        } else {
        // Display the products in the inventory
        System.out.println("Products in the inventory: ");
        System.out.println("1. " + book.getName() + " - $" + book.getPrice());
        System.out.println("2. " + cd.getName() + " - $" + cd.getPrice());
        System.out.println("3. " + dvd.getName() + " - $" + dvd.getPrice());
        System.out.print("Enter the product number you want to purchase: ");
        int productNumber = sc.nextInt();
        Product product = null;
        // Determine which product was selected
        if (productNumber == 1) {
            product = book;
        } else if (productNumber == 2) {
            product = cd;
        } else if (productNumber == 3) {
            product = dvd;
        }
         if (product != null) {
             // Prompt user for the quantity of the product they want to purchase
            System.out.print("Enter the quantity you want to purchase: ");
               int quantity = sc.nextInt();
               double purchaseAmount = product.getPrice() * quantity;
          // If the member is a premium member, apply a 10% discount
               if (member instanceof PremiumMember) {
                   purchaseAmount *= 0.9;
                 }
            if (product.getInventoryCount() >= quantity) {
                System.out.println("You have purchased " + quantity + " " + product.getName() + " for $" + purchaseAmount);
                member.addToTotalSpent(purchaseAmount);
                product.setInventoryCount(product.getInventoryCount() - quantity);
            } else {
                System.out.println("Sorry, the product is out of stock.");
            }
        } else {
            System.out.println("Invalid product number. Please try again.");
        }
    }
    break;
                        case 4:
                if (member == null) {
            System.out.println("Please register as a member first");
                        } else {
            System.out.println("You have spent a total of $" + member.getAmountSpent());
                }
                break;
                case 5:
            System.out.println("Exiting the system..."
                    + "Thank you for shopping with us");
            System.exit(0);
                break;
                default:
            System.out.println("Invalid choice. Please try again.");
            break;
            // Quantity of each item in the inventory left
                case 6:
                    System.out.println("Here is the inventory quantity of each product:");
                    System.out.println("Quantity of Books left: " + book.getInventoryCount());
                    System.out.println("Quantity of DVDs left: " + dvd.getInventoryCount());
                    System.out.println("Quantity of CDs left: " + cd.getInventoryCount());
                    
            }
        }
    }
}
