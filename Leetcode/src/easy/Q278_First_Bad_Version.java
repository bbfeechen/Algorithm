package easy;

public class Q278_First_Bad_Version {
    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            // (start + end) / 2 will have overflow issue
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int version) { return true; }

    public static void main(String[] args) {

    }
}
