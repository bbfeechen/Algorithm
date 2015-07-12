package hard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q30_Substring_with_Concatenation_of_All_Words {
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(L.length == 0) {
            return result;
        }
        
        HashMap<String, Integer> toFind = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++) {
            if(toFind.containsKey(L[i])) {
                toFind.put(L[i], toFind.get(L[i]) + 1); 
            } else {
                toFind.put(L[i], 1);
            }
        }
        
        int len = L[0].length();
        for(int i = 0; i <= S.length() - L.length * len; i++) {
            HashMap<String, Integer> found = new HashMap<String, Integer>(toFind);
            int numOfFound = 0;
            for(int j = i; j <= i + (L.length - 1)* len; j += len) {
                if(j + len > S.length()) {
                    break;
                }
                
                String word = S.substring(j, j + len);
                if(found.containsKey(word)) {
                    numOfFound++;
                    int numOfRemained = found.get(word);
                    if(numOfRemained > 1) {
                        found.put(word, numOfRemained - 1);
                    } else {
                        found.remove(word);
                    }
                } else {
                    break;
                }
            }
            if(numOfFound == L.length) {
                result.add(i);
            }
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
