
public class Q11_1 {

	public static void main(String[] args) {
		int[] a = new int[8];
		a[0] = 1; a[1] = 22; a[2] = 44; a[3] = 66;
		int[] b = new int[4];
		b[0] = 11; b[1] = 33; b[2] = 55; b[3] = 77;
		merge(a, b, 4, 4);
	}

	private static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerged = lastB + lastA - 1;
		
		while(indexA >= 0 && indexB >= 0) {
			if(a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexMerged--;
				indexA--;
			} else {
				a[indexMerged] = b[indexB];
				indexMerged--;
				indexB--;
			}
		}
		
		while(indexB >= 0) {
			a[indexMerged] = b[indexB];
			indexMerged--;
			indexB--;
		}
	}
}
