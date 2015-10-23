package linkedin;

public class Valid_Number {
	public static boolean isNumberSimplied(String s) {
	    if (s ==  null || s.length() == 0) {
	        return false;
	    }
	    int index = 0;
	    if (s.charAt(index) == '-' || s.charAt(index) == '+') {
	        index++;
	    }
	    boolean hitPoint = false;
	    if (index == s.length()) {
	            return false;
	    }
	    for (; index < s.length(); ++index) {
	        if (Character.isDigit(s.charAt(index))) {
	            continue;
	        }
	        if (s.charAt(index) == '.') {
	            if (hitPoint) {
	                return false;
	            }
	            hitPoint = true;
	            if (index + 1 == s.length()) {
	                return false;
	            }
	            continue;
	        }
	        return false;
	    }
	    return true;
	}
	
	//--------------------
	public static boolean isNumber(String s) {
        int len = s.length();
        int i = 0, e = len - 1;
        while(i <= e && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if(i > len - 1) {
            return false;
        }
        while(e >= i && Character.isWhitespace(s.charAt(e))) {
            e--;
        }
        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        while(i <= e) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = true;
            } else if(c == '.') {
                if(exp || dot) {
                    return false;
                }
                dot = true;
            } else if(c == 'e') {
                if(exp || num == false) {
                    return false;
                }
                exp = true;
                num = false;
            } else if(c == '+' || c == '-') {
                if(s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return num;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
