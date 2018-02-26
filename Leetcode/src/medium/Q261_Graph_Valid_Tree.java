package medium;

public class Q261_Graph_Valid_Tree {
    static class DisjointSet {
        private int[] id;
        private int count;

        public DisjointSet(int N) {
            count = N;
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

    public static boolean validTree(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        for (int[] edge : edges) {
            if (set.connected(edge[0], edge[1])) {
                return false;
            }
            set.union(edge[0], edge[1]);
        }

        return set.count() == 1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        System.out.println(validTree(5, edges));
    }
}
