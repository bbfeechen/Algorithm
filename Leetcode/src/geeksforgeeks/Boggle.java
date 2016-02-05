package geeksforgeeks;

public class Boggle {
	private final static int M = 3;
	private final static int N = 3;
	
	public void findWords(char[][] boggle, String[] dict) {
		boolean[][] visited = new boolean[M][N];
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				findWordsUtil(boggle, visited, i, j, str, dict);
			}
		}
	}
	
	private void findWordsUtil(char[][] boggle, boolean[][] visited, 
			int i, int j, StringBuilder sb, String[] dict) {
		visited[i][j] = true;
		sb.append(boggle[i][j]);
		if(isWord(sb.toString(), dict)) {
			System.out.println(sb);
		}
		for(int row = i - 1; row <= i + 1 && row < M; row++) {
			for(int col = j - 1; col <= j + 1 && col < N; col++) {
				if(row >= 0 && col >= 0 && !visited[row][col]) {
					findWordsUtil(boggle, visited, row, col, sb, dict);
				}
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}
	
	private boolean isWord(String str, String[] dict) {
		for(int i = 0; i < dict.length; i++) {
			if(str.equals(dict[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] boggle = {
				{'G', 'I', 'Z'},
				{'U', 'E', 'K'},
				{'Q', 'S', 'E'}
		};
		System.out.println("Following words of dictionary are present");
		String[] dict = {"GEEKS", "FOR", "QUIZ", "GO"};
		Boggle b = new Boggle();
	    b.findWords(boggle, dict);
	}
}
