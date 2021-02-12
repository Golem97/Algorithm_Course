package findMinMax;

public class MinMaxAlgorithms {

	/**
	 * This function represent naive solution to find max in array. number of
	 * comparisons: n-1. complexity: O(n).
	 * 
	 * @param a array.
	 * @return the maximum value in the array
	 */
	public static int findMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

	/**
	 * This function represent naive solution to find max and max in array.
	 * comparisons: 2(n-1)= 2n-2. complexity: O(n).
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find min and max value.
	 */
	public static int findMinMax1(int[] a) {
		int max = a[0];
		int comparisons = 0;
		for (int i = 1; i < a.length; i++) {
			comparisons++;
			if (a[i] > max)
				max = a[i];
		}
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			comparisons++;
			if (a[i] < min)
				min = a[i];
		}
		return comparisons;
	}

	/**
	 * This function represent naive (more complex - one loop) solution to find max
	 * and max in array. comparisons: 2(n-1)= 2n-2.---->in worst case. in avg
	 * littele less then 2n-2.
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find min and max value.
	 */
	public static int findMinMax2(int[] a) {
		int min, max, comparisons;
		min = max = a[0];
		comparisons = 0;
		for (int i = 1; i < a.length; i++) {
			comparisons++;
			if (a[i] > max)
				max = a[i];
			else {
				comparisons++;
				if (min < a[i])
					min = a[i];
			}
		}
		return comparisons;
	}

	/**
	 * This function represent solution to find min and max in array. comparisons:
	 * 3n/2. complexity: O(n).
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find min and max value.
	 */
	public static int findMinMax3(int[] a) {
		int comparisons = 1;
		int min = a[0];
		int max = a[1];
		if (a[0] > a[1]) {
			max = a[0];
			min = a[1];
		}
		for (int i = 2; i < a.length; i = i + 2) {
			comparisons++;
			if (a[i] < a[i + 1]) {
				comparisons += 2;
				if (a[i] < min)
					min = a[i];
				if (a[i + 1] > max)
					max = a[i + 1];
			} else {// a[i] > a[i+1].
				comparisons += 2;
				if (a[i + 1] < min)
					min = a[i + 1];
				if (a[i] > max)
					max = a[i];
			}
			if (a.length % 2 != 0) {// if the number of element in the array is odd.
				comparisons++;
				if (a[a.length - 1] > max)
					max = a[a.length - 1];
				else {
					comparisons++;
					if (a[a.length - 1] < min)
						min = a[a.length - 1];
				}
			}
		}
		return comparisons;
	}

	/**
	 * This function represent solution to find max1 and max2 in array. comparisons:
	 * 2n-2. complexity: O(n).
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find max1 and max2 value.
	 */
	public static int findMaxMax1(int a[]) {
		int comparisons = 0;
		int max1 = a[0], index1 = 0;
		for (int i = 1; i < a.length; i++) {
			comparisons++;
			if (a[i] > max1) {
				max1 = a[i];
				index1 = i;
			}
		}
		a[index1] = a[a.length - 1];
		a[a.length - 1] = max1;
		int max2 = a[0], index2 = 0;
		for (int i = 0; i < a.length - 1; i++) {
			comparisons++;
			if (a[i] > max2) {
				max2 = a[i];
				index2 = i;
			}
		}
		return comparisons;
	}

	/**
	 * This function represent solution to find max1 and max2 in array.
	 * comparisons:little less 2n-3(in general case). complexity: O(n).
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find max1 and max2 value.
	 */
	public static int findMaxMax2(int a[]) {
		int comparisons = 1;
		int max1 = a[0], index1 = 0;
		int max2 = a[1], index2 = 1;
		if (a[0] < a[1]) {
			max1 = a[1];
			index1 = 1;
			max2 = a[0];
			index2 = 0;
		}
		for (int i = 2; i < a.length; i++) {
			comparisons++;
			if (a[i] > max1) {
				max2 = max1;
				index2 = index1;
				max1 = a[i];
				index1 = i;
			} else {
				comparisons++;
				if (a[i] > max2) {
					max2 = a[i];
					index2 = i;
				}
			}
		}

		return comparisons;
	}

	/**
	 * This function represent solution to find max1 and max2 in array.
	 * comparisons:~1.5n. (in general case). complexity: O(n).
	 * 
	 * @param a the array.
	 * @return number of comparisons that takes to find max1 and max2 value.
	 */
	public static int findMaxMax4(int a[]) {
		int comparisons = 1;
		int max1 = a[0], index1 = 0;
		int max2 = a[1], index2 = 1;
		if (a[1] > a[0]) {
			max1 = a[1];
			index1 = 1;
			max2 = a[0];
			index2 = 0;
		}
		for (int i = 2; i < a.length; i++) {
			comparisons++;
			if (a[i] < max2) {
			} // do nothing.
			else// a[i] >= max2.
				comparisons++;
			if (a[i] > max1) {
				max2 = max1;
				index2 = index1;
				max1 = a[i];
				index1 = i;
			} else {
				max2 = a[i];
				index2 = i;
			}
		}
		return comparisons;
	}

	public static int findMaxMax5(int a[]) {
		int comparisons = 1;
		int max1 = a[0], index1 = 0;
		int max2 = a[1], index2 = 1;
		if (a[1] > a[0]) {
			max1 = a[1];
			index1 = 1;
			max2 = a[0];
			index2 = 0;
		}
		// the main loop
		for (int i = 2; i < a.length - 1; i = i + 2) {
			comparisons++;
			if (a[i] < a[i + 1]) {
				comparisons++;
				if (a[i + 1] > max1) { 
					max2 = max1;
					index2 = index1;
					max1 = a[i + 1];
					index1 = i + 1;
					comparisons++;
					if (a[i] > max2) {
						max2 = a[i];
						index2 = i;
					}
				} 
				else { // arr[i+1] < max1
					comparisons++;
					if (a[i + 1] > max2) {
						max2 = a[i + 1];
						index2 = i + 1;
					}
				}
			} else {// ***** arr[i] > arr[i+1] *****
				comparisons++;
				if (a[i] > max1) {
					max2 = max1;
					index2 = index1;
					max1 = a[i];
					index1 = i;
					comparisons++;
					if (a[i + 1] > max2) {
						max2 = a[i + 1];
						index2 = i + 1;
					}
				} 
				else { // arr[i] < max1
					comparisons++;
					if (a[i] > max2) {
						max2 = a[i];
						index2 = i;
					}
				}
			}
		}
		comparisons++;
		if (a.length % 2 != 0) {//// if the number of element in the array is odd.
			comparisons++;
			if (a[a.length - 1] > max1) {
				max2 = max1;
				max1 = a[a.length - 1];
			} else {
				comparisons++;
				if (a[a.length - 1] > max2)
					max2 = a[a.length] - 1;
			}
		}
		System.out.println("max1: " + max1 + ", max2: " + max2) ;
		return comparisons;
	}

	public static void main(String[] args) {
		int n = 100;
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) Math.round(Math.random() * 100000);

		long start = System.nanoTime();
		findMinMax1(arr);
		long end = System.nanoTime();
		long timeFacRec = end - start;
		System.out.println("the time that takes to findMinMax1 to find minimum and maximum in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMinMax1 to find min and max value in array that contains "
						+ n + " numbers  is: " + findMinMax1(arr));
		System.out.println();

		start = System.nanoTime();
		findMinMax2(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMinMax2 to find minimum and maximum in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMinMax2 to find min and max value in array that contains "
						+ n + " numbers  is: " + findMinMax2(arr));
		System.out.println();

		start = System.nanoTime();
		findMinMax3(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMinMax3 to find minimum and maximum in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMinMax3 to find min and max value in array that contains contains "
						+ n + " numbers  is: " + findMinMax3(arr));
		System.out.println();

		start = System.nanoTime();
		findMaxMax1(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMaxMax1 to find maximum1 and maximum2 in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMaxMax1 to find min and max value in array that contains contains "
						+ n + " numbers  is: " + findMaxMax1(arr));
		System.out.println();

		start = System.nanoTime();
		findMaxMax2(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMaxMax2 to find maximum1 and maximum2 in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMaxMax2 to find min and max value in array that contains contains "
						+ n + " numbers  is: " + findMaxMax2(arr));
		System.out.println();

		start = System.nanoTime();
		findMaxMax4(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMaxMax4 to find maximum1 and maximum2 in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMaxMax4 to find min and max value in array that contains contains "
						+ n + " numbers  is: " + findMaxMax4(arr));
		System.out.println();
		
		
		
		
		start = System.nanoTime();
		findMaxMax5(arr);
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to findMaxMax5 to find maximum1 and maximum2 in the array is:  "
				+ timeFacRec + " (nano time)");
		System.out.println(
				"The number of comparisons for algorithem findMaxMax5 to find min and max value in array that contains contains "
						+ n + " numbers  is: " + findMaxMax5(arr));
		System.out.println();
		
		int a[] = {1,2,3,4,5,6,7,8,9,10,0,1,2,3,4,5,6,7,8,9,0,2,5,8,3,6,9,1,4,7};
		findMaxMax5(a);
	}

}
