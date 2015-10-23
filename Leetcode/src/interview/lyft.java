package interview;

import java.util.ArrayList;
import java.util.Iterator;

public class lyft {
	public static class CommonIterator {
	    private Iterator<Integer> iter1;
	    private Iterator<Integer> iter2;
	    
	    private int nextCommonElem;
	    
	    public CommonIterator(Iterator<Integer> iter1, Iterator<Integer> iter2) {
	      this.iter1 = iter1;
	      this.iter2 = iter2;
	      this.nextCommonElem = Integer.MIN_VALUE;
	      findNextCommon();
	    }
	    
	    public boolean hasNext() {
	      return nextCommonElem != Integer.MIN_VALUE;
	    }
	    
	    public int next() {
	      int ret = nextCommonElem;
	      if(!findNextCommon()) {
	        nextCommonElem = Integer.MIN_VALUE;
	      }
	      return ret;
	    }
	    
	    private boolean findNextCommon() {
	      boolean isFound = false;
	      int curr1 = Integer.MIN_VALUE;
	      int curr2 = Integer.MIN_VALUE;
	      if(!iter1.hasNext() || !iter2.hasNext()) {
	    	  return false;
	      }
	      curr1 = iter1.next();
	      curr2 = iter2.next();
	      while(iter1.hasNext() && iter2.hasNext()) {
	    	if(curr1 < curr2) {
	        	curr1 = iter1.next();
	        } else if(curr1 > curr2) {
	        	curr2 = iter2.next();
	        } else {
	            nextCommonElem = curr1;
	            System.out.println(curr1 + " has been found");
	            isFound = true;
	            break;
	        }
	      }
	      return isFound;
	    }
	  }
	  
	  // 1, 1, 2, 3, 5, 8, 13, 21
	  // 0, 5, 7, 8, 9 
	  public static void main(String[] args) {
	    ArrayList<Integer> it1 = new ArrayList<Integer>();
	    it1.add(1);
	    it1.add(1);
	    it1.add(2);
	    it1.add(3);
	    it1.add(5);
	    it1.add(8);
	    it1.add(13);
	    it1.add(21);

	    ArrayList<Integer> it2 = new ArrayList<Integer>();
	    it2.add(0);
	    it2.add(5);
	    it2.add(7);
	    it2.add(8);
	    it2.add(9);
	    CommonIterator commonIt = new CommonIterator(it1.iterator(), it2.iterator());
	    while(commonIt != null && commonIt.hasNext()) {
	    	System.out.print(commonIt.next() + " ");
	    }
	    System.out.println("done");
	  }
}
