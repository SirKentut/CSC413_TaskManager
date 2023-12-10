import java.util.Scanner;

public class TaskManagerApp {
    private TaskManager taskManager;
    private TaskDecorator priorityDecorator;
    private Scanner scanner;

    public TaskManagerApp() {
        this.taskManager = TaskManager.getInstance();
        this.priorityDecorator = new PriorityDecorator();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Set Priority Decorator");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Task Description:");
                    scanner.nextLine(); // Consume newline character
                    String description = scanner.nextLine();
                    taskManager.addTask(description);

                    // Simulating task decoration
                    Task lastAddedTask = taskManager.getLastAddedTask();
                    if (lastAddedTask != null) {
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
                    taskManager.setTaskDecorator(priorityDecorator);
                    System.out.println("Priority Decorator set.");
                    break;

                case 5:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TaskManagerApp taskManagerApp = new TaskManagerApp();
        taskManagerApp.run();
    }
}
