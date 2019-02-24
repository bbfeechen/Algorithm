package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q676_Implement_Magic_Dictionary {
    static class MagicDictionary {
        class TrieNode {
            char c;
            Map<Character, TrieNode> children;
            boolean isLeaf;
            public TrieNode() {
                this.children = new HashMap<>();
                this.isLeaf = false;
            }
            public TrieNode(char c) {
                this.c = c;
                this.children = new HashMap<>();
                this.isLeaf = false;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            root = new TrieNode();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                insert(word);
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = word.toCharArray();
                    if (ch == chars[i]) {
                        continue;
                    }
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if (isExist(newWord)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode(c));
                }
                node = node.children.get(c);
            }
            node.isLeaf = true;
        }

        private boolean isExist(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isLeaf;
        }
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello"));
    }
}
