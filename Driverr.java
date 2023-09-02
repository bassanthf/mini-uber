public class Driverr extends User  {

        private String name;
        private String carDetails;
        private boolean available;




        public Driverr(String name,String password,String email, String carDetails, boolean available) {
            super(name, password, email);

            this.name = name;
            this.carDetails = carDetails;
            this.available = available;
        }



    public String getName() {
            return name;
        }

        public boolean isAvailable() {
            return available;
        }

        public String getCarDetails() {
            return carDetails;
        }

        public void setCarDetails(String carDetails) {
            this.carDetails = carDetails;
        }
    public void checkRideRequests() {
        // Logic for checking ride requests
        System.out.println("Checking ride requests...");
    }

    }

