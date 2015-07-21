package easy;


public class Q88_Merge_Sorted_Array {
	public static void merge(int[] A, int m, int[] B, int n) {
		int index = m + n;
		while(m > 0 && n > 0) {
			if(A[m - 1] < B[n - 1]) {
				A[index - 1] = B[n - 1];
				n--;
			} else {
				A[index - 1] = A[m - 1];
				m--;
			}
			index--;
		}
		if(n > 0) {
			while(n > 0) {
				A[index - 1] = B[n - 1];
				n--;
				index--;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = new int[9];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 7;
		A[4] = 9;
		int[] B = {2, 4, 6, 8};
		merge(A, 5, B, 4);
		for(int num : A) {
			System.out.print(num + " ");
		}
	}
}
