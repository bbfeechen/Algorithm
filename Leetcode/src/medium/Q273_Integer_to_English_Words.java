package medium;

public class Q273_Integer_to_English_Words {
	private static final String[] lowNames = {
	    "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
	    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private static final String[] tensNames = {
	    "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] bigNames = {
	    "Thousand", "Million", "Billion"};
	    
    public static String numberToWords(int num) {
        if (num < 0) {
            return "Minus " + numberToWords(-num); 
        }
        if (num <= 999) {
            return convert999(num); 
        }
        String s = null;
        int t = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                String s2 = convert999(num % 1000);
                if (t > 0) {
                    s2 = s2 + " " + bigNames[t-1]; 
                }
                if (s == null) {
                    s = s2; 
                } else {
                    s = s2 + " " + s; 
                }
            }
            num /= 1000;
            t++; 
        }
        return s; 
    }
    
    private static String convert999 (int n) {
        String s1 = lowNames[n / 100] + " Hundred";
        String s2 = convert99(n % 100);
        if (n <= 99) {
            return s2; 
        } else if (n % 100 == 0) {
            return s1; 
        } else {
            return s1 + " " + s2; 
        }
    }
    
    private static String convert99 (int n) {
        if (n < 20) {
            return lowNames[n]; 
        }
        String s = tensNames[n / 10 - 2];
        if (n % 10 == 0) {
            return s; 
        }
        return s + " " + lowNames[n % 10]; 
    }
	
	public static void main(String[] args) {
		System.out.println(numberToWords(1234567));
	}
}
