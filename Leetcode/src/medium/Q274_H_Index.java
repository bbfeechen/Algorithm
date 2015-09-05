package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q274_H_Index {
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        Integer[] array = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
        	array[i] = citations[i];
        }
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list, Collections.reverseOrder());
        int hIndex = 0;
        while(hIndex < list.size() && list.get(hIndex) >= (hIndex + 1)) {
            hIndex++;
        }
        return hIndex;
    }

	public static void main(String[] args) {
		int[] citations = {3, 1, 0, 6, 5};
		System.out.println(hIndex(citations));
	}
}
