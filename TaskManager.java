import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager instance;
    private List<Task> tasks;
    private TaskDecorator taskDecorator;

    private TaskManager() {
        this.tasks = new ArrayList<>();
        this.taskDecorator = null; // No decorator by default
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);

        // Apply decorator if available
        if (taskDecorator != null) {
            taskDecorator.decorateTask(newTask);
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks) {
                System.out.println("Task ID: " + task.getId() +
                                   ", Description: " + task.getDescription() +
                                   ", Status: " + (task.isStatus() ? "Complete" : "Incomplete"));
            }
        }
    }

    public void markTaskAsComplete(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setStatus(true);
                System.out.println("Task ID " + taskId + " marked as complete.");
                return;
            }
        }
        System.out.println("Task ID " + taskId + " not found.");
    }

    public Task getLastAddedTask() {
        if (!tasks.isEmpty()) {
            return tasks.get(tasks.size() - 1);
        }
        return null;
    }

    public void setTaskDecorator(TaskDecorator taskDecorator) {
        this.taskDecorator = taskDecorator;
    }
}
