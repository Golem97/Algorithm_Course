package aeroplane_problem;

import java.util.ArrayList;

public class AeroplaneProblem {
	/* Inner class Node. represent vertex on matrix. */
	class Node {
		int x, y, price, nPaths;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.price = 0;
			this.nPaths = 0;
		}

		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
	}
	/* End Node inner class. */

	/* -------Fields------- */
	private Node[][] mat; // matrix of Nodes

	public AeroplaneProblem() {
		this.mat = initMatrix();
		buildPriceNPathMatrix();
	}

	private Node[][] initMatrix() {
		int m = 4; // number of rows
		int n = 5; // number of columns

		Node mat[][] = new Node[m][n];
		/* The first row */
		mat[0][0] = new Node(3, 1);
		mat[0][1] = new Node(5, 2);
		mat[0][2] = new Node(10, 4);
		mat[0][3] = new Node(4, 2);
		mat[0][4] = new Node(0, 4);
		/* The second row */
		mat[1][0] = new Node(3, 8);
		mat[1][1] = new Node(11, 5);
		mat[1][2] = new Node(1, 3);
		mat[1][3] = new Node(5, 3);
		mat[1][4] = new Node(0, 2);
		/* The third row */
		mat[2][0] = new Node(8, 3);
		mat[2][1] = new Node(6, 3);
		mat[2][2] = new Node(4, 1);
		mat[2][3] = new Node(6, 5);
		mat[2][4] = new Node(0, 4);
		/* The forth row */
		mat[3][0] = new Node(4, 0);
		mat[3][1] = new Node(4, 0);
		mat[3][2] = new Node(5, 0);
		mat[3][3] = new Node(3, 0);
		mat[3][4] = new Node(0, 0);
		return mat;

	}

	/*
	 * This function build the price matrix and calculate the number of tracks that
	 * have a minimal cost.
	 */
	private void buildPriceNPathMatrix() {
		/* INIT the first row */
		for (int j = 1; j < mat[0].length; j++) {
			mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].x;
			mat[0][j].nPaths = 1;
		}

		/* INIT the first col */
		for (int i = 1; i < mat.length; i++) {
			mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].y;
			mat[i][0].nPaths = 1;
		}
		int a, b;

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				a = mat[i - 1][j].price + mat[i - 1][j].y; // from above
				b = mat[i][j - 1].price + mat[i][j - 1].x; // from left

				if (a < b) {// from above
					mat[i][j].price = a;
					mat[i][j].nPaths = mat[i - 1][j].nPaths;
				} else if (a > b) {// from left
					mat[i][j].price = b;
					mat[i][j].nPaths = mat[i][j - 1].nPaths;
				} else {// a == b
					mat[i][j].price = a;
					mat[i][j].nPaths = mat[i - 1][j].nPaths + mat[i][j - 1].nPaths;
				}
			}
		}
	}

	/* This function calculate one best track. O(row+col) */
	public String getOneBestTrack() {
		int i = mat.length - 1;
		int j = mat[0].length - 1;
		int a, b;
		String ans = "";

		while (i > 0 && j > 0) {
			a = mat[i - 1][j].price + mat[i - 1][j].y;
			b = mat[i][j - 1].price + mat[i][j - 1].x;

			if (a <= b) {
				ans = "1" + ans;
				i--;
			} else {
				ans = "0" + ans;
				j--;
			}
		}

		while (j > 0) {
			ans = "0" + ans;
			j--;
		}
		while (i > 0) {
			ans = "1" + ans;
			i--;
		}

		return ans;
	}

	public void getAllBestPathsRec() {
		int teta = 10000;
		int numOfPaths = mat[mat.length - 1][mat[0].length - 1].nPaths;
		if (numOfPaths <= teta) {
			ArrayList<String> paths = new ArrayList<>(numOfPaths);
			buildPaths(new String(), mat.length - 1, mat[0].length - 1, paths);
			System.out.println(paths);
		}
	}

	private void buildPaths(String path, int i, int j, ArrayList<String> paths) {
		if (i > 0 && j > 0) {
			int a = mat[i - 1][j].price + mat[i - 1][j].y;
			int b = mat[i][j - 1].price + mat[i][j - 1].x;
			if (a < b)
				buildPaths("1" + path, i - 1, j, paths);
			else if (a > b)
				buildPaths("0" + path, i, j - 1, paths);
			else {
				buildPaths("1" + path, i - 1, j, paths);
				buildPaths("0" + path, i, j - 1, paths);
			}
		}
		else if(i == 0 && j == 0)
			paths.add(path);
		else if(i == 0) {
			String t = new String();
			for(int k = 0; k < j ; k++) t +="0";
			paths.add(t+path);
		}
		else if(j == 0) {
			String t = new String();
			for(int k = 0; k < i ; k++) t +="1";
			paths.add(t+path);
		}
		
	}

	/* This function prints the price matrix. */
	public void printPriceMat() {
		System.out.println("\nmatrix of prices: \n");
		for (int i = 0; i < this.mat.length; i++) {
			for (int j = 0; j < this.mat[0].length; j++) {
				System.out.print(this.mat[i][j].price + "\t");
			}
			System.out.println("\n");
		}
		System.out.println();
	}

	/* This function prints the node matrix. */
	public void printMatrixNode() {
		System.out.println("\nmatrix node: \n");
		for (int i = 0; i < this.mat.length; i++) {
			for (int j = 0; j < this.mat[0].length; j++) {
				System.out.print(this.mat[i][j] + "\t");
			}
			System.out.println("\n");
		}
		System.out.println();
	}

}
