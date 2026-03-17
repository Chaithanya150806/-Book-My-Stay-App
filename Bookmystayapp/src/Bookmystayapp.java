/**
 * UseCase2RoomInitialization
 *
 * Demonstrates basic room types using abstraction, inheritance,
 * and static availability representation.
 *
 * @author YourName
 * @version 2.1
 */

// Abstract Room class
abstract class Room {
    private String roomType;
    private int beds;
    private double price;

    public Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + roomType);
        System.out.println("Beds: " + beds);
        System.out.println("Price: $" + price);
    }
}

// Single Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

// Double Room
class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

// Suite Room
class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 300.0);
    }
}

// Main Application Class
public class Bookmystayapp {

    public static void main(String[] args) {

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("========== Room Details ==========");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println("----------------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println("----------------------------------");

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
        System.out.println("----------------------------------");

        System.out.println("Application Version: 2.1");
    }
}