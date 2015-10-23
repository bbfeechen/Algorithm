package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212_Word_Search_II {
	public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList<String>(result);
        }
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        Trie trie = new Trie();  
        for(String word : words) {
            trie.insert(word);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, trie, i, j, visited, new StringBuilder(), result);
            }
        }
        return new ArrayList<String>(result);
    }
    
    private void dfs(char[][] board, Trie trie, int i, int j, boolean[][] visited, StringBuilder sb, Set<String> result)     {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        sb.append(board[i][j]);
        visited[i][j] = true;
        String s = sb.toString();
        
        if(trie.startsWith(s)) {
            if(trie.search(s)) {
                result.add(s);
            }
            
            dfs(board, trie, i - 1, j, visited, sb, result);
            dfs(board, trie, i + 1, j, visited, sb, result);
            dfs(board, trie, i, j - 1, visited, sb, result);
            dfs(board, trie, i, j + 1, visited, sb, result);
        }
        
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
    
    class TrieNode {
        // Initialize your data structure here.
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
        
        public TrieNode() {
        }
        
        public TrieNode(char c) {
            this.c = c;
        }
    }

    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            HashMap<Character, TrieNode> children = root.children;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode t;
                if(children.containsKey(c)) {
                    t = children.get(c);
                } else {
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                if(i == word.length() - 1) {
                    t.isLeaf = true;
                }
                children = t.children;
            }
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode t = searchNode(word);
            if(t != null && t.isLeaf) {
                return true;
            } else {
                return false;
            }
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(searchNode(prefix) == null) {
                return false;
            } else {
                return true;
            }
        }
        
        private TrieNode searchNode(String word) {
            HashMap<Character, TrieNode> children = root.children;
            TrieNode t = null;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(children.containsKey(c)) {
                    t = children.get(c);
                    children = t.children;
                } else {
                    return null;
                }
            }
            return t;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
