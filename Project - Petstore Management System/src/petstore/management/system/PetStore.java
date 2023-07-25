/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore.management.system;

/**
 *
 * @author Saul
 */

import java.util. *;
/**
* The PetStore class represents a pet store with available pets, members, and premium members
* It implements the PetStoreSpecification
* It also provides methods to add and remove pets, add new members, add dogs, add cats, and exotic pets
* conduct adoption drives and get the total inventory value.
* @author Saul Moreno-Avila
*/
public class PetStore implements PetStoreSpecification {

    // Instance variables
    private String storeName;
    private ArrayList<Dog> availableDogs = new ArrayList(); // The list of available dogs
    private ArrayList<Cat> availableCats = new ArrayList(); // The list of available cats
    private ArrayList<ExoticPet> availableExoticPets = new ArrayList(); // The list of available exotic pets
    private ArrayList<Member> memberList = new ArrayList(); // The list of regular members
    private ArrayList<PremiumMember> premiumMemberList = new ArrayList(); // The list of premium members
    private ArrayList<Pet> availablePets = new ArrayList<>(); // The list of all available pets
    private static int nextPetID = 1; // The next pet ID to assign
    private static int nextMemberID = 1; // The next member ID to assign

    /**
    * Constructs a new PetStore with the given storeName and initializes the available pets and members
    * @param storeName the name of the pet store
    */
    public PetStore(String storeName) {
        this.storeName = storeName;
        // Available list of dogs
        Dog dog1 = new Dog( // New Dog 1
            "Waffle",
            "German Shepherd",
            "Female",
            12,
            85,
            getNextPetID(),
            500,
            1 // stock value
        );
        Dog dog2 = new Dog("Poe", "Corgi", "Male", 3, 35, getNextPetID(), 450,  1); // New Dog 2
        Dog dog3 = new Dog("Joe", "Bulldog", "Male", 3, 35, getNextPetID(), 600, 1); // New dog 3
        Dog dog4 = new Dog("Max", "Golden Retriever", "Female", 3, 35, getNextPetID(), 800, 1); // New dog 4
        Dog dog5 = new Dog("Buddy", "Labrador Retriever", "Male", 2, 70, getNextPetID(), 100, 1); // New dog 5
        
        // Available list of cats
        Cat cat1 = new Cat( // New cat 1
            "Karma",
            "Orange Tabby",
            "Female",
            6,
            15,
            getNextPetID(),
            200,
            1 // stock value
        );
        Cat cat2 = new Cat("Kit", "Maine Coon", "Male", 6, 18, getNextPetID(), 150, 1); // New cat 2
        Cat cat3 = new Cat("Milo", "Siamese", "Male", 4, 12, getNextPetID(), 100, 1); // New cat 3
        Cat cat4 = new Cat("Luna", "Sphynx", "Female", 2, 10, getNextPetID(), 300, 1); // New cat 4
        Cat cat5 = new Cat("Simba", "Bengal", "Male", 1, 14, getNextPetID(), 250, 1); // New cat 5
        
        // Available list of exotic pets
        ExoticPet ep1 = new ExoticPet( // New Exotic pet
            "Pancake",
            "Bearded Dragon",
            "Male",
            6,
            0.8,
            getNextPetID(),
            75,
            1 // stock value
        );
        ExoticPet ep2 = new ExoticPet( // New exotic pet 2
            "Noodle",
            "Ball Python",
            "Male",
            4,
            2,
            getNextPetID(),
            95,
            1 // stock value
        );

        ExoticPet ep3 = new ExoticPet( // New exotic pet 3
            "Luna",
            "Fennec Fox",
            "Female",
            3,
            3.5,
            getNextPetID(),
            2500,
            1 // stock value
        );
        ExoticPet ep4 = new ExoticPet("Rocco", "Chameleon", "Male", 2, 0.5, getNextPetID(), 150, 1); // New Exotic pet 4
        ExoticPet ep5 = new ExoticPet("Ziggy", "Sugar Glider", "Female", 1, 0.2, getNextPetID(), 350, 1); // New exotic pet 5
        //Available Dogs added
        availableDogs.add(dog1);
        availableDogs.add(dog2);
        availableDogs.add(dog3);
        availableDogs.add(dog4);
        availableDogs.add(dog5);
        // Available Cats added
        availableCats.add(cat1);
        availableCats.add(cat2);
        availableCats.add(cat3);
        availableCats.add(cat4);
        availableCats.add(cat5);
        // Available Exotic Pets added
        availableExoticPets.add(ep1);
        availableExoticPets.add(ep2);
        availableExoticPets.add(ep3);
        availableExoticPets.add(ep4);
        availableExoticPets.add(ep5);
        // Creates a new member 
        Member member1 = new Member("Jo", getNextMemberID(), true);
        member1.addCat(new Cat("Valjean", "White tabby", "Male", 1, 11.5, 5, 500.50, 1)); // Name, species, sex, age, weight, ID, price, stock
        memberList.add(member1);
        // Creates a new member
        PremiumMember member2 = new PremiumMember("Sage", getNextMemberID(), false, false);
        premiumMemberList.add(member2);
        member2.addExoticPet(
            new ExoticPet("Smaug", "Bearded Dragon", "Male", 5, 10.5, 3, 600.50, 1)
        );

    }

