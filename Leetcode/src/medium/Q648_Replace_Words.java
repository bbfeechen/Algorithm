package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q648_Replace_Words {
    static class TrieNode {
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

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode(c));
                }
                node = node.children.get(c);
            }
            node.isLeaf = true;
        }

        public String replace(String word) {
            StringBuilder sb = new StringBuilder();
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.isLeaf) {
                    return sb.toString();
                }
                if (!node.children.containsKey(c)) {
                    return "";
                }
                sb.append(c);
                node = node.children.get(c);
            }
            return "";
        }
    }

    public static String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String replaceWord = trie.replace(words[i]);
            if (!replaceWord.isEmpty()) {
                words[i] = replaceWord;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }
}
