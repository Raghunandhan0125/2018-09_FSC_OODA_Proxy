/*
 * Created on: 02/06/2019
 * Author : Raghunandhan
 * 
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.*;
import java.util.ArrayList;

/**
 * The class slowFileStringifier display the implementation of an interface "FileStringifier"
 *  override two abstract methods for reading and displaying contents of file 
 */

public class SlowFileStringifier implements FileStringifier {

	/**
	 * Constructor of SlowFileStringifier class and gets executed when ever object for this class is created.
	 * @param filename
	 */
    public SlowFileStringifier(String filename) {
        this.fileName = filename;
    }
 //Interface method being implemented.
    public void display(PrintWriter out) {
//    	Println() method is called out on System.out reference hence it prints output on console and stringify() is called inside this method.
    	out.println(this.stringify());
//    	flush() method is used to flush out any data that got stuck or saved inside the output stream onto the console.
    	out.flush();
    }
   //    This stringify() method is used to return the file contents.
    public String stringify() {
//    	Local FileReader reference.
        FileReader f;
		try {
//			FileReader object created with filepath thats passed to the constructor.
			f = new FileReader(this.fileName);
//			BufferedReader object is created and it takes Filereader object reference as it can't directly communicate with the file.
	        BufferedReader bf = new BufferedReader(f);
//			ArrayList collection object of generic String.
	        ArrayList<String> lines = new ArrayList<String>();
//	        String type local variable line
	        String line = null;
//	        while loop used to read the contents in files line by line using readLine() method.
	        while ((line = bf.readLine()) != null) {
//	        	Thread.sleep() stops the execution of thread for given amount of time.
	            Thread.sleep(2000);
//	            add() method is used to add the each read line to ArrayList collection object by being called with ArrayList object reference.
	            lines.add(line);
	        }
//	        close() method is used to close the costly resource BufferedReader.
	        bf.close();
//	        stringify() method returning the ArrayList object reference.
	        return String.join("\n", lines);
	        
//        Here catch blocks will handle the exceptions that rise during execution of code.
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

/** 
* The file name.
* private String variable and this can only be used in this class.
*/
    private final String fileName;
}