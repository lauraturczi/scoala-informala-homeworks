package siit_h7;

/**
 * GenericSelectionSort class implements a generic selection sort. The algorithm
 * divides the input list into two parts: the sublist of items already sorted,
 * which is built up from left to right at the front (left) of the list, and the
 * sublist of items remaining to be sorted that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire
 * input list. The algorithm proceeds by finding the smallest (or largest,
 * depending on sorting order) element in the unsorted sublist, exchanging
 * (swapping) it with the leftmost unsorted element (putting it in sorted
 * order), and moving the sublist boundaries one element to the right.
 * 
 * @author Laura
 * @version 1
 */
public class GenericSelectionSort {

	private <T> void swap(T[] a, int i, int j) {
		if (i != j) {
			T temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	public <T extends Comparable<T>> void selectionSort(T[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array must not be null.");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Array must not be empty.");
		}
		for (int i = 0; i < array.length - 1; i++) {

			int smallest = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[smallest]) <= 0) {
					smallest = j;
				}
			}

			swap(array, i, smallest);
		}
	}

}