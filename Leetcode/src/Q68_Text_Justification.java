import java.util.ArrayList;
import java.util.List;


public class Q68_Text_Justification {
	public static List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(words == null || words.length == 0) {
            return result;
        }
        
        int curLen = 0;
        int lastWordCount = 0;
        for(int i = 0; i < words.length; i++) {
            // (i - lastWordCount) is the length of spaces for all the current words
            if(curLen + words[i].length() + (i - lastWordCount) > L) {
                int aveSpaceNum = 0;
                int extSpaceNum = 0;
                if(i - lastWordCount > 1) {
                    aveSpaceNum = (L - curLen) / (i - lastWordCount - 1); // average space number for each word
                    extSpaceNum = (L - curLen) % (i - lastWordCount - 1); // extra space number for the first several words
                }  
                
                // append average/extra space for each word 
                StringBuilder sb = new StringBuilder();
                for(int j = lastWordCount; j < i; j++) {
                    sb.append(words[j]);
                    if(j < i - 1) {
                        for(int k = 0; k < aveSpaceNum; k++) {
                            sb.append(" ");
                        }
                        if(extSpaceNum > 0) {
                            sb.append(" ");
                        }
                        extSpaceNum--;
                    }
                }
                
                // append the spaces to make overall length equals to L
                for(int j = sb.length(); j < L; j++) {
                    sb.append(" ");
                }
                result.add(sb.toString());
                curLen = 0; // reset current length
                lastWordCount = i; // the previous used word number in array of words
            }
            
            // concatenate the words until current length surpasses L
            curLen += words[i].length();
        }
        
        // process the last line
        StringBuilder sb = new StringBuilder();
        for(int i = lastWordCount; i < words.length; i++) {
            sb.append(words[i]);
            if(sb.length() < L) {
                sb.append(" ");
            }
        }
        
        for(int i = sb.length(); i < L; i++) {
            sb.append(" ");
        }
        
        result.add(sb.toString());
        return result;
    }
	
	public static void main(String[] args) {

	}
}
