import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


//buffered reader from https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html.
public class readwrite {
	public static void main(String [] args) {
		
		//variables
		int linecount=0;

        // The name of the file to open.
        String fileName = "text/text";

        // This will reference one line at a time
        String line = null;
        
        //READ
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            //store stuff
            String print="";
            
            //count the number of lines to read and display lines
            while((line = bufferedReader.readLine()) != null) {
                linecount=linecount+1;
                print=line;
                System.out.println(print);
            }   
            
            //display a section of the text
            System.out.println(print.substring(5, 10));
            //display that
            System.out.println(linecount);
            
           

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        //WRITE
        fileName = "text/write";
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);
            
            //text to print
            String write=JOptionPane.showInputDialog(null,"Type some text to write");
            
            while(write.equals("")){
            	write=JOptionPane.showInputDialog(null,"Just type something.");
            }

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(write);
            bufferedWriter.newLine();
            bufferedWriter.write(write+" "+write);

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
