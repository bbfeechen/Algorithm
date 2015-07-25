package medium;
import java.util.ArrayList;
import java.util.List;


public class Q46_Permutations {
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null) {
            return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        helper(result, solution, num);
        return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> solution, int[] num) {
        if(solution.size() == num.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(solution.contains(num[i])) {
                continue;
            }
            solution.add(num[i]);
            helper(result, solution, num);
            solution.remove(solution.size() - 1);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
