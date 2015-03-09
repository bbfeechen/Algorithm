
public class Q11_5 {

	public static void main(String[] args) {
		String[] strings = new String[] {"abcd", "acbd", "adbc", "", "bacd", "bcad", "bdac", "", "", 
				"cabd", "", "", "cbad", "dabc", "dacb", "dbca", "dcab"};
		String str = "cabd";
		System.out.println(search(strings, str));
	}
	
	private static int search(String[] strings, String str) {
		if(strings == null || str == null || str == "") {
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}
	
	private static int search(String[] strings, String str, int first, int last) {
		if(first > last) {
			return -1;
		}
		int mid = (first + last) / 2;
		if(strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while(true) {
				if(left < first && right > last) {
					return -1;
				} else if(right <= last && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if(left >= first && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}
		
		if(str.equals(strings[mid])) {
			return mid;
		} else if(strings[mid].compareTo(str) < 0) {
			return search(strings, str, mid + 1, last);
		} else {
			return search(strings, str, first, mid - 1);
		}
	}
}


















