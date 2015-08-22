package easy;

public class Q28_Implement_strStr {
	public static int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		String haystack = "abdecf";
		String needle = "dec";
		System.out.println(strStr(haystack, needle));
	}

}
