
public class Q1_6 {
	public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		System.out.print(String.format("%02d ", matrix[i][j]));
        	}
        	System.out.println();
        }     
        System.out.println();
        
        matrix = rotate(matrix, 4);
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		System.out.print(String.format("%02d ", matrix[i][j]));
        	}
        	System.out.println();
        }
	}
	
	private static int[][] rotate(int[][] matrix, int n) {
		for(int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
}
