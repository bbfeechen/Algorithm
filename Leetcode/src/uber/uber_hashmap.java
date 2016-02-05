package uber;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class uber_hashmap {
	public static class Entry {
		Object key;
		Object val;
		Time time;
		Entry next;
		public Entry(Object key, Object val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}
	
	public static class HashMap {
		private static final int DEFAULT_CAPACITY = 100;
		private int size;
		private int capacity;
		private List<Entry>[] table;
		
		public class EntryComparator implements Comparator<Entry> {
			public int compare(Entry e1, Entry e2) {
				return e1.time.compareTo(e2.time);
			}
		}
		
		public HashMap() {
			this.size = 0; 
			this.capacity = DEFAULT_CAPACITY;
			this.table = new List[capacity];
			for(int i = 0; i < capacity; i++) {
				table[i] = new ArrayList<Entry>();
			}
		}
		
		public void put(Object key, Object val) {
			int hashcode = hash(key);
			for(int i = 0; i < table[hashcode].size(); i++) {
				Entry entry = table[hashcode].get(i);
				if(entry.key.equals(key)) {
					table[hashcode].remove(i);
					table[hashcode].add(new Entry(key, val));
//					Collections.sort(table[hashcode], new EntryComparator());
					return;
				}
			}
			table[hashcode].add(new Entry(key, val));
//			Collections.sort(table[hashcode], new EntryComparator());
			size++;
		}
		
		public Object get(Object key) {
			int hashcode = hash(key);
			for(int i = 0; i < table[hashcode].size(); i++) {
				Entry entry = table[hashcode].get(i);
				if(entry.key.equals(key)) {
					return entry.val;
				}
			}
			return null;
		}
		
		public int size() {
			return size;
		}
		
		public boolean contains(Object key) {
			return get(key) != null;
		}
		
		private int hash(Object key) {
			return key.hashCode() % capacity;
		}
		
		public void print() {
			for(int i = 0; i < table.length; i++) {
				List<Entry> list = table[i];
				if(!list.isEmpty()) {
					for(Entry entry : list) {
						System.out.print(entry.key + "->" + entry.val);
					}
					System.out.println();
				}
			}
		}
	}
	

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(3, 3);
		map.put(2, 2);
		map.put(1, 1);
		map.print();
		System.out.println(map.get(3));
        map.put(3, 4);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.get(8));
        System.out.println(map.size());
        map.print();
	}
}
