import java.util.LinkedList;
import java.util.Queue;
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

// Reservation class representing a booking request
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
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

    @Override
    public String toString() {
        return "Reservation [Guest=" + guestName + ", RoomType=" + roomType + "]";
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

// Booking Request Queue Manager
class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request to queue
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Request added: " + reservation);
    }

    // View all pending requests
    public void displayRequests() {
        if (requestQueue.isEmpty()) {
            System.out.println("No pending booking requests.");
            return;
        }

        System.out.println("\nBooking Requests in Queue (FIFO Order):");
        for (Reservation r : requestQueue) {
            System.out.println(r);
        }
    }
}

// Main class
public class Bookmystayapp {
    public static void main(String[] args) {

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulating multiple guest booking requests
        Reservation r1 = new Reservation("Alice", "Deluxe");
        Reservation r2 = new Reservation("Bob", "Standard");
        Reservation r3 = new Reservation("Charlie", "Suite");

        // Step 1: Guests submit booking requests
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Step 2: Display queued requests (FIFO maintained)
        bookingQueue.displayRequests();

        // NOTE: No room allocation happens here (as per requirement)
    }
}