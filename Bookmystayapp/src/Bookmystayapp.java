/**
 * UseCase4RoomSearch
 *
 * Demonstrates read-only room search and availability check
 * using centralized inventory and domain models.
 *
 * @author YourName
 * @version 4.0
 * UseCase3InventorySetup
 *
 * Demonstrates centralized room inventory management using HashMap.
 *
 * @author YourName
 * @version 3.1
 */

import java.util.HashMap;
import java.util.Map;

// Abstract Room class
abstract class Room {
    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public String getType() {
        return type;
    }

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

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: $" + price);
    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

// Concrete Room Types
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 300.0);
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

// Inventory Class (Read-only access during search)
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public Map<String, Integer> getAllInventory() {
        return inventory; // read-only usage expected
    }
}

// Search Service
class RoomSearchService {

    public void searchAvailableRooms(RoomInventory inventory, Map<String, Room> roomMap) {
        System.out.println("====== Available Rooms ======");

        for (String type : roomMap.keySet()) {
            int available = inventory.getAvailability(type);

            // Filter unavailable rooms
            if (available > 0) {
                Room room = roomMap.get(type);
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println("-----------------------------");
            }
        }
    }
}

// Main Class
public class Bookmystayapp{

    public static void main(String[] args) {

        // Initialize rooms
        Map<String, Room> roomMap = new HashMap<>();
        roomMap.put("Single Room", new SingleRoom());
        roomMap.put("Double Room", new DoubleRoom());
        roomMap.put("Suite Room", new SuiteRoom());

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 5);
        inventory.addRoom("Double Room", 0); // unavailable
        inventory.addRoom("Suite Room", 2);

        // Perform search
        RoomSearchService searchService = new RoomSearchService();
        searchService.searchAvailableRooms(inventory, roomMap);

        System.out.println("Application Version: 4.0");
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