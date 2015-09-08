package medium;

public class Q275_H_Index_II {
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if((citations.length - mid) > citations[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return citations.length - start;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
