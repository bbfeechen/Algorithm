package medium;

import java.util.ArrayList;
import java.util.List;

public class Q89_Gray_Code {
	public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0) {
            result.add(0);
            return result;
        }
        if(n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        List<Integer> list = grayCode(n - 1);
        result.addAll(list);
        for(int i = list.size() - 1; i >= 0; i--) {
            result.add((1 << (n - 1)) + list.get(i));
        }
        return result;
    }

	public static void main(String[] args) {
		List<Integer> result = grayCode(3);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

}
