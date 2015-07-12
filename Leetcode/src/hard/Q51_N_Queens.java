package hard;
import java.util.ArrayList;
import java.util.List;


public class Q51_N_Queens {
	public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if(n <= 0) {
            return result;
        }
        search(result, n, new ArrayList<Integer>());
        return result;
    }
    
    private void search(ArrayList<String[]> result, int n, ArrayList<Integer> cols) {
        if(cols.size() == n) {
            result.add(drawChessboard(cols));
            return;
        }
        for(int col = 0; col < n; col++) {
            if(!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(result, n, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        
        for(int i = 0; i < row; i++) {
            if(cols.get(i).equals(col)) {
                return false;
            }
            if(row - i == Math.abs(cols.get(i) - col)) {
                return false;
            }
        }
        return true;
    }
    
    private String[] drawChessboard(ArrayList<Integer> cols) {
        String[] chessboard = new String[cols.size()];
        for(int i = 0; i < cols.size(); i++) {
            chessboard[i] = "";
            for(int j = 0; j < cols.size(); j++) {
                if(j == cols.get(i)) {
                    chessboard[i] += "Q";
                } else {
                    chessboard[i] += "."; 
                }
            }
        }
        return chessboard;
    }
    
	public static void main(String[] args) {

	}
}
