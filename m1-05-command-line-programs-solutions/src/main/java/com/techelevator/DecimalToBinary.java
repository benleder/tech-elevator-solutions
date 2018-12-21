package com.techelevator;

/*
Write a command line program which accepts a series of decimal integer values as command line arguments, 
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 460 8218 1 31313 987654321
460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
public class DecimalToBinary {

	public static void main(String[] args) {

		for(int ix = 0; ix < args.length; ix++) {
			
			String binary = "";
			
			int decimal = Integer.parseInt(args[ix]);
			for( ; decimal > 0; decimal = decimal / 2) { // the first and last section of the for loop are optional.  Here, we do not do anything before the for loop begins.
				binary = (decimal % 2) + binary;
			}
			
			System.out.println(args[ix]+" in binary is "+binary);
		}
	}
}
