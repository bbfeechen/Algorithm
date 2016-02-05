package sandbox;

import java.util.ArrayList;
import java.util.List;

public class LinkedHashMap {
	class Entry {
		Object key;
		Object value;
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private List<Entry> list;
	
	public LinkedHashMap() {
		this.list = new ArrayList<Entry>();
	}
	
	public void put(Object key, Object value) {
		Entry entry = new Entry(key, value);
		for(int i = 0; i < list.size(); i++) {
			Entry e = list.get(i);
			if(e.key.equals(key)) {
				list.remove(i);
				break;
			}
		}
		list.add(entry);
	}
	
	public Object get(Object key) {
		for(int i = 0; i < list.size(); i++) {
			Entry e = list.get(i);
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}
	
	public int hash(Object key) {
		return key.hashCode();
	}

	public static void main(String[] args) {
		LinkedHashMap hm = new LinkedHashMap();
        hm.put(1, 1);
        hm.put(2, 2);
        hm.put(3, 3);
        System.out.println(hm.get(3));
        hm.put(3, 4);
         
        System.out.println(hm.get(1));
        System.out.println(hm.get(3));
        System.out.println(hm.get(8));
	}
}
