package linkedin;

public class Sqrt {
	public static double mySqrt2(double c) {
		double epsilon = 1e-15;    // relative error tolerance
        double t = c;              // estimate of the square root of c

        // repeatedly apply Newton update step until desired precision is achieved
        while (Math.abs(t - c/t) > epsilon*t) {
            t = (c/t + t) / 2.0;
        }
        return t;
	}
	
	public static int mySqrt(int x) {
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
