import java.util.Scanner;


public class TodoList {
    public static void main(String args[]) {
        // Create a new scanner object
        Scanner inScan = new Scanner(System.in);
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