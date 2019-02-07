/*
 * Created on : 
 * Author :
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.*;


/**
 * The Interface FileStringifier. It contains two methods, one is default display method and another is public stringify method.
 */
//Interface implemented by SlowFileStringifier.
public interface FileStringifier {

/**
 * Display.
 *
 * @param out, the out is of PrintWriter type and out reference is used to print on console and to flush.
 */
//	default method and is available in this package only and can't be accessed out of this package.
	void display(PrintWriter out);

/**
 * Stringify.
 *
 * @return the string, and it holds a single line in a file as value.
 */
//public method can be accessed any where.
	public String stringify();
}