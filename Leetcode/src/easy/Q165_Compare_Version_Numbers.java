package easy;

public class Q165_Compare_Version_Numbers {
	public static int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) {
            return 0;
        }
        int fVersion1 = 0, fVersion2 = 0;
        String sVersion1 = "", sVersion2 = "";
        if(version1.contains(".")) {
            int pos = version1.indexOf(".");
            fVersion1 = Integer.valueOf(version1.substring(0, pos));
            sVersion1 = version1.substring(pos + 1);
        } else {
            fVersion1 = Integer.valueOf(version1);
            sVersion1 = "0";
        }
        if(version2.contains(".")) {
            int pos = version2.indexOf(".");
            fVersion2 = Integer.valueOf(version2.substring(0, pos));
            sVersion2 = version2.substring(pos + 1);
        } else {
            fVersion2 = Integer.valueOf(version2);
            sVersion2 = "0";
        }
        
        if(fVersion1 > fVersion2) {
            return 1;
        } else if(fVersion1 < fVersion2) {
            return -1;
        } else {
            return compareVersion(sVersion1, sVersion2);
        }
    }
	
	public static void main(String[] args) {
		
	}
}
