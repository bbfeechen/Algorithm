package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q792_Number_of_Matching_Subsequences {
    public static int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<String>());
            }
        }
        for (String word : words) {
            map.get(word.charAt(0)).offer(word);
        }

        int count = 0;
        for (char c : S.toCharArray()) {
            Queue<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).offer(word.substring(1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[] {"a", "bb", "acd", "ace"}));
    }
}
