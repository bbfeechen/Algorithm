package basic;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private class TrieNode {
		private char c;
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean isLeaf;
	    
	    public TrieNode() {
	    }
	    
	    public TrieNode(char c) {
	        this.c = c;
	    }
	}

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
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
        TrieNode node = searchNode(word);
        if(node != null && node.isLeaf) {
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
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                return null;
            }
            children = t.children;
        }
        return t;
    }

	public static void main(String[] args) {
		 Trie trie = new Trie();
		 trie.insert("somestring");
		 System.out.println(trie.search("somes"));
	}
}
