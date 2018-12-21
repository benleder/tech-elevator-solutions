package com.techelevator;

import java.util.Scanner;

/*
 The foot to meter conversion formula is:
 	m = f * 0.3048
 	
 The meter to foot conversion formula is:
 	f = m * 3.2808399
 	
 Write a command line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
 Convert the length to the opposite measurement, and display the old and new measurements to the console.
  
 $ java LinearConvert
 Please enter the length: 58
 Is the measurement in (m)eter, or (f)eet? f
 58f is 17m.
 */

public class LinearConvert {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter the length: ");
		String lengthInput = userInput.nextLine();
		int length = Integer.parseInt(lengthInput);
		
		System.out.print("Is the measurement in (m)eters, or (f)eet?: ");
		String unitInput = userInput.nextLine();
		
		if("f".equals(unitInput)) {
			int meterLength = (int)(length * .3048);
			System.out.println(length+"f is "+meterLength+"m.");
		} else if("m".equals(unitInput)) {
			int feetLength = (int)(length * 3.2808399);
			System.out.println(length+"m is "+feetLength+"f.");
		} else {
			System.out.println(unitInput + " is an invalid choice.");
		}
	}

}
