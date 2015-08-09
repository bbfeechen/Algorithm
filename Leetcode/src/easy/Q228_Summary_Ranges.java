package easy;

import java.util.ArrayList;
import java.util.List;

public class Q228_Summary_Ranges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		int start = nums[0];
		int end = nums[0];
		for(int i = 0; i < nums.length; i++) {
			if(i != nums.length - 1 && nums[i + 1] == end + 1) {
				end = nums[i + 1];
			} else {
				if(start == end) {
					result.add(end + "");
				} else {
					result.add(start + "->" + end);
				}
				if(i != nums.length - 1) {
					end = nums[i + 1];
					start = end;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		List<String> result = summaryRanges(nums);
		for(String s : result) {
			System.out.print(s + ", ");
		}
	}
}