    /*
    * Gets the next available ID for a new pet
    *
    * @return The next available ID for a new pet
    */
    public static int getNextPetID() {
        nextPetID++;
        return nextPetID ;
    }
    
    /**
    * Gets the next available ID for a new member
    *
    * @return The next available ID for a new member
    */
    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
        
    } 

    /**
    * Gets the name of the pet store.
    *
    * @return The name of the pet store.
    */
    public String getStoreName() {
        return storeName;
    }

    /**
    * Sets the name of the pet store.
    *
    * @param storeName The name of the new pet store.
    */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
    * Gets the list of available dogs in the pet store.
    *
    * @return The list of available dogs in the pet store.
    */
    public ArrayList<Dog> getAvailableDogs() {
        return availableDogs;
    }

    /** 
    * Sets the list of available dogs in the pet store.
    * @param availableDogs The new list of available dogs in the pet store.
    */
    public void setAvailableDogs(ArrayList<Dog> availableDogs) {
        this.availableDogs = availableDogs;
    }

    /** 
    * Gets the list of available cats in the pet store.
    * @return The list of available cats in the pet store.
    */
    public ArrayList<Cat> getAvailableCats() {
        return availableCats;
    }

    /**
    * Sets the list of available cats in the pet store.
    * @param availableCats The new list of available cats in the pet store.
    */
    public void setAvailableCats(ArrayList<Cat> availableCats) {
        this.availableCats = availableCats;
    }

    /**
    * Get the list of available exotic pets in the pet store.
    * @return The  list of available exotic pets in the pet store.
    */
    public ArrayList<ExoticPet> getAvailableExoticPets() {
        return availableExoticPets;
    }

    /**
    * Sets the list of available exotic pets in the pet store.
    * @param availableExoticPets The new list of available exotic pets in the pet store.
    */
    public void setAvailableExoticPets(ArrayList<ExoticPet> availableExoticPets) {
        this.availableExoticPets = availableExoticPets;
    }

    /**
    * Gets the list of all members.
    * @return An ArrayList of Member objects representing all regular members.
    */
    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    /**
    * Sets the list of all members.
    * @param memberList An ArrayList of Member objects representing all regular members.
    */
    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    /**
    * Gets the list of all premium members.
    * @return An ArrayList of PremiumMember objects representing all premium members.
    */
    public ArrayList<PremiumMember> getPremiumMemberList() {
        return premiumMemberList;
    }

    /**
    * Sets the list of all premium members.
    * @param premiumMemberList An ArrayList of PremiumMember objects representing all premium members.
    */
    public void setPremiumMemberList(ArrayList<PremiumMember> premiumMemberList) {
        this.premiumMemberList = premiumMemberList;
    }

    /**
    * Removes a pet from the inventory based on its type and index.
    * @param type The type of the pet to remove. Possible values: "dog", "cat", or "exotic".
    * @param index The index of the pet to remove in the corresponding ArrayList.
    */
    public void removePet(String type, int index) {
        if (type.equals("dog")) 
            availableDogs.remove(index);
        else if (type.equals("cat")) 
            availableCats.remove(index);
        else if (type.equals("exotic")) 
            availableExoticPets.remove(index);

    }

    /**
    * Adds a new member to the store, either as regular or premium member.
    * @param name The name of the new member.
    * @param premium A boolean indicating whether the new member is a premium member.
    */
    public void addNewMember(String name, boolean premium) {
        if (premium) {
            premiumMemberList.add(new PremiumMember(name,getNextMemberID(),false,false));
        } else {
            memberList.add(new Member(name,getNextMemberID(), false));
        }
    } 

    /*
    * Adds a new dog to the inventory.
    * @param dog A Dog object representing the new dog to add.
    */
    public void addDog(Dog dog) {
        availableDogs.add(dog);
    }

    /*
    * Adds a new cat to the inventory.
    * @param cat A Cat object representing the new cat to add.
    */    
    public void addCat(Cat cat) {
        availableCats.add(cat);
    }

    /*
    * Adds a new exotic pet to the inventory.
    * @param exoticpet An ExoticPet object representing the new exotic pet to add.
    */
    public void addExoticPet(ExoticPet exoticpet) {
        availableExoticPets.add(exoticpet);
    }
    
    /**
    * Reduces the price of each pet in the provided ArrayList by a certain percentage (discount).
    * @param pets An ArrayList of Object objects representing the pets to apply the discount to.
    * @param discount A double representing the percentage of discount to apply (in decimal form).
    */
    @Override
    public void adoptionDrive(ArrayList<Object> pets, double discount) {
        for (Object pet : pets) {
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                dog.setPrice(dog.getPrice() * (1 - discount));
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                cat.setPrice(cat.getPrice() * (1 - discount));
            } else if (pet instanceof ExoticPet) {
                ExoticPet exoticPet = (ExoticPet) pet;
                exoticPet.setPrice(exoticPet.getPrice() * (1 - discount));
            }
        }
    }

    /**
    * Calculates the total value of the current inventory of pets in the store.
    * This method interates through the ArrayLists of available dogs, cats, and exotic pets
    * and adds up the price of each pet in the ArrayList to calculate the total inventory value.
    * @return The total value of the current inventory of pets in the store.
    */
    @Override
    public double inventoryValue() {
        double totalValue = 0;

        for (Dog dog : availableDogs) {
            totalValue += dog.getPrice();
        }

        for (Cat cat : availableCats) {
            totalValue += cat.getPrice();
        }

        for (ExoticPet exoticPet : availableExoticPets) {
            totalValue += exoticPet.getPrice();
        }
        return totalValue;
    }

    /**
    * Prints the current inventory of pets available in the pet store.
    * Displays all available dogs, cats, and exotic pets along with their details.
    */
    public void displayInventory() {
        System.out.println("Current Inventory");
        // Print available dogs
        System.out.println("\nDogs:");
        for (Dog dog : availableDogs) {
            System.out.println(dog.toString());
        }
        // Print available cats 
        System.out.println("\nCats:");
        for (Cat cat : availableCats) {
            System.out.println(cat.toString());
        }
        // Print available exotic pets
        System.out.println("\nExotic Pets:");
        for (ExoticPet exoticPet : availableExoticPets) {
            System.out.println(exoticPet.toString());
        }
    }

    /**
    * Restocks the quantity of a particular dog by ID.
    * @param dogID the ID of the dog to restock
    * @param restockQuantity the quantity of dogs to add to the current stock.
    * @return true if the dog is found and restocked, false otherwise.
    */
    public boolean restockDog(int dogID, int restockQuantity){
        for (Dog dog : availableDogs) {
            if (dog.getID() == dogID) {
                dog.setStock(dog.getStock() + restockQuantity);
                return true;
            }
        }
        return false;
    }

    /**
    * Restocks the quantity of a particular cat by ID.
    * @param catID the ID of the cat to restock
    * @param restockQuantity the quantity of cats to add to the current stock.
    * @return true if the cat is found and restocked, false otherwise.
    */
    public boolean restockCat(int catID, int restockQuantity){
        for (Cat cat : availableCats) {
            if (cat.getID() == catID) {
                cat.setStock(cat.getStock() + restockQuantity);
                return true;
            }
        }
        return false;
    }

    /**
    * Restocks the quantity of a particular exotic pet by ID.
    * @param exoticPetID the ID of the exotic pet to restock
    * @param restockQuantity the quantity of exotic pets to add to the current stock.
    * @return true if the exotic pet is found and restocked, false otherwise.
    */
    public boolean restockExoticPet(int exoticPetID, int restockQuantity){
        for (ExoticPet exoticPet : availableExoticPets) {
            if (exoticPet.getID() == exoticPetID) {
                exoticPet.setStock(exoticPet.getStock() + restockQuantity);
                return true;
            }
        }
        return false;
    }

    /**
    * Finds a member by their ID.
    * @param memberID The ID of a member.
    * @return The member with the specified ID, or null if not found. 
    */
    public Member findMemberById(int memberID) {
        for (Member m : memberList) {
            if (m.getMemberID() == memberID) {
                return m;
            }
        }

        for (PremiumMember pm : premiumMemberList) {
            if (pm.getMemberID() == memberID) {
                return pm;
            }
        }
        return null;
    }

    /**
    * Diplays all the members in the pet store, seperated by membership type
    * (free tier and premium).
    * @param petStore the pet store object containing the members list 
    */
    public void displayAllMembers(PetStore petStore) {
        System.out.println("-------------------------------------------");
        System.out.println("All the free tier members in the pet store:");
        for (Member member : petStore.getMemberList()) {
          System.out.println(member.toString());
        }
       System.out.println("-------------------------------------------");
       System.out.println("All the premium members in the pet store:");
        for (Member member : petStore.getPremiumMemberList()) {
          System.out.println(member.toString());
        }
    }
       
        
} // End PetStore class