package interview;

public class yelp_1 {
	public static int findFirstOne(String str) {
		if(str == null || str.length() == 0) {
			return -1;
		}
		int start = 0;
		int end = str.length() - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			String prefix = str.substring(0, mid);
			if((prefix.length() == 0 || Integer.parseInt(prefix) == 0) && str.charAt(mid) == '1') {
				return mid;
			} else if(prefix.length() == 0 || Integer.parseInt(prefix) == 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "000000";
		System.out.println(findFirstOne(str));
	}
}
