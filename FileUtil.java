package filetest;

// importing necessary classes.
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Asif Shahristani
 */
public class FileUtil {
    
    // Name of the file to open    
    private static String fileName;
    
    // The path to files please change it
    private String path = "C:\\Users\\Shahristani\\Documents\\NetBeansProjects\\FileTest\\src\\files\\";
    
    // reader object
    private BufferedReader reader;  
    
    File file;
    
    /**
     * Constructor method
     * @param fileName 
     */
    public FileUtil (String fileName) throws FileNotFoundException {
        // setting file name
        this.fileName = fileName;
        
        // completing the path
        this.path = this.path + fileName;
        
        // creating file object 
        this.file = new File(this.path);
        
        this.reader  = new BufferedReader(new FileReader(this.file));
        
    }
    
    /**
     * print a message for user to enter the file name
     * after the user entered the file name simply returns it
     * @return String
     */
    public static String getFileName () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the of file with extention .txt");
        fileName = input.nextLine();
        return fileName.trim();
    }
    
    /**
     * display the options and then getting the option and return it
     * @return integer 
     */
    public static int options () {
       int selected_option = -1;
       Scanner input = new Scanner(System.in);
       System.out.println("Welcome please choose an option a enter the opetions number!");
       System.out.println("----------------------------------------------------------------------------");
       System.out.println();
       System.out.println("(1) Print (display the file content on screen)");
       System.out.println("(2) Lines (count the number of lines in file)");
       System.out.println("(3) Words (Count the number of words in file)");
       System.out.println("(4) Characters (count the number of char in file)");
       System.out.println("(5) Exit (to terminate the file)");
       
       selected_option = input.nextInt();
       return selected_option;
    }
    
    
    /**
     * Prints contents of a file
     * @throws IOException 
     */
    public void display () throws IOException {
        // this will reference one line at a time
        String line = null;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
    
    /**
     * Counts the number of lines in a file
     * @return integer
     * @throws IOException 
     */
    public int countLine () throws IOException {
     // holds number of lines
     int num_of_lines = 0;
     String line = null;
     while((line = reader.readLine()) != null) {
         num_of_lines++;
     }
     reader.close();
     return num_of_lines;   
    }
    
    /**
     * Counts the number of words in a file
     * @return integer
     * @throws IOException 
     */
    public int countWord () throws IOException {
        // holds number of words
        int num_of_words = 0;
        String line = null;
        while((line = reader.readLine()) != null) {
            // spliting each line according to space and 
            // then getting the number words and summing it with num_of_words
            num_of_words += line.split(" ").length;
        }
        reader.close();
        return num_of_words;
    }
    
    /**
     * Counts the number characters in a file
     * counts space as a character
     * @return integer
     * @throws IOException 
     */
    public int countCharsWithSpace () throws IOException {
        int num_of_chars = 0;
        String line = null;
        while((line = reader.readLine()) != null) {
            // removing before and after spaces 
            line = line.trim();
            // summing each lines number of characters            
            num_of_chars += line.length();
        }
        reader.close();
        return num_of_chars;
    }
    
    /**
     * Counts the number of characters in a file
     * ignores space
     * @return  integer
     * @throws IOException 
     */
    public int countChars () throws IOException {
       int num_of_chars = 0;
       String line = null;
       while ((line = reader.readLine()) != null) {
           for(String word : line.split(" ")) {
               word = word.trim();
               num_of_chars += word.length();
           }
       }
       reader.close();
       return num_of_chars;
    }
    
}
