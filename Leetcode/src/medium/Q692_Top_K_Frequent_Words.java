package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q692_Top_K_Frequent_Words {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return quickSelect(map, new ArrayList<String>(map.keySet()), 0, map.size() - 1, k);
    }

    private static List<String> quickSelect(HashMap<String, Integer> map,
            ArrayList<String> keys, int start, int end, int k) {
        int left = start, right = end;
        List<String> res = new ArrayList<>();

        while (left < right) {
            int pivot = partition(map, keys, left, right);
            if (pivot < k - 1) {
                left = pivot + 1;
            } else if (pivot > k - 1) {
                right = pivot - 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(keys.get(i));
        }
        return res;
    }


    private static int partition(HashMap<String, Integer> map, ArrayList<String> keys, int start, int end) {
        int left = start;
        int pivot = map.get(keys.get(start));
        for (int i = start + 1; i <= end; i++) {
            if (map.get(keys.get(i)) > pivot || (map.get(keys.get(i)) == pivot && keys.get(start).compareTo(keys.get(i)) > 0)) {
                Collections.swap(keys, i, ++left);
            }
        }
        Collections.swap(keys, start, left);
        return left;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> res = topKFrequent(words, k);
    }
}
