package medium;

import java.util.HashMap;
import java.util.Map;

public class Q211_Add_and_Search_Word {
	public static class WordDictionary {
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
		
		public void addWord(String word) {
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
			return searchNode(word, root);
		}
		
		private boolean searchNode(String word, TrieNode node) {
			if(node == null) {
				return false;
			}
			if(word.length() == 0) {
				return node.isLeaf;
			}
			Map<Character, TrieNode> children = node.children;
			TrieNode t = null;
			char c = word.charAt(0);
			if(c == '.') {
				for(char key : children.keySet()) {
					if(searchNode(word.substring(1), children.get(key))) {
						return true;
					}
				}
				return false;
			} else if(!children.containsKey(c)) {
				return false;
			} else {
				t = children.get(c);
				return searchNode(word.substring(1), t);
			}
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("word");
		System.out.println(wordDictionary.search("pattern"));
		wordDictionary.addWord("pattern");
		System.out.println(wordDictionary.search("pattern"));
	}
}
