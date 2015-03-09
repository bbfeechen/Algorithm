/*************************************************************************
 *  Compilation:  javac ResizingArrayStack.java
 *  Execution:    java ResizingArrayStack < input.txt
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *  
 *  Stack implementation with a resizing array.
 *
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

package com.bbfeechen.gmail.data.structure;

import java.util.Iterator;

import com.bbfeechen.gmail.utility.In;
import com.bbfeechen.gmail.utility.StdOut;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;
    
    public boolean isEmpty() { 
    	return N == 0; 
    }
    
    public int size() {
    	return N;
    }
    
    private void resize(int max) {
    	Item[] temp = (Item[]) new Object[max];
    	for(int i = 0; i < N; i++) 
    		temp[i] = a[i];
    	a = temp;
    }
    
    public void push(Item item) {
    	if(N == a.length) 
    		resize(2*a.length);
    	a[N++] = item; 
    }
    
    public Item pop() {
    	Item item  = a[--N];
    	a[N] = null;
    	if(N > 0 && N == a.length / 4) 
    		resize(a.length / 2);
    	return item;
    }
	
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}

		@Override
		public void remove() {			
		}
	}
	
	public static void test(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<String>();
    	In in = new In(args[0]);
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
