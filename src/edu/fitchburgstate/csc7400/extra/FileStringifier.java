/*
 * Created on : 02/06/2019
 * Author :Raghunandhan
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.*;


/**
 * The Interface FileStringifier. It contains two methods, one is default display method and another is public stringify method.
 */

public interface FileStringifier {

/**
 * Display used to display contents 
 *
 * @param out, the out is of PrintWriter type and out reference is used to print on console and to flush.
 */

	void display(PrintWriter out);

/**
 * Stringify is an abstract method 
 *
 * @return the string, and it holds a single line in a file as value.
 */

	public String stringify();
}