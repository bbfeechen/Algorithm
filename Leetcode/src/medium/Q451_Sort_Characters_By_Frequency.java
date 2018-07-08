package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q451_Sort_Characters_By_Frequency {
    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> char2freq = new HashMap<>();
        Map<Integer, Integer> idx2freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char2freq.put(s.charAt(i), char2freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            idx2freq.put(i, char2freq.get(s.charAt(i)));
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(idx2freq.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : list) {
            int index = (Integer) entry.getKey();
            sb.append(s.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
