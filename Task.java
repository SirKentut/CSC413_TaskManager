public class Task {
    private static int nextId = 1;

    private int id;
    private String description;
    private boolean status;

    public Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = false;  // Default status is incomplete
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
