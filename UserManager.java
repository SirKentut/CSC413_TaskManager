import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(String username) {
        User newUser = new User(username);
        users.add(newUser);
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("Users:");
            for (User user : users) {
                System.out.println("Username: " + user.getUsername());
            }
        }
    }
}
