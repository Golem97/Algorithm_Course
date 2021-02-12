package secretaryProblem;

import java.util.Arrays;

public class secretaryAlgorithm {
	
	/* 
	 * CHECK:
	 * int times[] = { 10,1,8};
	 *	int t1 = 1;
	 *	int t2 = 8;
	 *	int t3 = 10;
	 *	int T1 = t1; // = 1
	 * 	int T2 = t1 + t2; // = 1 + 8 = 9 
	 *	int T3 = t1 + t2 + t3; // = 1 + 8 + 10 = 19
	 *	double avg = (T1+T2+T3)/3.0;// = (1 + 9 + 19) / 3 =  29 / 3 = 9.66
	 */
	
	public static double getAvarageTime(int[] times) {
		int n = times.length;
		Arrays.sort(times);
		int Tn = 0;
		int sum=0;
		for(int i = 0 ; i < n ; i++) {
			Tn += times[i];
			sum += Tn;
		}
		double avg = sum/(double)n;
		return avg;
	}

	public static void main(String[] args) {
		int times[] = { 10,1,8};
		System.out.println(getAvarageTime(times));
		
		
		
	}

}
