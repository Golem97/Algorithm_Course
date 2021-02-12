package lcs;

public class LcsDynamic {
	private String x;
	private String y;
	private String result;
	private int[][] matrix;
	private int row;
	private int col;

	public LcsDynamic(String x, String y) {
		this.x = x;
		this.y = y;
		this.row = x.length() + 1;
		this.col = y.length() + 1;
		this.matrix = new int[this.row][this.col];

		buildMatrix();

		int lcsLen = matrix[row - 1][col - 1];
		result = "";
		int i = row - 1;
		int j = col - 1;

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result = x.charAt(i - 1) + result;
				i--;
				j--;
			} else {
				if (matrix[i][j] == matrix[i][j - 1])
					j--;
				else
					i--;
			}
		}
	}

	public void buildMatrix() {
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1))
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				else
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
			}
		}
	}

	public String toString() {
		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		return result;
	}

	public static void main(String[] args) {
		String x = "ABCBDA";
		String y = "BDCAB";
		LcsDynamic xGy = new LcsDynamic(x, y);
		LcsDynamic yGx = new LcsDynamic(y, x);
		System.out.println(xGy);
		System.out.println(yGx);
	}

}
