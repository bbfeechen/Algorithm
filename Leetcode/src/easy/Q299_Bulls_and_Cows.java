package easy;

public class Q299_Bulls_and_Cows {
	public static String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] mark = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                bull++;
            } else {
                if(mark[secret.charAt(i) - '0']++ < 0) {
                    cow++;
                } 
                if(mark[guess.charAt(i) - '0']-- > 0) {
                    cow++;
                }
            }
        }
        
        return bull + "A" + cow + "B";
    }

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
	}
}
