package easy;

public class Q551_Student_Attendance_Record_I {
    public static boolean checkRecord(String s) {
        int numOfA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                numOfA++;
            }
        }
        return numOfA <= 1 && !s.contains("LLL");
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
}
