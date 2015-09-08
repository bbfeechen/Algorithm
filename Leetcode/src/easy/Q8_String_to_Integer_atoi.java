package easy;

public class Q8_String_to_Integer_atoi {
	public static int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int index = 0;
        if(str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if(str.charAt(index) == '+') {
            index++;
        }
        double abs = 0;
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            abs = abs * 10 + str.charAt(index) - '0';
            index++;
        } 
        if(sign * abs > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(sign * abs < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)(sign * abs);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
