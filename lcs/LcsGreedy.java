package lcs;

/**
 * **********************This Algorithm returns not optimal answer.************************
 * @author Shay Naor
 *
 */
public class LcsGreedy {
	private String ans;
	private int start, index, i,m,n;
	
	/* O(n*m) */
	public LcsGreedy(String X, String Y) {
		ans = "";
		start = index = i = 0;
		m = X.length(); 
		n = Y.length();
		
		while(i < m && index < n) {
			index = Y.indexOf(X.charAt(i), start);
			if(index != -1) {
				ans = ans + X.charAt(i);
				start = index + 1;
			}
			i++;
			//index++;
		}
	}
	
	public String toString() {
		return ans;
	}
	public static void main(String[] args) {
		String x = "ababcbb";
		String y = "cbab";
		LcsGreedy xGy = new LcsGreedy(x,y);
		System.out.println(xGy);
		LcsGreedy yGx = new LcsGreedy(y,x);
		System.out.println(yGx);
		
	}

}
