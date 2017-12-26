package basic.sort;

import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] a, int maxVal) {
        int[] sorted = new int[a.length];
        int [] counts = new int[maxVal+1];

        for (int i = 0; i < a.length; i++) {
            counts[a[i]]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = 0; i < a.length; i++) {
            sorted[counts[a[i]] - 1] = a[i];
            counts[a[i]]--;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
//	      int maxVal = 5;
//	      int [] data = {5,3,0,2,4,1,0,5,2,3,1,4};

        int maxVal = 4;
        int [] data = {1, 2, 1, 3, 4, 2};

        System.out.println("Before: " + Arrays.toString(data));
        sort(data,maxVal);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
