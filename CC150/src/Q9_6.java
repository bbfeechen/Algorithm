import java.util.ArrayList;


public class Q9_6 {
    private static final int GRID_SIZE = 8;	
	
	public static void main(String[] args) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		placeQueens(0, new Integer[GRID_SIZE], result);
	}
	
	private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
		if(row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for(int col = 0; col < GRID_SIZE; col++) {
				if(checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row + 1, columns, results);
				}
			}
		}
	}

	private static boolean checkValid(Integer[] columns, int row1, int column1) {
		for(int row2 = 0; row2 < row1; row2++) {
			int column2 = columns[row2];
			
			if(column1 == column2) {
				return false;
			}
			
			int columnDistance = Math.abs(column2 - column1);
			int rowDistance = row1 - row2;
			if(columnDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
}
