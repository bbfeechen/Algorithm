
public class Q1_7 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9, 0,11,12}, {13,14,15,16}};
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		System.out.print(String.format("%02d ", matrix[i][j]));
        	}
        	System.out.println();
        }     
        System.out.println();
        
        matrix = setZeros(matrix);
        for(int i = 0; i < 4; i++) {
        	for(int j = 0; j < 4; j++) {
        		System.out.print(String.format("%02d ", matrix[i][j]));
        	}
        	System.out.println();
        }
	}
	
	private static int[][] setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(row[i] || col[j]) {
					matrix[i][j] = 0; 
				}
			}
		}
		
		return matrix;
	}
}
