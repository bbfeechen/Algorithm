package linkedin;

import java.util.List;

//Given a nested list of integers, returns   the sum of all integers in the list weighted by their depth 
//For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
//* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 

public class NestedListSum {
	public interface NestedInteger 
	{ 
		// Returns true if this NestedInteger holds a single integer, rather than a nested list 
		public boolean isInteger(); 

		// Returns the single integer that this NestedInteger holds, if it holds a single integer 
		// Returns null if this NestedInteger holds a nested list 
		public Integer getInteger(); 

		// Returns the nested list that this NestedInteger holds, if it holds a nested list 
		// Returns null if this NestedInteger holds a single integer 
		public List<NestedInteger> getList(); 
	}
	
	private static int sum = 0;

    private NestedListSum() {

    }

    public static int findNestedListSum(List nestedList) {
        return findNestedListSum(nestedList, 1);
    }

    public static int findNestedListSum(List inputList, int depth) {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) instanceof List) {
                findNestedListSum((List) inputList.get(i), depth + 1);
            } else {
                sum = sum + depth * (Integer) inputList.get(i);
//                System.out.println("integer => " + inputList.get(i) + " Depth => " + depth);
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
		
	}
}
