/*************************************************************************
 *  Compilation:  javac FixedCapacityStack.java
 *  Execution:    java FixedCapacityStack
 *  
 *  Generic stack implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java FixedCapacityStack 5 < tobe.txt 
 *  to be not that or be
 *
 *  Remark:  bare-bones implementation. Does not do repeated
 *  doubling or null out empty array entries to avoid loitering.
 *
 *************************************************************************/
package com.bbfeechen.gmail.data.structure;

import com.bbfeechen.gmail.utility.In;
import com.bbfeechen.gmail.utility.StdOut;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N;
    
    @SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
    	a = (Item[])new Object[cap];
    }
    
    public boolean isEmpty() {
    	return N == 0;
    }
    
    public int size() {
    	return N;
    }
    
    public void push(Item item) {
    	a[N++] = item;
    }
    
    public Item pop() {
    	return a[--N];
    }
    
    public static void test(String[] args) {
    	FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
    	In in = new In(args[0]);
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
