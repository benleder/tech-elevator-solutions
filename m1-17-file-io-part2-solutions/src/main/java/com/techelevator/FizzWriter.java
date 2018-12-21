package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Create a program to write out the result of FizzBuzz (1 to 300) to a file.
 * 
 * Note, this version of FizzBuzz has additional requirements
 * - If the number is divisible by 3, or contains a 3, print “Fizz”
 * - If the number is divisible by 5, or contains a 5, print “Buzz”
 * - If the number is divisible by 3 and 5, print “FizzBuzz”
 * - Otherwise print the number.
 * 
 * The program should prompt the user for the following values:
 * - The destination file.  If the file already exists, it should be overwritten. If the user 
 *   enters an invalid destination file, the program will indicate this and exit.
 */

public class FizzWriter {

	public static void main(String[] args) {

		try (Scanner userInput = new Scanner(System.in)) {
			
			// Get the destination file
			File destinationFile;
			System.out.println("What is the destination file?");
			String path = userInput.nextLine();
			// Validate the input file
			destinationFile = new File(path);
			
			// Write FizzBuzz 1 - 300
			try (PrintWriter destinationWriter = new PrintWriter(destinationFile.getAbsoluteFile())){
				for (int i = 1; i <= 300; i++) {
					boolean isDivisibleBy5 = i % 5 == 0;
					boolean isDivisibleBy3 = i % 3 == 0;
					if (isDivisibleBy5 && isDivisibleBy3) {
						destinationWriter.println("FizzBuzz");
					}
					else if (isDivisibleBy3 || Integer.toString(i).contains("3")) {
						destinationWriter.println("Fizz");
					}
					else if (isDivisibleBy5 || Integer.toString(i).contains("5")) {
						destinationWriter.println("Buzz");
					}
					else {
						destinationWriter.println(Integer.toString(i));
					}
				}
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage() + ". Please check the path.");
		}
		

	}

}
