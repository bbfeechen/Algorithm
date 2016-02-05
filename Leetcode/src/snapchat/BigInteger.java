package snapchat;

import java.util.LinkedList;

public class BigInteger {
	String mag;
//	String sign;
	
//	public BigInteger(String mag, String sign) {
	public BigInteger(String mag) {
		this.mag = mag;
//		this.sign = sign;
	}
	
	public String toString() {
//		return sign + mag;
		return mag;
	}
	
	public static BigInteger add(BigInteger num1, BigInteger num2) {
		String sum = add(num1.mag, num2.mag);
		return new BigInteger(sum);
	}
	
	private static String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		while(i >= 0 && j >= 0) {
			int i1 = num1.charAt(i) - '0';
			int i2 = num2.charAt(j) - '0';
			int sum = i1 + i2 + carry;
			carry = sum / 10;
			sb.insert(0, sum % 10);
			i--;
			j--;
		}
		if(i != 0) {
			while(i >= 0) {
				int i1 = num1.charAt(i) - '0';
				int sum = i1 + carry;
				carry = sum / 10;
				sb.insert(0, sum % 10);
				i--;
			}
		} else {
			while(j >= 0) {
				int i2 = num1.charAt(j) - '0';
				int sum = i2 + carry;
				carry = sum / 10;
				sb.insert(0, sum % 10);
				j--;
			}
		}
		if(carry == 1) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}
	
	public static BigInteger subtract(BigInteger num1, BigInteger num2) {
		String diff = subtract(num1.mag, num2.mag);
		return new BigInteger(diff);
	}
	
	public static String subtract(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        
		int l1 = num1.length();
        String s1 = num1, s2 = num2;
        l1 = s1.length();
        while (s2.length() != l1) {
            s2 = "0" + s2;
        }
        int carry = 0;
        for (int i = l1 - 1; i >= 0; i--) {
            int d1 = s1.charAt(i) - '0';
            int d2 = '9' - s2.charAt(i);
            int x = d1 + d2 + carry;
            tmp.add(x % 10);
            carry = x / 10;
        }
        for (int i = 0; i < l1; i++)
        {
            int x = tmp.get(i) + carry;
            sb.insert(0, x % 10);
            carry = x / 10;
        }    
        return sb.toString();
	}
	
	public static BigInteger multiply(BigInteger num1, BigInteger num2) {
		String product = multiply(num1.mag, num2.mag);
		return new BigInteger(product);
	}
	
	private static String multiply(String num1, String num2) {
		int m = num1.length();
        int n = num2.length();
        int[] num3 = new int[m + n];
        
        for(int i = m - 1; i >= 0; i--) {
            int carry = 0;
            int j = n - 1;
            for(; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + num3[i + j + 1] + carry;
                carry = product / 10;
                num3[i + j + 1] = product % 10;
            }
            num3[i + j + 1] = carry;
        }
        
        int index = 0;
        while(index < m + n - 1 && num3[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < num3.length; i++) {
            sb.append(num3[i]);
        }
        return sb.toString();
	}
	
//	public static String divide(String num1, String num2) {
//        int res = 0;
//        while(a >= b) {
//            int shift = 0;
//            while(a >= (b << shift)) {
//                shift++;
//            }
//            res += (1 << (shift - 1));
//            a -= (b << (shift - 1));
//        }
//        return (int)(res);
//    }
	
	public static int divide(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while(a >= b) {
            int shift = 0;
            while(a >= (b << shift)) {
                shift++;
            }
            res += (1 << (shift - 1));
            a -= (b << (shift - 1));
        }
        return (int)(res);
    }

	public static void main(String[] args) {
		BigInteger s1 = new BigInteger("25000000000000000000000");
		BigInteger s2 = new BigInteger("250000000000000000");
//        System.out.println(add(s1, s2));
        System.out.println(subtract(s1, s2));
//        System.out.println(multiply(s1, s2));
	}
}
