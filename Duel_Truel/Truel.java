package Duel_Truel;

public class Truel {

	static Player player[] = new Player[3];

	static boolean duel = true;
	static double chance = 0;
	static int simulationCount = 5000000;

	class Player {
		double probability = 0.0;
		int victory = 0;
	}

	Truel() {
		player[0] = new Player(); // Carol
		player[1] = new Player(); // Alice
		player[2] = new Player(); // Bob

		player[0].probability = 1.0;
		player[1].probability = 0.8;
		player[2].probability = 0.5;
	}

	// ****************************************************************

	public static void carolFirst() { // Carol is first
		chance = Math.random();
		if (chance < player[2].probability) {
			player[2].victory++;
		} else
			player[0].victory++;
	}

	// ****************************************************************

	public static void aliceFirst() { // Alice is first
		// A-->C
		chance = Math.random();
		/* If A->C hit C */
		if (chance < player[1].probability) {
			duelSimulation();// duel B->A
		} else {// A-> missed C
			if (chance > 0.5)// how shoot next C or B.
				carolFirst();
			else
				bobFirst();
		}
	}

	// ****************************************************************

	public static void bobFirst() { // Bob is first ;
		// B shoot in the air.
		chance = Math.random();
		if (chance < 0.5)
			carolFirst();
		else
			aliceFirst();

	}

	// ****************************************************************

	static void duelSimulation() {
		int begin = 2;
		duel = true;
		while (duel) {
			chance = Math.random();
			if (chance < player[begin].probability) {
				duel = false;
				player[begin].victory++;
			}
			if (begin == 2)
				begin = 1;
			else
				begin = 2;
		}

	}

	// ****************************************************************

	public static void truel() {
		for (int i = 0; i < simulationCount; i++)
			truelSimulation(i % 3);
	}

	// ****************************************************************

	public static void printResult() {
		double probCarol = (double) player[0].victory / simulationCount;
		double probAlice = (double) player[1].victory / simulationCount;
		double probBob = (double) player[2].victory / simulationCount;

		System.out.println("probCarol = " + probCarol + ",   probAlice = " + probAlice + ",  probBob = " + probBob);
		System.out.println("summa = " + (probCarol + probBob + probAlice));
	}

	// ****************************************************************

	public static void truelSimulation(int begin) {
		if (begin == 0)
			carolFirst();
		if (begin == 1)
			aliceFirst();
		if (begin == 2)
			bobFirst();
	}

	// ****************************************************************

	public static void main(String[] args) {

		new Truel();
		truel();
		printResult();
	}

}

// ****************************************************************
