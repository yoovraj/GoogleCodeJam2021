package GoogleCodeJam2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author yoovraj.shinde
 */
public class Solution1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        //System.out.println("cases = " + num_cases);
        for (int i = 1; i <= num_cases; ++i) {
        	int list_len = in.nextInt();
        	//System.out.println("case no : " + i);
        	int[] list = new int[list_len];
        	for (int j = 0 ; j < list_len; j++ ) {
        		//System.out.println("j=" + j);
        		list[j] = in.nextInt();
        	}
        	
        	solve(i, list);
        }

	}
	
	public static void solve(int case_no, int[] list) {
		int cost = 0;
		//System.out.println(" -------- ");
		// System.out.println(Arrays.toString(list));
		for (int i = 1; i <= list.length - 1; i++) {
			//System.out.println("i = " + i);
			//System.out.println(Arrays.toString(Arrays.copyOfRange(list, i-1, list.length)));
			int j = i + getMinValueIndex(Arrays.copyOfRange(list, i-1, list.length));
			//System.out.println("j=" + j);
			
			int[] arr_sublit = Arrays.copyOfRange(list, i-1, j);
			//System.out.println(Arrays.toString(arr_sublit));
			
			int[] rev_array = reverseArray(arr_sublit);
			//System.out.println(Arrays.toString(rev_array));
			
			System.arraycopy(rev_array, 0, list, i-1, rev_array.length);
			//System.out.println("--- " + Arrays.toString(list));
			cost = cost + j - i + 1;
		}
		
        System.out.println("Case #" + case_no + ": " + cost);        
		
	}

	public static int getMinValueIndex(int[] numbers){
		int minValue = numbers[0];
		int minValueIndex = 0;
		for(int i=1;i<numbers.length;i++){
			if(numbers[i] < minValue){
				minValue = numbers[i];
				minValueIndex = i;
		    }
		}
		return minValueIndex;
	}
	
	public static int[] reverseArray(int[] list) {
		for(int i = 0; i < list.length / 2; i++)
		{
		    int temp = list[i];
		    list[i] = list[list.length - i - 1];
		    list[list.length - i - 1] = temp;
		}
		return list;
	}
}
