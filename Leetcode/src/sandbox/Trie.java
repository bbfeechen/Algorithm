package sandbox;

import java.util.HashMap;
import java.util.Map;


public class Trie {
	public class TrieNode {
		char c;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isLeaf;
		public TrieNode() {
			this.c = 0;
		}
		public TrieNode(char c) {
			this.c = c;
		}
	}
	
	private TrieNode root;
	public Trie() {
		this.root = new TrieNode();
	}
	
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
		TrieNode node = searchNode(prefix);
		if(node != null) {
			return true;
		} else {
			return false;
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
	
	public int getNotAutoCompleteCharacter(String word) { 
		int num = 0;
		Map<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(children.containsKey(c)) {
				if(children.size() > 1) {
					num++;
					System.out.println(c);
				}
				t = children.get(c);
			} else {
				return -1;
			}
			children = t.children;
		}
		return num;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("adbinstall");
		trie.insert("adbkillserver");
		trie.insert("apple");
		trie.insert("ls");
		trie.insert("mkdir");
		System.out.println(trie.search("mkdir"));
		System.out.println(trie.search("adb"));
		System.out.println(trie.startWith("adb"));
		System.out.println(trie.getNotAutoCompleteCharacter("adbinstall"));
	}
}
