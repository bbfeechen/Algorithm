package secret;

import java.util.HashMap;

public class Q170_Two_Sum_III {
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public void add(int num) {
		if(map.containsKey(num)) {
			map.put(num, map.get(num) + 1);
		} else {
			map.put(num, 1);
		}
	}
	
	public boolean find(int target) {
		for(Integer key : map.keySet()) {
			if(map.containsKey(target - key)) {
				return true;
			} else if(target - key == key) {
				if(map.get(key) >= 2) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Q170_Two_Sum_III util = new Q170_Two_Sum_III();
		util.add(1);
		util.add(3);
		util.add(5);
		
		System.out.println(util.find(4));
		System.out.println(util.find(7));
	}
}
