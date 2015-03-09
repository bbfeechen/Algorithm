import java.util.ArrayList;


public class Q9_4 {

	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> subsets = getSubsets(set, 0);
	}

	private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubsets = new ArrayList<Integer>();
				newsubsets.addAll(subset);
				newsubsets.add(item);
				moresubsets.add(newsubsets);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
