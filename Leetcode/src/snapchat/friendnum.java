package snapchat;

import java.util.ArrayList;
import java.util.List;

public class friendnum {
    public static void main(String[] args) {
        int intMain = 2;
        int intBig = 1000;
        
        do {
            List<Integer> listYakuSu1 = findYakuSu(intMain);
            int intSum1 = addYakuSu(listYakuSu1);
            if(intSum1 == intMain) {
                System.out.println("self num:" + intSum1);
            } else {
                List<Integer> listYakuSu2 = findYakuSu(intSum1);
                int intSum2 = addYakuSu(listYakuSu2);
                if(intSum2 == intMain) {
                    System.out.println("love num:" + intMain + "--" + intSum1);
                }
            }
            intMain ++;
        } while(intMain <= intBig);
    }
	    
    public static int addYakuSu(List<Integer> listYakuSu) {
        int sum = 0;
        for(int i : listYakuSu) {
            sum += i;
        }
        return sum;
    }
	    
    public static List<Integer> findYakuSu(int intNum) {
        List<Integer> listYakuSu = new ArrayList<Integer>();
        listYakuSu.add(1);
        int intRoot = (int)Math.sqrt(intNum);
        for(int i = 2; i <= intRoot ; i++) {
            int intPart = intNum / i;
            if(intPart * i == intNum) {
                listYakuSu.add(i);
                if(intPart != i) {
                    listYakuSu.add (intPart);
                }
            }
        }
        return listYakuSu;
    }
}
