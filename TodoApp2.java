import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp2 {

    public static TodoList readTodos(String username) {
        
        Scanner inScan = new Scanner(System.in);

        try {

            String filename = username + "_todos.txt"; // Take username and create filename
            FileReader reader = new FileReader(filename); // Set up FileReader for thr filename
            BufferedReader in = new BufferedReader(reader); // Set up buffer for the reader
            TodoList Todos = new TodoList(username); // Initialise a TodoList for the user
            String todo; // Initialise a new string 
            while ((todo = in.readLine()) != null ) { // Assign line of File to String and check it is NOT NULL
                String[] todoParts = todo.split(","); // Split into parts
                Todos.addTodo(todoParts[0], todoParts[1]); // Add new Todo Item to TodoList
            }
            in.close();
            return Todos;
            
        } catch (IOException e) {
            System.out.println("We couldn't find your Todo List, " + username + 
            ", would you like to set up a new account or try logging in again?"); 
            
            String answer = "";
            while (!answer.equals("LOGIN") && !answer.equals("SIGNUP")) {
                System.out.println("Please enter: 'LOGIN' or 'SIGNUP'");
                answer = inScan.nextLine().trim();
            }
            
            if (answer.equals("LOGIN")) {
                return null; 
            } else {
                inScan.close();
                return new TodoList(username); // Return new TodoList for new User
            }
                
        }
    }
    public static void main(String[] args) {

        // Create a new scanner object
        Scanner inScan = new Scanner(System.in);
        Boolean validUser = false;
        String username = "Default";

        TodoList Todos = new TodoList(username);

        while (validUser == false) {
            // Print out and ask user for Username
            System.out.print("Please enter username: ");
            // Save username
            username = inScan.nextLine();

            Todos = new TodoList(username);

            Todos = readTodos(username);

            if ( Todos != null ) {
                validUser = true;
            }
        }
        
        System.out.println("Welcome " + username + ". What would you like to do?");
        Boolean running = true;
        while ( running ) {
            System.out.println("Please select: 'ADD', 'VIEW', 'EDIT', 'COMPLETE', 'EXIT'");
            String input = inScan.nextLine();

            switch (input) { // Can we make this not case sensitive?
                case "ADD" :
                    System.out.print("Please enter a new todo: "); // Print out and ask user for a todo item
                    String todoDescription = inScan.nextLine(); // Save the user input - todo description

                    System.out.print("When is this due? "); // Print out and ask user for a due date
                    String todoDueDate = inScan.nextLine(); // Save the user input - todo due date
                    
                    Todos.addTodo(todoDescription, todoDueDate);
                    break;
                
                case "VIEW" :
                    Todos.getTodos();
                    break;

                case "EXIT" :
                    running = false;
                    break;
            }

        }
        

        
    
        
        // String answer;
        // while (true) {
        //     // What does the user want to do
        //     System.out.print("What next? ");
        //     // Save the user input - todo due date
        //     answer = inScan.nextLine();
            
        //     switch ( answer ) {
        //         case "Add":
        //             // Print out and ask user for a todo item
        //             System.out.print("Please enter a new todo: ");
        //             // Save the user input - todo description
        //             todoDescription = inScan.nextLine();

        //             // Print out and ask user for a due date
        //             System.out.print("When is this due? ");
        //             // Save the user input - todo due date
        //             todoDueDate = inScan.nextLine();

        //             TodoList.addTodo(todoDescription, todoDueDate);
        //         case "View": 
        //             TodoList.getTodos();
        //         case "Finish": 
        //             break;
        //     }
        // }        
    }
}
