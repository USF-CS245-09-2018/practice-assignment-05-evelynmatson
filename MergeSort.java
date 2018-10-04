import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
	public void sort(int[] a) {
		// Base case: If size = 1, return the array
		if (a.length <= 1) {
			return;
		}

		// Iterative step: recurse, then merge

		// System.out.println("\tSort Running! Array: " + Arrays.toString(a));

		int[] leftHalf = Arrays.copyOfRange(a, 0, a.length/2);
		// System.out.println("\t\tLeft Half: " + Arrays.toString(leftHalf));
		sort(leftHalf);
		int[] rightHalf = Arrays.copyOfRange(a, a.length/2, a.length);
		// System.out.println("\t\tRight Half: " + Arrays.toString(rightHalf));
		sort(rightHalf);

		// System.out.println("\t\tLeft Half Sorted: " + Arrays.toString(leftHalf));
		// System.out.println("\t\tRight Half Sorted: " + Arrays.toString(rightHalf));


		int l = 0;	// moving along left array
		int r = 0;	// moving along right array
		int insertingToaAt = 0;
		while (l < leftHalf.length  || r < rightHalf.length) {
			if (l >=leftHalf.length) {		// If the left half has run out
				a[insertingToaAt] = rightHalf[r];
				r++;
				insertingToaAt++;
			} else if ( r >= rightHalf.length) {		// If the right half has run out
				a[insertingToaAt] = leftHalf[l];
				l++;
				insertingToaAt++;
			} else {								// If neither has run out, compare!
				if (leftHalf[l] < rightHalf[r]) {			// If left half item is smaller
					a[insertingToaAt] = leftHalf[l];
					insertingToaAt++;
					l++;
				} else if (rightHalf[r] < leftHalf[l]) {	// If right half item is smaller
					a[insertingToaAt] = rightHalf[r];
					insertingToaAt++;
					r++;
				} else {									// If they are the same, chose left
					a[insertingToaAt] = leftHalf[l];
					insertingToaAt++;
					l++;
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] arrayToTest = new int[5];
		arrayToTest[0] = 5;
		arrayToTest[1] = 3;
		arrayToTest[2] = 9;
		arrayToTest[3] = -4;
		arrayToTest[4] = 12;
		// arrayToTest[5] = 5;
		// arrayToTest[6] = 3;
		// arrayToTest[7] = 9;
		// arrayToTest[8] = -4;
		// arrayToTest[9] = 12;

		System.out.println("Started as: " + Arrays.toString(arrayToTest));
		SortingAlgorithm sorter = new MergeSort();
		sorter.sort(arrayToTest);
		System.out.println("Finished as: " + Arrays.toString(arrayToTest));
	}
}