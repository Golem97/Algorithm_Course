package glassBall;

public class GlassBallTriangle {


	public static void glassBallsTriangle(int[] floorPotential, int ballPotential) {
		// n = the number of floors, t - the current floor
		int n = floorPotential.length;
		int k = (int) Math.sqrt(2*n);
		int step = k, numChecks = 0, t = k - 1;
		boolean isBroken = false;
		if (floorPotential[n - 1] < ballPotential) {// the first ball not broken
			System.out.println("the first ball is not broken");
			return;
		}
		// the first ball
		while (!isBroken && t < n) {
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential))
				isBroken = true;
			else
				t = t + (--step);
		}
		// the second ball
		if (t > n)
			t = t - k;
		else
			t = t - step + 1;
		isBroken = false;
		// throw the second ball
		while (!isBroken) {
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential))
				isBroken = true;
			else
				t++;
		}
		System.out.println("k = " + k + ", " + ", numChecks = " + numChecks + ", floor number =  " + (t + 1));
	}

	public static boolean isCrashed(int floorPotential, int ballPotential) {
		return floorPotential >= ballPotential;
	}

	public static void main(String[] args) {
	}
}
