
public class Q45_Jump_Game_II {
	public static int jump(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        int n = A.length;
        int step = 0;
        int curReach = 0;
        int nextReach = 0;
        int i;
        for (i = 0; i < n;) {
 
            if (curReach >= n - 1)
                break;
 
            while (i <= curReach) {
                nextReach = nextReach > (i + A[i]) ? nextReach : (i + A[i]);
                i++;
            }
            curReach = nextReach;
 
            step++;
        }
 
        return step;
    }
	
	public static void main(String[] args) {
		int[] A = new int[] {2,3,1,1,4};
		System.out.println(jump(A));
	}
}
