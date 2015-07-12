package hard;

public class Q44_Wildcard_Matching {
	public static boolean isMatch(String s, String p) {
        int pcur = 0;
        int scur = 0;
        int pstar = -1;
        int sstar = -1;
        while(scur < s.length()) {  // pcur<p.length() cannot present for *?
            if(pcur < p.length() && p.charAt(pcur) == '*') {
                pstar = pcur;
                sstar = scur;
                pcur++;
                continue;
            }
            if(pcur<p.length() && (p.charAt(pcur) == '?' || p.charAt(pcur) == s.charAt(scur))) {
                pcur++;
                scur++;
                continue;
            }
            if(pstar != -1) {   // not matched, return last *, move s one step, try again
                sstar++;
                scur = sstar;
                pcur = pstar + 1;
                continue;
            }
            return false;
        }
        while(pcur < p.length() && p.charAt(pcur) == '*') {
            pcur++; // eliminate last consecutive *s, if p not end
        }
        return pcur == p.length();    // true if p ends
    }
	
	public static void main(String[] args) {
		isMatch("abde", "?b*d*");
	}
}
