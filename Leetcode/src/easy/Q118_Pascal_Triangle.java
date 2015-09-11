package easy;

import java.util.ArrayList;
import java.util.List;

public class Q118_Pascal_Triangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return result;
        }
        
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(prev);
        for(int i = 1; i < numRows; i++) {
            List<Integer> curr = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }
            prev = curr;
            result.add(prev);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
