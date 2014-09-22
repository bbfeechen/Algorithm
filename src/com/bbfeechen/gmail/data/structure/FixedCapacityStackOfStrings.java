/*************************************************************************
 *  Compilation:  javac FixedCapacityStackOfStrings.java
 *  Execution:    java FixedCapacityStackOfStrings
 *  
 *  Stack of strings implementation with a fixed-size array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is 
 * 
 *  % java FixedCapacityStackOfStrings 5 < tobe.txt 
 *  to be not that or be
 *
 *  Remark:  bare-bones implementation. Does not do repeated
 *  doubling or null out empty array entries to avoid loitering.
 *
 *************************************************************************/
package com.bbfeechen.gmail.data.structure;

import com.bbfeechen.gmail.utility.In;
import com.bbfeechen.gmail.utility.StdOut;

public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void push(String item) {
		a[N++] = item;
	}
	
	public String pop() {
		return a[--N];
	}
	
	public static void test(String[] args) {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
    	In in = new In(args[0]);
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
