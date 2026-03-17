/**
 * UseCase3InventorySetup
 *
 * Demonstrates centralized room inventory management using HashMap.
 *
 * @author YourName
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

// Inventory Management Class
class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add or initialize room type availability
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (increase/decrease)
    public void updateAvailability(String roomType, int change) {
        int current = getAvailability(roomType);
        inventory.put(roomType, current + change);
    }

    // Display all inventory
    public void displayInventory() {
        System.out.println("====== Room Inventory ======");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Room Type: " + entry.getKey() +
                    " | Available: " + entry.getValue());
        }
    }
}

// Main Application Class
public class Bookmystayapp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Register room types
        inventory.addRoomType("Single Room", 5);
        inventory.addRoomType("Double Room", 3);
        inventory.addRoomType("Suite Room", 2);

        // Display initial inventory
        inventory.displayInventory();

        System.out.println("\nUpdating availability...");

        // Update inventory
        inventory.updateAvailability("Single Room", -1); // booking
        inventory.updateAvailability("Suite Room", 1);   // cancellation

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication Version: 3.1");
    }
}