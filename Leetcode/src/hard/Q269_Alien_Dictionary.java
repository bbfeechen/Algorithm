package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q269_Alien_Dictionary {
    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            boolean isAlreadySet = false;
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
                if (!isAlreadySet && i > 0 && j < words[i-1].length() && words[i].charAt(j) != words[i - 1].charAt(j)) {
                    if (!map.containsKey(words[i - 1].charAt(j))) {
                        map.put(words[i - 1].charAt(j), new ArrayList<>());
                    }
                    if (!map.get(words[i - 1].charAt(j)).contains(words[i].charAt(j))) {
                        map.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
                    }
                    isAlreadySet = true;
                }
            }
        }
        int[] inDegrees = new int[26];
        Arrays.fill(inDegrees, Integer.MIN_VALUE);
        for (char c : set) {
            inDegrees[c - 'a'] = 0;
        }
        for (List<Character> list : map.values()) {
            for (char c : list) {
                inDegrees[c - 'a']++;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (inDegrees[i] == 0) {
                char c = (char) (i + 'a');
                queue.offer(c);
                sb.append(c);
            }
        }
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            int size = map.containsKey(curr) ? map.get(curr).size() : 0;
            for (int i = 0; i< size; i++) {
                char next = map.get(curr).get(i);
                inDegrees[next - 'a']--;
                if (inDegrees[next - 'a'] == 0) {
                    queue.offer(next);
                    sb.append(next);
                }
            }
        }
        return sb.length() == set.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[] {"za","zb","ca","cb"}));
    }
}
