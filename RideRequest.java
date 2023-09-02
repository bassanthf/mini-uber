public class RideRequest {
    private User user;
    private Driverr[] drivers;

    public RideRequest(User user, Driverr[] drivers) {
        this.user = user;
        this.drivers = drivers;
    }

    public void requestRide(String pickupLocation, String destination) {
        Ride ride = new Ride(pickupLocation, destination, user);


        Driverr availableDriver = findAvailableDriver();
        if (availableDriver != null) {
            ride.assignDriver(availableDriver);
            System.out.println("Ride requested. Driver assigned: " + availableDriver.getName());
        } else {
            System.out.println("No available drivers. Please try again later.");
        }
    }

    private Driverr findAvailableDriver() {
        for (Driverr driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }
}