package secret;

import java.util.LinkedList;

public class Q158_Read_N_Characters_Given_Read4_II_Call_multiple_times {
	public static int read4(char[] buf) {
		return 4;
	}
	
	private static LinkedList<Character> queue = new LinkedList<Character>();
	
	public static int read(char[] buf, int n) {
		char[] _buf = new char[4];
		int total = 0;
		while(true) {
			int l = read4 (_buf);
			for(int i = 0; i < l; i++) {
				queue.add(_buf[i]);
			}
			
			l = Math.min(n - total, queue.size());
			for(int i = 0; i < l; i++) {
				buf[total++] = queue.poll();
			}
			if(l == 0) break;
		}
		
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
