package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class indeed_kthquantiles {
//	public static void calQuantiles(int[] data, int p, int r, int k, int[] res, int t) {
//		int rank = k == 1 ? k * t : k / 2 * t;
//		int quantile = randomSelect(data, p, r, rank);
//		res[(rank + p) / t - 1] = quantile;
//		if (k == 1) {
//			return;
//		}
//		int q = indexOf(data, p, r, quantile);
//		calQuantiles(data, p, q, k / 2, res, t);
//		calQuantiles(data, q+ 1, r, k - (int)(k / 2), res, t);
//	}
//	
//	private static int randomSelect(int[] data, int p, int r, int i) {
//		if (p == r) {
//			return data[p];
//		}
//		int q = randomizedPartition(data, p, r);
//		int k = q - p + 1;
//		if (i == k) {
//			return data[q];
//		} else if (i < k) {
//			return randomSelect(data, p, q - 1, i);
//		} else {
//			return randomSelect(data, q + 1, r, i - k);
//		}
//	}
//	
//	private static int randomizedPartition(int[] data, int p, int r) {
//		int pivotIndex = (int)(Math.random() * (r - p) + p);
//		swap(data, pivotIndex, r);
//		return partition(data, p, r);
//	}
//	
//	private static void swap(int[] data, int i, int j) {
//		int temp = data[i];
//		data[i] = data[j];
//		data[j] = temp;
//	}
//	
//	private static int partition(int[] data, int p, int r) {
//		int i = p - 1;
//		int j = p;
//		int pivot = data[r];
//		while(j <= r - 1) {
//			if (data[j] <= pivot) {
//				i++;
//				swap(data, i, j);
//			}
//			j++;
//		}
//		swap(data, r, i + 1);
//		return i + 1;
//	}
//	
//	private static int indexOf(int[] data, int start, int end, int key) {
//		for (int i = start; i <= end; i++) {
//			if (data[i] == key) {
//				return i;
//			}
//		}
//		return -1;
//	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int Q = scanner.nextInt();
		int N = scanner.nextInt();
		
		int total = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			int freq = scanner.nextInt();
			total += freq;
			map.put(num, freq);
		}
		int T = total / Q;
		
		int count = 0;
		int i = 0;
		List<Integer> quantiles = new ArrayList<Integer>();
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			count += freq;
			if(count >= (i + 1) * T) {
				quantiles.add(num);
				i++;
				if(i == Q - 1) {
					break;
				}
			}
		}
		for(int quantile : quantiles) {
			System.out.println(quantile);
		}
		
//		calQuantiles(data, 0, data.length - 1, Q, res, t);
//		for(int num : res) {
//			System.out.print(num + " ");
//		}
	}
}
