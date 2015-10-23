package yelp;

public class yelp_searchMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		return helper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, target);
	}
	
	private static boolean helper(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd, int target) {
		if(rowStart > rowEnd || colStart > colEnd) {
			return false;
		}
		int rowMid = rowStart + (rowEnd - rowStart) / 2;
		int colMid = colStart + (colEnd - colStart) / 2;
		if(matrix[rowMid][colMid] == target) {
			return true;
		} else if(matrix[rowMid][colMid] > target) {
			return helper(matrix, rowStart, rowMid - 1, colStart, colMid - 1, target) || 
				   helper(matrix, rowMid, rowEnd, colStart, colMid - 1, target) ||
				   helper(matrix, rowStart, rowMid - 1, colMid, colEnd, target);
		} else {
			return helper(matrix, rowMid + 1, rowEnd, colMid + 1, colEnd, target) || 
				   helper(matrix, rowMid + 1, rowEnd, colStart, colMid, target) ||
				   helper(matrix, rowStart, rowMid, colMid + 1, colEnd, target);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		System.out.println(searchMatrix(matrix, 20));
	}

}
