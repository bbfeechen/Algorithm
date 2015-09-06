package medium;

public class Q215_Kth_Largest_Element_in_an_Array {
	public static int findKthLargest(int[] nums, int k) {
		if(nums == null) {
			return -1;
		}
        return findPos(nums, 0, nums.length - 1, k);
    }
    
    private static int findPos(int[] nums, int start, int end, int order) {
    	int pivot = nums[start];
    	if(start >= end) {
    		return (order == 1) ? pivot : -1;
    	}
        int i = start;
        int j = end + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if(i == end) {
                    break;
                }
            }
            while(nums[--j] > pivot) {
                if(j == start) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        
        if (end - j == order - 1) {
            return pivot;
        } else if (end - j < order - 1) {
            return findPos(nums, start, j - 1, order - (end - j) - 1);
        } else {
            return findPos(nums, j + 1, end, order);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		System.out.println(findKthLargest(nums, 2));
	}
}
