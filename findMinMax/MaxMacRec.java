package findMinMax;

import java.util.Stack;

public class MaxMacRec {
	/* Inner class - node */
	static class Node {
		private int _num;
		private Stack<Integer> _st;

		/* Constructor */
		public Node(int num) {
			_num = num;
			_st = new Stack<Integer>();
		}

	}// end inner class.

	static int comparisons = 0;

	private static int maxMax2(Node arr[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			int i = maxMax2(arr, low, mid);
			int j = maxMax2(arr, mid + 1, high);
			int index = -1;
			if (arr[i]._num > arr[j]._num) {
				arr[i]._st.push(arr[j]._num);
				index = i;
			} else {
				arr[j]._st.push(arr[i]._num);
				index = j;
			}
			return index;
		}
		return low;
	}

	public static void maxMax2(int a[]) {
		int n = a.length;
		Node nodes[] = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(a[i]);
		}
		int index = maxMax2(nodes, 0, n - 1);
		int max1 = nodes[index]._num;
		int max2 = nodes[index]._st.pop();
		while (!nodes[index]._st.empty()) {
			int temp = nodes[index]._st.pop();
			if (temp > max2)
				max2 = temp;
		}
		System.out.println("Max1: " + max1 + "\n" + "max2: " + max2);
	}

	public static void main(String[] args) {
		int a[] = { 1, 10, 8, 50, 31, 49, 9, 5, 20, 11, 18, 19, 15, 30 };
		maxMax2(a);
	}
}
