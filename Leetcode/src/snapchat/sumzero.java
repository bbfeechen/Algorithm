package snapchat;

import java.util.HashMap;
import java.util.Map;

public class sumzero {

	public static void main (String[] args) {
		int[]arr = new int[]{1,2, 3, -1, 2, -3, -3, 1, 2};//new int[]{1,2, 3, -1, 2, -3, -3, 1, 2};//new int[]{1,2, -3, 1};//new int[]{1,2, -2, 1};
		
		int running = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0 ; i < arr.length ; i++) {
			running += arr[i];
			if (running == 0) {
				System.out.println( 0 + "," + i);
				return;
			}
			if (map.containsKey(running)) {
				System.out.println((map.get(running) + 1) + "," + i);
				return;
			}
			map.put(running, i);
		}
		System.out.println("Not found.");
	}

}
