package hard;

public class Q52_N_Queens_II {
	public static int sum = 0;
    public static int totalNQueens(int n) {
        sum = 0;
        int[] usedColumn = new int[n];
        placeQueen(usedColumn, 0);
        return sum;
    }
    
    private static void placeQueen(int[] usedColumn, int row) {
        int n = usedColumn.length;
        if(row == n) {
            sum++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isValid(usedColumn, row, i)) {
                usedColumn[row] = i;
                placeQueen(usedColumn, row + 1);
            }
        }
    }
    
    private static boolean isValid(int[] usedColumn, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(usedColumn[i] == col) {
                return false;
            }
            if(row - i == Math.abs(usedColumn[i] - col)) {
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
