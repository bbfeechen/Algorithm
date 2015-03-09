import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;


public class Q11_2 {

	public static void main(String[] args) {
		String[] array = new String[] {"abcd", "acre", "zero", "race", "heat", "care"};
		sort(array);
	}

	private static void sort(String[] array) {
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for(String s : array) {
			String key = sortChars(s);
			if(!hash.containsKey(key)) {
				hash.put(key, new LinkedList<String>());
			}
			LinkedList<String> anagrams = hash.get(key);
			anagrams.push(s);
		}
		
		int index = 0;
		for(String key : hash.keySet()) {
			LinkedList<String> list = hash.get(key);
			for(String t : list) {
				array[index] = t;
				index++;
			}
		}
	}
	
	private static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
}
