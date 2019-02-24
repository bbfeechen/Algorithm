package basic;

public class BinaryIndexTree2D {
    int[][] nums;
    int[][] trees;
    int R;
    int C;
    public BinaryIndexTree2D(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return;
        }

        this.nums = nums;
        this.R = nums.length;
        this.C = nums[0].length;
        this.trees = new int[R + 1][C + 1];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                init(i, j, nums[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        init(row, col, diff);
    }

    public int query(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= (i & -i)) {
            for (int j = col + 1; j > 0; j -= (j & -j)) {
                sum += trees[i][j];
            }
        }
        return sum;
    }

    public int queryRange(int row1, int col1, int row2, int col2) {
        return query(row2, col2) + query(row1 - 1, col1 - 1) - query(row1 - 1, col2) - query(row2, col1 - 1);
    }

    private void init(int row, int col, int val) {
        for (int i = row + 1; i <= R; i += (i & -i)) {
            for (int j = col + 1; j <= C; j += (j & -j)) {
                trees[i][j] += val;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        BinaryIndexTree2D tree = new BinaryIndexTree2D(nums);
        System.out.println(tree.queryRange(2, 1, 4, 3));
        tree.update(3, 2, 2);
        System.out.println(tree.queryRange(2, 1, 4, 3));
    }
}
