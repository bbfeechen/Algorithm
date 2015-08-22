package easy;

public class Q242_Valid_Anagram {
	public static boolean isAnagram(String s, String t) {
        if(s == null) {
            return t == null;
        }
        if(s.length() == 0) {
            return t.length() == 0;
        }
        if(s.length() != t.length()) {
            return false;
        }
        
        // 1
        // char[] arrs = s.toCharArray();
        // char[] arrt = t.toCharArray();
        // Arrays.sort(arrs);
        // Arrays.sort(arrt);
        // for(int i = 0; i < arrs.length; i++) {
        //     if(arrs[i] != arrt[i]) {
        //         return false;
        //     }
        // }
        // return true;
        
        // 2
        return getHash(s) == getHash(t); 
    }
    
    private static int getHash(String s) {
        char[] arrs = s.toCharArray();
        int[] count = new int[26];
        for(char c : arrs) {
            count[c - 'a']++;
        }
        
        int a = 5, b = 7;
        int hash = 0;
        for(int i : count) {
            a = a * b;
            hash += a * i + b;
        }
        return hash;
    }

	public static void main(String[] args) {
		System.out.println(isAnagram("happy", "phapy"));
	}
}
