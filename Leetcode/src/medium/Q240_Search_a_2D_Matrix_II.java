package medium;

public class Q240_Search_a_2D_Matrix_II {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        int row = 0;
        int col = n - 1;
        while(row <= m - 1 && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,   4,  7, 11, 15},
						  {2,   5,  8, 12, 19},
						  {3,   6,  9, 16, 22},
						  {10, 13, 14, 17, 24},
						  {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(matrix, 20));
	}
}
