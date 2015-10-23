package secret;

//Problem Description:
//
//A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
//
//Write a function to determine if a number is strobogrammatic. The number is represented as a string.
//
//For example, the numbers "69", "88", and "818" are all strobogrammatic.

public class Q246_Strobogrammatic_Number {
	public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
         
        int lo = 0;
        int hi = num.length() - 1;
         
        while (lo <= hi) {
            if (num.charAt(lo) == num.charAt(hi)) {
                if (isStrobo(num.charAt(lo))) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            } else {
                if ((num.charAt(lo) == '6' && num.charAt(hi) == '9') ||
                    (num.charAt(lo) == '9' && num.charAt(hi) == '6')) {
                    hi--;
                    lo++;
                } else {
                    return false;
                }
            }
        }
         
        return true;
    }
     
    private static boolean isStrobo(Character num) {
        return num == '0' || num == '1' || num == '8';
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
