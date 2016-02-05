package snapchat;


public class friendnum {
	private static int sumDivisors(int a) {
	    int s = 0, i;
	    for(i = 1;i <= a/2; i++) {
	        if(a % i == 0) {
	            s += i;
	        }
	    }
	    return s;
	}
	
    public static void main(String[] args) {
    	int min = 1;
        int max = 10000;
        int n = max - min + 1;
        int[] s = new int[n];
        int i, j;

        for (i = min; i <= max; i++) {
            s[i - min] = sumDivisors (i);
        }

        // search for perfect numbers
        for (i = min; i <= max; i++) {
            if (s[i - min] == i) {
                System.out.println("perfect number: " + i);
            }
        }

        // search for amicable pairs
        for (i = min; i <= max; i++) {
            for (j = i + 1; j <= max; j++) {
                if ((s[i - min] == j) && (s[j - min] == i)) {
                	System.out.println("amicable pair: " + i + " " + j);
                }
            }
        }
    }
}
