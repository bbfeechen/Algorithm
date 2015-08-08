package medium;

import java.util.Scanner;

public class Q59_Spiral_Matrix_II {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int num = 1;
		int count = 0;
		while(n - 2 * count > 0) {
			for(int j = count; j < n - count; j++) {
				matrix[count][j] = num++;
			}
			for(int i = count + 1; i < n - count; i++) {
				matrix[i][n - count - 1] = num++;
			}
			if(n - 2 * count == 1) {
				break;
			}
			for(int j = n - count - 2; j >= count; j--) {
				matrix[n - count - 1][j] = num++;
			}
			for(int i = n - count - 2; i >= count + 1; i--) {
				matrix[i][count] = num++;
			}
			count++;
		}
		return matrix;
	}

	public static void main(String[] args) {
		System.out.println("Please input a number n:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] matrix = generateMatrix(n);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
