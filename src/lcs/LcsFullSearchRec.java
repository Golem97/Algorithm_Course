package lcs;
/**
 * O(2^m+n * min(n,n))
 * @author Shay Naor
 *
 */
public class LcsFullSearchRec {
	private String ans;

	public LcsFullSearchRec(String a, String b) {
		ans = LcsRec(a, b);
	}

	public String LcsRec(String a, String b) {
		int aLen = a.length(), bLen = b.length();
		if (aLen == 0 || bLen == 0)
			return "";
		else {
			if (a.charAt(aLen - 1) == b.charAt(bLen - 1))
				return LcsRec(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + a.charAt(aLen - 1);
			else {
				String x = LcsRec(a, b.substring(0, bLen - 1));
				String y = LcsRec(a.substring(0, aLen - 1), b);
				return (x.length() > y.length()) ? x : y;

			}
		}
	}

	public String toString() {
		return ans;
	}

	public static void main(String[] args) {
		String x = "bonirheimataoved";
		String y = "bonaoved";
		LcsFullSearchRec xGy = new LcsFullSearchRec(x, y);
		System.out.println(xGy);

	}

}
