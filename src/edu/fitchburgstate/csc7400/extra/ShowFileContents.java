package edu.fitchburgstate.csc7400.extra;

import java.io.File;
import java.io.PrintWriter;


//Declaring main class with calls to methods of classes that read and display contents of files from the specified directory.
public class ShowFileContents {
	public static void main(String[] args) {
		
		//Checks that the class is executed in the correct format (mentioning the directory name), else displays a message with correct format to the user
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
        
      //String variable to store directory name
        String dirname = args[0];

      //Declaring object of type File
        File dir = new File(dirname);
        
        // Checks that a directory exists with the specified name. Displays message to the user if it does not exist and exits.
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
        
        // Checks that specified argument is name of a directory. Displays message to the user if it is not and exits.
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }

        //Declaring object of type PrintWriter with 'System.out' aas argument so as to display the contents in the console.
        PrintWriter outWriter = new PrintWriter(System.out);
        
     // Loops through each file in the directory, and calls 'display' method of SlowFileStringifier class to display content of file. Skips any sub-directories.
        for (File file: dir.listFiles()) {
        	if (file.isDirectory()) continue;
        	
        	//Creating an object of SlowFileStringifier class to call the display method that displays content of file. Object is declared of type FileStringifier but an object of SlowFileStringifier  is created (as it implements FileStringifier). 
        	FileStringifier fileStringifier = new SlowFileStringifier(file.getPath());
        	fileStringifier.display(outWriter);
        }
    }
  }

