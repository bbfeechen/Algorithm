package medium;

public class Q69_Sqrt {
	public static int mySqrt(int x) {
		if(x < 0) {
			return -1;
		}
		if(x == 0 || x == 1) {
			return x;
		}
         long start = 0;
         long end = x;
         while(start <= end) {
             long mid = (start + end) / 2;
             if(x == mid * mid) {
                 return (int)mid;
             } else if(x < mid * mid) {
                 end = mid - 1;
             } else {
                 start = mid + 1;
             }
         }
         return (int)end;
    }

	public static void main(String[] args) {
		System.out.println(mySqrt(50));
	}

}
