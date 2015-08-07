package hard;

public class Q42_Trapping_Rain_Water {
	public static int trap(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        
        int max = A[0];
        for(int i = 1; i < A.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, A[i]);
        }
        
        max = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; i--) {
            maxRight[i] = max;
            max = Math.max(max, A[i]);
        }
        
        int sum = 0;
        for(int i = 1; i < A.length - 1; i++) {
            int trap = Math.min(maxLeft[i], maxRight[i]) - A[i];
            sum += Math.max(0, trap);
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}

}
