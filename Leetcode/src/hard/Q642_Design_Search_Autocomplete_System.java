package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q642_Design_Search_Autocomplete_System {
    static class AutocompleteSystem {
        private Trie trie;

        public AutocompleteSystem(String[] sentences, int[] times) {
            this.trie = new Trie();
            for (int i = 0; i < sentences.length; i++) {
                trie.insert(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            return trie.search(c);
        }

        class TrieNode {
            char c;
            Map<Character, TrieNode> children;
            Map<String, Integer> count;
            boolean isLeaf;

            public TrieNode() {
                this.children = new HashMap<>();
                this.count = new HashMap<>();
            }
            public TrieNode(char c) {
                this();
                this.c = c;
            }
        }

        class Pair {
            String str;
            int count;
            public Pair(String str, int count) {
                this.str = str;
                this.count = count;
            }
        }

        class Trie {
            private TrieNode root;
            private String prefix;

            public Trie() {
                this.root = new TrieNode();
                this.prefix = "";
            }

            public void insert(String str, int count) {
                TrieNode node = root;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (!node.children.containsKey(c)) {
                        node.children.put(c, new TrieNode(c));
                    }
                    node = node.children.get(c);
                    node.count.put(str, node.count.getOrDefault(str, 0) + count);
                }
                node.isLeaf = true;
            }

            public List<String> search(char c) {
                if (c == '#') {
                    insert(prefix, 1);
                    prefix = "";
                    return new ArrayList<>();
                }
                prefix += c;
                TrieNode curr = root;
                for (char cc : prefix.toCharArray()) {
                    if (!curr.children.containsKey(cc)) {
                        return new ArrayList<>();
                    }
                    curr = curr.children.get(cc);
                }

                PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair a, Pair b) {
                        return (b.count == a.count) ? a.str.compareTo(b.str) : (b.count - a.count);
                    }
                });
                for (String s : curr.count.keySet()) {
                    pq.offer(new Pair(s, curr.count.get(s)));
                }

                List<String> result = new ArrayList<>();
                for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                    result.add(pq.poll().str);
                }
                return result;
            }
        }
    }


    public static void main(String[] args) {
        String[] sentences = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5,3,2,2};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        print(obj.input('i'));
        print(obj.input(' '));
        print(obj.input('a'));
        print(obj.input('#'));
    }

    private static void print(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("not found");
            return;
        }
        for (String str : list) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }
}
