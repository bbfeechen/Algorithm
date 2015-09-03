package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q130_Surrounded_Regions {
	public static void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            fill(board, i, 0);
            fill(board, i, n - 1);
        }
        
        for(int j = 0; j < n; j++) {
            fill(board, 0, j);
            fill(board, m - 1, j);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private static void fill(char[][] board, int i, int j) {
        if(board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * board[0].length + j);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int num = queue.poll();
            int row = num / board[0].length;
            int col = num % board[0].length;
            if(row > 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                queue.offer((row - 1) * board[0].length + col);
            }
            if(row < board.length - 1 && board[row + 1][col] == 'O') {
                board[row + 1][col] = '#';
                queue.offer((row + 1) * board[0].length + col);
            }
            if(col > 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '#';
                queue.offer(row * board[0].length + col - 1);
            }
            if(col < board[0].length - 1 && board[row][col + 1] == 'O') {
                board[row][col + 1] = '#';
                queue.offer(row * board[0].length + col + 1);
            }
        }
    }

	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},
						  {'X', 'O', 'O', 'X'},
						  {'X', 'X', 'O', 'X'},
						  {'X', 'O', 'X', 'X'}};
		solve(board);
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
