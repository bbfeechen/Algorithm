package snapchat;
/**
 * 
 * @ClassName: Test 
 * @Description: 从右上角到左下角打印N*N矩阵 
 *       | 1  2  3  4 |               4        
 *       | 5  6  7  8 |     ----->    3 8
 *       | 9 10  11 12|               2 7 12 
 *       |13 14  15 16|               1 6 11 16
 *                                    5 10 15
 *                                    9 14 
 *                                    13 
 * @author wenniuwuren  
 *
 */
public class zigzag {
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1,  2,  3,  4}, 
				{ 5,  6,  7,  8}, 
				{ 9, 10, 11, 12}, 
				{13, 14, 15, 16}
		};
		printReverseZigZag(matrix);
		System.out.println();
		printZigZag(matrix);
	}
	
	public static void printReverseZigZag(int[][] matrix) {
		int N = matrix.length;
	    int currentPrint = N;
	    for (int rowNum = 1; rowNum <= 2 * (N - 1) + 1; rowNum++) {
            for (int row = 0; row < N; row++) {
            	for (int col = 0; col < N; col++) {
            		if (col - row + 1 == currentPrint) {
            			if(row == N - 1 && col == 0) {
            				System.out.print(matrix[row][col]);
            			} else {
            				System.out.print(matrix[row][col] + "->");
            			}
                  	}
            	}
            	
            }
            currentPrint--;
		}
	}
	
	public static void printZigZag(int[][] matrix) {
		int i = 0, j = 0;
        int N = matrix.length;
        while (i < N) {
            if (i == N - 1 && j == N - 1)
                System.out.println(matrix[i][j]);
            else
                System.out.print(matrix[i][j] + "->");

            if (i == N - 1) {
                i = j + 1;
                j = N - 1;
            } else if (j == 0) {
                j = i + 1;
                i = 0;
            } else {
                i++;
                j--;
            }
        }
        System.out.println();
	}
}
