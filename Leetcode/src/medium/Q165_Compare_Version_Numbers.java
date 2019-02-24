package medium;

public class Q165_Compare_Version_Numbers {
    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            int v1 = i < s1.length ? Integer.valueOf(s1[i]) : 0;
            int v2 = i < s2.length ? Integer.valueOf(s2[i]) : 0;
            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
    }
}
