package medium;

public class Q74_Search_a_2D_Matrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,   3,  5,  7},
				          {10, 11, 16, 20},
				          {23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix, 3));
		System.out.println(searchMatrix(matrix, 2));
	}
}
