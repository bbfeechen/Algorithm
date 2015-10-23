package secret;

import java.util.ArrayList;
import java.util.List;

//Problem Description:
//
//Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
//
//For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

public class Q163_Missing_Ranges {
	public static List<String> findMissingRanges(int[] A, int lower, int upper) { 
		List<String> result = new ArrayList<String>();
		if(A == null || A.length == 0) {
			if(upper - lower > 1) {
				result.add(lower + "->" + upper);
			} else {
				result.add(lower + "");
			}
			return result;
		}
		
		if(lower < A[0]) {
			if(A[0] - lower >= 2) {
				result.add(lower + "->" + (A[0] - 1));
			} else if(A[0] - lower == 1) {
				result.add(lower + "");
			}
		}
		
		for(int i = 1; i < A.length; i++) {
			if(A[i] - A[i - 1] > 2) {
				result.add((A[i - 1] + 1) + "->" + (A[i] - 1));
			} else if(A[i] - A[i - 1] == 2) {
				result.add((A[i - 1] + 1) + "");
			}
		}
		
		if(A[A.length - 1] < upper) {
			if(upper - A[A.length - 1] > 2) {
				result.add((A[A.length - 1] + 1) + "->" + upper);
			} else if(upper - A[A.length - 1] == 2) {
				result.add((A[A.length - 1] + 1) + "");
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] A = new int[] {0, 1, 3, 50, 75};
		List<String> result = findMissingRanges(A, 0, 99);
		for(String str : result) {
			System.out.print(str + ", ");
		}
	}
}
