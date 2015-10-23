package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintFactorCombinations {
	public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        List<Integer> base = new ArrayList<Integer>();
//        base.add(1);
//        base.add(n);
//        result.add(base);
        if (n <= 3) {
            return result;
        }
        List<Integer> curr = new ArrayList<Integer>();
        helper(n, n, 2, curr, result);
//        for(List<Integer> list : result) {
//        	Collections.sort(list, Collections.reverseOrder());
//        }
        return result;
    }
     
    private static void helper(int ori, int n, int start, List<Integer> curr, List<List<Integer>> result) {
        if (n <= 1) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
         
        for (int i = start; i <= n && i < ori; i++) {
            if (n % i == 0) {
//            	if(curr.contains(i)) {
//            		continue;
//            	}
                curr.add(i);
                helper(ori, n / i, i, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

	public static void main(String[] args) {
		List<List<Integer>> solution = getFactors(12);
		for(List<Integer> list : solution) {
			for(int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
