package uber;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class uber_timelimit {
	public static class Tester {
	    private int timeLimit;
	    private int capacity;
	    private Queue<Date> queue;
	    
	    public Tester(int timeLimit,int capacity) {
	    	this.timeLimit = timeLimit;
	    	this.capacity = capacity;
	    	this.queue = new LinkedList<Date>();
	    }
	    
	    public void func() {
	        Date curr = new Date();
	        System.out.println(curr);
	        queue.offer(curr);
//	        while(!queue.isEmpty() && (curr.getTime() - queue.peek().getTime()) > timeLimit) {
//	        	queue.poll();
//	        }
	        if(queue.size() > capacity) { 
	        	System.out.println("NO");
	        } else { 
	        	System.out.println("YES");
	        }
	    }
	}

	public static void main(String[] args) {
		Tester tester = new Tester(3, 3);
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tester.func();
		}
	}
}
