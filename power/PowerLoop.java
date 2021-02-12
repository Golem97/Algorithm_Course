package power;

public class PowerLoop {//O(logn)
	
	public static double powerLoop(double x, int n) {
		double result = 1;
		while(n != 0) {
			if(n % 2 == 1) result *= x;//mult when the digit in binary representation is 1.
			x *= x;
			n /= 2;
		}
		return result;
	}
	
	public static double powerRec(double x, int n) {
		if(n == 0) return 1;
		else if (n % 2 == 0) return powerRec(x*x, n/2);
		else return x*powerRec(x*x, (n-1)/2);
	}
	
	public static double powerJava(double x, double n) {
		return Math.pow(x, n);
	}

	public static void main(String[] args) {
		
		//System.out.println(powerLoop(2, 3));
		
		int n = 5636464;
		double x = 5654315.7;
		
		long start = System.nanoTime();
		powerLoop(x,n);
		long end = System.nanoTime();
		long timePowerLoop = end - start;
		System.out.println("the time that takes to timePowerLoop:  "
				+ timePowerLoop + " (nano time)");
		
		
		start = System.nanoTime();
		powerRec(x,n);
		end = System.nanoTime();
		long timepowerRec = end - start;
		System.out.println("the time that takes to powerRec:  "
				+ timepowerRec + " (nano time)");
		
		double a = 5636464;
		double b = 5654315.7;
		
		start = System.nanoTime();
		powerJava(a,b);
		end = System.nanoTime();
		long timePowerJava = end - start;
		System.out.println("the time that takes to powerJava:  "
				+ timePowerJava + " (nano time)");
	}

}
