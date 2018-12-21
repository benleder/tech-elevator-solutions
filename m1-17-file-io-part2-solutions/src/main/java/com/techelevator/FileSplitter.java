package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * FileSplitter (Challenge Level)
 * 
 * Develop an application that takes a significantly large input file and splits it into smaller file chunks.
 * 
 * The program should prompt the user for the following values:
 * - The source file. This must be an existing file. If the user enters an invalid source file path, 
 *   the program will indicate this and exit.
 * - The maximum number of lines in each output file.
 * 
 * Each output file that is created should have a sequential number assigned to it. For example, given "fizzbuzz.txt"
 * as the source filename, the output filenames should be "fizzbuzz-1.txt", "fizzbuzz-2.txt", ....
 * 
 * These types of files use to be used quite common back in the earlier days of computing when disks such as floppies
 * ere much smaller and couldn’t hold a larger program on their own.
 */
public class FileSplitter {

	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {
			
			// Get the location of the source file
			File sourceFile;
			System.out.println("What is the input file?");
			String path = userInput.nextLine();
			// Validate the input file
			sourceFile = new File(path);
			if(sourceFile.exists() == false) {
				System.out.println(path+" does not exist");
				System.exit(1);
			} else if(sourceFile.isFile() == false) {
				System.out.println(path+" is not a file");
				System.exit(1);
			}

			// Get the search word
			System.out.println("What is the maximum number of lines in each output file?");
			int maxLineCount = userInput.nextInt();
			
			// Setup the initial destination file
			String destinationPath = sourceFile.getAbsoluteFile().getParent();
			String destinationFilename = sourceFile.getAbsoluteFile().getName();
			String destinationExtension = "";
			if (destinationFilename.contains(".")) {
				// Separate filename and extension
				int lastPeriod = destinationFilename.lastIndexOf(".");
				destinationExtension = destinationFilename.substring(lastPeriod);	// Period before extension is preserved in the string
				destinationFilename = destinationFilename.substring(0, lastPeriod); // Period before extension is removed from the string
			}
			File destinationFile = new File(destinationPath + File.separatorChar + destinationFilename + "-1" + destinationExtension);
			
			// Split file
			int currentLineCount = 0;
			int currentFileCount = 1;
			try (Scanner sourceScanner = new Scanner(sourceFile.getAbsoluteFile())){
				PrintWriter destinationWriter = null;
				try {
					destinationWriter = new PrintWriter(destinationFile.getAbsoluteFile());					
					while (sourceScanner.hasNextLine()) {
						String line = sourceScanner.nextLine();
						if (currentLineCount >= maxLineCount) {
							destinationWriter.close();
							currentLineCount = 0;
							currentFileCount++;
							destinationFile = new File(destinationPath + File.separatorChar + destinationFilename + "-" +
									Integer.toString(currentFileCount) + destinationExtension);
							destinationWriter = new PrintWriter(destinationFile.getAbsoluteFile());
							
						}
						currentLineCount++;
						destinationWriter.println(line);
					}
				}
				finally {
					if (destinationWriter != null) {
						destinationWriter.close();
					}
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
