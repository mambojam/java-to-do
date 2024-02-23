// import java.time.LocalDateTime;

public class TodoItem {
    // Initialise variables
    String description;
    String dueDate;
    boolean completed;
    // boolean late;
    // int urgency;
    // LocalDateTime dueDate;

    // Constructor
    public TodoItem(String description, String dueDate) {
        this.description = description;
        this.completed = false; // Default value set for new objects
        // this.late = late;
        // this.urgency = urgency;
        this.dueDate = dueDate;
    }

    // Methods
    // Override toString()
    public String toString() {
        return description + " due " + dueDate;
    }

    // For loading todos into list
    public String getTodo() {
        return description;
    }
    
    // For loading due dates
    public String getDueDate() {
        return dueDate;
    }

    // To set as complete
    public void setComplete(boolean x) {
        this.completed = x;
        
    }

    // To update the todo description
    public String updateTodo(String newTodo) {
        this.description = newTodo;
        return description;
    }
    }
