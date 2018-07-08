package medium;

import java.util.Stack;

public class Q394_Decode_String {

    public static String decodeString(String s) {
        int currIdx = 0;
        int maxLen = s.length();

        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String currRes = "";
        while (currIdx < maxLen) {
            if (Character.isDigit(s.charAt(currIdx))) {
                int count = 0;
                while (currIdx < maxLen && Character.isDigit(s.charAt(currIdx))) {
                    count = 10 * count + (s.charAt(currIdx) - '0');
                    currIdx++;
                }
                countStack.push(count);
            } else if (s.charAt(currIdx) == '[') {
                resStack.push(currRes);
                currRes = "";
                currIdx++;
            } else if (s.charAt(currIdx) == ']') {
                StringBuilder sb = new StringBuilder();
                sb.append(resStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    sb.append(currRes);
                }
                currRes = sb.toString();
                currIdx++;
            } else {
                currRes += s.charAt(currIdx);
                currIdx++;
            }
        }
        return currRes;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
