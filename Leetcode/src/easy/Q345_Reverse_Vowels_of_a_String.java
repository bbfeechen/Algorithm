package easy;

public class Q345_Reverse_Vowels_of_a_String {
    private static final String VOWELS = "aeiouAEIOU";
    public static String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start <= end) {
            while (start <= end && !VOWELS.contains(chars[start] + "")) {
                start++;
            }
            while (start <= end && !VOWELS.contains(chars[end] + "")) {
                end--;
            }
            if (start > end) {
                break;
            }
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }
}
