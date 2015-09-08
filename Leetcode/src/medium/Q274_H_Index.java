package medium;


public class Q274_H_Index {
	public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int[] count = new int[citations.length + 1];
        for(int citation : citations) {
            if(citation > citations.length) {
                count[citations.length]++;
            } else {
                count[citation]++;
            }
        }
        int total = 0;
        for(int i = citations.length; i >= 0; i--) {
            total += count[i];
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		int[] citations = {3, 1, 0, 6, 5};
		System.out.println(hIndex(citations));
	}
}
