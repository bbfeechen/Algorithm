package basic;


public class Heap {
    private int[] nums;
    private int size;
    
    public Heap(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
    }
    
    public void sort() {
        buildheap();

        for(int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            maxheap(0);
        }
    }

    private void buildheap() {
        for(int i = size/2; i >= 0; i--) {
            maxheap(i);
        }
    }

    private void maxheap(int i) { 
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if(left < size && nums[left] > nums[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if(right < size && nums[right] > nums[largest]) {
            largest = right;
        }
        if(largest != i) {
            swap(i, largest);
            maxheap(largest);
        }
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t; 
    }
    
    public static void main(String[] args) {
        int[] nums = {2, 9, 7, 3, 4, 1, 8, 6, 5};
        Heap heap = new Heap(nums);
        heap.sort();
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
