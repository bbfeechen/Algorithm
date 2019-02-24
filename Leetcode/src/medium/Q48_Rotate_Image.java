package medium;

public class Q48_Rotate_Image {
//	public static void rotate(int[][] matrix) {
//        int size = matrix.length;
//        for(int i = 0; i < size - 1; i++) {
//            for(int j = 0; j < size - i; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[size - 1 - j][size - 1 - i];
//                matrix[size - 1 - j][size - 1 - i] = tmp;
//            }
//        }
//        for(int i = 0; i < size / 2; i++) {
//            for(int j = 0; j < size; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[size - 1 - i][j];
//                matrix[size - 1 - i][j] = tmp;
//            }
//        }
//    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

	public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		rotate(matrix);
	}

}
