package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q609_Find_Duplicate_File_in_System {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            String dir = strs[0];
            for (int i = 1; i < strs.length; i++) {
                String file = strs[i].substring(0, strs[i].indexOf("("));
                String content = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].indexOf(")"));
                String value = dir + "/" + file;
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(value);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] paths = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"};
        findDuplicate(paths);
    }
}
