package easy;

public class Q58_Length_of_Last_Word {
	public static int lengthOfLastWord(String s) {
		int count = 0;
		boolean isStart = false;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) != ' ') {
				count++;
				isStart = true;
			} else {
				if(isStart) {
					break;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(lengthOfLastWord(s));
	}
}
