package square;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BoggleGame {
	private int N; // dimension of board 
	char[][] board={{'D','A','T','H'},{'C','G','O','A'},{'S','A','T','L'},{'B','E','D','G'}};; // the board (a-z) 
	private boolean[][] visited; // for dfs 
	Set<String> set; 
	
		// create random N-by-N board 
	public BoggleGame(int N, Set<String> set) { 
		this.N = N; 
		this.set = set; 
		visited = new boolean[N][N]; 
	} 

		// show all words, starting from each possible starting place 
	public void showWords() { 
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < N; j++) 
				dfs("", i, j); 
	} 

	// run depth first search starting at cell (i, j) 
	private void dfs(String prefix, int i, int j) { 
		if (i < 0 || j < 0 || i >= N || j >= N) return; 

		// can't visited a cell more than once 
		if (visited[i][j]) return; 

		// not allowed to reuse a letter 
		visited[i][j] = true; 

		// found a word 
		prefix = prefix + board[i][j]; 
		if (set.contains(prefix)) 
			System.out.println(prefix); 

		// consider all neighbors 
		for (int ii = -1; ii <= 1; ii++) 
			for (int jj = -1; jj <= 1; jj++) 
				dfs(prefix, i + ii, j + jj); 

		visited[i][j] = false; 
	} 

	// just the board 
	public String toString() { 
		String s = ""; 
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++) { 
				s = s + board[i][j] + " "; 
			} 
			s = s + "\n"; 
		} 
		return s; 
	} 

	public static void main(String[] args) throws FileNotFoundException, IOException { 
		int N = 4; 

		Set<String> set = new HashSet<String>();
		set.add("DATA");
		set.add("HALO");
		set.add("HALT");
		set.add("SAG");
		set.add("BEAT");
		set.add("TOTAL");
		set.add("GLOT");
		set.add("DAG");

		BoggleGame boggle = new BoggleGame(N, set); 
		System.out.println(boggle); 
		boggle.showWords(); 
	} 
}