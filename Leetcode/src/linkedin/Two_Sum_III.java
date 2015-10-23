package linkedin;

import java.util.HashMap;

//Problem Description:
//
//Design and implement a TwoSum class. It should support the following operations: add and find.
//
//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.
//
//For example,
//
//add(1); add(3); add(5);
//find(4) -> true
//find(7) -> false

public class Two_Sum_III {
	//----------------- search more frequently
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
		Two_Sum_III util = new Two_Sum_III();
		util.add(1);
		util.add(3);
		util.add(5);
		
		System.out.println(util.find(4));
		System.out.println(util.find(7));
	}
}
