package medium;

import java.util.ArrayList;
import java.util.List;

public class Q60_Permutation_Sequence {
	public static String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        int factorial = 1;
        for(int i = 2; i < n; i++) {
            factorial = factorial * i;
        }
        
        StringBuilder sb = new StringBuilder();
        int times = n - 1;
        while(times >= 0) {
            int index = k / factorial;
            sb.append(list.get(index));
            list.remove(index);
            k = k % factorial;
            if(times != 0) {
                factorial = factorial / times;
            }
            times--;
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 6));
	}
}
