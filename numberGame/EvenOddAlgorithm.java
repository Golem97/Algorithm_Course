package numberGame;

public class EvenOddAlgorithm {

	private int A_Result; // sum of the numbers that player one choice.
	private int B_Result;// sum of the numbers that player two choice.
	private int arr[];// numbers array.
	private int begin;// arrays first ondex.
	private int end;// arrays last index.
	private int oddSum;// sum of odd numbers elements.
	private int evenSum;// sum of even numbers elements.

	/** A default constructor. */
	public EvenOddAlgorithm() {
		A_Result = 0;
		B_Result = 0;
		arr = buildArr();
		begin = 0;
		end = arr.length - 1;
		oddSum = 0;
		evenSum = 0;
	}

	private int[] buildArr() {
		int a[] = new int[10];

		for (int i = 0; i < a.length; i++)
			a[i] = (int) Math.round(Math.random() * 100);

		return a;
	}

	public void greedyAlgorithm() {
		
		for(int i = 0 ; i < arr.length ; i = i+2) {//clculate even and odd summs.
			evenSum += arr[i];
			oddSum += arr[i+1];
		}
		boolean even = true;
		if(evenSum < oddSum)
			even = false;
		
		while (end > begin) {
			if ( (even && begin % 2 == 0) || (!even && begin % 2 == 1))// first player A choice.
				A_Result += arr[begin++];
			else
				A_Result += arr[end--];
			if (arr[begin] > arr[end])// second player B choice.
				B_Result += arr[begin++];
			else
				B_Result += arr[end--];
		}
	}

	public static void main(String[] args) {
		
		int A_Wins = 0;
		int B_Wins = 0;

		for (int i = 0; i < 100; i++) {
			EvenOddAlgorithm g = new EvenOddAlgorithm();
			g.greedyAlgorithm();
			if (g.A_Result >= g.B_Result)
				A_Wins++;
			else
				B_Wins++;
		}
		System.out.println("The number of times that player A wins: " + A_Wins + "\n"
				+ "The number of times that player B wins: " + B_Wins);
		System.out.println("If you used EvenOddAlgorithm your precent to win in 100 round of games is: " + A_Wins + "%");
	}

}
