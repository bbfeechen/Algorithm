package lineartimesort;

import java.util.Arrays;

import utils.Utils;

public class CountSort {
	private int k;
	private int[] data;
	private int[] count;
	private int[] results;
	public CountSort(int k, int[] data) {
		this.k = k;
		this.data = data;
	}
	
	public void printRes() {
		Utils.printArray(results);
	}
	
	public void sort() {
		count = new int[k + 1];
		results = new int[data.length];
		int i;
		for (i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		for (i = data.length - 1; i >= 0; i--) {
			results[count[data[i]] - 1] = data[i];
			count[data[i]]--;
		}
	}
	
	
	public static void main(String[] args) {
		//int[] data = {6, 0, 2, 0, 1, 3, 4, 6, 1, 3, 2};
		int[] data = Utils.generateRandomTestData(1000000, 1, (int)Math.pow(10.0, 5));
		CountSort mySort = new CountSort((int)Math.pow(10.0, 5), data);
		long startTime = System.currentTimeMillis();
		mySort.sort();
		long endTime = System.currentTimeMillis();
		mySort.printRes();
		System.out.println("Sort time is " + (endTime - startTime));
	}

}
