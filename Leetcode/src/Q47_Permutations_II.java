import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q47_Permutations_II {
	public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null) {
            return result;
        }
        Arrays.sort(num);
        List<Integer> solution = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        helper(result, visited, solution, num);
        return result;
    }
    
    private static void helper(List<List<Integer>> result, boolean[] visited, List<Integer> solution, int[] num) {
        if(solution.size() == num.length) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(visited[i] || (i != 0 && num[i] == num[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            solution.add(num[i]);
            helper(result, visited, solution, num);
            solution.remove(solution.size() - 1);
            visited[i] = false;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
