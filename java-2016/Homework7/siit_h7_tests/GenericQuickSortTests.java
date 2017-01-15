package siit_h7_tests;

import org.junit.Test;

import siit_h7.GenericQuickSort;

import siit_h7.Job;

import static org.junit.Assert.*;

import org.junit.Assert;

public class GenericQuickSortTests {

	@Test
	public void sortIntegersQuickSort() {
		GenericQuickSort sorter = new GenericQuickSort();
		Integer[] numbers = { 13, 43, 21, 89, 76, 52, 0, -2, -523, 25 };
		sorter.quickSort(numbers, 0, numbers.length - 1);
		Integer[] expected = { -523, -2, 0, 13, 21, 25, 43, 52, 76, 89 };
		assertArrayEquals(numbers, expected);
	}

	@Test
	public void sortStringsQuickSort() {
		GenericQuickSort sorter = new GenericQuickSort();
		String[] words = { "dog", "cat", "chair", "old", "zulu", "buffalo" };
		sorter.quickSort(words, 0, words.length - 1);
		;
		String[] expected = { "buffalo", "cat", "chair", "dog", "old", "zulu" };
		assertArrayEquals(words, expected);
	}

	@Test
	public void sortObjectsQuickSort() {
		GenericQuickSort sorter = new GenericQuickSort();
		Job manager = new Job("Manager", 2);
		Job bigFootHunter = new Job("Bigfoot Hunter", 10);
		Job doctor = new Job("Doctor", 1);
		Job[] jobs = { manager, bigFootHunter, doctor };
		sorter.quickSort(jobs, 0, jobs.length - 1);
		Job[] expected = { doctor, manager, bigFootHunter };
		assertArrayEquals(jobs, expected);
	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void whenNullArrayUsed_ExceptionIsThrownQuickSort() {
		Integer[] array = null;
		GenericQuickSort sorter = new GenericQuickSort();
		sorter.quickSort(array, 0, array.length - 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyArrayUsed_ExceptionIsThrownQuickSort() {
		Integer[] array = new Integer[] {};
		GenericQuickSort sorter = new GenericQuickSort();
		sorter.quickSort(array, 0, array.length - 1);
	}

	@Test
	public void unsortedIntArrayWithDuplicatesIsSortedQuickSort() {
		Integer[] array = new Integer[] { 1, 2, 1, 3, 4, 2, 3, 2, 1 };
		GenericQuickSort sorter = new GenericQuickSort();
		sorter.quickSort(array, 0, array.length - 1);
		Integer[] correctlySortedArray = new Integer[] { 1, 1, 1, 2, 2, 2, 3, 3, 4 };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

	@Test
	public void sortedIntArrayIsUnmodifiedQuickSort() {
		Integer[] array = new Integer[] { 1, 2, 3, 5, 6, 7, 9 };
		GenericQuickSort sorter = new GenericQuickSort();
		sorter.quickSort(array, 0, array.length - 1);
		Integer[] correctlySortedArray = new Integer[] { 1, 2, 3, 5, 6, 7, 9 };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

	@Test
	public void unsortedIntArrayWithDuplicatesIsSortedQuickSortStrings() {
		String[] array = new String[] { "cow", "dog", "chair", "dog" };
		GenericQuickSort sorter = new GenericQuickSort();
		sorter.quickSort(array, 0, array.length - 1);
		String[] correctlySortedArray = new String[] { "chair", "cow", "dog", "dog" };
		Assert.assertArrayEquals(correctlySortedArray, array);
	}

}
