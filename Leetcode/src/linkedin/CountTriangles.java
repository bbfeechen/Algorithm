package linkedin;

import java.util.Arrays;

public class CountTriangles {
    // O(n^2)
    //https://codility.com/demo/results/demoHFCK86-FBV/
    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 0, n = A.length;
        for (int i = 0; i < n - 2; i++) {
            int k = 0;  // k is init here
            for (int j = i + 1; j < n - 1; j++) {
                while (k < n && A[i] + A[j] > A[k]) {
                    k++;
                }
                ans += k - j - 1;
            }
        }
        return ans;
    }

    // O(n^3)
    //https://codility.com/demo/results/demoHVJ2YB-D56/
    /*public int solution(int[] A) {
        Arrays.sort(A);
        int ans = 0, n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                for (int k = j + 1; k < n && A[k] < sum; k++) {
                    ans++;
                }
            }
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int ans = new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12});
        System.out.println(ans);
    }
}
