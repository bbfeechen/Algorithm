package easy;

public class Q6_ZigZag_Conversion {
	public static String convert(String s, int numRows) { 
		if(s == null || s.length() <= numRows || numRows <= 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		char[] array = s.toCharArray();
		int step = 2 * (numRows - 1);
		for(int i = 0; i < numRows; i++) {
			int interval = step - 2 * i;
			for(int j = i; j < array.length; j += step) {
				sb.append(array[j]);
				if(interval > 0 && interval < step && j + interval < array.length) {
					sb.append(array[j + interval]);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("PAYPALISHIRING", 4));
	}
}
