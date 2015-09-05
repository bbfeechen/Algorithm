package medium;

public class Q134_Gas_Station {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0;
        int start = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++) {
            int remaining = (gas[i] - cost[i]);
            if(sumRemaining >= 0) {
                sumRemaining += remaining;
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
