package LIS;

public class LISLength {

	public static int findLISLen(int a[]) {//O(nlogn)
		int n = a.length;
		int t[] = new int[n];
		t[0] = a[0];
		int lis = 1;
		for (int i = 1; i < n; i++) {
			int index = binarySearchBetween(t, lis, a[i]);
			t[index] = a[i];
			if (index > lis)
				lis++;
		}
		return lis;
	}

	private static int binarySearchBetween(int[] t, int end, int key) {//O(logn)
		int left = 0;
		int right = end;
		if (key < t[0])
			return 0;
		if (key > t[end])
			return end + 1;
		while (left < right - 1) {
			int middle = (left + right) / 2;
			if (t[middle] < key)
				left = middle;
			else
				right = middle;
		}
		return right;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 4, 12, 2, 14, 10, 3, 5, 6, 7, 0, 11, 3, 5, 7, 9, 1, 4, 6, 0, 1, 7, 6, 4, 33 };

		System.out.println(findLISLen(arr));

	}

}
