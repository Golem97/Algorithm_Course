package LIS;

import java.util.Arrays;

public class LISDynamic {//O(n^2) O(n) = O(n^2)
	private int[] lis, d, p;

	public LISDynamic(int[] a) {
		int n = a.length;
		d = new int[n];// be the length of the LIS ending at index i such that a[i] is the last element
						// of the LIS.
		p = new int[n];// help array indexes of previous element.
		int max = 1, i = 0, j = 0, pos = 0;

//		/* Initialize d[],p[] values for all indexes */
//		for (i = 0; i < n; i++) {//O(n)
//			d[i] = 1;
//			p[i] = -1;
//		}

		/* Compute optimized LIS values */
		for (i = 0; i < n; i++) {//O(n^2)
			/* Initialize d[],p[] values for all indexes */
			d[i] = 1;
			p[i] = -1;
			for (j = 0; j < i; j++) {
				if (a[i] > a[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
					p[i] = j;
					/* Pick maximum of all LIS values and save his possition to pos */
					if (max < d[i]) {
						max = d[i];
						pos = i;
					}
				}
			}
		}

//		/* Pick maximum of all LIS values and save his possition to pos */
//		for (i = 0; i < n; i++) {
//			if (max < d[i]) {
//				max = d[i];
//				pos = i;
//			}
//		}

		lis = new int[max];// Longest Increasing Subsequence in max size.
		i = max - 1;

		/* Initialize lis values for all indexes */
		while (pos != -1) {//O(n)
			lis[i--] = a[pos];
			pos = p[pos];
		}

	}

	public String toString() {
		return Arrays.toString(lis);
	}

	public static void main(String[] args) {
		int[] arr = { 8, 4, 12, 2, 14, 10, 3, 5, 6, 7, 0, 11, 3, 5, 7, 9, 1, 4, 6, 0, 1, 7, 6, 4, 33 };
		LISDynamic lis = new LISDynamic(arr);
		System.out.println(lis);

	}

}
