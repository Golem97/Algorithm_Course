package prisonersproblemAlgorithm;

public class PrisonersAlgorithm {

	public static int prisonersLampOn(int n) {
		boolean enter[] = new boolean[n];
		for (int i = 0; i < enter.length; i++)
			enter[i] = false;
		/* First the lamp is on. */
		boolean lamp = true; //
		/* The first prisioner is the counter */
		int count = 0, steps = 0;
		while (count < n) {
			steps++;
			int p = (int) (Math.random() * n);
			if (p == 0) { // the counter enters
				if (!enter[p]) {// the counter enters for the first time
					enter[p] = true;
					count++;
				}
				if (!lamp) {
					lamp = true;
					count++;
				}
			} else {
				/* p>=1, prisoner enters for the first time && the lamp is on */
				if (!enter[p] && lamp) {
					lamp = false;
					enter[p] = true;
				}
			}
		}
		return steps;
	}

	public static void main(String[] args) {
		int steps = prisonersLampOn(30);
		System.out.println(steps);

	}

}
