import java.util.Scanner;

public class createStringtest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter username: ");
        String username = in.nextLine();
        String filename = username + "_todos.txt";
        System.out.println(filename);
    }
    
}
