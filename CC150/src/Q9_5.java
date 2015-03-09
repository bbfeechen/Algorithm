import java.util.ArrayList;


public class Q9_5 {
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> permutations = getPerms(str);
	}
	
	private static ArrayList<String> getPerms(String str) {
		if(str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if(str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word : words) {
			for(int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	} 
	
	private static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
}
