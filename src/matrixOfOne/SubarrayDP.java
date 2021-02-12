package matrixOfOne;

public class SubarrayDP {
	
	//*********************************************************************************

	public static void maxSubarrayDP(int[]arr){
		int [] help = new int[arr.length];
		help[0] = arr[0];
		int indMax = 0;
		for(int i = 1 ; i < help.length ; i++) {
			if(arr[i] == 1)
				help[i] = help [i-1]+1;
			if(help[i] > help[indMax])
				indMax = i;
		}
		int lengthMax = help[indMax];
		int startMax = indMax - lengthMax +1;

		 
		System.out.println("startMax = " + startMax + "   lengthMax = " + lengthMax);
	}

	//*********************************************************************************

	public static void main(String[] args) {

		System.out.println("*****  DP  *****");
		int arr[] = {1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,0,1,0,0};
		int arr1[] = {1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1};
		int arr2[] = {1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1};
		maxSubarrayDP(arr);
		maxSubarrayDP(arr1);
		maxSubarrayDP(arr2);
	}
}