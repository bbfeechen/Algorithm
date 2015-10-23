package basic;

public class HashTable {
	public class HashEntry {
		int key;
		int value;
 
		HashEntry(int key, int value) {
			this.key = key;
			this.value = value;
		} 
	}
	
	private final static int TABLE_SIZE = 128;
	private HashEntry[] table;

    public HashTable() {
          table = new HashEntry[TABLE_SIZE];
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }

    public int get(int key) {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].key != key)
                hash = (hash + 1) % TABLE_SIZE;
          if (table[hash] == null)
                return -1;
          else
                return table[hash].value;
    }

    public void put(int key, int value) {
          int hash = (key % TABLE_SIZE);
          while (table[hash] != null && table[hash].key != key)
                hash = (hash + 1) % TABLE_SIZE;
          table[hash] = new HashEntry(key, value);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
