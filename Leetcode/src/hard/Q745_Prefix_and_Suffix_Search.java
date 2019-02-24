package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q745_Prefix_and_Suffix_Search {
    static class WordFilter {
        class TrieNode {

            char c;
            boolean isLeaf;
            Map<Character, TrieNode> children;
            List<Integer> weights;

            public TrieNode() {
                this.children = new HashMap<>();
                this.weights = new ArrayList<>();
            }

            public TrieNode(char c) {
                this();
                this.c = c;
            }
        }

        private TrieNode forward;
        private TrieNode backward;

        public WordFilter(String[] words) {
            forward = new TrieNode();
            backward = new TrieNode();
            for (int i = words.length - 1; i >= 0; i--) {
                String reverse = new StringBuilder(words[i]).reverse().toString();
                insert(forward, words[i], i);
                insert(backward, reverse, i);
            }
        }

        public int f(String prefix, String suffix) {
            List<Integer> fwd = find(forward, prefix);
            List<Integer> bwd = find(backward, new StringBuilder(suffix).reverse().toString());
            int i = 0;
            int j = 0;
            while (i < fwd.size() && j < bwd.size()) {
                if (fwd.get(i).equals(bwd.get(j))) {
                    return fwd.get(i);
                } else if (fwd.get(i) > bwd.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return -1;
        }

        private void insert(TrieNode root, String word, int weight) {
            TrieNode curr = root;
            curr.weights.add(weight);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode(c));
                }
                curr = curr.children.get(c);
                curr.weights.add(weight);
            }
            curr.isLeaf = true;
        }

        private List<Integer> find(TrieNode root, String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    return new ArrayList<>();
                }
                curr = curr.children.get(c);
            }
            return curr.weights;
        }
    }


    public static void main(String[] args) {
        WordFilter obj = new WordFilter(new String[] {""});
        System.out.println(obj.f("a", "a"));
        System.out.println(obj.f("a", "a"));
        System.out.println(obj.f("a", "a"));
    }
}
