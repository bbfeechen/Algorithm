import java.util.Arrays;


public class Q36_Valid_Sudoku {
	public static boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++) {
                if(!process(board[i][j], visited)) {
                    return false;
                }    
            }
        }
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++) {
                if(!process(board[j][i], visited)) {
                    return false;
                }    
            }
        }
        
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for(int k = 0; k < 9; k++) {
                    if(!process(board[k / 3 + i][k % 3 + j], visited)) {
                        return false;
                    }    
                }
            }
        }
        
        return true;
    }
    
    private static boolean process(char digit, boolean[] visited) {
        if(digit == '.') {
            return true;
        }
        
        int num = digit - '0';
        if(visited[num - 1] || num <= 0 || num > 9) {
            return false;
        }
        visited[num - 1] = true;
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
