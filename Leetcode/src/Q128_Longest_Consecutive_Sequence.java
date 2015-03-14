import java.util.HashMap;


public class Q128_Longest_Consecutive_Sequence {
	public static int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : num) {
            map.put(i, 0); // 0 : not visited
        }
        
        int maxLength = 0;
        for(int i : num) {
            if(map.get(i) == 1) {
                continue;
            }
            int temp = i;
            int curMaxLength = 1;
            while(map.containsKey(temp + 1)) {
                temp++;
                curMaxLength++;
                map.put(temp, 1);
            }
            
            temp = i;
            while(map.containsKey(temp - 1)) {
                temp--;
                curMaxLength++;
                map.put(temp, 1);
            }
            
            maxLength = Math.max(curMaxLength, maxLength);
        }
        return maxLength;
    }

	public static void main(String[] args) {

	}
}
