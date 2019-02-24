package medium;

public class Q8_String_to_Integer {
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) == '-') {
            index++;
            sign = -1;
        }
        long num = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            num = num * 10 + (str.charAt(index) - '0');
            index++;
        }
        if ((sign * num) >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if ((sign * num) <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)(sign * num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
