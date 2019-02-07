/*
 * Created on : 
 * Author : 
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.File;
import java.io.PrintWriter;


/**
 * The Class ShowFileContents. In this the given path as argument to main method is validated
 * and an object of slowFileStringifier is created and display method is called using the slowFileStringifier object reference.
 */
public class ShowFileContents {

/**
 * The main method.
 *
 * @param args the String array arguments of main holds the path of text files as value.
 */
//	Directory path to be given as arguments to main methods String array(command line arguments).
    public static void main(String[] args) {

//    	If argument to main method is not passed then thread enters inside if block.
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
//       Path argument is stored in dirname 
        String dirname = args[0];
//        File object is created and path is passed as an argument to file object constructor.
        File dir = new File(dirname);
//        If the given directory doesn't exist then thread enters into this if block and execution stops.
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }
//		PrintWriter object is created and System.out is sent as an argument to Printwriter object's constructor.
        PrintWriter outWriter = new PrintWriter(System.out);
//       For each loop is used to list out all the files one by one. 
        for (File file: dir.listFiles()) {
        	if (file.isDirectory()) continue;
//        	Object of SlowFileStringifier is created and is handled by FileStringifier interface as SlowFileStringifier is implementing FileStringifier.
//        	File path is passed to this object constructor by making use of getPath() method.
        	FileStringifier fileStringifier = new SlowFileStringifier(file.getPath());
//        	A non static method Display inside SlowStringifier implimented from FileStringifier is called using FileStringifier object reference.
        	fileStringifier.display(outWriter);
        }
    }
  }