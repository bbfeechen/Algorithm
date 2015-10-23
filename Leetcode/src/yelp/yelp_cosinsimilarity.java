package yelp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class yelp_cosinsimilarity {
	public static class Frequency {
		int freq1;
		int freq2;
		public Frequency(int freq1, int freq2) {
			this.freq1 = freq1;
			this.freq2 = freq2;
		}
		public void update(int freq1, int freq2) {
			this.freq1 = freq1;
			this.freq2 = freq2;
		} 
	}
	
	public static double cosineSimilarity(String text1, String text2) {
		String[] words1 = text1.split(" ");
		String[] words2 = text2.split(" ");
		Map<String, Frequency> map = new HashMap<String, Frequency>();
		Set<String> set = new HashSet<String>();
		
		for(String word : words1) {
			if(!map.containsKey(word)) {
				Frequency freq = new Frequency(1, 0);
				map.put(word, freq);
				set.add(word);
			} else {
				Frequency freq = map.get(word);
				int freq1 = freq.freq1 + 1;
				int freq2 = freq.freq2;
				freq.update(freq1, freq2);
				map.put(word, freq);
			}
		}
		
		for(String word : words2) {
			if(!map.containsKey(word)) {
				Frequency freq = new Frequency(0, 1);
				map.put(word, freq);
				set.add(word);
			} else {
				Frequency freq = map.get(word);
				int freq1 = freq.freq1;
				int freq2 = freq.freq2 + 1;
				freq.update(freq1, freq2);
				map.put(word, freq);
			}
		}
		
		double vecAB = 0.0;
		double vecAA = 0.0;
		double vecBB = 0.0;
		for(String word : set) {
			Frequency freq = map.get(word);
			int freq1 = freq.freq1;
			int freq2 = freq.freq2;
			vecAB += freq1 * freq2;
			vecAA += freq1 * freq1;
			vecBB += freq2 * freq2;
		}
		return vecAB / (Math.sqrt(vecAA) * Math.sqrt(vecBB));
	}

	public static void main(String[] args) {
		String text1 = "Julie loves me more than Linda loves me";
		String text2 = "Jane likes me more than Julie loves me";
		System.out.println(cosineSimilarity(text1, text2));
	}
}
