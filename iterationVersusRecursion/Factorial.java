package iterationVersusRecursion;

public class Factorial {

	public static int factorialRec(int n) {
		if (n == 0)
			return 1;
		return n * factorialRec(n - 1);
	}

	public static int factorialIndu(int n) {
		int ans = 1;
		for (int i = 2; i <= n; i++) {
			ans = ans * i;
		}
		return ans;
	}
	
	

	public static void main(String[] args) {
		int n = 5;
		long start = System.nanoTime();
		System.out.println(factorialRec(n));
		long end = System.nanoTime();
		long timeFacRec = end - start;
		System.out.println(
				"the time that takes to factorialRec to calculate " + n + "! is: " + timeFacRec + " (nano time)");

		start = System.nanoTime();
		System.out.println(factorialIndu(n));
		end = System.nanoTime();
		timeFacRec = end - start;
		System.out.println(
				"the time that takes to factorialRec to calculate " + n + "! is: " + timeFacRec + " (nano time)");

	}

}
