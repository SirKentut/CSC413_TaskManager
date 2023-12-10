public class PriorityDecorator implements TaskDecorator {
    @Override
    public void decorateTask(Task task) {
        // Simulating adding priority information
        System.out.println("Task ID " + task.getId() + " - Priority: High");
    }
}
