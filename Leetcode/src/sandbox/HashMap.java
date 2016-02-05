package sandbox;

public class HashMap {
	public class Entry {
		Object key;
		Object val;
		public Entry(Object key, Object val) {
			this.key = key;
			this.val = val;
		}
	}
	
	private static final int CAPACITY = 128;
	private Entry[] table;
	
	public HashMap() {
		table = new Entry[CAPACITY];
	}
	
	public void put(Object key, Object val) {
		int hash = (Integer)key % CAPACITY;
		while(table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % CAPACITY;
		}
		table[hash] = new Entry(key, val);
	}
	
	public Object get(Object key) {
		int hash = (Integer)key % CAPACITY;
		while(table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % CAPACITY;
		} 
		if(table[hash] == null) {
			return null;
		}
		return table[hash].val;
	}

	public static void main(String[] args) {
		HashMap hm = new HashMap();
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
