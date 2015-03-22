import java.util.Set;


public class Q139_Word_Break {
	public static boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for(int j = 1; j <= i && j <= maxLength; j++) {
                if(!canSegment[i - j]) {
                    continue;
                }
                String str = s.substring(i - j, i);
                if(dict.contains(str)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
    
    private static int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for(String str : dict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
