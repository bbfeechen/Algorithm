package medium;

public class Q393_UTF_8_Validation {
    public static boolean validUtf8(int[] data) {
        int n = data.length;
        int skip = 0b10000000;
        int check = 0;
        for (int i = 0; i < data.length; i++) {
            if (check > 0) {
                if ((data[i] & skip) == skip)
                    check--;
                else
                    return false;
            } else {
                check = getHeadType(data[i]);
                if (check < 0) return false;
            }
        }
        return check == 0;
    }

    public static int getHeadType(int num) {
        if ((num & 0b11110000) == 0b11110000) return 3;
        if ((num & 0b11100000) == 0b11100000) return 2;
        if ((num & 0b11000000) == 0b11000000) return 1;
        if ((num & 0b10000000) == 0b10000000) return -1; //error
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(validUtf8(new int[] {248,130,130,130}));
    }
}
