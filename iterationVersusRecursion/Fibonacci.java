package iterationVersusRecursion;

public class Fibonacci {

	public static int fibonacciRec(int n) {
		if (n <= 2)
			return 1;
		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
	}

	public static int fibonacciIndu(int n) {
		int ans = 0;
		int f1 = 1, f2 = 1;
		for (int i = 3; i <= n; i++) {
			ans = f1 + f2;
			f1 = f2;
			f2 = ans;
		}
		return ans;
	}

	static private long fibArray[] = new long[1000];

	static public long recursiveFibonacciMemo(int n) {
		if (n <= 2)
			return 1;
		else {
			if (fibArray[n] != 0)
				return fibArray[n];
			else {
				fibArray[n] = recursiveFibonacciMemo(n - 1) + recursiveFibonacciMemo(n - 2);
			}
		}
		return fibArray[n];
	}

	static int fibTail(int n, int f1, int f2) {

		if (n == 1 || n == 2)
			return f2;
		return fibTail(n - 1, f2, f1 + f2);
	}

	public static void main(String[] args) {
		int n = 40;
		long start = System.nanoTime();
		System.out.println(fibonacciRec(n));
		long end = System.nanoTime();
		long timeFacRec = end - start;
		System.out.println(
				"the time that takes to fibonacciRec to calculate " + n + "! is: " + timeFacRec + " (nano time)");

		start = System.nanoTime();
		System.out.println(fibonacciIndu(n));
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println(
				"the time that takes to fibonacciIndu to calculate " + n + "! is: " + timeFacRec + " (nano time)");

		start = System.nanoTime();
		System.out.println(recursiveFibonacciMemo(n));
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to recursiveFibonacciMemo to calculate " + n + "! is: " + timeFacRec
				+ " (nano time)");
		
		
		start = System.nanoTime();
		System.out.println(fibTail(n,1,1));
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println("the time that takes to fibTail to calculate " + n + "! is: " + timeFacRec
				+ " (nano time)");
	}

}
