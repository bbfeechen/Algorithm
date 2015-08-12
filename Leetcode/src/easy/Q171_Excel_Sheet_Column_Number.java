package easy;

public class Q171_Excel_Sheet_Column_Number {
	public static int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result += Math.pow(26, s.length() - i - 1) * (c - 'A' + 1);
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}
}
