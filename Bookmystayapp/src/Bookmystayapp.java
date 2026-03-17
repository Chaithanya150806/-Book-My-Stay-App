import java.util.LinkedList;
import java.util.Queue;

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
    }

    @Override
    public String toString() {
        return "Reservation [Guest=" + guestName + ", RoomType=" + roomType + "]";
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