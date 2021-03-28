package GoogleCodeJam2021;


public class Solution2 {

	public static void main(String[] args) {
		String[] list = {
				"???????",
				"?",
				"J",
				"C",
				"JJJJJJJJJJ",
				"CCCCCCCCCC",
				"JJJJJCCCCC",
				"JCJCJCJCJC",
				"J?????",
				"JC???JC",
				"???JC???",
				"??J???C"
		};
		
		for(String s : list) {
			System.out.println("------");
			System.out.println(s);
			System.out.println(compressString(s));
		}
		
		System.out.println(" -300 -300" + sigmoid(-300, -300));
		System.out.println(" -300  300" + sigmoid(-300,  300));
		System.out.println(" 300 -300" + sigmoid(300, -300));
		System.out.println(" 300 300" + sigmoid(300, 300));
		System.out.println(" 0 0" + sigmoid(0, 0));

	}
	public static double sigmoid(int si, int qj) {
		System.out.println(" si = " + si + " qj = " + qj);
		double exp = Math.exp(-si*qj/10000.0);
		System.out.println(" exp = " + exp);
		double res = 1.0/(1+exp);
		System.out.println("res = " + res);
		return res;
	}
	public static String compressString(String input) {
		if (input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		char prev = arr[0];
		sb.append(prev);
		for (int i = 1; i < arr.length; i++) {
		    char curr = arr[i];
		    prev = arr[i - 1];
		    if (curr != prev) {
	            sb.append(curr);
		    }
		}
		
		return sb.toString();
	}
}
