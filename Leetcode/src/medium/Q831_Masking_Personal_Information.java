package medium;

public class Q831_Masking_Personal_Information {
    public static String maskPII(String S) {
        StringBuilder sb = new StringBuilder();
        if (isEmail(S)) {
            int index = S.indexOf("@");
            String firstName = S.substring(0, index);
            firstName = firstName.toLowerCase();
            sb.append(firstName.charAt(0))
                    .append("*****")
                    .append(firstName.charAt(firstName.length() - 1))
                    .append(S.substring(index));
        } else if (isPhoneNumber(S)) {
            int numOfDigits = getNumOfDigits(S);
            if (numOfDigits > 10) {
                sb.append("+");
                for (int i = 0; i < numOfDigits - 10; i++) {
                    sb.append("*");
                }
                sb.append("-");
            }
            sb.append("***-***-")
                    .append(getLastFourDigits(S));
        }
        return sb.toString();
    }

    private static boolean isEmail(String S) {
        for (char c : S.toCharArray()) {
            if (c != '@' && c != '.' && !Character.isLetter(c)) {
                return false;
            }
        }
        return S.length() >= 2 && S.contains("@");
    }

    private static boolean isPhoneNumber(String S) {
        int numOfDigits = 0;
        for (char c : S.toCharArray()) {
            if (!"+-() ".contains(c + "") && !Character.isDigit(c)) {
                return false;
            }
            if (Character.isDigit(c)) {
                numOfDigits++;
            }
        }
        return numOfDigits >= 10 && numOfDigits <= 13;
    }

    private static int getNumOfDigits(String S) {
        int count = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    private static String getLastFourDigits(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (Character.isDigit(S.charAt(i))) {
                sb.append(S.charAt(i));
                count++;
            }
            if (count == 4) {
                break;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPII("+(501321)-50-23431"));
    }
}
