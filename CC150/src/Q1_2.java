
public class Q1_2 {
	public static void main(String[] args) {
        String str = "abcd";
        str = reverse(str);
        System.out.println(str);
	}
	
	private static String reverse(String str) {
		char[] array = str.toCharArray();
		for(int i = 0, j = array.length - 1; i < j; i++, j--) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return new String(array);
	}
}
