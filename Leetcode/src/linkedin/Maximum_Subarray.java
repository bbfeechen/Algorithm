package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maximum_Subarray {
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static int maxSubArray(int[] A) {
        // int max = Integer.MIN_VALUE;
        // int sum = 0;
        // for(int a : A) {
        //     sum += a;
        //     max = Math.max(max, sum);
        //     sum = Math.max(sum, 0);
        // }
        // return max;
		
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        List<Integer> temp = new ArrayList<Integer>();
        for(int i = 1; i < A.length; i++) {
            if(sum[i - 1] + A[i] > A[i]) {
            	sum[i] = sum[i - 1] + A[i];
            } else {
            	sum[i] = A[i];
            	temp.clear();
            }
            temp.add(A[i]);
            if(sum[i] > max) {
            	max = sum[i];
            	list.clear();
            	list.addAll(temp);
            }
        }
        return max;
    }

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(A));
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
