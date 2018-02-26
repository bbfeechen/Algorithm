package basic;

public class DisjointSet {
//    Brute-force Union and Find
//    private int[] subset;
//    public DisjointSet(int numOfSet) {
//        subset = new int[numOfSet];
//        for (int i = 0; i < numOfSet; i++) {
//            subset[i] = i;
//        }
//    }
//
//    public int find(int i) {
//        while (subset[i] != i) {
//            i = subset[i];
//        }
//        return subset[i];
//    }
//
//    public void union(int i, int j) {
//        int p = find(i);
//        int q = find(j);
//        subset[p] = q;
//    }

    // Union By Rank and Path Compression
    private int[] subset;
    private int[] rank;
    public DisjointSet(int numOfSet) {
        subset = new int[numOfSet];
        rank = new int[numOfSet];
        for (int i = 0; i < numOfSet; i++) {
            subset[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        while (subset[i] != i) {
            i = subset[i];
        }
        return subset[i];
    }

    public void union(int i, int j) {
        int p = find(i);
        int q = find(j);
        if (rank[p] > rank[q]) {
            subset[q] = p;
            rank[p] += rank[q];
        } else {
            subset[p] = q;
            rank[q] += rank[p];
        }
    }

    public static void main(String[] args) {

    }
}
