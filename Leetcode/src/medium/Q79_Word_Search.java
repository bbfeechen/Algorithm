package medium;

public class Q79_Word_Search {
	public static boolean exist(char[][] board, String word) {
		int rowNum = board.length;
		int colNum = board[0].length;
		boolean[][] visited = new boolean[rowNum][colNum];
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				if(dfs(board, i, j, word, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean dfs(char[][] board, int i, int j, String word, boolean[][] visited) {
		if(word.length() == 0) {
			return true;
		}
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if(visited[i][j] || board[i][j] != word.charAt(0)) {
			return false;
		}
		visited[i][j] = true;
		boolean result = dfs(board, i + 1, j, word.substring(1), visited) || 
				dfs(board, i - 1, j, word.substring(1), visited) || 
				dfs(board, i, j + 1, word.substring(1), visited) || 
				dfs(board, i, j - 1, word.substring(1), visited);
		if(result) {
			return true;
		} else {
			visited[i][j] = false;
			return false;
		}
	}

	public static void main(String[] args) {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
	}
}