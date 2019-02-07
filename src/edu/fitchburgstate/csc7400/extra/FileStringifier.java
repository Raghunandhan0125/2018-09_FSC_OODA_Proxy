package edu.fitchburgstate.csc7400.extra;
import java.io.*;


//Declaring FileStringifier interface
public interface FileStringifier {
	
	  //Declaring interface method with one argument of type PrintWriter
	void display(PrintWriter out);
	
	//Declaring interface method of type String
	public String stringify();
}
