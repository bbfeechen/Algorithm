package yelp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class yelp_topKth {
	public static class WordFreq implements Comparable<WordFreq> {
		String word;
		int freq;
		public WordFreq(String word, int freq) {
			this.word = word;
			this.freq = freq;
		}
		@Override
		public int compareTo(WordFreq other) {
			return (this.freq == other.freq) ? 0 : (this.freq > other.freq ? 1 : -1);
		}
	}
	
	public static String[] topKwords(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<WordFreq> minHeap = new PriorityQueue<WordFreq>(k);
		for(String word : words) {
			if(!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				map.put(word, map.get(word) + 1);
			}
		}
		for(Map.Entry entry : map.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer(new WordFreq((String)entry.getKey(), (int)entry.getValue()));
			} else if((int)entry.getValue() > minHeap.peek().freq) {
				minHeap.poll();
				minHeap.offer(new WordFreq((String)entry.getKey(), (int)entry.getValue()));
			}
		}
		
		String[] result = new String[k];
		int i = 0;
		while(minHeap.size() > 0) {
			result[i++] = minHeap.poll().word;
		}
		return result;
	} 
	
	// ---------------
	public static String[] topKwords2(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String word : words) {
			if(!map.containsKey(word)) {
				map.put(word, 1);
			} else {
				map.put(word, map.get(word) + 1);
			}
		}
		int[] freq = new int[map.size()];
		int i = 0;
		for(int value : map.values()) {
			freq[i++] = value;
		}
		int kthFreq = kthLargest(freq, 0, i - 1, k);
		
		String[] result = new String[k];
		i = 0;
		for(Map.Entry entry : map.entrySet()) {
			if((int)entry.getValue() >= kthFreq) {
				result[i++] = (String)entry.getKey();
				if(i == k) {
					break;
				}
			}
		}
		return result;
	} 
	
	private static int kthLargest(int[] freq, int start, int end, int order) {
		int pivot = freq[start];
		if(start >= end) {
			return (order == 1) ? pivot : -1;
		}
		int i = start + 1;
		int j = end;
		while(i <= j) {
			if(freq[i] < pivot) {
				i++;
				continue;
			}
			if(freq[j] > pivot) {
				j--;
				continue;
			}
			swap(freq, i, j);
			i++;
			j--;
		}
		swap(freq, start, j);
		if(end - j + 1 == order) {
			return pivot;
		} else if (end - j + 1 > order) {
			return kthLargest(freq, j + 1, end, order);
		} else {
			return kthLargest(freq, start, j, order - (end - j));
		}
	}
	
	private static void swap(int[] freq, int i, int j) {
		int temp = freq[i];
		freq[i] = freq[j];
		freq[j] = temp;
	}

	public static void main(String[] args) {
		String words = "a b b c c c e e e e e d d d d g g g g g g g f f f f f f";
		String[] topK = topKwords2(words.split(" "), 3);
		for(String word : topK) {
			System.out.print(word + " ");
		}
	}
}
