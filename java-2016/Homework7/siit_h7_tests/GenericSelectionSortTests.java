package siit_h7_tests;

import org.junit.Test;

import siit_h7.GenericSelectionSort;
import siit_h7.Job;

import static org.junit.Assert.*;

import org.junit.Assert;

public class GenericSelectionSortTests {

	@Test
	public void sortIntegers() {
		GenericSelectionSort sorter = new GenericSelectionSort();
		Integer[] numbers = { 13, 43, 21, 89, 76, 52, 0, -2, -523, 25 };
		sorter.selectionSort(numbers);
		Integer[] expected = { -523, -2, 0, 13, 21, 25, 43, 52, 76, 89 };
		assertArrayEquals(numbers, expected);
	}

	@Test
	public void sortStrings() {
		GenericSelectionSort sorter = new GenericSelectionSort();
		String[] words = { "dog", "cat", "chair", "old", "zulu", "buffalo" };
		sorter.selectionSort(words);
		;
		String[] expected = { "buffalo", "cat", "chair", "dog", "old", "zulu" };
		assertArrayEquals(words, expected);
	}

	@Test
	public void sortObjects() {
		GenericSelectionSort sorter = new GenericSelectionSort();
		Job manager = new Job("Manager", 2);
		Job bigFootHunter = new Job("Bigfoot Hunter", 10);
		Job doctor = new Job("Doctor", 1);
		Job[] jobs = { manager, bigFootHunter, doctor };
		sorter.selectionSort(jobs);
		Job[] expected = { doctor, manager, bigFootHunter };
		assertArrayEquals(jobs, expected);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenNullArrayUsed_ExceptionIsThrown() {
		Integer[] array = null;
		GenericSelectionSort sorter = new GenericSelectionSort();
		sorter.selectionSort(array);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyArrayUsed_ExceptionIsThrown() {
		Integer[] array = new Integer[] {};
		GenericSelectionSort sorter = new GenericSelectionSort();
		sorter.selectionSort(array);
	}

	@Test
	public void unsortedIntArrayWithDuplicatesIsSorted() {
		// given
		Integer[] array = new Integer[] { 1, 2, 1, 3, 4, 2, 3, 2, 1 };
		GenericSelectionSort sorter = new GenericSelectionSort();
		// when
		sorter.selectionSort(array);
		// then
		Integer[] correctlySortedArray = new Integer[] { 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

	@Test
	public void sortedIntArrayIsUnmodified() {
		// given
		Integer[] array = new Integer[] { 1, 2, 3, 5, 6, 7, 9 };
		GenericSelectionSort sorter = new GenericSelectionSort();
		// when
		sorter.selectionSort(array);
		// then
		Integer[] correctlySortedArray = new Integer[] { 1, 2, 3, 5, 6, 7, 9 };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

	@Test
	public void unsortedIntArrayWithDuplicatesIsSortedStrings() {
		String[] array = new String[] { "cow", "dog", "chair", "dog" };
		GenericSelectionSort sorter = new GenericSelectionSort();
		sorter.selectionSort(array);
		String[] correctlySortedArray = new String[] { "chair", "cow", "dog", "dog" };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

}
