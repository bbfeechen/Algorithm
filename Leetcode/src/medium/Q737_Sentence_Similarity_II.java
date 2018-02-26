package medium;

import java.util.HashMap;
import java.util.Map;

public class Q737_Sentence_Similarity_II {
    static class DisjointSet {
        private int[] id;
        private int count;

        public DisjointSet(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int count() {
            return count;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            return id[p];
        }

        public void union(int p, int q) {
            int pID = find(p);
            int qID = find(q);
            if (pID == qID) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    id[i] = qID;
                }
            }
            count--;
        }
    }

    public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        DisjointSet set = new DisjointSet(2 * pairs.length);

        // initialize disjoint set
        int index = 0;
        for (String[] pair : pairs) {
            for (String word : pair) {
                if (!map.containsKey(word)) {
                    map.put(word, index++);
                }
            }
            set.union(map.get(pair[0]), map.get(pair[1]));
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i])) {
                return false;
            }
            int root1 = set.find(map.get(words1[i]));
            int root2 = set.find(map.get(words2[i]));
            if (root1 != root2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "painting", "talent"};
        String[][] pair = {{"great", "fine"}, {"drama", "acting"}, {"skills", "talent"}};
        System.out.println(areSentencesSimilarTwo(words1, words2, pair));
    }
}
