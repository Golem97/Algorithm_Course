package LIS;

import java.util.Arrays;
/**
 * **********************This Algorithm returns not optimal answer.************************
 * @author Shay Naor
 *
 */
public class LISGreedy {
	private int[] temp;
	private int[] lis;

	
	public LISGreedy(int[] arr) {
		int n = arr.length;
		this.temp = new int[n];
		int k = 0;
		temp[0] = arr[0];
		for(int i = 1 ; i < n ; i++) {
			if(arr[i] > temp[k])
				temp[++k] = arr[i];
		}
		this.lis = new int [++k];
		for(int i = 0 ; i < k ; i++) {
			lis[i] = temp[i];
		}
	}
	
	public String toString() {
		return Arrays.toString(this.lis);
	}
	public static void main(String[] args) {
		int[] arr = {0,8,4,12,2,10,6,14,1,9,5,12,3,11,7,15};
		LISGreedy gre = new LISGreedy(arr);
		System.out.println(gre);
	}

}
