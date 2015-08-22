package easy;

public class Q38_Count_and_Say {
	public static String countAndSay(int n) {
        String str = "1";
        while(--n > 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                int count = 1;
                while((i + 1) < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + str.charAt(i));
            }
            str = sb.toString();
        }
        return str;
    }

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}
}
