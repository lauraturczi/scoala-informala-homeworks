package siit_h7;

/**
 * GenericQuickSort class implements a generic quicksort. first divides a large
 * array into two smaller sub-arrays: the low elements and the high elements.
 * Quicksort can then recursively sort the sub-arrays.
 * 
 * @author Laura
 * @version 1
 */

public class GenericQuickSort {

	public <T extends Comparable<T>> void quickSort(T[] array, int a, int b) {
		if (array == null) {
			throw new NullPointerException("Array must not be null.");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Array must not be empty.");
		}
		if (a < b) {
			int i = a, j = b;
			T x = array[(i + j) / 2];

			do {
				while (array[i].compareTo(x) < 0)
					i++;
				while (x.compareTo(array[j]) < 0)
					j--;

				if (i <= j) {
					T tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					i++;
					j--;
				}

			} while (i <= j);

			quickSort(array, a, j);
			quickSort(array, i, b);
		}
	}

}
