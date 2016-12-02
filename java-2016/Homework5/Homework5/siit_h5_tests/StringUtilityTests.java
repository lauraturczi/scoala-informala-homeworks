package siit_h5_tests;

import org.junit.Test;

import static org.junit.Assert.*;

import siit_h5.StringUtility;

public class StringUtilityTests {

	@Test
	public void removeAllWhiteSpaceTest() {
		StringUtility s = new StringUtility("This needs to be 		 without spaces  .");
		String t;
		t = s.removeAllWhiteSpace();
		assertEquals("Thisneedstobewithoutspaces.", t);

	}

	@Test
	public void removeAllWhiteSpaceTestIfEmpty() {
		StringUtility s = new StringUtility("");
		String t;
		t = s.removeAllWhiteSpace();
		assertEquals("", t);

	}

	@Test
	public void removeAllWhiteSpaceTestIfOnlySpacesAndTabs() {
		StringUtility s = new StringUtility("   		 ");
		String t;
		t = s.removeAllWhiteSpace();
		assertEquals("", t);

	}

	@Test
	public void replaceAllWordsWithNumbersTest() {
		StringUtility s = new StringUtility("I have four apples");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("I have 4 apples", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestHyphen() {
		StringUtility s = new StringUtility("I want twenty-nine dollars");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("I want twenty-nine dollars", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestWithSpecialCharactersinNumberAtEnd() {
		StringUtility s = new StringUtility("Five six SEVEN eiGHt!!");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("5 6 7 8!!", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestWithSpecialCharactersinNumberAtBeginning() {
		StringUtility s = new StringUtility("*&Five six SEVEN eiGHt!!");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("*&5 6 7 8!!", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestWithTabsAndSpaces() {
		StringUtility s = new StringUtility("I have	 two	   dogs");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("I have	 2	   dogs", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestSpaceAtBeginningofString() {
		StringUtility s = new StringUtility(" I have three dogs");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals(" I have 3 dogs", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestSpaceAtEndofString() {
		StringUtility s = new StringUtility("I want zero cats ");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("I want 0 cats ", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestSpecialCharactersWithSpaceAsFirstChar() {
		StringUtility s = new StringUtility(" *&Five six SEVEN eiGHt!!");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals(" *&5 6 7 8!!", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestSpecialCharactersWithSpaceAsLastChar() {
		StringUtility s = new StringUtility("*&Five six SEVEN eiGHt!! ");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("*&5 6 7 8!! ", t);
	}

	@Test
	public void replaceAllWordsWithNumbersTestEmpty() {
		StringUtility s = new StringUtility("");
		String t;
		t = s.replaceAllWordsWithNumbers();
		assertEquals("", t);
	}

}
