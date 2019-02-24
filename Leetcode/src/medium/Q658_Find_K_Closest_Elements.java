package medium;

import java.util.ArrayList;
import java.util.List;

public class Q658_Find_K_Closest_Elements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        if (index < 0) {
            index = 1;
        }
        int i = index - 1;
        int j = index;
        while (k > 0) {
            if (i < 0 || (j < arr.length && Math.abs(arr[i] - x) > Math.abs(x - arr[j]))) {
                j++;
            } else {
                i--;
            }
            k--;
        }
        List<Integer> result = new ArrayList<>();
        int start = i < 0 ? 0 : i;
        int end = j > arr.length - 1 ? (arr.length - 1) : j;
        for (int l = start; l <= end; l++) {
            result.add(arr[l]);
        }
        return result;
    }

    private static int binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[] {0,1,1,1,2,3,6,7,8,9}, 9 ,4));
    }
}
