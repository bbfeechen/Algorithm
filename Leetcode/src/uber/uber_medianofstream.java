package uber;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class uber_medianofstream {
	public static Queue<Integer> minHeap = new PriorityQueue<Integer>();
	public static Queue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
	public static int numOfElements = 0;
	
	public static void addNumberToStream(Integer num) {
		maxHeap.add(num);
		if(numOfElements % 2 == 0) {
			if(minHeap.isEmpty()) {
				numOfElements++;
				return;
			} else if(maxHeap.peek() > minHeap.peek()) {
				Integer maxHeapRoot = maxHeap.poll();
				Integer minHeapRoot = minHeap.poll();
				maxHeap.offer(minHeapRoot);
				minHeap.offer(maxHeapRoot);
			}
		} else {
			minHeap.add(maxHeap.poll());
		}
		numOfElements++;
	}
	
	public static double getMedian() {
		if(numOfElements % 2 == 0) {
			return (double)(minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return (double)(maxHeap.peek());
		}
	}
	
	public static void main(String[] args) {
		addNumberToStream(1);
		System.out.println(getMedian()); // should be 1
		
		addNumberToStream(5);
		addNumberToStream(10);
		addNumberToStream(12);
		addNumberToStream(2);
		System.out.println(getMedian()); // should be 5
		
		addNumberToStream(3);
		addNumberToStream(8);
		addNumberToStream(9);
		System.out.println(getMedian()); // should be 6.5
	}
	
}
