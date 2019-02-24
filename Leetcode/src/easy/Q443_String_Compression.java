package easy;

public class Q443_String_Compression {
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            chars[len] = chars[i];
            len++;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[len] = c;
                    len++;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a', 'b', 'c'}));
    }
}
