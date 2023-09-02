public class Ride {
    private String pickupLocation;
    private String destination;
    private User user;
    private Driverr driver;

    public Ride(String pickupLocation, String destination, User user) {
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.user = user;
    }

    public void assignDriver(Driverr driver) {
        this.driver = driver;
    }


}