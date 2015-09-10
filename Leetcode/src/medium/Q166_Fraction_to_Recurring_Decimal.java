package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q166_Fraction_to_Recurring_Decimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }
        
        long a = Math.abs((long)numerator);
        long b = Math.abs((long)denominator);
        
        long quotient = a / b;
        sb.append(quotient);
        
        long remainder = a % b;
        if(remainder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            Queue<Long> queue = new LinkedList<Long>();
            int i = 1;
            map.put(remainder, i);
            int begin = 0;
            while(remainder != 0) {
                long temp = remainder * 10 / b;
                remainder = remainder * 10 % b;
                i++;
                if(map.containsKey(remainder)) {
                    begin = map.get(remainder);
                    queue.offer(temp);
                    break;
                } else {
                    map.put(remainder, i);
                    queue.offer(temp);
                }
            }
            
            if(remainder == 0) {
                while(!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
            } else {
                int j = 1;
                while(!queue.isEmpty()) {
                    if(j != begin) {
                        sb.append(queue.poll());
                    } else {
                        sb.append("(");
                        sb.append(queue.poll());
                    }
                    j++;
                }
                sb.append(")");
            }
            return sb.toString();
        }
	}
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(2, 3));
	}
}
