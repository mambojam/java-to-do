import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    // Write todos to file NAME
    public void writeTodos(String filename) {
        File outFile = new File ( filename );
        try {
            FileWriter writer = new FileWriter( outFile );
            BufferedWriter out = new BufferedWriter(writer);

            for ( TodoItem todo : Todos ) {
                out.write(todo.getTodo() + "," + todo.getDueDate() + "\n");
            }

            out.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    // Get todo
    public void getTodo(int i) {
        TodoItem todo = Todos.get(i);
        System.out.println(todo);
    }

     public void getTodos() {
        for ( int i = 0 ; i < Todos.size() ; i++ ) {
            System.out.println((i+1) + ": " + Todos.get(i).toString() );
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
    public void completeTodo(int i) {
        Todos.remove(i-1);
    }
    // Edit todo

    }