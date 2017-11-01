package easy;

public class Q557_Reverse_Words_in_a_String_III {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chars, i, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
