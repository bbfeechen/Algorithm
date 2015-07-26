package medium;

import java.util.HashMap;
import java.util.Map;

public class Q208_Implement_Trie_Prefix_Tree {
	public static class Trie {
		class TrieNode {
			char c;
			Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
			boolean isLeaf;
			public TrieNode() {
				
			}
			public TrieNode(char c) {
				this.c = c;
			}
		}
		
		private TrieNode root = new TrieNode();
		
		public void insert(String word) {
			Map<Character, TrieNode> children = root.children;
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode t = null;
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
		
		public boolean search(String word) {
			TrieNode node = searchNode(word);
			if(node != null && node.isLeaf) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean startWith(String prefix) {
			return searchNode(prefix) != null;
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
	} 

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("somestring");
		System.out.println(trie.search("key"));
		trie.insert("key");
		System.out.println(trie.search("key"));
	}
}
