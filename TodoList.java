import java.util.ArrayList;

public class TodoList {
    // Variables
    String Username;
    ArrayList<TodoItem> Todos = new ArrayList<TodoItem>();

    // Constructor
    public TodoList(String Username) {
        this.Username = Username;
        ArrayList<TodoItem> Todos = new ArrayList<TodoItem>();
    }

    public TodoList(String Username, ArrayList<TodoItem> Todos) {
        this.Username = Username;
        this.Todos = Todos;
    }

    // Methods
    // To String
    public String toString() {
        String s = "";
        for ( TodoItem Todo : Todos ) {
            s += Todo.toString();
        }
        return s;
    }
    // Get todo
    public void getTodo(int i) {
        TodoItem todo = Todos.get(i);
        System.out.println(todo);
    }

    // Get all todos
    public void getTodos() {
        for ( TodoItem todo : Todos ) {
            System.out.println(todo);
        }
     }
    // Add todo
    public void addTodo( TodoItem todo ) {
        Todos.add(todo);
    }

    public void addTodo(String todoDescription, String dueDate ) {
        TodoItem todo = new TodoItem(todoDescription, dueDate);
        Todos.add(todo);
    }
    // Complete todo
    // Edit todo

    }