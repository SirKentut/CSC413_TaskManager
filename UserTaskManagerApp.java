import java.util.Scanner;

public class UserTaskManagerApp {
    private TaskManager taskManager;
    private UserManager userManager;
    private Scanner scanner;

    public UserTaskManagerApp() {
        this.taskManager = TaskManager.getInstance();
        this.userManager = new UserManager();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Task Management");
            System.out.println("2. User Management");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageTasks();
                    break;

                case 2:
                    manageUsers();
                    break;

                case 3:
                    System.out.println("Exiting User-Task Manager. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageTasks() {
        System.out.println("Task Management:");

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Set Priority Decorator");
            System.out.println("5. Back to Main Menu");

            int taskChoice = scanner.nextInt();

            switch (taskChoice) {
                case 1:
                    System.out.println("Enter Task Description:");
                    scanner.nextLine(); // Consume newline character
                    String description = scanner.nextLine();
                    taskManager.addTask(description);

                    // Simulating task decoration
                    Task lastAddedTask = taskManager.getLastAddedTask();
                    if (lastAddedTask != null) {
                        // Assuming a priority decorator is set by default
                        PriorityDecorator priorityDecorator = new PriorityDecorator();
                        priorityDecorator.decorateTask(lastAddedTask);
                    }
                    break;

                case 2:
                    taskManager.displayTasks();
                    break;

                case 3:
                    System.out.println("Enter Task ID to mark as complete:");
                    int taskId = scanner.nextInt();
                    taskManager.markTaskAsComplete(taskId);
                    break;

                case 4:
                    // Set Priority Decorator
                    taskManager.setTaskDecorator(new PriorityDecorator());
                    System.out.println("Priority Decorator set.");
                    break;

                case 5:
                    return; // Return to the main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageUsers() {
        System.out.println("User Management:");

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Display Users");
            System.out.println("3. Back to Main Menu");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
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
                    return; // Return to the main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserTaskManagerApp userTaskManagerApp = new UserTaskManagerApp();
        userTaskManagerApp.run();
    }
}
