package hard;

public class Q65_Valid_Number {
    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numSeen = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (s.charAt(i) == '.') {
                if (eSeen || dotSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                numSeen = false;
                eSeen = true;
            } else {
                return false;
            }
        }
        return numSeen;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
