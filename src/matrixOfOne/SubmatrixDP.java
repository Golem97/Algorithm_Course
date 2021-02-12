package matrixOfOne;

public class SubmatrixDP {

	// method for Maximum size square sub-matrix with all 1s
	static void maxSubmatrixDP(int m[][]) {

		int row = m.length;
		int col = m[0].length;

		int[][] h = new int[row][col];//help matrix
		
		/* Copy to help matrix the first row from m matrix */
		for (int i = 0; i < row; i++) {//O(n)
			h[i][0] = m[i][0];
		}
		
		/* Copy to help matrix the first col from m matrix */
		for (int j = 0; j < col; j++) {//O(n)
			h[0][j] = m[0][j];
		}
		int maxSize = h[0][0], maxI = 0, maxJ = 0;
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (m[i][j] == 1) {
					h[i][j] = Math.min(h[i][j - 1], Math.min(h[i - 1][j], h[i - 1][j - 1])) + 1;
					if (maxSize < h[i][j]) {
						maxSize = h[i][j];
						maxI = i;
						maxJ = j;
					}
				}
			}
		}

		System.out.println("Maximum size sub-matrix is: " + maxSize);
		System.out.println("xEnd = " + maxI + "   yEnd = " + maxJ);
	}

	// ****************************************************************

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
						{ 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0 },
						{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1 }, 
						{ 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0 },
						{ 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1 }, 
						{ 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 },
						{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1 } };
		System.out.println("matrix mat ");
		printMatrix(mat);
		maxSubmatrixDP(mat);
	}

	// ************************************************************

	public static void printMatrix(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
