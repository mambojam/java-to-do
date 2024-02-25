import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoApp {

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
            
            // Username not recognised:
        } catch (IOException e) {
            System.out.println("We couldn't find your Todo List, " + username + 
            ", would you like to set up a new account or try logging in again?"); // Give user the option to try logging in again or create a new Todo List
            
            String answer = "";
            while (!answer.equals("LOGIN") && !answer.equals("SIGNUP")) {
                System.out.println("Please enter: 'LOGIN' or 'SIGNUP'");
                answer = inScan.nextLine().trim();
            }
            
            if (answer.equals("LOGIN")) {
                return null; // If Login, return null and begin User Authenticaton again
            } else {
                return new TodoList(username); // Return new TodoList for new User
            }
                
        }
    }

    public static void main(String[] args) {

        // Create a new scanner object
        Scanner inScan = new Scanner(System.in);
        Boolean validUser = false; // Switch for user authentication
        String username = "Default"; // Default username

        TodoList Todos = new TodoList(username); // Default TodoList object

        while (validUser == false) { // Authenticate user
            // Print out and ask user for Username
            System.out.print("Please enter username: ");
            // Save username
            username = inScan.nextLine();

            Todos = readTodos(username); // Call the readTodos() function on the entered username

            if ( Todos != null ) { // If readTodos() returns a valid return type (TodoList)
                validUser = true; // Approve user
            }
        }
        
        System.out.println("Welcome " + username + ". What would you like to do?");
        Boolean running = true;
        String filename = username + "_todos.txt"; 

        while ( running ) {
            System.out.println("Please select: 'ADD', 'VIEW', 'EDIT', 'COMPLETE', 'EXIT'");
            String input = inScan.nextLine().toUpperCase().trim(); // Clean up input

            switch (input) { 
                case "ADD" :
                    System.out.print("Please enter a new todo: "); // Print out and ask user for a todo item
                    String todoDescription = inScan.nextLine(); // Save the user input - todo description

                    System.out.print("When is this due? "); // Print out and ask user for a due date
                    String todoDueDate = inScan.nextLine(); // Save the user input - todo due date
                    
                    Todos.addTodo(todoDescription, todoDueDate);
                    Todos.writeTodos(filename);
                    
                    break;
                
                case "VIEW" :
                    Todos.getTodos();
                    break;

                case "EDIT" :
                    System.out.println("Please enter the number todo you want to edit:"); // Prompt user to input number
                    int todoToEdit = -1;

                    while ( true ) {
                        try {
                            Todos.getTodos(); // Show numbered list of tasks
                            todoToEdit = inScan.nextInt() - 1 ; // Take int input
                            inScan.nextLine(); // Consume the newline character

                            if ( todoToEdit < 0 || todoToEdit >= Todos.size() ) {
                                System.out.println("Please enter a number corresponding to a task");
                                continue; // Move onto next iteration of loop
                            }

                            String newDescription = "";
                            System.out.print("Do you want to change the description? Enter new description to change or leave blank to move on to changing the date: "); // Print out and ask user for a todo item
                            
                            newDescription = inScan.nextLine(); // Save the user input - todo description
                            if ( newDescription.equals("") ) {
                                newDescription = Todos.getTodo(todoToEdit).getTodo();
                            }

                            System.out.print("Do you want to change the due date? Enter new date to change or leave blank to move on: \" "); // Print out and ask user for a due date
                            String newDueDate = inScan.nextLine(); // Save the user input - todo due date
                            if ( newDueDate.equals("") ) {
                                newDueDate = Todos.getTodo(todoToEdit).getDueDate();
                            }

                            TodoItem oldTodo = Todos.getTodo(todoToEdit);
                            TodoItem newTodo = new TodoItem(newDescription, newDueDate);
                            System.out.println("You Edited \"" + oldTodo.getTodo() +"\", new task is: \"" + newTodo + "\".");              
                            Todos.editTodo(todoToEdit, newTodo); 
                            Todos.writeTodos(filename);
                            break;

                        } catch (InputMismatchException e ) {
                            System.out.println("Please enter a whole number corresponding to a task");
                            inScan.nextLine(); // Consume the invalid input
                        }
                    } 
                    break;

                case "COMPLETE" : // Need to add exception handling for other data input types
                    System.out.println("Please enter the number todo you have completed:"); // Prompt user to input number
                    int todoToComplete = -1;

                    while ( true ) {
                        try {
                            Todos.getTodos(); // Show numbered list of tasks
                            todoToComplete = inScan.nextInt() - 1 ; // Take int input
                            inScan.nextLine(); // Consume the newline character

                            if ( todoToComplete < 0 || todoToComplete >= Todos.size() ) {
                                System.out.println("Please enter a number corresponding to a task");
                                continue; // Move onto next iteration of loop
                            }
                            TodoItem completedTodo = Todos.getTodo(todoToComplete);
                            System.out.println("Well done! You completed \"" + completedTodo.getTodo() +"\"");              
                            Todos.completeTodo(todoToComplete); 
                            Todos.writeTodos(filename);
                            break;

                        } catch (InputMismatchException e ) {
                            System.out.println("Please enter a whole number corresponding to a task");
                            inScan.nextLine(); // Consume the invalid input
                        }
                    }    
                    break;

                case "EXIT" :
                    running = false;
                    break;
            }

        }
    }
}
