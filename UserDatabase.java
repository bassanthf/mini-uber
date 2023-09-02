import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users;
    private String filePath;

    public UserDatabase(String filePath) {
        this.users = new ArrayList<>();
        this.filePath = filePath;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void saveUsersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.println(user.getUsername() + "," + user.getPassword() + "," + user.getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    String email = parts[2];
                    User user = new User(username, password, email);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}