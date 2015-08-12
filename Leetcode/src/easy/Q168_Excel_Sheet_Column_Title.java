package easy;

public class Q168_Excel_Sheet_Column_Title {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            char c = (char) ((n - 1) % 26 + 'A'); 
            sb.insert(0, c);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(28));
	}
}
