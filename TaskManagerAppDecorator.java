import java.util.Scanner;

public class TaskManagerAppDecorator {
    private TaskManager taskManager;
    private TaskDecorator taskDecorator;
    private Scanner scanner;

    public TaskManagerAppDecorator() {
        this.taskManager = TaskManager.getInstance();
        this.taskDecorator = null; // No decorator by default
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

                    // Apply decorator if available
                    if (taskDecorator != null) {
                        Task lastAddedTask = taskManager.getLastAddedTask();
                        if (lastAddedTask != null) {
                            taskDecorator.decorateTask(lastAddedTask);
                        }
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
                    taskDecorator = new PriorityDecorator();
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
        TaskManagerAppDecorator taskManagerAppDecorator = new TaskManagerAppDecorator();
        taskManagerAppDecorator.run();
    }
}
