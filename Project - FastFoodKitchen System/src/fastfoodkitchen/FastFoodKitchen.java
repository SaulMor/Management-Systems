package fastfoodkitchen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FastFoodKitchen class represents a fast food kitchen management system. It
 * can manage orders, track pending orders, and perform various operations such
 * as adding, canceling, and completing orders. ITSC 1213 University of North
 * Carolina at Charlotte
 */
public class FastFoodKitchen {

    private ArrayList<BurgerOrder> orderList = new ArrayList<>();
    private static int nextOrderNum = 1;
    private int numOrdersPending = 0;
    private List<BurgerOrder> completedOrders;

    /**
     * Constructor that initializes the FastFoodKitchen object with a default
     * orders file path.
     */
    FastFoodKitchen() {
        String ordersFilePath = "resources/updatedOrders.csv";
        readOrdersFromFile(ordersFilePath);
        completedOrders = new ArrayList<>(); // Initialize completedOrders
    }

    /**
     * Constructor that initializes the FastFoodKitchen object with a custom
     * orders file path.
     *
     * @param ordersFilePath the file path for the orders data
     */
    public FastFoodKitchen(String ordersFilePath) {
        readOrdersFromFile(ordersFilePath);
        completedOrders = new ArrayList<>(); // Initialize completedOrders
    }

    /**
     * Returns the next order number.
     *
     * @return the next order number
     */
    public static int getNextOrderNum() {
        return nextOrderNum;
    }

    /**
     * Increments the next order number.
     */
    private void incrementNextOrderNum() {
        nextOrderNum++;
    }

