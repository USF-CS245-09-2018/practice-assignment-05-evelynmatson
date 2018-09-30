import java.util.Arrays;

public class QuickSort implements SortingAlgorithm {

	public void Oldsort(int[] a, int start, int end) {

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

	public void sort(int[] a, int start, int end) {
		System.out.println("\n\n\nStarting to sort: " + Arrays.toString(a) + " from " + start + " to " + end + ".");
		int originalStart = start;
		int originalEnd = end;

		end--;		// end passed to function is exclusive, to avoid index out of bounds, end in the function must be a point in the array.

		// Base case: trying to sort 1 item or smaller
		if (end-start < 2) {
			return;
		}

		// Iterative step: partition and recurse!
		int pivot = start;
		start++;

		while (start < end) {			// Main loop. Do the work here!
			// System.out.println("\tMain loop start. a[start] = " + a[start] + " and a[end] = " + a[end] + ".");
			if (a[start] > a[pivot] && a[end] < a[pivot]) {		// If they should be swapped
				System.out.println("SWAPPING: start = " + start + ", end = " + end + ", pivot = " + pivot);
				swap(a,start,end);

				// EXPERIMENTAL: increment start and decrement end?
				// start++;
				end--;
			} else if (a[start] > a[pivot] && a[end] > a[pivot]) {		// If theyre both greater than a[pivot]
				end--;	// End is ok, start can't be moved
			} else if (a[start] < a[pivot] && a[end] < a[pivot]) {		// If thyere both lower than a[pivot]
				start++;	// Start is ok, end can't be moved
			} else {		// Theyre both good, so both can move on!
				end--;
				// start++;
			}
			// System.out.println("\t  Main while loop finished. start = " + start + " and end = " + end + ".");
		}

		// At this point, start and end point to the same thing AKA (start == end)

		if (a[start] < a[pivot]) {		// If pivot should swap with the start/end item
			System.out.println("SWAPPING: start = " + start + ", end = " + end + ", pivot = " + pivot);
			swap(a,start,pivot);
		} else {						// If pivot should swap with the item before that.
			System.out.println("SWAPPING: start-1 = " + (start-1) + ", end = " + end + ", pivot = " + pivot);
			swap(a,start-1,pivot);
		}

		// System.out.println("\nDone with first iteration! now:");
		// System.out.println("\toriginalStart = " + originalStart);
		// System.out.println("\tstart = " + start);
		// System.out.println("\tpivot = " + pivot);
		// System.out.println("\tend = " + end);
		// System.out.println("\toriginalEnd = " + originalEnd);

		System.out.println("Done with this recursion step. a looks like: " + Arrays.toString(a));

		// Recurse now!
		sort(a,originalStart,start);		// sort the left half
		sort(a,start+1,originalEnd);			// sort the right half

	}

	public void sort(int[] a) {
	
		sort(a,0,a.length);
	}

	public void swap(int[] a, int swap1, int swap2) {
		System.out.println("\t\tSwapping a[" + swap1 + "] = " + a[swap1] +" and a[" + swap2 + "] = " + a[swap2] + "]");
		int temp = a[swap1];
		a[swap1] = a[swap2];
		a[swap2] = temp;
		System.out.println("\t\tNow a looks like: " + Arrays.toString(a));
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