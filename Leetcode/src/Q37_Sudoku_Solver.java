import java.util.HashSet;
import java.util.Set;


public class Q37_Sudoku_Solver {
	public static void solveSudoku(char[][] board) {
        dfs(board);
    }
    
    private static boolean dfs(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    continue;
                }
                for(int k = 1; k <= 9; k++) {
                    board[i][j] = (char)(k + '0');
                    if(isValid(board, i, j) && dfs(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    private static boolean isValid(char[][] board, int a, int b) {
        Set<Character> contained = new HashSet<Character>();
        for(int j = 0; j < 9; j++) {
            if(contained.contains(board[a][j])) {
                return false;
            }
            if(board[a][j] >= '0' && board[a][j] <= '9') {
                contained.add(board[a][j]);
            }
        }
        
        contained = new HashSet<Character>();
        for(int i = 0; i < 9; i++) {
            if(contained.contains(board[i][b])) {
                return false;
            }
            if(board[i][b] >= '0' && board[i][b] <= '9') {
                contained.add(board[i][b]);
            }
        }
        
        contained = new HashSet<Character>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int x = a / 3 * 3 + i, y = b / 3 * 3 + j;
                if(contained.contains(board[x][y])) {
                    return false;
                }
                if(board[x][y] >= '0' && board[x][y] <= '9') {
                    contained.add(board[x][y]);
                }
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
