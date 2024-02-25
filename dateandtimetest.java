import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class dateandtimetest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("Today's date: " + now);

        LocalTime nowTime = LocalTime.now();
        System.out.println("The time is: " + nowTime);

        LocalDateTime unformattedtime = LocalDateTime.of(2024, 2, 25, 13, 12);
        System.out.println("Before formatting: " + unformattedtime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        String formattedDateTime = unformattedtime.format(formatter);
        System.out.println("After formatting: "+formattedDateTime);



        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a new todo: "); // Print out and ask user for a todo item
        String todoDescription = in.nextLine(); // Save the user input - todo description

        System.out.println("Please enter due date? dd-MM-yyyy"); // Print out and ask user for a due date
        String dueDate = in.nextLine(); // Save the user input - todo due date
        String[] dueDateParts = dueDate.split("-");

        System.out.println("Please enter due time? HH:mm"); // Print out and ask user for a due date
        String dueTime = in.nextLine();
        String[] dueTimeParts = dueTime.split(":");

        Integer number;
        Integer[] numParts = new Integer[5];

        for ( int i = 0 ; i < dueDateParts.length ; i ++ ) {
            number = Integer.valueOf(dueDateParts[i]);
            numParts[i] = number;
        }
        for ( int i = 0 ; i < dueTimeParts.length ; i ++ ) {
            number = Integer.valueOf(dueTimeParts[i]);
            numParts[i+dueDateParts.length] = number;
        }
        
        LocalDateTime newDateTime = LocalDateTime.of(numParts[2], numParts[1], numParts[0], numParts[3], numParts[4]);

        System.out.println("Before formatting: " + newDateTime);

        String newformattedDateTime = newDateTime.format(formatter);
        System.out.println("After formatting: "+ newformattedDateTime);

    }
    
}
