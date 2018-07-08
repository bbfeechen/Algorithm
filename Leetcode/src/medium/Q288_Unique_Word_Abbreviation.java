package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q288_Unique_Word_Abbreviation {

    static class ValidWordAbbr {
        private Map<String, Integer> str2freq;
        private Map<String, Integer> abbr2freq;

        public ValidWordAbbr(String[] dictionary) {
            str2freq = new HashMap<>();
            abbr2freq = new HashMap<>();
            for (String word : dictionary) {
                String abbr = getAbbr(word);
                abbr2freq.put(abbr, abbr2freq.getOrDefault(abbr, 0) + 1);
                str2freq.put(word, str2freq.getOrDefault(word, 0) + 1);
            }
        }

        public boolean isUnique(String word) {
            return !abbr2freq.containsKey(getAbbr(word))
                    || (str2freq.containsKey(word) && abbr2freq.get(getAbbr(word)) == 1)
                    || abbr2freq.get(getAbbr(word)) == str2freq.get(word);
        }

        private String getAbbr(String word) {
            if (word == null || word.length() <= 2) {
                return word;
            }
            return "" + word.charAt(0) + word.substring(1, word.length() - 1).length() + word.charAt(word.length() - 1);
        }
    }

    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(new String[] {"deer","door","cake","card"});
        System.out.println(validWordAbbr.isUnique("dear"));
    }

}
