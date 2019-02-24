package medium;

import java.util.Collections;
import java.util.Stack;

public class Q227_Basic_Calculator_II {
    public static long calculate(String s) {
        s=s.replace(" ","");
        int lastpos = -1;
        char lastOps = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case '+':
                    return calculate(s.substring(0, i)) + calculate(s.substring(i + 1, s.length()));
                case '-':
                    return calculate(s.substring(0, i)) - calculate(s.substring(i + 1, s.length()));
                case '*':
                    if (lastpos < 0) {
                        lastpos = i;
                        lastOps = '*';
                    }
                    break;
                case '/':
                    if (lastpos < 0) {
                        lastpos = i;
                        lastOps = '/';
                    }
                    break;
            }
        }
        if (lastOps == '*') {
            return calculate(s.substring(0, lastpos)) * calculate(s.substring(lastpos + 1, s.length()));
        }
        if (lastOps == '/') {
            return calculate(s.substring(0, lastpos)) / calculate(s.substring(lastpos + 1, s.length()));
        }
        return Long.parseLong(s);
    }

//	public static int calculate(String s) {
//        int length = s.length();
//        Stack<Integer> stack = new Stack<Integer>();
//
//        for(int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if(Character.isDigit(c)) {
//                int cur = c - '0';
//                while((i + 1) < length && Character.isDigit(s.charAt(i + 1))) {
//                    cur = cur * 10 + s.charAt(i + 1) - '0';
//                    i++;
//                }
//                if(!stack.isEmpty() && (stack.peek() == 2 || stack.peek() == 3)) {
//                    int op = stack.pop();
//                    int opl = stack.pop();
//                    int res = 0;
//                    if(op == 2) {
//                        res = opl * cur;
//                    } else {
//                        res = opl / cur;
//                    }
//                    stack.push(res);
//                } else {
//                    stack.push(cur);
//                }
//            } else if(c == ' ') {
//                continue;
//            } else {
//                switch(c) {
//                    case '+':
//                        stack.push(0);
//                        break;
//                    case '-':
//                        stack.push(1);
//                        break;
//                    case '*':
//                        stack.push(2);
//                        break;
//                    case '/':
//                        stack.push(3);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//        if(stack.isEmpty()) {
//            return 0;
//        }
//        Collections.reverse(stack);
//
//        int res = stack.pop();
//        while(!stack.isEmpty()) {
//            int op = stack.pop();
//            int opr = stack.pop();
//            if(op == 0) {
//                res += opr;
//            } else {
//                res -= opr;
//            }
//        }
//        return res;
//    }
	
	public static void main(String[] args) {
		String s = " 3+5 / 2 ";
		System.out.println(calculate(s));
	}

}
