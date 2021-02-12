package numberGame;

public class DPAlgorithm {

	public static int[][] buildMatrix(int game[]) {

		int n = game.length;
		int mat[][] = new int[n][n];
		/* Fill the trace with game elements. */
		for (int i = 0; i < n; i++) {
			mat[i][i] = game[i];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				mat[i][j] = Math.max(game[i] - mat[i + 1][j], game[j] - mat[i][j - 1]);
			}
		}
		return mat;
	}

	public static void gameStrategy(int game[]) {
		int i = 0, n = game.length, j = n - 1;
		int first = 0, second = 0, firstSum = 0, secondSum = 0;
		int mat[][] = buildMatrix(game);
		for (int k = 0; k < (n / 2); k++) {
			/* First player choose. */
			if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) {// the left element is bigger.
				firstSum += game[i];
				first = i++;
			} else {// the right element is bigger.
				firstSum += game[j];
				first = j--;
			}
			/* Second player choose. */
			if (i != j) {
				if (game[i] - mat[i + 1][j] > game[j] - mat[i][j - 1]) {// the left element is bigger.
					secondSum += game[i];
					second = i++;
				} else {// the right element is bigger.
					secondSum += game[j];
					second = j--;
				}
			} else {// j=0 or i=game.length-1, the second takes the last element
				second = j;
				secondSum = secondSum + game[j];
			}
			System.out.println(
					"first: game[" + first + "] = " + game[first] + ", second: game[" + second + "] = " + game[second]);
		}
		System.out.println(
				"firstSum = " + firstSum + ", secondSum = " + secondSum + ", diff = " + (firstSum - secondSum));
	}

	public static void printMatrix(int mat[][]) {
		System.out.println("The matrix: \n");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		int game[] = { 1, 3, 6, 1, 3, 6 };
		int[][] mat = buildMatrix(game);
		printMatrix(mat);
		gameStrategy(game);

	}

}
