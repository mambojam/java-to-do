import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class TodoList extends ArrayList<TodoItem> {
    // Variables
    private String username;

    // Constructor
    public TodoList(String username) {
        super();
        this.username = username;
    }


    // Methods
    // To String
    public String toString() {
        String s = "";
        for ( TodoItem Todo : this ) {
            s += Todo.toString();
        }
        return s;
    }
    // Write todos to file NAME
    public void writeTodos( String filename ) {
        File outFile = new File ( filename );
        try {
            FileWriter writer = new FileWriter( outFile );
            BufferedWriter out = new BufferedWriter( writer );

            for ( TodoItem todo : this ) {
                out.write(todo.getTodo() + "," + todo.getDueDate() + "\n");
            }

            out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Username
    public String getUsername(){
        return username;
    }
    // Get todo
    public TodoItem getTodo(int i) {
        TodoItem todo = this.get(i);
        return todo;
    }

     public void getTodos() {
        for ( int i = 0 ; i < this.size() ; i++ ) {
            System.out.println((i+1) + ": " + this.get(i).toString() );
        }
     }
    // Add todo
    public void addTodo( TodoItem todo ) {
        this.add(todo);
    }

    public void addTodo( String todoDescription, String dueDate ) {
        TodoItem todo = new TodoItem( todoDescription, dueDate );
        this.add(todo);
    }
    // Complete todo
    public void completeTodo(int index) {
        this.remove(index);
    }
    // Edit todo
    public TodoItem editTodo(int index, TodoItem editedTodo) {
        TodoItem newTodo = this.set(index, editedTodo);
        return newTodo;
    }

    }