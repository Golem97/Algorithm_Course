package gameAliseAndBob;

public class AliceAndBob {

	/**
	 * Coin flip method
	 * 
	 * @return this method return 1 or 0.
	 */
	public static int coinFlip() {
		long result = 0;
		result = Math.round(Math.random());
		return (int) result;
	}

	/** @return this methid returns resault of alice. */
	public static int aliceGame() {
		return coinFlip();
	}

	/** @return this methid returns resault of alice. */
	public static int bobGame() {
		return coinFlip();
	}

	/**
	 * Game strategy 1: Alise chooce a random number.
	 */
	public static boolean gameStrategy1() {
		boolean result = false;
		int aliceResult = aliceGame();
		if (aliceResult > 0)
			result = true;
		return result;
	}

	/**
	 * Game strategy 2: Alise and bob say 1.
	 */
	public static boolean gameStrategy2() {
		boolean result = false;
		int aliceResult = aliceGame();
		int bobResult = bobGame();
		if ((aliceResult == 1) || (bobResult == 1))
			result = true;
		return result;
	}

	/**
	 * Game strategy 3: every one says what he gets.
	 */
	public static boolean gameStrategy3() {
		boolean result = false;
		int aliceResult = aliceGame();
		int bobResult = bobGame();
		if (aliceResult == bobResult)
			result = true;
		return result;
	}

	/**
	 * Game strategy 4: alise say what she gets and bob say the opposite.
	 */
	public static boolean gameStrategy4() {
		boolean result = false;
		int aliceResult = aliceGame();
		int bobResult = bobGame();
		if ((aliceResult == bobResult) || (bobResult == 1 - aliceResult))
			result = true;
		return result;
	}

	public static void main(String[] args) {

		int count = 10000000;
		int GameStrategy1, GameStrategy2, GameStrategy3, GameStrategy4;
		GameStrategy1 = GameStrategy2 = GameStrategy3 = GameStrategy4 = 0;
		boolean result1, result2, result3, result4;
		result1 = result2 = result3 = result4 = false;

		for (int i = 0; i < count; i++) {
			result1 = gameStrategy1();
			if (result1 == true)
				GameStrategy1++;
			result2 = gameStrategy2();
			if (result2 == true)
				GameStrategy2++;
			result3 = gameStrategy3();
			if (result3 == true)
				GameStrategy3++;
			result4 = gameStrategy4();
			if (result4 == true)
				GameStrategy4++;
		}
		System.out.println("Alice & Bob game : Strategy1 probability= " + (double) GameStrategy1 / (double) count);
		System.out.println("Alice & Bob game : Strategy2 probability= " + (double) GameStrategy2 / (double) count);
		System.out.println("Alice & Bob game : Strategy3 probability= " + (double) GameStrategy3 / (double) count);
		System.out.println("Alice & Bob game : Strategy4 probability= " + (double) GameStrategy4 / (double) count);
	}

}
