package power;

public class FibByPow {

	public static long fibLoop(int n) {
		if (n == 1 || n == 2)
			return 1;
		n = n - 2;
		long mat[][] = { { 1, 1 }, { 1, 0 } };
		long res[][] = { { 1, 1 }, { 1, 0 } };
		while (n != 0) {
			if(n % 2 == 1) res = matSq2Mult(res, mat);
			mat = matSq2Mult(res, mat);
			n /= 2;
		}
		return res[0][1];
	}

	private static long[][] matSq2Mult(long m1[][], long m2[][]) {
		long[][] ans = new long[2][2];
		ans[0][0] = m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0];
		ans[0][1] = m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1];
		ans[1][0] = m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0];
		ans[1][1] = m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1];
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(fibLoop(8));
		String s = new String();
		
	}

}
