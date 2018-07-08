package easy;

public class Q482_License_Key_Formatting {
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (count == K) {
                    sb.append('-');
                    count = 0;
                }
                sb.append(Character.toUpperCase(S.charAt(i)));
                count++;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
