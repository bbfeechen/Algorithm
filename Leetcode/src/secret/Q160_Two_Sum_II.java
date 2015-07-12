package secret;

public class Q160_Two_Sum_II {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[] {-1, -1};
		if(numbers == null  || numbers.length == 0) {
			return result;
		}
		
		int start = 0,  end = numbers.length - 1;
		
		while(start < end) {
			int sum = numbers[start] + numbers[end];
			if(sum == target) {
				result[0] = start + 1;
				result[1] = end + 1;
				break;
			} else if(sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Q160_Two_Sum_II util = new Q160_Two_Sum_II();
		
		int[] numbers = new int[] { 1, 2, 3, 5, 6, 7};
		int[] index = util.twoSum(numbers, 10);
		
		System.out.print(index[0] + ", " + index[1]);
	}
}
