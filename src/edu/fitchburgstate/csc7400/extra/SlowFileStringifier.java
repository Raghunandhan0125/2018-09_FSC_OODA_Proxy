package edu.fitchburgstate.csc7400.extra;

import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;


public class SlowFileStringifier implements FileStringifier {

	/* constructor for the file name */
    public SlowFileStringifier(String filename) {
        this.fileName = filename;
    }

    /* method to display the contents of file */
    public void display(PrintWriter out) {
    	out.println(this.stringify());
    	out.flush();
    }
    
    public String stringify() {
        FileReader f;
		try {
			f = new FileReader(this.fileName);
	        BufferedReader bf = new BufferedReader(f);
		/* array list for storing the content of file */
	        ArrayList<String> lines = new ArrayList<String>();
	        String line = null;
                /* read the file line by line */
	        while ((line = bf.readLine()) != null) {
	            Thread.sleep(2000); /* sleep for 2 sec */
	            lines.add(line);	/* add each line to arraylist */
	        }
	        bf.close();
		/* add the new line character after each line int the arraylist */
	        return String.join("\n", lines);
        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File "+this.fileName+" was not found.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problem reading file "+this.fileName+".");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("File reading interrupted: "+this.fileName);
		}
		return "";
    }

    private final String fileName;
}

