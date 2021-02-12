package lcs;

/**
 * **********************This Algorithm returns not optimal answer.************************
 * O(n+m) + O(min(n,m)
 * @author Shay Naor
 *
 */
public class LcsGreedyImprove {
	private char[] help;
	private String ans;
	private int start, index, i,m,n,place;

	public LcsGreedyImprove(String x , String y) {
		help = new char[26];
		m = x.length();
		n = y.length();
		ans = "";
		start = index = i = 0;

		if(m < n) 
			GreedyImprove(x , y);
		else
			GreedyImprove(y , x);
	}

	public void GreedyImprove(String x, String y) {
		m = x.length();
		n = y.length();

		for(int k = 0 ; k < m ; k++) {
			place = x.charAt(k) - 'a';
			help[place]++;
		}

		while(i < n && index < m) {
			place = y.charAt(i) - 'a';
			if(help[place] > 0) {
				index = x.indexOf(y.charAt(i), start);
				if(index != -1) {
					ans = ans + y.charAt(i);
					start = index + 1;
					help[place]--;
				}else
					help[place] = 0;

			}
			i++;
		}

	}
	
	
	public String toString() {
		return ans;
	}
	public static void main(String[] args) {
		String x = "ababcb";
		String y = "cbab";
		LcsGreedyImprove xGy = new LcsGreedyImprove(x,y);
		System.out.println(xGy);
		LcsGreedyImprove yGx = new LcsGreedyImprove(y,x);
		System.out.println(yGx);
	}

}
