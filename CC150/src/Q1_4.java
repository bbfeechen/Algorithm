
public class Q1_4 {
	public static void main(String[] args) {
        char[] array = new char[30];
        String str = "a b sd  e";
        for(int i = 0; i < str.length(); i++) {
        	array[i] = str.charAt(i);
        }
        array[str.length()] = '\0';
        String newStr = replaceSpaces(array, str.length());
        System.out.println(str);
        System.out.println(newStr);
	}
	
	private static String replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for(i = 0; i < length; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for(i = length - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
		return new String(str);
	}
}
