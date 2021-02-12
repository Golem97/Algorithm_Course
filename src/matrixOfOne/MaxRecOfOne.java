package matrixOfOne;

import java.util.Stack;

public class MaxRecOfOne {

	public static int fullSearch(int mat[][]) {// O(n^6)
		int row = mat.length;
		int col = mat[0].length;
		int maxArea = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1) {
					for (int p = i; p < row; p++) {
						for (int q = j; q < col; q++) {
							int area = checkFor_1(mat, i, j, p, q);
							if (maxArea < area)
								maxArea = area;
						}
					}
				}
			}
		}
		return maxArea;
	}

	private static int checkFor_1(int[][] mat, int i, int j, int p, int q) {// O(n^2)
		boolean flag = true;
		int ans = 0;
		for (int m = i; m <= p && flag; m++) {
			for (int n = j; n <= q && flag; n++) {
				if (mat[m][n] == 0)
					flag = false;
			}
		}
		if (flag) {
			ans = (p - i + 1) * (q - j + 1);
		}
		return ans;
	}

	public static int findMaxRectangle(int mat[][]) {// O(n^2)
		int row = mat.length, col = mat[0].length;
		int maxArea = 0, histMax = 0;
		if (row == 0 || col == 0)
			return 0;
		int temp[] = new int[col];
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (mat[j][i] == 0)
					temp[j] = 0;
				else
					temp[j]++;
			}
			histMax = getMaxArea(temp);
			if (histMax > maxArea)
				maxArea = histMax;
		}
		return maxArea;
	}

	private static int getMaxArea(int[] hist) {// O(n)

		Stack<Integer> s = new Stack<>();
		int n = hist.length;

		int maxArea = 0, top = 0, areaTop = 0;

		int i = 0;// index
		/* while we didnt reach to the end of the hist */
		while (i < n) {
			/*
			 * If the current value is bigger then the value in the top of the stack or the
			 * stack is empty add him to the stack.
			 */
			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);
			/*
			 * The current value is less then thr top of the stack so pop him and calculete
			 * the area.
			 */
			else {
				top = s.peek();
				s.pop();
				/* If the stack is empty mult by i */
				if (s.empty())
					areaTop = hist[top] * i;
				/* Else mult by the new top. */
				else
					areaTop = hist[top] * (i- s.peek() - 1);

				/* Update the maxArea if nedded. */
				if (maxArea < areaTop)
					maxArea = areaTop;
			}
		}

		/*
		 * If we finished to go over hist and the stack isnt empy so get stack to be
		 * emptied and recalculate the maxArea.
		 */
		while (!s.empty()) {
			top = s.peek();
			s.pop();
			/* If the stack is empty mult by i */
			if (s.empty())
				areaTop = hist[top] * i;
			/* Else mult by the new top. */
			else
				areaTop = hist[top] * (i- s.peek() - 1);

			/* Update the maxArea if nedded. */
			if (maxArea < areaTop)
				maxArea = areaTop;

	}
		return maxArea;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 } };
		System.out.println(fullSearch(mat));
		System.out.println(findMaxRectangle(mat));

	}

}
