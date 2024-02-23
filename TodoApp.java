import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TodoApp {

   public String[] readTodos 
   // Login / get Owner

   // Owner existing ?
   // Yes - Get Todo List from file
   // No - Initialise new Todo List

   // What would the user like to do (add, get, complete, edit)
   // switch (input)
   // case add: todolist.add()
   // case get etc..

   public static void main(String args[]) {
      // Create a new scanner object
      Scanner inScan = new Scanner(System.in);
      // Print out and ask user for name
      System.out.print("Please enter username: ");
      // Save the user name
      String Username = inScan.nextLine();

      while (true) {
            
            try {
               String fileString = Username + "_todos.txt";
               FileReader reader = new FileReader(fileString);
               BufferedReader inRead = new BufferedReader(reader);

               FileWriter writer = newFile
               
               String todo;
               // Get user's TodoList
               while ( (todo = inRead.readLine()) != null ) {
                  String[] splitTodo = todo.split(",");
                  String description = splitTodo[0];
                  String dueDate = splitTodo[1];
                  System.out.println(description + " due " + dueDate);
               }   
         
            } catch (FileNotFoundException e) {
               System.out.println("User not found, would you like to set up an account?");
               String Answer = inScan.nextLine();
               switch (Answer) {
                  case "Yes":
                     // Print out and ask user for a todo item
                     System.out.println("Please enter a new todo: ");
                     // Save the user input - todo description
                     String description = inScan.nextLine();

                     // Print out and ask user for a due date
                     System.out.println("When is this due? ");
                     // Save the user input - todo due date
                     String dueDate = inScan.nextLine();
                     
                     
               
                  default:
                     break;
               }   
            }

      }
      
     

        // Print out and ask user for a todo item
        System.out.print("Please enter a new todo: ");
        // Save the user input - todo description
        String todoDescription = inScan.nextLine();

        // Print out and ask user for a due date
        System.out.print("When is this due? ");
        // Save the user input - todo due date
        String todoDueDate = inScan.nextLine();
        
        TodoItem item1 = new TodoItem(todoDescription, todoDueDate);

        System.out.println(item1.getTodo() + " by " + item1.getDueDate());
   
        // Close scanner
        inScan.close();
   }
}
