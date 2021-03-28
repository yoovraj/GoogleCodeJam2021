package GoogleCodeJam2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	    File file = new File("/Users/yoovraj.shinde/Downloads/cheating_detection_sample_ts1_input.txt");
	    BufferedReader br = new BufferedReader(new FileReader(file));

//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int num_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

	    int num_cases = Integer.parseInt(br.readLine());
//    	int P = in.nextInt();
    	int P = Integer.parseInt(br.readLine());
	    for(int t=1;t<=num_cases;t++){
	    	int[] players = new int[100];
	    	Arrays.fill(players, 0);
	    	int[] questions = new int[10000];
	    	Arrays.fill(questions, 0);
	    	
	    	boolean[][] answers = new boolean[100][10000];
//	    	BitSet answers = new BitSet()[100][10000];
	    	for (int i = 0; i < 100; i++) {
	    		// for each player i 
	    		String ss_i = br.readLine();
//	    		String ss_i = in.next();
	    		//System.out.println(ss_i);
	    		char[] ss_i_arr = ss_i.toCharArray();
	    		for (int j = 0; j < 10000; j++) {
	    			if (ss_i_arr[j] == '1') {
	    				questions[j]++;
	    				players[i] ++;
	    				answers[i][j] = true;
	    			}
	    			
	    		}
	    		players[i] = players[i] / 100;
	    		players[i] = -300 + players[i] * 6;
//	    		System.out.println(" Player " + i + " skills=" + players[i]);
	    		
	    	}
	    	
	    	int[] players_expected = new int[100];
	    	int difference=0, player = 0;
	    	for (int i = 0 ; i < 100; i++) {
		    	for (int j = 0; j < 10000; j++) {
		    		questions[j] = -300 + questions[j] * 6;
		    		//System.out.println(" Question Difficulty " + j + " = " + questions[j]);
		    		if (answers[i][j]) {
		    			double prob_win = sigmoid(players[i], questions[j]);
		    			if (prob_win > P*num_cases/100.0/100.0) {
		    				players_expected[i]++;
		    			}
		    		}
		    	}
//		    	System.out.println(" Player " + i + " actual = " + players[i] + " expected = " + players_expected[i]);
//		    	System.out.println(" Player " + i + " difference = " + (players[i] - players_expected[i]));
		    	int d = players[i] - players_expected[i];
		    	if (d < difference) {
		    		difference = d;
		    		player = i;
		    	}
	    	}
	    	
    		System.out.println("Case #" + t + ": " + (player + 1));
    		
    		
	    }
	    br.close();
	}

	public static int countCorrect(String list) {
		int count = 0;
		for (char c : list.toCharArray()) {
			if (c == '1') {
				count++;
			}
		}
		return count;
	}
	public static double sigmoid(int si, int qj) {
		return 1.0/(1+Math.exp(-(si/100.0)*(qj/100.0)));
	}
}
