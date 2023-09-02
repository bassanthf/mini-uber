import java.sql.Driver;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        UserDatabase database = new UserDatabase("users.txt");
        Driverr[] drivers={
                new Driverr("ahmed", "Car 1", "ahmed.com","kia",true),
                new Driverr("hamza", "Car 1", "hamza.com","kia",true),
                new Driverr("omar", "Car 1", "omar.com","kia",false)
        };


        database.loadUsersFromFile();
        System.out.println("Hello world!");
        while(true)
        {
            System.out.println("Welcome to our mini Uber");
            System.out.println("press 1 for sign in");
            System.out.println("press 2 for register");
            System.out.println("press 3 for exit ");

            Scanner scanner = new Scanner(System.in);
            int choice= scanner.nextInt();
            if(choice==1)
            {

                System.out.print("Enter username: ");
                String loginUsername = scanner.nextLine();

                System.out.print("Enter password: ");
                String loginPassword = scanner.nextLine();

                User loginUser = database.getUser(loginUsername);
                if (loginUser != null && loginUser.getPassword().equals(loginPassword)) {
                    System.out.println("Login successful!");
                    System.out.println("enter your ride details pick up location and destination");
                    String pickup = scanner.nextLine();
                    String location = scanner.nextLine();
                    Ride trip=new Ride(pickup,location,loginUser);
                    RideRequest thetrip=new RideRequest(loginUser,drivers);
                    thetrip.requestRide(pickup,location);
                } else {
                    System.out.println("Invalid username or password!");
                }

            } else if (choice==2) {
                System.out.println("press 1 to register as a customer");
                System.out.println("press 2 to register as a driver ");


                int ch= scanner.nextInt();
                if(ch==1)
                {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Customer user = new Customer(username, password, email);
                    database.addUser(user);
                    database.saveUsersToFile();
                    System.out.println("Registration successful!");

                }
                else if (ch==2) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter ypur car details: ");
                    String car = scanner.nextLine();

                    Driverr user = new Driverr(username, password, email,car,true);
                    database.addUser(user);
                    database.saveUsersToFile();
                    System.out.println("Registration successful!");

                }


            }
            else {
                System.exit(0);
            }



        }



            }






        User userr = new User("bassant", "password", "basbosa.com");
        //Driverr d=new Driverr("bb","nn",true);





        //RideRequest rideRequest = new RideRequest(userr, drivers);
        //rideRequest.requestRide("Pickup Location", "Destination");


    }
