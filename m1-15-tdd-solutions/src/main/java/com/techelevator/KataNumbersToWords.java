package com.techelevator;

public class KataNumbersToWords {

    private final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };

    private final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };

    private final String[] specialNames = {
        "",
        " thousand",
        " million"
    };

	private String numberToWordsLessThanOneThousand(int number) {
		// Handle numbers less than 1000
		String words = "";
		if (number % 100 < 20) {
			words = numNames[number % 100];
			number /= 100;
		} else {
			words = numNames[number % 10];
			number /= 10;
			words = tensNames[number % 10] + words;
			number /= 10;
		}
		if (number == 0) {
			return words;
		}
		return numNames[number] + " hundred" + words;
	}

	public String numberToWords(int number) {
        if (number == 0) { return "zero"; }
        String prefix = "";
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        String current = "";
        int place = 0;
        do {
            int n = number % 1000;
            if (n != 0){
                String s = numberToWordsLessThanOneThousand(n);
                current = s + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);
        return (prefix + current).trim();
	}

	public int wordsToNumber(String words) {
		int number = 0;
		int finalNumber = 0;
		String[] valueWords = words.split(" ");
		for(String str : valueWords)
		{
		    if(str.equalsIgnoreCase("zero")) {
		    	number += 0;
		    }
		    else if(str.equalsIgnoreCase("one")) {
		    	number += 1;
		    }
		    else if(str.equalsIgnoreCase("two")) {
		    	number += 2;
		    }
		    else if(str.equalsIgnoreCase("three")) {
		    	number += 3;
		    }
		    else if(str.equalsIgnoreCase("four")) {
		    	number += 4;
		    }
		    else if(str.equalsIgnoreCase("five")) {
		    	number += 5;
		    }
		    else if(str.equalsIgnoreCase("six")) {
		    	number += 6;
		    }
		    else if(str.equalsIgnoreCase("seven")) {
		    	number += 7;
		    }
		    else if(str.equalsIgnoreCase("eight")) {
		    	number += 8;
		    }
		    else if(str.equalsIgnoreCase("nine")) {
		    	number += 9;
		    }
		    else if(str.equalsIgnoreCase("ten")) {
		    	number += 10;
		    }
		    else if(str.equalsIgnoreCase("eleven")) {
		    	number += 11;
		    }
		    else if(str.equalsIgnoreCase("twelve")) {
		    	number += 12;
		    }
		    else if(str.equalsIgnoreCase("thirteen")) {
		    	number += 13;
		    }
		    else if(str.equalsIgnoreCase("fourteen")) {
		    	number += 14;
		    }
		    else if(str.equalsIgnoreCase("fifteen")) {
		    	number += 15;
		    }
		    else if(str.equalsIgnoreCase("sixteen")) {
		    	number += 16;
		    }
		    else if(str.equalsIgnoreCase("seventeen")) {
		    	number += 17;
		    }
		    else if(str.equalsIgnoreCase("eighteen")) {
		    	number += 18;
		    }
		    else if(str.equalsIgnoreCase("nineteen")) {
		    	number += 19;
		    }
		    else if(str.equalsIgnoreCase("twenty")) {
		    	number += 20;
		    }
		    else if(str.equalsIgnoreCase("thirty")) {
		    	number += 30;
		    }
		    else if(str.equalsIgnoreCase("forty")) {
		    	number += 40;
		    }
		    else if(str.equalsIgnoreCase("fifty")) {
		    	number += 50;
		    }
		    else if(str.equalsIgnoreCase("sixty")) {
		    	number += 60;
		    }
		    else if(str.equalsIgnoreCase("seventy")) {
		    	number += 70;
		    }
		    else if(str.equalsIgnoreCase("eighty")) {
		    	number += 80;
		    }
		    else if(str.equalsIgnoreCase("ninety")) {
		    	number += 90;
		    }
		    else if(str.equalsIgnoreCase("hundred")) {
		    	number *= 100;
		    }
		    else if(str.equalsIgnoreCase("thousand")) {
		    	number *= 1000;
		        finalNumber += number;
		        number=0;
		    }
		    else if(str.equalsIgnoreCase("million")) {
		    	number *= 1000000;
		        finalNumber += number;
		        number=0;
		    }
		}
		finalNumber += number;
		return finalNumber;
	}
}
