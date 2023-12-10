import java.util.Scanner;

public class UserManagerApp {
    private UserManager userManager;
    private Scanner scanner;

    public UserManagerApp() {
        this.userManager = new UserManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Display Users");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter User Username:");
                    scanner.nextLine(); // Consume newline character
                    String username = scanner.nextLine();
                    userManager.addUser(username);
                    break;

                case 2:
                    userManager.displayUsers();
                    break;

                case 3:
                    System.out.println("Exiting User Manager. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserManagerApp userManagerApp = new UserManagerApp();
        userManagerApp.run();
    }
}
