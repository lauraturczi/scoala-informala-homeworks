/**
 * This class works with String.
 * <p>
 * Using this class we can either remove all whitespaces from a given String or replace all numbers represented as words into numbers. 
 * 
 * @author Laura
 * @version 1.0
 */
package siit_h5;

import java.util.HashMap;

public class StringUtility {

	private String s;
	HashMap<String, String> hmap = new HashMap<String, String>();

	public StringUtility(String s) {
		this.s = s;
	}

	private void populateHashMap() {
		hmap.put("zero", "0");
		hmap.put("one", "1");
		hmap.put("two", "2");
		hmap.put("three", "3");
		hmap.put("four", "4");
		hmap.put("five", "5");
		hmap.put("six", "6");
		hmap.put("seven", "7");
		hmap.put("eight", "8");
		hmap.put("nine", "9");
	}

	private String returnWordwithoutCharacter(String s) {
		String newStr = "";
		String strWord = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isLetterOrDigit(c)) {
				newStr = newStr + c;
			} else {
				strWord = strWord + c;
			}
		}
		return strWord;
	}

	private String returnCharacter(String s) {
		String newStr = "";
		String strWord = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isLetterOrDigit(c)) {
				newStr = newStr + c;
			} else {
				strWord = strWord + c;
			}
		}
		return newStr;
	}

	private boolean isCharAtBeginningofWord(String word) {
		boolean b = false;
		char c = word.charAt(0);
		if (!Character.isLetterOrDigit(c)) {
			b = true;
		}
		return b;
	}

	private boolean isCharAtEndofWord(String word) {
		boolean b = false;
		int x = word.length() - 1;
		char c = word.charAt(x);
		if (!Character.isLetterOrDigit(c)) {
			b = true;
		}
		return b;
	}

	private boolean checkIfSpaceLastChar(String s) {
		int lastCharIndex = s.length() - 1;
		char lastChar = s.charAt(lastCharIndex);
		boolean b = false;
		if (lastChar == ' ') {
			b = true;
		}

		return b;
	}

	private String removeFirstSpaceFromBeginning(String s) {
		return s = s.replaceFirst(" ", "");
	}

	private String addSpaceAtEnd(String s) {
		return s = s + new String(" ");
	}

	/**
	 * This method removes all whitespaces from a String.
	 * 
	 * @return s - same String but without any whitespaces (space, tab,
	 *         new-line)
	 */
	public String removeAllWhiteSpace() {
		return s = this.s.replaceAll("\\s+", "");

	}

	/**
	 * This method replaces all numbers that are presented as words, for numbers
	 * between 0 and 9, where the words are not part of a larger word.
	 * <p>
	 * Method works with both Upper and Lower Case letter and if special
	 * characters except hyphens as attached to the word.
	 * <p>
	 * If the word is part of a larger word the string is returned unmodified.
	 * 
	 * @return newString
	 */

	public String replaceAllWordsWithNumbers() {
		String newString = "";
		populateHashMap();
		boolean check = false;

		String[] ss = this.s.split(" ");
		for (String word : ss) {
			for (String key : hmap.keySet()) {
				if (word.equalsIgnoreCase(key) || returnWordwithoutCharacter(word).equalsIgnoreCase(key)) {
					if (isCharAtBeginningofWord(word)) {
						check = true;
						newString = newString + " " + returnCharacter(word);
						newString = newString + hmap.get(key);
					} else {
						if (isCharAtEndofWord(word)) {
							check = true;
							newString = newString + " " + hmap.get(key);
							newString = newString + returnCharacter(word);
						}

						else {
							check = true;
							newString = newString + " " + hmap.get(key);
						}
					}
				}
			}
			if (check == false) {
				newString = newString + " " + word;
			}
			check = false;
		}
		if (checkIfSpaceLastChar(newString)) {
			addSpaceAtEnd(newString);
		}

		newString = removeFirstSpaceFromBeginning(newString);
		return newString;
	}

}
