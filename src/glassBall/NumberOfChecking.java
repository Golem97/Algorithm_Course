package glassBall;

public class NumberOfChecking {

	public static int numberOfChecking2(int n) {
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;
		int min, x;
		for (int i = 3; i <= n; i++) {
			min = n;
			for (int j = 1; j < i; j++) {
				x = Math.max(j, f[i - j] + 1);
				if (x < min)
					min = x;
			}
			f[i] = min;
		}
		return f[n];
	}

	/* n= the number of floors , k = the number of balls. */
	public static int numberOfChecking(int n, int k) {
		int min = n + 1;
		int checks[][] = new int[k + 1][n + 1];
		for (int j = 0; j <= n; j++) {
			checks[1][j] = j;// one ball
		}
		for (int i = 0; i <= k; i++) {
			checks[i][1] = 1;//floor one
		}
		for (int i = 2; i <= k; i++) {// i - the number of the ball.
			for (int j = 2; j <= n; j++) {// j - the number of the floor
				min = n + 1;
				for (int p = 1; p < j; p++) {
					min = Math.min(min, 1 + Math.max(checks[i][j - p], checks[i - 1][p - 1]));
				}
				checks[i][j] = min;
			}

		}
		return checks[k][n];
	}

	public static void main(String[] args) {
		System.out.println(numberOfChecking2(3));
		System.out.println(numberOfChecking(100, 2));
	}

}
