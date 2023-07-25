/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petstore.management.system;

/**
 *
 * @author Saul
 */
import java.util. *;
/**
* This class contains the main method to run the PetStore application.
* It initializes a PetStore object, displays a menu of options to the user, 
* and allows the user to interact with the PetStore by selecting from the menu.
*/
public class Main {
    // main method
    public static void main(String[] args) {
        // Initialize Scanner object to read user input
        Scanner scnr = new Scanner(System. in);
        // Create new PetStore object
        PetStore ps = new PetStore("Saul's Premier Pet Emporium");
        // Diplay welcome message with store name
        System.out.println("**** Welcome to " + ps.getStoreName() + "****");
        // loop to display menu options until user decides to exit:
        while (true) {
            // Display menu options:
            System.out.println("Please select from one of the following menu options"); 
            System.out.println("\t1. Buy a new pet"); // Allows the user to purchase a pet from the pet store
            System.out.println("\t2. Register a new member"); // Allows the user register as a new member
            System.out.println("\t3. Start adoption drive (add new pets)"); // Allows the user to add pets to the store's inventory
            System.out.println("\t4. Check current inventory"); // Allows the user to check the current inventory of pets in the store
            System.out.println("\t5. Register new pet to Owner profile"); // Allows the user to register a new pet to an existing member's profile 
            System.out.println("\t6. Compare pets"); // Allows the user to compare pets based on price
            System.out.println("\t7. Restock a pet"); // Allows the user to restock a pet in the store's inventory
            System.out.println("\t8. View all members"); // Allows the user to view all current members in the store
            System.out.println("\t9. Exit"); // Exits the program
            
            // Read user's choice of for menu options:
            int choice1 = scnr.nextInt();

            switch (choice1) {
                case 1:
                    System.out.println("-----------------------------------");
                    purchase(ps, scnr, new ArrayList<Pet>());
                    break;
                case 2:
                    System.out.println("-----------------------------------");
                    registerNewMember(ps, scnr);
                    break;
                case 3:
                    System.out.println("-----------------------------------");
                    adoptionDrive(ps, scnr);
                    break;
                case 4:
                    System.out.println("-----------------------------------");
                    ps.displayInventory();
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    registerNewPet(ps, scnr);
                    break;
                case 6:
                    System.out.println("-----------------------------------");
                    compareProducts(ps, scnr);
                    break;
                case 7:
                    System.out.println("-----------------------------------");
                    restockProduct(ps, scnr);
                    break;
                case 8:
                    System.out.println("-----------------------------------");
                    ps.displayAllMembers(ps);
                    break;
                case 9:
                    System.out.println("Thanks for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    /**
    * This method allows the user to purchase a pet from the pet store.
    * The user is prompted to select the type of pet to purchase (dogs, cat, and exotic pets).
    *
    * @param petStore The PetStore object containing the inventory of available pets.
    * @param scnr The scanner object used to recieve user input.
    * @param cart The ArrayList of Pet objects representing the user's shopping cart.
    */
    private static void purchase(PetStore petStore, Scanner scnr, ArrayList<Pet> cart) {
        // Prompt user to select what type of pet to purchase by selecting 1, 2, or 3
        System.out.println("What type of pet are you here to purchase?");
        System.out.println("\t1. Dogs");
        System.out.println("\t2. Cats"); 
        System.out.println("\t3. Exotic Pets");

        int petTypeChoice = scnr.nextInt();

        // display inventory menu
        // Display inventory for Dog Selection
        int itemNum = 1;
        if (petTypeChoice == 1) {
            ArrayList<Dog> inventory = petStore.getAvailableDogs();
            if (!inventory.isEmpty()) {

                System.out.println("Which of the following dogs would you like to purchase?:");

                for (Dog pet : inventory) {
                    System.out.println(
                        "\t" + itemNum + ". $" + pet.getPrice() + " - " + pet.getBreed() + "(" + pet.getName() +
                        ")"
                    );
                    itemNum++;
                }
                // get user selection and add the selected dog to the arraylist (cart)
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));
                    //update inventory for this item
                    petStore.removePet("dog", choice - 1);
                    
                    // User cart summary
                    System.out.println(
                        "You have " + cart.size() + " items in your cart. Are you done shopping?"
                    );
                    for (Pet pet : cart) {
                        System.out.println(pet.toString());
                    }

                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    scnr.nextLine(); //Consume the new line character
                    
                    if (doneShopping == 1) {
                        //System.out.println("TO DO - CHEKOUT ");
                        checkout(petStore, scnr, cart); // Proceed to checkout if user is done shopping
                    } else if (doneShopping == 2) { // continue shopping
                        purchase(petStore, scnr, cart); // recursively call purchase(...) until done
                    } else {
                        System.out.println("Invalid Choice.");
                    }
                } else {
                    System.out.println("Please enter a valid product number. Try again");
                    purchase(petStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry! we currently have no dogs available.");
            }

        }

        // Display inventory for cats 
        else if (petTypeChoice == 2) {
            ArrayList<Cat> inventory = petStore.getAvailableCats();
            if (!inventory.isEmpty()) {
                System.out.println("Which of the following cats would you like to purchase");
                for (Cat pet : inventory) {
                    System.out.println(
                        "\t" + itemNum + ". $" + pet.getPrice() + " - " + pet.getBreed() + "(" + pet.getName() +
                        ")"
                    );
                    itemNum++;
                }
                // Get the users selection and add the selected cat to the cart
                int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));                  
                    petStore.removePet("cat", choice - 1);
                    // Display thr cart summary and prompt the user to continue shopping
                    System.out.println(
                        "You have " + cart.size() + " items in your cart. Are you done shopping?"
                    );
                    for (Pet pet : cart) {
                        System.out.println(pet.toString());
                    }
                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");

                    int doneShopping = scnr.nextInt();
                    scnr.nextLine(); // Consume the new line character

                    if (doneShopping == 1) {
                        //System.out.println("TO DO - CHEKOUT ");
                        checkout(petStore, scnr, cart);
                    } else if (doneShopping == 2) { // more shopping
                        purchase(petStore, scnr, cart); // recursively call purchase(...) until done
                    } else {
                        System.out.println("Invalid Choice.");
                    }
                } else {
                    System.out.println("Please enter a valid number. Try again");
                    purchase(petStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry no more cats available");
            }
        } // end display inventory for cats
        
        // Diplay inventory for Exotic Pets
        else if (petTypeChoice == 3) {
            ArrayList<ExoticPet> inventory = petStore.getAvailableExoticPets();
            if (!inventory.isEmpty()) {
                System.out.println("Which of the following exotic pets would you like to purchase?:");

                for (ExoticPet pet : inventory) {
                    System.out.println(
                         "\t" + itemNum + ". $" + pet.getPrice() + " - " + pet.getSpecies() + "(" + pet.getName() + ")"
                    );
                    itemNum++;
                }
                 int choice = scnr.nextInt();
                if (choice <= inventory.size()) {
                    cart.add(inventory.get(choice - 1));                  
                    petStore.removePet("exotic", choice - 1);

                    // User cart summary
                    System.out.println(
                        "You have " + cart.size() + " items in your cart. Are you done shopping?"
                    );
                    for (Pet pet : cart) {
                        System.out.println(pet.toString());
                    }

                    System.out.println("\t1. Yes");
                    System.out.println("\t2. No");
                    int doneShopping = scnr.nextInt();
                    scnr.nextLine(); // Consume the new line character

                    if (doneShopping == 1) {
                        //System.out.println("TO DO - CHEKOUT ");
                        checkout(petStore, scnr, cart);
                    } else if (doneShopping == 2) { // more shopping
                        purchase(petStore, scnr, cart); // recursively call purchase(...) until done
                    } else {
                        System.out.println("Invalid Choice.");
                    }
                } else {
                    System.out.println("Please enter a valid number. Try again");
                    purchase(petStore, scnr, cart);
                }
            } else {
                System.out.println("Sorry no more exotic pets available");
            }
        } // end display inventory for exotic pets

    } // end purchase method
    
    /**
    * This method handles the checkout process for the pet store.
    * It calculates the total price for the purchased pets in the
    * cart, prompts the user to select the member making the purchase
    * and handles the member selection and payment process.
    * @param petStore The PetStore object containing the inventory of available pets.
    * @param scnr The scanner object used to recieve user input.
    * @param cart The ArrayList of Pet objects representing the user's shopping cart.
    */
    private static void checkout(PetStore petStore, Scanner scnr, ArrayList<Pet> cart) {
        // calculate total
        double total = 0;
        for (Pet pet : cart) {
            total += pet.getPrice();
        }
        // Prompt user to select the member making the purchase
        System.out.println(
            "Your total comes to " + "$" + total + ". \nPlease select which member is making this" +
            " purchase."
        );

        // List all available members and option to register a new member
        int num = 1;
        for (Member member : petStore.getMemberList()) {
            System.out.println(num + ". " + member.getName());
            num++;
        }
        for (PremiumMember member : petStore.getPremiumMemberList()) {
            System.out.println(num + ". " + member.getName());
            num++;
        }
        System.out.println(num + ". Register a new Member.");

        System.out.println(""); // space line
        int memberSelect = scnr.nextInt();
        Member purchaser = null;
        PremiumMember premiumPurchaser = null;

        // Handle invalid user selection
        if (memberSelect > petStore.getMemberList().size() + petStore.getPremiumMemberList().size() + 1) { // invalid selection
            System.out.println("Invalid Selection");
            checkout(petStore, scnr, cart); // recursive call if valid user input

        } else { // Handle valid selection
            if (memberSelect == (petStore.getMemberList().size() + petStore.getPremiumMemberList().size()) + 1) { // adding a new member
                boolean premium = registerNewMember(petStore, scnr); // Register a new member and check if they want to be a premium member
                if (premium) {
                    premiumPurchaser = petStore.getPremiumMemberList().get(
                        petStore.getPremiumMemberList().size() - 1
                    );
                } else {
                    purchaser = petStore.getMemberList().get(petStore.getMemberList().size() - 1);
                }
            } else if (memberSelect <= (petStore.getMemberList().size())) { // Existing regular member
                purchaser = petStore.getMemberList().get(memberSelect - 1);
            } else { // existing premium member
                premiumPurchaser = petStore.getPremiumMemberList().get(
                    memberSelect - petStore.getMemberList().size() - 1
                );
            }

            // check if premium member and fees are due
            if (purchaser == null && premiumPurchaser != null) { // Handle premium member 
                if( !premiumPurchaser.isDuesPaid()){
                System.out.println(
                    "Premium Membership dues unpaid, $5 will be added to purchase total to cover du" +
                    "es."
                );
                total += 5;
                }
                premiumPurchaser.setDuesPaid(true);
                // update amount of purchases for this member
                premiumPurchaser.setAmountSpent(total);
                // done
                System.out.println("Your purchase total was: " + total);
                System.out.println(
                    "Congrats on your purchase " + premiumPurchaser.getName() + "!");

            } else { // Handle regular member
                // update amount of purchases for this member
                purchaser.setAmountSpent(total);
                System.out.println("Your purchase total was: " + total);
                System.out.println("Congrats on your purchase " + purchaser.getName() + "!");

            }
        }
    } // End checkout method

    /**
    * This method prompts the user to register as a new member, either free tier or premium
    * then adds to to the PetStore's list of members with a new member ID. It returns true if
    * the user chooses to register as a premium member and false otherwise.
    *
    * @param petStore the PetStore object to add the new member to
    * @param scnr the Scanner object to read input from the user
    * @return true if the user chooeses to register as a premium member and false otherwise.
    */
    private static boolean registerNewMember(PetStore petStore, Scanner scnr) {
        // prompt user to select membership type
        System.out.println("Let's get you registered as a new Member!");
        System.out.println( "Would you like to register as a free-tier or premium member?");
        System.out.println("\t1. Free-tier");
        System.out.println("\t2. Premium");

        // user selection
        int choice1 = scnr.nextInt();
        // if user selects a wrong choice 
        if (choice1 > 2 || choice1 < 1) {
            System.out.println("Invalid choice.");
            registerNewMember(petStore, scnr); // try again

        } else {
            // prompt user for name 
            System.out.println("Please enter your name:");
            scnr.nextLine();
            String name = scnr.nextLine();

            boolean isPremium = (choice1 == 2);
            petStore.addNewMember(name, isPremium);
            int memberId = petStore.getNextMemberID() - 1;

            System.out.println("Welcome to our membership program: " + name + "!" + " Your New Member ID is: " + memberId);
            return isPremium;
        }
        return false;
    } // End registerNewMember method

    /**
    * Allows the user to compare the prices of two pets of the same type.
    * The user selects the type of pet to compare, and then selects two pets from the available inventory.
    * The method then displays the prices of the two pets.
    * 
    * @param petStore the PetStore object containing the inventory of pets.
    * @param scnr the Scanner object used to get user input
    */
    private static void compareProducts(PetStore petStore, Scanner scnr) {
        // Prompt users to select the type of pet to compare by selecting 1, 2, or 3
        System.out.println("Select the type of pet you want to compare:");
        System.out.println("\t1. Dogs");
        System.out.println("\t2. Cats");
        System.out.println("\t3. Exotic Pets");

        int productTypeChoice = scnr.nextInt();
        int firstPetIndex, secondPetIndex;

        if (productTypeChoice == 1 || productTypeChoice == 2 || productTypeChoice == 3) {
            ArrayList<Pet> petList;
            // Create the list of available pets based on the user's selection
            if (productTypeChoice == 1) {
                petList = new ArrayList<>(petStore.getAvailableDogs());
                System.out.println("Select two dogs to compare:");
            } else if (productTypeChoice == 2) {
                petList = new ArrayList<>(petStore.getAvailableCats());
                System.out.println("Select two cats to compare:");
            } else {
                petList = new ArrayList<>(petStore.getAvailableExoticPets());
                System.out.println("Select two Exotic pets to compare:");
            }
           
            // display the available pets for the user to choose from
            for (int i = 0; i < petList.size(); i++) {
                Pet pet = petList.get(i);
                System.out.println("\t" + (i + 1) + ". " + pet.getName() + " (" + pet.getSpecies() + ")");
            }

             // Get the users selection of two pets to compare
             firstPetIndex = scnr.nextInt() - 1;
             secondPetIndex = scnr.nextInt() - 1;
            // Retrieve the selected two pets and display their prices for comparsion
            Pet firstPet = petList.get(firstPetIndex);
            Pet secondPet = petList.get(secondPetIndex);

            System.out.println("Comparison of " + firstPet.getName() + " and " + secondPet.getName() + ":");
            System.out.println("Price:");
            System.out.println("\t" + firstPet.getName() + ": $" + firstPet.getPrice());
            System.out.println("\t" + secondPet.getName() + ": $" + secondPet.getPrice());
        } else {
            System.out.println("Invalid choice, try again.");
            compareProducts(petStore, scnr);
        }
    } // End CompareProducts Method

    /**
    * Method to restock products such as dogs, cats, and exotic pets
    *
    * @param petStore the PetStore object containing the inventory of pets.
    * @param scnr the Scanner object used to get user input
    */
    private static void restockProduct(PetStore petStore, Scanner scnr) {
        // Prompt user to select the type of pet to restock by selecting 1, 2, or 3.
        System.out.println("Select the type of pet you want to restock:");
        System.out.println("\t1. Dogs");
        System.out.println("\t2. Cats");
        System.out.println("\t3. Exotic Pets");

        int productTypeChoice = scnr.nextInt();
        // Prompt the user to enter the ID of the pet restock and the quantity to restock
        System.out.println("Enter the ID number of the pet you want to restock:");
        int petID = scnr.nextInt();

        System.out.println("Enter the quantity to restock:");
        int restockQuantity = scnr.nextInt();

        boolean success = false;
        // Switch statements to determine which type of pet to restock and call the corresponding restock method
        switch (productTypeChoice) {
            case 1:
                success = petStore.restockDog(petID, restockQuantity);
                break;
            case 2:
                success = petStore.restockCat(petID, restockQuantity);
                break;
            case 3:
                success = petStore.restockExoticPet(petID, restockQuantity);
                break;
            default:
                System.out.println("Invalid product type.");
                return;
        }
        // Display message indictating whether the restock was successful or not
        if (success) {
            System.out.println("Pet restocked successfully");
        } else {
            System.out.println("Error. Pet not found. Please try again");
            restockProduct(petStore, scnr);
        }
    } // End restock method

    /**
    * Method for adoption drive allowing users to add pets to the inventory
    *
    * @param petStore the PetStore object containing the inventory of pets.
    * @param scnr the Scanner object used to get user input
    */
    private static void adoptionDrive(PetStore petStore, Scanner scnr) {
        System.out.println("Welcome to the adoption drive!");
        System.out.println("What type of pet would you like to add?");
        System.out.println("\t1. Dog");
        System.out.println("\t2. Cat");
        System.out.println("\t3. Exotic Pet");

        int petTypeChoice = scnr.nextInt();
        scnr.nextLine(); // Consume the new line character
       
        // Prompt the user to add details about the new pet
        System.out.println("Enter the pet's name:");
        String name = scnr.nextLine();

        System.out.println("Enter the pet's breed/species:");
        String breed = scnr.nextLine();

        System.out.println("Enter the pet's gender:");
        String gender = scnr.nextLine();

        System.out.println("Enter the pet's age:");
        int age = scnr.nextInt();

        System.out.println("Enter the pet's price:");
        double price = scnr.nextDouble();
        scnr.nextLine(); // Consume the new line character

        System.out.println("Enter the pet's ID:");
        int id = scnr.nextInt();

        System.out.println("Enter the pet's weight:");
        double weight =  scnr.nextDouble();
        scnr.nextLine(); // Consume the new line character

        // Add the new pet to the inventory based on the user's selection.
        if (petTypeChoice == 1) {
            petStore.addDog(new Dog(name, breed, gender, age, price, id, weight, 0 ));
        } else if (petTypeChoice == 2) {
            petStore.addCat(new Cat(name, breed, gender, age, price, id, 0, 0));
        } else if (petTypeChoice == 3) {
            petStore.addExoticPet(new ExoticPet(name, breed, gender, age, price, id, 0, 0));
        } else {
            System.out.println("Sorry, invalid choice. Please try again.");
        }
        System.out.println("Pet added successfully!");
    } // End method for adoption Drive

    /**
    * A method thats the user to Register a new pet to owner profile 
    *
    * @param petStore the PetStore object containing the inventory of pets.
    * @param scnr the Scanner object used to get user input
    */
    public static void registerNewPet(PetStore petStore, Scanner scnr) {
        // Prompt the user to enter the member ID
        System.out.println("Enter the member ID:");
        int memberId = scnr.nextInt();
        scnr.nextLine();
       
        // Find member by ID
        Member member = petStore.findMemberById(memberId); 
        
        // If the member is not found, return error message.
         if (member == null) {
            System.out.println("Member not found.");
            return;
        } 
        // Prompt user to enter the pet details.
        System.out.println("Select the type of pet to register:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Exotic Pet");
        int petType = scnr.nextInt();
        scnr.nextLine();

        System.out.println("Enter the pet's name:");
        String name = scnr.nextLine();
        
        System.out.println("Enter the pet's breed/species:");
        String breed = scnr.nextLine();
      
        System.out.println("Enter the pet's gender:");
        String gender = scnr.nextLine();

        System.out.println("Enter the pet's age:");
        int age = scnr.nextInt();

        System.out.println("Entet the pet's weight:");
        double weight = scnr.nextDouble();

        System.out.println("Enter the pet's price:");
        double price = scnr.nextDouble();
        scnr.nextLine(); // Consume the new line character

        System.out.println("Enter the number of pet's of this type in stock:");
        int stock = scnr.nextInt();
        scnr.nextLine(); // Consume the new line character

        int petID = petStore.getNextPetID();

        // Create new pet based on user input and add to member's profile
        switch (petType) {
        case 1:
            Dog dog = new Dog(name, breed, gender, age, weight, petID, price, stock);
            member.addDog(dog);
            System.out.println("Dog registered sucessfully");
            break;
        case 2:
            Cat cat = new Cat(name, breed, gender, age, weight, petID, price, stock);
            member.addCat(cat);
            System.out.println("Cat registered sucessfully");
            break;
        case 3:
            ExoticPet exoticPet = new ExoticPet(name, breed, gender, age, weight, petID, price, stock);
            member.addExoticPet(exoticPet);
            System.out.println("Exotic Pet registered sucessfully");
            break;
        default:
            System.out.println("Invalid Pet Type");
        }

    } // end register new pet to owner profile method

    
} //End main class