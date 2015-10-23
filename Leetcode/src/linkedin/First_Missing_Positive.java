package linkedin;

public class First_Missing_Positive {
	public static int firstMissingPositive(int[] A) {
        if(A == null) {
            return 0;
        }
        
        for(int i = 0; i < A.length; i++) {
            while(A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
                int temp = A[A[i] - 1];
                if(temp == A[i]) {
                    break;
                }
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
	
	public static void main(String[] args) {

	}
}
