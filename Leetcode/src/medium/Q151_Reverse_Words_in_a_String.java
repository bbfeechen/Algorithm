package medium;

public class Q151_Reverse_Words_in_a_String {
	public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                j = i;
            } else if(i == 0 || s.charAt(i - 1) == ' ') {
                if(!sb.toString().isEmpty()) {
                    sb.append(" ");
                }
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}
