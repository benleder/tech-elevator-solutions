package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = getChoiceFromOptions(options, (char)0);
		return choice;
	}
	
	public Object getChoiceFromOptions(Object[] options, char nav ) {
		if (nav != 'B'  &&  nav != 'Q') {
			nav = (char)0;
		}
		Object choice = null;
		while(choice == null) {
			displayMenuOptions(options, nav);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}
	
	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if(selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch(NumberFormatException e) {
			String possibleCommands = "QqBb";
			if (possibleCommands.contains(userInput));
			{
				choice = (Object)userInput;
			}
			// else eat the exception, an error message will be displayed below since choice will be null
		}
		if(choice == null) {
			out.println("\n*** "+userInput+" is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		displayMenuOptions(options, (char)0);
	}

	private void displayMenuOptions(Object[] options, char nav) {
		out.println();
		for(int i = 0; i < options.length; i++) {
			int optionNum = i+1;
			// use the object's toString method to display information
			out.println(optionNum+") "+options[i]);
		}
		if(nav == 'B')
		{
			out.println("B) Back");
		}
		else if (nav == 'Q')
		{
			out.println("Q) Quit");
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}