/*
 * Created on : 02/06/2019
 * Author : Raghunandhan
 */
package edu.fitchburgstate.csc7400.extra;

import java.io.File;
import java.io.PrintWriter;


/**
 * The Class ShowFileContents. In this the given path as argument to main method is validated
 * and an object of slowFileStringifier is created and display method is called for printing the content to console.
 */
public class ShowFileContents {
/**
 * The main method.
 *
 * @param args the String array arguments of main holds the path of text files as value.
 */
	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
        }
          String dirname = args[0];
//        File object is created and path is passed as an argument to file object constructor.
        File dir = new File(dirname);
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
//        	A non static method Display inside SlowStringifier implemented from FileStringifier is called using FileStringifier object reference.
        	fileStringifier.display(outWriter);
        }
    }
  }