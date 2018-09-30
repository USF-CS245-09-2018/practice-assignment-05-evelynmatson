import java.util.Arrays;

public class QuickSort implements SortingAlgorithm {

	public void sort(int[] a, int start, int end) {

		System.out.println("Sorting: " + Arrays.toString(a));

		// Base case:
		if (end <= 1) {
			return;
		}

		// Iterative step
		int right = end-1;
		int pivot = a[start];

		int left=start;

		System.out.println("About to start. right: " + right + ". left: " + left + ". pivot: " + pivot + ".");

		for (left = start; left <= right; left++) {
			System.out.println("\tleft = " + left);
			for (right=end-1; right >= left; right --) {
				System.out.println("\tright = " + right);
				if (a[left] > a[right]) {
					swap(a,left,right);
				}
			}
		}

		System.out.println("About to swap " + pivot + " and " + right);
		swap(a,pivot,right);

		sort(a,0,left);
		sort(a,left,a.length);

	}

	public void sort(int[] a) {
	
		sort(a,0,a.length);
	}

	public void swap(int[] a, int swap1, int swap2) {
		System.out.println("\t\t\tSwapping " + swap1 + " and " + swap2);
		int temp = a[swap1];
		a[swap1] = a[swap2];
		a[swap2] = temp;
		System.out.println("\t\t\tNow a looks like: " + Arrays.toString(a));
	}

	public static void main(String[] args) {
		int[] arrayToTest = new int[10];
		arrayToTest[0] = 5;
		arrayToTest[1] = 3;
		arrayToTest[2] = 9;
		arrayToTest[3] = -4;
		arrayToTest[4] = 12;
		arrayToTest[5] = 5;
		arrayToTest[6] = 3;
		arrayToTest[7] = 9;
		arrayToTest[8] = -4;
		arrayToTest[9] = 12;

		System.out.println("Started as: " + Arrays.toString(arrayToTest));
		SortingAlgorithm sorter = new QuickSort();
		sorter.sort(arrayToTest);
		System.out.println("Finished as: " + Arrays.toString(arrayToTest));
	}

}