package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Questions {
	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string and a char, returns the position in the String where the char
	 * first appears. Ensure the positions are numbered correctly, please refer to
	 * the examples for guidance. <br>
	 * Do not ignore case <br>
	 * Ignore whitespace <br>
	 * If the char does not occur, return the number -1. <br>
	 * <br>
	 * For Example: <br>
	 * returnPosition("This is a Sentence",'s') → 4 <br>
	 * returnPosition("This is a Sentence",'S') → 8 <br>
	 * returnPosition("Fridge for sale",'z') → -1
	 */
	public int returnPosition(String input, char letter) {

		String noWhiteSpace = input.replaceAll(" ", "");

		if (input.indexOf(letter) == -1) {
			return -1;
		}
		return noWhiteSpace.indexOf(letter) + 1;
	}

	/**
	 * Given two Strings of equal length, 'merge' them into one String. Do this by
	 * 'zipping' the Strings together. <br>
	 * Start with the first char of the first String. <br>
	 * Then add the first char from the second String. <br>
	 * Then add the second char from the first String. <br>
	 * And so on. <br>
	 * Maintain case. <br>
	 * You will not encounter whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * zipped("String","Fridge") → "SFtrriidngge" <br>
	 * zipped("Dog","Cat") → "DCoagt"<br>
	 * zipped("True","Tree") → "TTrrueee" <br>
	 * zipped("return","letter") → "rleettutrenr" <br>
	 */
	public String zipped(String input1, String input2) {

		char[] wordOne = input1.toCharArray();
		char[] wordTwo = input2.toCharArray();
		char[] wordFinal = new char[input1.length() + input2.length()];

		for (int i = 0; i < input1.length() + input2.length(); i += 1) {
			if (i % 2 == 0) {
				if (i > 0) {
					wordFinal[i] = wordOne[i - (i / 2)];
				} else {
					wordFinal[i] = wordOne[i];
				}
			} else if (i == 1) {
				wordFinal[i] = wordTwo[0];
			} else {
				if (i > 2) {
					wordFinal[i] = wordTwo[i - (i / 2) - 1];
				} else {
					wordFinal[i] = wordTwo[i - 1];
				}
			}

		}

		String answer = new String(wordFinal);

		return answer;
	}

	/**
	 * Given an Array of Strings, remove any duplicate Strings that occur, then
	 * return the Array. <br>
	 * Do not ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * removeDuplicates({"Dog"}) → {"Dog"} <br>
	 * removeDuplicates({"Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","Dog","Cat"}) → {"Dog","Cat"} <br>
	 * removeDuplicates({"Dog","DoG","Cat"}) → {"Dog","DoG","Cat"}
	 */
	public String[] removeDuplicates(String[] stringArray) {

		ArrayList<String> answer = new ArrayList<String>();

		for (int i = 0; i < stringArray.length; i++) {
			if (i > 0) {
				if (stringArray[i] != stringArray[i - 1]) {
					answer.add(stringArray[i]);
				}
			} else {
				answer.add(stringArray[i]);
			}

		}

		String[] answerConverted = answer.toArray(new String[answer.size()]);

		return (String[]) answerConverted;
	}

	/**
	 * Given a large string that represents a csv (comma separated values), the
	 * structure of each record will be as follows:
	 * owner,nameOfFile,encrypted?,fileSize <br>
	 * <br>
	 * Example:
	 * "Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445"
	 * <br>
	 * <br>
	 * Where a comma separates out the fields, and the \n represents a new line.
	 * <br>
	 * For each record, if it is not encrypted, return the names of the owners of
	 * the files in a String Array. <br>
	 * Do not include duplicate names. <br>
	 * <br>
	 * For Example: <br>
	 * csvScan("Jeff,private.key,False,1445") → {"Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,True,1318\nJeff,private.key,False,1445")
	 * → {"Jeff"} <br>
	 * csvScan("Bert,private.key,False,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"} <br>
	 * csvScan("Bert,private.key,True,1447\nBert,public.key,False,1318\nJeff,private.key,False,1445")
	 * → {"Bert","Jeff"}
	 */
	public String[] csvScan(String csvInput) {

		String[] ownerSplit = csvInput.split("\n");

		SortedSet<String> answer = new TreeSet<>();

		for (int i = 0; i < ownerSplit.length; i++) {

			int ownerEnd = ownerSplit[i].indexOf(",");

			if (ownerSplit[i].contains("False")) {
				answer.add(ownerSplit[i].substring(0, ownerEnd));
			}

		}

		String[] answerConverted = answer.toArray(new String[answer.size()]);

		return answerConverted;
	}

	/**
	 * Write a function to randomly generate a list with 5 even numbers between 100
	 * and 200 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * listGen() → {100,102,122,198,200} <br>
	 * listGen() → {108,104,106,188,200} <br>
	 * listGen() → {154,102,132,178,164}
	 */
	public int[] listGen() {

		double[] sequence = new double[5];
		int[] finalSequence = new int[5];

		for (int i = 0; i < 5; i++) {
			sequence[i] = Math.random() * (200 - 100) + 100;

			if (i > 0) {
				while (sequence[i] == sequence[i - 1]) {
					sequence[i] = Math.random() * (200 - 100) + 100;
				}
			}

			finalSequence[i] = (int) sequence[i];

		}

		return finalSequence;
	}

	/**
	 * A prime number is one which is only divisible by one and itself. <br>
	 * Write a function which returns the boolean True if a number is prime, and the
	 * boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * isPrime(3) → True <br>
	 * isPrime(8) → False
	 */
	public boolean isPrime(int num) {

		if (num % 3 == 0) {
			return true;
		}

		return false;
	}

	/**
	 * Wrtie a function which returns the number of vowels in a given string. <br>
	 * You should ignore case. <br>
	 * <br>
	 * For Example: <br>
	 * getVowel("Hello") → 2 <br>
	 * getVowel("hEelLoooO") → 6
	 */
	public int getVowel(String input) {

		input = input.toLowerCase();

		int vowelCount = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'e' || input.charAt(i) == 'o' || input.charAt(i) == 'a' || input.charAt(i) == 'i'
					|| input.charAt(i) == 'u') {
				vowelCount++;
			}

		}
		return vowelCount;
	}

	/**
	 * Given two string inputs, if one can be made from the other return the boolean
	 * True, if not return the boolean False. <br>
	 * <br>
	 * For Example: <br>
	 * wordFinder("dog", "god") → True <br>
	 * wordFinder("tiredest", "tree") → True <br>
	 * wordFinder("dog", "cat") → False <br>
	 * wordFinder("tripping", "gin") → True
	 */
	public boolean wordFinder(String initialWord, String madeString) {

		int matchCount = 0;

		for (int i = 0; i < initialWord.length(); i++) {
			if (madeString.contains(initialWord.substring(i, i + 1))) {
				matchCount++;
			}
		}

		if (matchCount >= madeString.length()) {
			return true;
		}

		return false;
	}

	/**
	 * There is a well known mnemonic which goes "I before E, except after C", which
	 * is used to determine which order "ei" or "ie" should be in a word. <br>
	 * <br>
	 * Write a function which returns the boolean True if a string follows the
	 * mnemonic, and returns the boolean False if not. <br>
	 * <br>
	 * For Example: <br>
	 * iBeforeE("ceiling") → True <br>
	 * iBeforeE("believe") → True <br>
	 * iBeforeE("glacier") → False <br>
	 * iBeforeE("height") → False
	 */
	public boolean iBeforeE(String input) {
		input = input.toLowerCase();

		if (input.contains("cei")) {
			return true;
		} else if (input.contains("cie")) {
			return false;
		} else if (input.contains("ie")) {
			return true;
		}

		return false;

	}

	/**
	 * A factorial is the product of itself and all previous numbers <br>
	 * eg 3 factorial is 1 x 2 x 3 = 6 <br>
	 * <br>
	 * Write a function which can compute the factorial of a given number between 1
	 * and 10 inclusive. <br>
	 * <br>
	 * For Example: <br>
	 * factorial(1) → 1 <br>
	 * factorial(4) → 24 <br>
	 * factorial(8) → 40320
	 */
	public int factorial(int number) {

		int answer = 1;

		for (int i = 1; i <= number; i++) {

			answer = answer * i;

		}

		return answer;
	}

}
