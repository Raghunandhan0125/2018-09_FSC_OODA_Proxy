package edu.fitchburgstate.csc7400.extra;

import java.io.File;
import java.io.PrintWriter;

public class ShowFileContents {

	public static void main(String[] args) {
        /* checking for the commandline argument */
        if (args.length != 1) {
            System.out.println("Usage: java ShowFileContents <directory>");
	     return;
        }
        String dirname = args[0];
	
        File dir = new File(dirname);
        /* check if the directory exist or not */
        if (!dir.exists()) {
            System.err.println(dirname + " does not exist");
            return;
        }
	/* check if it is a valid directory or not */
        if (!dir.isDirectory()) {
            System.err.println(dirname + " is not a directory");
            return;
        }

        PrintWriter outWriter = new PrintWriter(System.out);
        for (File file: dir.listFiles()) {
		/* for each file in the direcotry if it is a directory skip it
		   otherwise send the path of the file to print the contents
		*/
        	if (file.isDirectory()) continue;
        	FileStringifier fileStringifier = new SlowFileStringifier(file.getPath());
        	fileStringifier.display(outWriter);
        }
    }
  }

}
