package fastfoodkitchen;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * FastFoodKitchenDriver class contains the main method for running the
 * fast-food ordering system.
 */
public class FastFoodKitchenDriver {

    /**
     * Main method which runs the fast-food ordering system.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new FastFoodKitchen object
        FastFoodKitchen kitchen = new FastFoodKitchen();
        // Create a Scanner object for reading user input
        Scanner sc = new Scanner(System.in);

        // Loop until the user chooses to exit
        while (true) {
            try {
                // see what the user wants to do
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order food");
                System.out.println("\t 2. Cancel last order");
                System.out.println("\t 3. Show number of orders currently pending");
                System.out.println("\t 4. Complete order");
                System.out.println("\t 5. Check on order");
                System.out.println("\t 6. Cancel order");
                System.out.println("\t 7. Exit");

                // Read the user's menu choice
                int num = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                // Process the user's menu choice
                switch (num) {
                    case 1: // Order food
                        // Prompt user for order details
                        System.out.println("How many hamburgers do you want?");
                        int ham = sc.nextInt();
                        System.out.println("How many cheeseburgers do you want?");
                        int cheese = sc.nextInt();
                        System.out.println("How many veggieburgers do you want?");
                        int veggie = sc.nextInt();
                        System.out.println("How many sodas do you want?");
                        int sodas = sc.nextInt();

                        // Prompt user whether the order is to go
                        char letter = '\0';
                        while (letter != 'Y' && letter != 'y' && letter != 'N' && letter != 'n') {
                            System.out.println("Is your order to go? (Y/N)");
                            letter = sc.next().charAt(0);
                            if (letter != 'Y' && letter != 'y' && letter != 'N' && letter != 'n') {
                                System.out.println("Invalid input. Please enter Y or N.");
                            }
                        }
                        // Process the order
                        boolean TOGO = false;
                        if (letter == 'Y' || letter == 'y') {
                            TOGO = true;
                        }
                        try {
                            int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                            if (orderNum == -1) {
                                System.out.println("An error occurred while processing your order. Please try again.");
                            } else {
                                System.out.println("Thank you. Your order number is " + orderNum);
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println();
                        break;
                    case 2: // Cancel last order
                        boolean ready = kitchen.cancelLastOrder();
                        if (ready) {
                            System.out.println("Thank you. The last order has been canceled");
                        } else {
                            System.out.println("Sorry. There are no orders to cancel.");
                        }
                        System.out.println();
                        break;
                    case 3: // Show number of orders currently pending
                        System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                        break;
                    case 4: // Complete order
                        System.out.println("Enter order number to complete?");
                        int order = sc.nextInt();
                        kitchen.completeSpecificOrder(order);
                        System.out.println("Your order is ready. Thank you!");
                        break;
                    case 5: //Check on order
                        System.out.println("What is your order number?");
                        order = sc.nextInt();
                        String statusMessage = kitchen.checkOrderStatus(order);
                        System.out.println(statusMessage);
                        System.out.println();
                        break;
                    case 6: //Cancel order
                        System.out.println("What is your order number?");
                        order = sc.nextInt();
                        boolean cancel = kitchen.cancelOrder(order);
                        if (cancel) {
                            System.out.println("Your order has been successfully cancelled ");
                        } else {
                            System.out.println("Sorry, we can’t find your order number in the system");
                        }
                        System.out.println();
                        break;
                    case 7: //Exit
                        String endOfDayReportFile = "resources/endOfDayReport.txt";
                        String updatedOrdersFile = "resources/updatedOrders.csv";
                        FastFoodKitchen.generateEndOfDayReport(kitchen, endOfDayReportFile);
                        FastFoodKitchen.writeUpdatedOrdersToFile(kitchen, updatedOrdersFile);
                        System.out.println("Orders file has been updated. Exiting the program...");
                        Thread.sleep(1000); // Add a 1-second delay
                        System.exit(0);
                        break;
                    default: //Invalid menu choice
                        System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, or a 7");
                } //end switch
            } catch (InputMismatchException e) {  // Handle non-numeric input
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // Consume the invalid input
            } catch (InterruptedException e) { // Handle sleep interruption
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IOException e) { // Handle I/O errors
                System.out.println("An I/O error occurred: " + e.getMessage());
            } catch (IllegalArgumentException e) { // Handle illegal argument errors
                System.out.println(e.getMessage());
            }

        } //end while loop
    } // end main
}// end class

