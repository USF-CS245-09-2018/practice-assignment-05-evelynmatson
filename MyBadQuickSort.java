import java.util.Arrays;

public class QuickSort implements SortingAlgorithm {

	public void sort(int[] a, int start, int end) {		// INCLUSIVE ON BOTH ENDS

		// Base  case: sorting just one or 0 items. Already sorted!
		// System.out.println("Sort running. start = " + start + ". end = " + end);
		if (end-start < 1) {
			return;
		} else if (start > end) {	// I think this is covered by the first condition, but just in case
			return;
		}

		// Iterative step: partion, recurse
		int pivot = start;
		int left = start + 1;
		int right = end;
		// System.out.println("\tSort defined: pivot = " + pivot + ", left = " + left + ", right = " + right);


		// Iterate through the array starting at the left
		for (left=left;left<right;left++) {
			// Check if we found an item on the left that should be on the right
			if (a[left] > a[pivot]) {
				// If we did, move right until we find an item on the right that should be on the left
				// System.out.println("\tTEST! right = " + right + ". pivot = " + pivot);
				// System.out.println("\tTEST! right=right = " + (right=right));
				// System.out.println("\ta[right] >= a[pivot] = " + (a[right] >= a[pivot]));
				// System.out.println("\tright--" + (right--));
				for (right=right; a[right] > a[pivot] && left < right; right--) {
					;
				}
				// System.out.println("\tDecided to swap: " + a[right] + " and " + a[left]);
				swap(a,right,left);
			}
		}


		int center;
		// Once theyve overlapped!
		if (a[left] < a[pivot]) {		// If the center value is less than pivot
			// System.out.println("\tPIVOT Decided to swap: " + a[left] + " and " + a[pivot]);
			swap(a,left,pivot);
			center = left;
		} else {						// If the center value is greater than pivot
			// System.out.println("\tPIVOT Decided to swap: " + a[left-1] + " and " + a[pivot]);
			swap(a,left-1,pivot);
			center = left-1;
		}


		// System.out.println("\tThis step done. Finished as: " + Arrays.toString(a));
		// System.out.println("\t(a[center] = a["+center+"] = "+ a[center] + ".");


		// NOW RECURSE:
		// System.out.println("\tAbout to recurse. "+start+" through " + (center-1) + " and " + (center+1) + " through " + end + "\n");
		sort(a,start,center-1);		// Left half
		sort(a,center+1,end);			// Right half



	}

	public void sort(int[] a) {		// Overloaded function so you don't need to specify start and end
	
		sort(a,0,a.length-1);
	}

	public void swap(int[] a, int swap1, int swap2) {		// Helper function
		// System.out.println("\t\tSwapping a[" + swap1 + "] = " + a[swap1] +" and a[" + swap2 + "] = " + a[swap2] + "]");
		
		if (swap1==swap2) {		// No need to swap an item with itself
			return;
		}

		int temp = a[swap1];
		a[swap1] = a[swap2];
		a[swap2] = temp;
		// System.out.println("\t\tNow a looks like: " + Arrays.toString(a));
	}

	public static void main(String[] args) {			// Testing function
		int[] arrayToTest = new int[50];
		arrayToTest[0] = 1;
		arrayToTest[1] = -2;
		arrayToTest[2] = -16;
		arrayToTest[3] = 15;
		arrayToTest[4] = -18;
		arrayToTest[5] = -16;
		arrayToTest[6] = -10;
		arrayToTest[7] = 1;
		arrayToTest[8] = 16;
		arrayToTest[9] = -9;
		arrayToTest[10] = 9;
		arrayToTest[11] = -19;
		arrayToTest[12] = 2;
		arrayToTest[13] = 16;
		arrayToTest[14] = 19;
		arrayToTest[15] = -5;
		arrayToTest[16] = 19;
		arrayToTest[17] = -8;
		arrayToTest[18] = 12;
		arrayToTest[19] = 2;
		arrayToTest[20] = -5;
		arrayToTest[21] = -3;
		arrayToTest[22] = 18;
		arrayToTest[23] = -2;
		arrayToTest[24] = 6;
		arrayToTest[25] = -1;
		arrayToTest[26] = 5;
		arrayToTest[27] = 19;
		arrayToTest[28] = 12;
		arrayToTest[29] = 11;
		arrayToTest[30] = -2;
		arrayToTest[31] = -18;
		arrayToTest[32] = -11;
		arrayToTest[33] = 10;
		arrayToTest[34] = -7;
		arrayToTest[35] = 12;
		arrayToTest[36] = 10;
		arrayToTest[37] = -4;
		arrayToTest[38] = 11;
		arrayToTest[39] = -9;
		arrayToTest[40] = -18;
		arrayToTest[41] = -19;
		arrayToTest[42] = -19;
		arrayToTest[43] = -13;
		arrayToTest[44] = -12;
		arrayToTest[45] = 13;
		arrayToTest[46] = 2;
		arrayToTest[47] = 17;
		arrayToTest[48] = -8;
		arrayToTest[49] = 1;

		// int[] arrayToTest = new int[3];
		// arrayToTest[0] = 2;
		// arrayToTest[1] = -18;
		// arrayToTest[2] = -16;


		System.out.println("Started as: " + Arrays.toString(arrayToTest));
		SortingAlgorithm sorter = new QuickSort();
		sorter.sort(arrayToTest);
		System.out.println("Finished as: " + Arrays.toString(arrayToTest));

	}

}