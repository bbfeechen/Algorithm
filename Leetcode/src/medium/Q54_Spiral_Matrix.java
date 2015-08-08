package medium;

import java.util.ArrayList;
import java.util.List;

public class Q54_Spiral_Matrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
            return result;
        }
        int xOffset = 0;
        int yOffset = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while(2 * xOffset < col && 2 * yOffset < row) {
            for(int j = xOffset; j < col - xOffset; j++) {
                result.add(matrix[yOffset][j]);
            }
            for(int i = yOffset + 1; i < row - yOffset; i++) {
                result.add(matrix[i][col - xOffset - 1]);
            }
            if(row - 2 * yOffset == 1 || col - 2 * xOffset == 1) {
                break;
            }
            for(int j = col - xOffset - 2; j >= xOffset; j--) {
                result.add(matrix[row - yOffset - 1][j]);
            }
            for(int i = row - yOffset - 2; i >= yOffset + 1; i--) {
                result.add(matrix[i][xOffset]);
            }
            xOffset++;
            yOffset++;
        }
        return result;
    }

	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 3 },
		                  { 4, 5, 6 },
		                  { 7, 8, 9 }};
		List<Integer> result = spiralOrder(matrix);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
