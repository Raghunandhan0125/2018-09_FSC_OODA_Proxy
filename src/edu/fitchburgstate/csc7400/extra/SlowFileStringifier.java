package edu.fitchburgstate.csc7400.extra;

import java.io.*;
import java.util.ArrayList;

import java.io.PrintWriter;


//Declaring class that implements FileStringifier
public class SlowFileStringifier implements FileStringifier {

	//Defining constructor for the class SlowFileStringifier
	  public SlowFileStringifier(String filename) {
	        this.fileName = filename;
	    }

	// Defining interface method to display contents of file
	    public void display(PrintWriter out) {
	    	
	    	//Prints content returned by stringify method on to console
	    	out.println(this.stringify());
	    	
	    	//clears content of out object
	    	out.flush();
	    }
	    
	  //Interface method implementation to read content of file and return as as a String
	    public String stringify() {
	        FileReader f;
			try {
				f = new FileReader(this.fileName);
				
				//declaring object of type BufferedReader to read contents of a file
		        BufferedReader bf = new BufferedReader(f);
		
		      //Declaring arraylist of type String to copy content of BufferedReader object into
		        ArrayList<String> lines = new ArrayList<String>();
		        
		      //Initializing String variable
		        String line = null;
		        
		      //Method to read each line of file and add the line to array list. Exit when end of BufferedReader is reached.
		        while ((line = bf.readLine()) != null) {
		            Thread.sleep(2000);
		            lines.add(line);
		        }
		        
		     // closes BufferedReader object
		        bf.close();
		        
		      //Returns the content of the file from array list as a String after adding end of line operator at end of each line
		        return String.join("\n", lines);
	        
		        //Throws error if a file is not found at the specified location
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.err.println("File "+this.fileName+" was not found.");
				
				//Throws error if a file cannot be read
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Problem reading file "+this.fileName+".");
				
				//Throws error when file reading is interruped
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.err.println("File reading interrupted: "+this.fileName);
			}
			
			//returns "" when an exception is encountered
			return "";
	    }

	    private final String fileName;
	}


