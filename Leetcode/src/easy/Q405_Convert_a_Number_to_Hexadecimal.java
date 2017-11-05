package easy;

public class Q405_Convert_a_Number_to_Hexadecimal {
    private static final char[] TBL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.insert(0, TBL[num & 15]);
            num >>>= 4;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}