    /**
     * Adds a new order to the list and increments the pending orders count.
     *
     * @param numHamburgers
     * @param numCheeseburgers
     * @param numVeggieburgers
     * @param numSodas
     * @param orderToGo
     * @return the order number for the new order
     */
    public int addOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo) {
        try {
            BurgerOrder newOrder = new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, orderToGo, nextOrderNum);
            orderList.add(newOrder);
            orderCallOut(newOrder); // Add the call to orderCallOut method
            incrementNextOrderNum(); // Update the nextOrderNum after the new order is added
            return newOrder.getOrderNum();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1; // Return -1 to indicate an error
        }
    }

    /**
     * Checks the status of an order with the given order number.
     *
     * @param orderNum the order number to check the status of
     * @return a string representing the status of the order
     */
    public String checkOrderStatus(int orderNum) {
        for (BurgerOrder order : orderList) {
            if (order.getOrderNum() == orderNum) {
                if (order.isCanceled()) {
                    return "The order has been canceled.";
                } else if (order.isCompleted()) {
                    return "The order is ready.";
                } else {
                    return "No, it's not ready, but it should be up soon. Sorry for the wait.";
                }
            }
        }
        return "Sorry, no order with this number was found.";
    }

    /**
     * Cancels an order with the given order number if it's not completed.
     *
     * @param orderNum the order number to cancel
     * @return true if the order was canceled, false otherwise
     */
    public boolean cancelOrder(int orderNum) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderNum && !orderList.get(i).isCompleted()) {
                orderList.remove(i);
                numOrdersPending--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the current number of orders pending in the kitchen.
     *
     * @return the number of pending orders
     */
    public int getNumOrdersPending() {
        return numOrdersPending;
    }

    /**
     * Cancels the last order in the order list and returns true if successful,
     * otherwise returns false.
     *
     * @return true if the last order was canceled, false otherwise
     */
    public boolean cancelLastOrder() {

        if (!orderList.isEmpty()) { // same as  if (orderList.size() > 0) 
            orderList.remove(orderList.size() - 1);
            return true;
        }

        return false;
    }

    /**
     * Prints out the items in the given order.
     *
     * @param order the order to call out
     */
    private void orderCallOut(BurgerOrder order) {
        if (order.getNumHamburgers() > 0) {
            System.out.println("You have " + order.getNumHamburgers() + " hamburgers");
        }
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumCheeseburgers() + " cheeseburgers");
        }
        if (order.getNumVeggieburgers() > 0) {
            System.out.println("You have " + order.getNumVeggieburgers() + " veggieburgers");
        }
        if (order.getNumSodas() > 0) {
            System.out.println("You have " + order.getNumSodas() + " sodas");
        }

    }

    /**
     * Completes a specific order in the order list based on the given orderID.
     *
     * @param orderID the order number to complete
     */
    public void completeSpecificOrder(int orderID) {
        BurgerOrder orderToComplete = null;
        for (BurgerOrder order : orderList) {
            if (order.getOrderNum() == orderID) {
                orderToComplete = order;
                break;
            }
        }
        if (orderToComplete != null) {
            completedOrders.add(orderToComplete); // Add completed order to completedOrders list
            orderList.remove(orderToComplete);
        } else {
            System.out.println("Order not found.");
        }
    }

    /**
     * Completes the next order in the order list.
     */
    public void completeNextOrder() {
        int nextOrder = orderList.get(0).getOrderNum();
        completeSpecificOrder(nextOrder);

    }

    /**
     * Returns the order list.
     *
     * @return the ArrayList of BurgerOrder objects
     */
    public ArrayList<BurgerOrder> getOrderList() {
        return orderList;
    }

    /**
     * Finds the index of a specific order in the order list by its order number
     * using sequential search.
     *
     * @param whatWeAreLookingFor the order number to search for
     * @return the index of the order in the list or -1 if not found
     */
    public int findOrderSeq(int whatWeAreLookingFor) {
        for (int j = 0; j < orderList.size(); j++) {
            if (orderList.get(j).getOrderNum() == whatWeAreLookingFor) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Finds the index of a specific order in the order list by its order number
     * using binary search.
     *
     * @param orderID the order number to search for
     * @return the index of the order in the list or -1 if not found
     */
    public int findOrderBin(int orderID) {
        int left = 0;
        int right = orderList.size() - 1;
        while (left <= right) {
            int middle = ((left + right) / 2);
            if (orderID < orderList.get(middle).getOrderNum()) {
                right = middle - 1;
            } else if (orderID > orderList.get(middle).getOrderNum()) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;

    }

    /**
     * Sorts the order list by the total number of burgers in each order using
     * selection sort.
     */
    public void selectionSort() {
        for (int i = 0; i < orderList.size() - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < orderList.size(); k++) {
                if (orderList.get(minIndex).getTotalBurgers() > orderList.get(k).getTotalBurgers()) {
                    minIndex = k;
                }
            }
            BurgerOrder temp = orderList.get(i);
            orderList.set(i, orderList.get(minIndex));
            orderList.set(minIndex, temp);
        }
    }

    /**
     * Sorts the order list by the total number of burgers in each order using
     * insertion sort.
     */
    public void insertionSort() {
        for (int j = 1; j < orderList.size(); j++) {
            BurgerOrder temp = orderList.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTotalBurgers() < orderList.get(possibleIndex - 1).getTotalBurgers()) {
                orderList.set(possibleIndex, orderList.get(possibleIndex - 1));
                possibleIndex--;
            }
            orderList.set(possibleIndex, temp);
        }
    }

    /**
     * Reads orders from a file and adds them to the order list.
     *
     * @param fileName the name of the file to read orders from
     */
    public void readOrdersFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                int numHamburgers = Integer.parseInt(values[0].trim());
                int numCheeseburgers = Integer.parseInt(values[1].trim());
                int numVeggieburgers = Integer.parseInt(values[2].trim());
                int numSodas = Integer.parseInt(values[3].trim());
                boolean orderToGo = Boolean.parseBoolean(values[4].trim());
                int orderNum = Integer.parseInt(values[5].trim());

                BurgerOrder order = new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, orderToGo, orderNum);
                orderList.add(order);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
    }

    /**
     * Writes the updated orders to a file, excluding completed orders.
     *
     * @param fileName the name of the file to save the updated orders
     * @param orders the list of BurgerOrder objects to write to the file
     */
    public void writeUpdatedOrdersToFile(String fileName, List<BurgerOrder> orders) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Num Hamburgers, Num Cheeseburgers, Num Veggieburgers, Num Sodas, Order To Go, Order Number\n");

            for (BurgerOrder order : orders) {
                if (!order.isCompleted()) {
                    fw.write(order.getNumHamburgers() + ", " + order.getNumCheeseburgers() + ", " + order.getNumVeggieburgers() + ", " + order.getNumSodas() + ", " + order.isOrderToGo() + ", " + order.getOrderNum() + "\n");
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    /**
     * Returns the list of BurgerOrder objects.
     *
     * @return the list of BurgerOrder objects
     */
    public List<BurgerOrder> getOrders() {
        return orderList;
    }

    /**
     * Generates an end-of-day report and saves it to a file.
     *
     * @param kitchen the FastFoodKitchen object containing the orders
     * @param endOfDayReportFile
     * @throws IOException
     */
    public static void generateEndOfDayReport(FastFoodKitchen kitchen, String endOfDayReportFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(endOfDayReportFile))) {
            // Write the report header
            bw.write("End of Day Report\n\n");

            // Write Pending Orders
            bw.write("Pending Orders:\n");
            for (BurgerOrder order : kitchen.orderList) {
                bw.write(order.toString() + "\n");
            }

            // Write Completed Orders
            bw.write("\nCompleted Orders:\n");
            for (BurgerOrder order : kitchen.completedOrders) {
                bw.write(order.toString() + "\n");
            }

            // Calculate and write totals for each item sold
            int totalHamburgers = 0;
            int totalCheeseburgers = 0;
            int totalVeggieburgers = 0;
            int totalSodas = 0;

            List<BurgerOrder> allOrders = new ArrayList<>(kitchen.orderList);
            allOrders.addAll(kitchen.completedOrders);

            for (BurgerOrder order : allOrders) {
                totalHamburgers += order.getNumHamburgers();
                totalCheeseburgers += order.getNumCheeseburgers();
                totalVeggieburgers += order.getNumVeggieburgers();
                totalSodas += order.getNumSodas();
            }

            bw.write("\nTotals for each item sold:\n");
            bw.write("Hamburgers: " + totalHamburgers + "\n");
            bw.write("Cheeseburgers: " + totalCheeseburgers + "\n");
            bw.write("Veggieburgers: " + totalVeggieburgers + "\n");
            bw.write("Sodas: " + totalSodas + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the updated orders to a file, excluding completed orders.
     *
     * @param kitchen the FastFoodKitchen object containing the orders
     * @param updatedOrdersFile the name of the file to save the updated orders
     * @throws IOException
     */
    public static void writeUpdatedOrdersToFile(FastFoodKitchen kitchen, String updatedOrdersFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(updatedOrdersFile))) {
            // Write the header for the updated orders file
            bw.write("numHamburgers,numCheeseburgers,numVeggieburgers,numSodas,orderToGo,orderNum,completed\n");

            // Write the remaining orders (pending and completed)
            List<BurgerOrder> allOrders = new ArrayList<>(kitchen.orderList);
            allOrders.addAll(kitchen.completedOrders);

            for (BurgerOrder order : allOrders) {
                bw.write(String.format("%d,%d,%d,%d,%b,%d,%b\n",
                        order.getNumHamburgers(),
                        order.getNumCheeseburgers(),
                        order.getNumVeggieburgers(),
                        order.getNumSodas(),
                        order.isOrderToGo(),
                        order.getOrderNum(),
                        order.isCompleted()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

} // End FastFoodKitchen class
