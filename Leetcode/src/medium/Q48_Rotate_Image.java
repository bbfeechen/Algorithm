package medium;

public class Q48_Rotate_Image {
	public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - j][size - 1 - i];
                matrix[size - 1 - j][size - 1 - i] = tmp;
            }   
        }
        for(int i = 0; i < size / 2; i++) {
            for(int j = 0; j < size; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - i][j];
                matrix[size - 1 - i][j] = tmp;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
