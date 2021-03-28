package GoogleCodeJam2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
*
* @author yoovraj.shinde
*/

public class Solution21 {

	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //System.out.println("cases = " + num_cases);
        for (int i = 1; i <= num_cases; ++i) {
        	int X = in.nextInt();
        	int Y = in.nextInt();
        	String input_pattern = in.next();
//        	System.out.println("case no : " + i + " X: " + X + " Y: " + Y + " input_pattern : " + input_pattern);
        	if (input_pattern.length() == 1) {
        		System.out.println("Case #" + i + ": 0");
        		continue;
        	}        	
        	input_pattern = compressString(input_pattern);
        	if (input_pattern.length() == 1 ) {
        		System.out.println("Case #" + i + ": 0");
        		continue;
        	}        	
//        	System.out.println("case no : " + i + " X: " + X + " Y: " + Y + " input_pattern : " + input_pattern);        	
        	char c_state = input_pattern.charAt(0);
        	int cost = 0;
        	for (int k = 1; k < input_pattern.length(); k++) {
        		char c = input_pattern.charAt(k);
//        		System.out.print(""+ c_state + c);
        		switch("" + c_state + c) {
	    			case "CJ":  // Direct CJ transition
	    			case "cJ":  // C to J effective transition via ?
	    				cost = cost + X;
	    				c_state = c;
	    				break;
	    			
	    			case "JC": // Direct JC transition
	    			case "jC": // J to C effective transition via ?
	    				cost = cost + Y;
	    				c_state = c;
	    				break;
	    				
	    			case "C?":
	    				// assume it will be same so 0 cost
	    				c_state = 'c';
	    				break;
    				
	    			case "J?":
	    				// assume it will be same so 0 cost
	    				c_state = 'j';
	    				break;
    				
	    			case "cC":
	    			case "jJ":
	    			case "??":
	    			case "JJ":
	    			case "CC":
	    			case "?J":
	    			case "?C":
	    			case "j?":
	    			case "c?":
	    				// all ? were C or J or ? so 0 cost, and restore state
	    				c_state = c;
	    				break;

	    			default:
						break;
        		}
//        		System.out.println(" :" + cost);
        	}
        	
        	
            System.out.println("Case #" + i + ": " + cost);        
        }
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