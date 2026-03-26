public class BookMyStayApp {
    public static void main(String[] args) {
        import java.util.*;

        class BookMyStayApp {

            private List<Hotel> hotels = new ArrayList<>();
            private List<Booking> bookings = new ArrayList<>();
            private Scanner scanner = new Scanner(System.in);

            public static void main(String[] args) {
                BookMyStayApp app = new BookMyStayApp();
                app.seedData(); // preload some hotels
                app.start();
            }

            // Entry point for use-case logic
            public void start() {
                while (true) {
                    System.out.println("\n=== Book My Stay ===");
                    System.out.println("1. Search Hotels");
                    System.out.println("2. Book Room");
                    System.out.println("3. View Bookings");
                    System.out.println("4. Exit");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            searchHotels();
                            break;
                        case 2:
                            bookRoom();
                            break;
                        case 3:
                            viewBookings();
                            break;
                        case 4:
                            System.out.println("Thank you for using BookMyStay!");
                            return;
                        default:
                            System.out.println("Invalid choice!");
                    }
                }
            }

            // Use-case: Search hotels
            private void searchHotels() {
                System.out.println("Available Hotels:");
                for (int i = 0; i < hotels.size(); i++) {
                    System.out.println((i + 1) + ". " + hotels.get(i));
                }
            }

            // Use-case: Book a room
            private void bookRoom() {
                searchHotels();
                System.out.print("Select hotel number: ");
                int hotelIndex = scanner.nextInt() - 1;

                if (hotelIndex < 0 || hotelIndex >= hotels.size()) {
                    System.out.println("Invalid hotel selection.");
                    return;
                }

                Hotel hotel = hotels.get(hotelIndex);

                System.out.print("Enter your name: ");
                scanner.nextLine(); // consume newline
                String userName = scanner.nextLine();

                Booking booking = new Booking(userName, hotel.getName());
                bookings.add(booking);

                System.out.println("Booking confirmed for " + userName + " at " + hotel.getName());
            }

            // Use-case: View bookings
            private void viewBookings() {
                if (bookings.isEmpty()) {
                    System.out.println("No bookings found.");
                    return;
                }

                System.out.println("Your Bookings:");
                for (Booking b : bookings) {
                    System.out.println(b);
                }
            }

            // Seed initial data
            private void seedData() {
                hotels.add(new Hotel("Taj Palace", "Delhi"));
                hotels.add(new Hotel("Oberoi Grand", "Kolkata"));
                hotels.add(new Hotel("Leela Palace", "Chennai"));
            }
        }

// Supporting classes

        class Hotel {
            private String name;
            private String location;

            public Hotel(String name, String location) {
                this.name = name;
                this.location = location;
            }

            public String getName() {
                return name;
            }

            public String toString() {
                return name + " (" + location + ")";
            }
        }

        class Booking {
            private String userName;
            private String hotelName;

            public Booking(String userName, String hotelName) {
                this.userName = userName;
                this.hotelName = hotelName;
            }

            public String toString() {
                return "User: " + userName + ", Hotel: " + hotelName;
            }
        }
    }
}
