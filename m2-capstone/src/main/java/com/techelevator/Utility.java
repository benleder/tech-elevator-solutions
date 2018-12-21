package com.techelevator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	public static void clear() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}

	public static String formatter(String input) {
		String result = formatter(input, 0);
		return result;
	}

	public static String formatter(String input, int titleLength) {
		final int LIMIT = 75;
		String result = "";
		String[] words = input.split("\\ ");
		int counter = titleLength; // includes title length in first line
		for (String word : words) {
			result += word + " ";
			counter += word.length() + 1;
			if (counter > LIMIT) {
				counter = 0;
				result += "\n";
			}
		}
		return result;
	}

	public static String month(int input) {
		String[] months = { "invalid", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		return months[input];
	}

	public static Date toDate(String input) {

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = formatter.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
