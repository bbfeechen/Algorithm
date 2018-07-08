package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Q748_Shortest_Completing_Word {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return w1.length() - w2.length();
            }
        });
        for (String word : words) {
            if (match(word, map)) {
                return word;
            }
        }
        return null;
    }

    private static boolean match(String word, Map<Character, Integer> map) {
        Map<Character, Integer> mapCopy = new HashMap<>(map);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (mapCopy.containsKey(c)) {
                mapCopy.put(c, mapCopy.get(c) - 1);
                if (mapCopy.get(c) == 0) {
                    mapCopy.remove(c);
                }
            }
        }
        return mapCopy.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(
                shortestCompletingWord("1s3 PSt", new String[] {"step","steps","stripe","stepple"}));
    }
}
