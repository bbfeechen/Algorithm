package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q643_Maximum_Average_Subarray_I {
    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return maxAvg;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
            if (queue.size() == k) {
                maxAvg = Math.max(maxAvg, getAvg(queue));
            }
        }
        for (int i = k; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            maxAvg = Math.max(maxAvg, getAvg(queue));
        }
        return maxAvg;
    }

    private static double getAvg(Queue<Integer> queue) {
        Queue<Integer> copy = new LinkedList<>(queue);
        int size = queue.size();
        int sum = 0;
        while (!copy.isEmpty()) {
            sum += copy.poll();
        }
        return (double) sum / size;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] {4,0,4,3,3}, 5));
    }
}
