import java.util.Arrays;

public class InsertionSort implements SortingAlgorithm {
	public void sort(int[] a) {
		for (int sortedThrough=0; sortedThrough<a.length-1; sortedThrough++) {
			// System.out.println("sortedThrough = " + sortedThrough);

			int toInsertIndex = sortedThrough+1;
			int toInsertValue = a[toInsertIndex];

			for (int lookingAt=toInsertIndex-1;lookingAt>=0;lookingAt--) {
				// System.out.println("\tlookingAt =  "+ lookingAt);
				// System.out.println("\tComparing a[" + toInsertIndex + "]=" + toInsertValue + " with a[" + lookingAt+ "]=" +a[lookingAt]);

				if (toInsertValue< a[lookingAt]) {
					a[lookingAt+1] = a[lookingAt];
					a[lookingAt] = toInsertValue;
					// System.out.println("\t\tnow it looks like: " + Arrays.toString(a));

				} else {
					a[lookingAt+1] = toInsertValue;
					// System.out.println("\t\tnow it looks like: " + Arrays.toString(a));
					break;

				}
			}

			// System.out.println("  now it looks like: " + Arrays.toString(a));

		}
	}

	public static void main(String[] args) {
		int[] arrayToTest = new int[5];
		arrayToTest[0] = 5;
		arrayToTest[1] = 3;
		arrayToTest[2] = 9;
		arrayToTest[3] = -4;
		arrayToTest[4] = 12;

		// System.out.println("Started as: " + Arrays.toString(arrayToTest));
		SortingAlgorithm sorter = new InsertionSort();
		sorter.sort(arrayToTest);
		// System.out.println("Finished as: " + Arrays.toString(arrayToTest));
	}

}