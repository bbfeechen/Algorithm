/*************************************************************************
 *  Compilation:  javac Queue.java
 *  Execution:    java Queue < input.txt
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt  
 *
 *  A generic queue, implemented using a linked list.
 *
 *  % java Queue < tobe.txt 
 *  to be or not to be (2 left on queue)
 *
 *************************************************************************/
package com.bbfeechen.gmail.data.structure;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.bbfeechen.gmail.utility.StdIn;
import com.bbfeechen.gmail.utility.StdOut;


public class Queue<Item> implements Iterable<Item> {
    private int N;         
    private Node first;    
    private Node last;     

    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;     
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;  
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    } 

    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    //------------------------
    
    public static void Josephus() {
    	int N = StdIn.readInt();
    	int M = StdIn.readInt();
    	
    	Queue<Integer> q = new Queue<Integer>();
    	for(int i = 0; i < N; i++)
    		q.enqueue(i);
    	while(!q.isEmpty()) {
    	    for(int i = 0; i < M - 1; i++)
    	    	q.enqueue(q.dequeue());
    	    StdOut.print(q.dequeue() + " ");
    	}
    	StdOut.println();
    }

    public static void test(String[] args) {
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
