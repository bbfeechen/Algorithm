package easy;

public class Q28_Implement_strStr {
//	public static int strStr(String haystack, String needle) {
//        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//            int j = 0;
//            while(j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
//                j++;
//            }
//            if(j == needle.length()) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public static int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        int haystackSize = haystack.length();

        // treat it as matched when needle is empty string
        if (needleSize == 0) {
            return 0;
        }

        if (needleSize > haystackSize) {
            return -1;
        }

        for (int i = 0; i < haystackSize; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < needleSize && (i + j) < haystackSize && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == needleSize) {
                    return i;
                }
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
