import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class newfiletest {
    public static void main(String[] args) {
        Scanner inScan = new Scanner(System.in);

        System.out.println("Enter filename: ");
        
        String filename = inScan.nextLine();

        File inFile = new File ( filename );       
        
        while ( true ) {
            if ( inFile.exists() ) {
                System.out.println("Loading Todo List");
                break;
            } else {
                System.out.println( "Couldn't find file, please try again");
            }
        }
            

        try {

            FileWriter writer = new FileWriter( filename );
            BufferedWriter out = new BufferedWriter(writer);

            for (int i = 1; i <= 10 ; i++ ) {
                out.write( "Hello\n");
            }
            
            out.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }   
        
    }
}
