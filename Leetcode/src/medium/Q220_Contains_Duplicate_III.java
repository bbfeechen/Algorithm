package medium;

import java.util.TreeSet;

public class Q220_Contains_Duplicate_III {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0) {
            return false;
        }
        
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
    		long c = nums[i];
    		if ((set.floor(c) != null && (c - set.floor(c)) <= t)
    		|| (set.ceiling(c) != null && (set.ceiling(c) - c) <= t))
    			return true;
     
    		set.add(c);
     
    		if (i >= k)
    			set.remove((long)nums[i - k]);
    	}
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
