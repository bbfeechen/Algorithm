package interview;

public class godaddy {
	static String compress(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        char prev = chars[0];
        int count = 1;
        for(int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if(prev == curr) {
                count++;
            } else {
                sb.append(prev);
                if(count > 1) {
                    sb.append(count);
                }
                count = 1;
                prev = curr;
            }
        }
        sb.append(prev);
        if(count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		String s = "aaaaabbbbbbbbbccccpqrstuv";
		System.out.println(compress(s));
	}

}
