package basic;

public class BinaryIndexTree {
    private int[] nums;
    private int[] bits;
    private int size;

    public BinaryIndexTree(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        this.bits = new int[size + 1];
        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int query(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += bits[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int queryRange(int i, int j) {
        return query(j) - query(i - 1);
    }

    private void init(int i, int val) {
        i++;
        while (i <= size) {
            bits[i] += val;
            i += (i & -i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        BinaryIndexTree tree = new BinaryIndexTree(nums);
        System.out.println(tree.queryRange(0, 2));
        tree.update(1, 2);
        System.out.println(tree.queryRange(0, 2));
    }
}
