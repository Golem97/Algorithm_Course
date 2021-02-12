package numberGame;

public class GreedyAlgorithm {

	private int A_Result; // sum of the numbers that player one choice.
	private int B_Result;// sum of the numbers that player two choice.
	private int arr[];// numbers array.
	private int begin;// arrays first ondex.
	private int end;// arrays last index.

	/** A default constructor. */
	public GreedyAlgorithm() {
		A_Result = 0;
		B_Result = 0;
		arr = buildArr();
		begin = 0;
		end = arr.length - 1;
	}

	private int[] buildArr() {
		int a[] = new int[10];

		for (int i = 0; i < a.length; i++)
			a[i] = (int) Math.round(Math.random() * 100);

		return a;
	}

	public void greedyAlgorithm() {
		while (end > begin) {
			if (arr[begin] > arr[end])// first player A choice.
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
			GreedyAlgorithm g = new GreedyAlgorithm();
			g.greedyAlgorithm();
			if (g.A_Result > g.B_Result)
				A_Wins++;
			else
				B_Wins++;
		}
		System.out.println("The number of times that player A wins: " + A_Wins + "\n"
				+ "The number of times that player B wins: " + B_Wins);
		System.out.println("If you greedy your precent to win in 100 round of games is: " + A_Wins + "%");

	}

}
