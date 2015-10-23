package secret;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q281_Zigzag_Iterator {
	public static class ZigzagIterator {
		private List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();
		private int count;
		
		public ZigzagIterator(Iterator<Integer> v1, Iterator<Integer> v2) {
			if(v1.hasNext()) {
				list.add(v1);
			}
			if(v2.hasNext()) {
				list.add(v2);
			}
		}
		
		public boolean hasNext() {
			return !list.isEmpty();
		}
		
		public int next() {
			int x = list.get(count).next();
			if(!list.get(count).hasNext()) {
				list.remove(count);
			}
			if(list.size() != 0) {
				count = (count + 1) % list.size();
			}
			return x;
		}
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		ZigzagIterator i = new ZigzagIterator(list1.iterator(), list2.iterator());
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
}
