package power;

public class PowerRec {
	
	public static double powerRec(double x, int n) {
		if(n == 0) return 1;
		else if (n % 2 == 0) return powerRec(x*x, n/2);
		else return x*powerRec(x*x, (n-1)/2);
	}

	public static void main(String[] args) {

		System.out.println(powerRec(2, 6));

		
	}

}
