package secret;

public class Q186_Reverse_Words_in_a_String_II {
	public static char[] reverse(char[] words) {
		if(words == null || words.length == 0) {
			return null;
		}
		
		words = reverse(words, 0, words.length - 1);
		
		for(int left = 0; left < words.length; left++) {
			if(words[left] != ' ') {
				int right = left;
				while(right <= words.length - 1 && words[right] != ' ') {
					right++;
				}
				words = reverse(words, left, right - 1);
				left = right;
			}
		}
		return words;
	}
	
	private static char[] reverse(char[] words, int start, int end) {
		for(int i = start, j = end; i < j; i++, j--) {
			char temp  = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
		return words;
	}

	public static void main(String[] args) {
		String s = "blue sky in the world";
		char[] charArray = s.toCharArray();
		charArray = reverse(charArray);
		System.out.println(new String(charArray));
	}
}
