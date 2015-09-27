package hard;
import java.util.ArrayList;
import java.util.Collections;


public class Q164_Maximum_Gap {
	public static int maximumGap(int[] num) {
        if(num == null || num.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        if(max == min) {
        	return 0;
        }
        ArrayList<ArrayList<Integer>> buckets = bucketSort(num, num.length - 1, max, min);
        
        int maxGap = Integer.MIN_VALUE;
        int prevMAX = min;
        for(int i = 0; i < buckets.size(); i++) {
            if(buckets.get(i).isEmpty()) {
                continue;
            }
            int bucketMIN = Collections.min(buckets.get(i));
            int bucketMAX = Collections.max(buckets.get(i));
            maxGap = Math.max(maxGap, Math.max(bucketMAX - bucketMIN, bucketMIN - prevMAX));
            prevMAX = bucketMAX;
        }
        return maxGap;
    }
    
    private static ArrayList<ArrayList<Integer>> bucketSort(int[] arr, int bucketCount, int max, int min) {
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucketCount);
        for(int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        
        int gap = (int)Math.ceil((double)(max - min) / bucketCount);
        for(int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - min) / gap;
            if(bucketIndex == bucketCount) {
                bucketIndex--;
            }
            buckets.get(bucketIndex).add(arr[i]);
        }
        return buckets;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
