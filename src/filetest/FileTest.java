
package filetest;



import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *
 * @author Asif Shahristani
 */
public class FileTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{ 
                // Getting the file name
             String file_name = FileUtil.getFileName();
             System.out.println();
             
           while(true) {
             int selected_option = FileUtil.options();
             switch(selected_option) {
                 // print
                case 1:
                     new FileUtil(file_name).display();
                     System.out.println();
                     System.out.println("*********************************************************************************");
                     System.out.println();
                     break;
                 // number of lines
                case 2:
                     System.out.println("File contains: " + new FileUtil(file_name).countLine() + " Lines");
                     System.out.println();
                     System.out.println("*********************************************************************************");
                     System.out.println();
                     break;
                 // number of Words
                case 3: 
                     System.out.println("File contains: " + new FileUtil(file_name).countWord() + " Words");
                     System.out.println();
                     System.out.println("*********************************************************************************");
                     System.out.println();
                    break;
                 // number of chacracters 
                case 4:
                     System.out.println("The file Contains: " + new FileUtil(file_name).countChars() + " characters");
                     System.out.println("The file Contains: " + new FileUtil(file_name).countCharsWithSpace()+ " characters(Included space)");
                     System.out.println();
                     System.out.println("*********************************************************************************");
                     System.out.println();
                    break;
                 // Terminate
                case 5:
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid Option choosed! ");
                    break;
             }
          } // while
       }  // try
       
        // Catching Exception if file not found       
       catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");                
        }
       // Catching Exception if there is an io error
        catch(IOException ex) {
            System.out.println("Error reading file ");                  
        }
    }
    
}
