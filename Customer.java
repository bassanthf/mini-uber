public class Customer extends User {
    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public void requestRide() {
        // Logic for requesting a ride
        System.out.println("Ride requested!");
    }
}
