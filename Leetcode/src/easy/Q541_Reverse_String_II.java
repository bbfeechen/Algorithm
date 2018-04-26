package easy;

public class Q541_Reverse_String_II {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            int end = (i + k - 1) > (s.length() - 1) ? (s.length() - 1) : (i + k - 1);
            reverse(chars, i, end);
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
