package easy;

import java.util.ArrayList;
import java.util.List;

public class Q119_Pascal_Triangle_II {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return result;
        }
        
        result.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(result.get(j - 1) + result.get(j));
                }
            }
            result = curr;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
