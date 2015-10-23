package linkedin;

public class HashTable {
	public class HashEntry {
		int key;
		int val;
		public HashEntry(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	private static final int CAPACITY = 128;
	private HashEntry[] table;
	
	public HashTable() {
		table = new HashEntry[CAPACITY];
	}
	
	public void put(int key, int val) {
		int hash = key % CAPACITY;
		while(table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % CAPACITY;
		}
		table[hash] = new HashEntry(key, val);
	}
	
	public int get(int key) {
		int hash = key % CAPACITY;
		while(table[hash] != null && table[hash].key != key) {
			hash = (hash + 1) % CAPACITY;
		}
		return table[hash].val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
