package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120_Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		int[] sum = new int[row];
		for(int i = 0; i < triangle.get(row - 1).size(); i++) {
			sum[i] = triangle.get(row - 1).get(i);
		}
		for(int i = row - 2; i >= 0; i--) {
			for(int j = 0; j < triangle.get(i).size(); j++) {
				sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]); 
			}
		}
		return sum[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(minimumTotal(triangle));
	}
}
