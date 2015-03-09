package data.structure;
/*************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/


import java.util.Iterator;
import java.util.NoSuchElementException;

import utility.In;
import utility.StdIn;
import utility.StdOut;


public class Stack<Item> implements Iterable<Item> {
    private int N;         
    private Node first;   

    private class Node {
        private Item item;
        private Node next;
        
        public Node() {
        	item = null;
        	next = null;
        }        
        public Node(Node x) {
        	item = x.item;
        	next = x.next;
        }
    }

    public Stack() {
        first = null;
        N = 0;
    }
    
    public Stack(Stack<Item> s) {
    	if(s.first != null) {
    		first = new Node(s.first);
    	    for(Node x = first; x.next != null; x = x.next) {
    	        x.next = new Node(x.next);     
    	    }
    	}
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        
        first = first.next;           
        N--;
        return item;                  
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator()  { return new ListIterator();  }

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
    public static void DijkstraTwoStackEvaluate() {
    	Stack<String> ops = new Stack<String>();
    	Stack<Double> vals = new Stack<Double>();
        while(!StdIn.isEmpty()) {
        	String s = StdIn.readString();
        	if(s.equals("(")) {
        		;
        	} else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
        		ops.push(s);
        	} else if(s.equals(")")) {
        		String op = ops.pop();
        		double v = vals.pop();
        		if(op.equals("+")) {
        			v = vals.pop() + v;
        		} else if(op.equals("-")) {
        			v = vals.pop() - v;
        		} else if(op.equals("*")) {
        			v = vals.pop() * v;
        		} else if(op.equals("/")) {
        			v = vals.pop() / v;
        		} else if(op.equals("sqrt")) {
        			v = Math.sqrt(v);
        		} 
            	vals.push(v);
        	} else {
        	    vals.push(Double.parseDouble(s));	
        	}	
        }
        StdOut.println(vals.pop());
    }
    
    public static boolean isParentBalanced() {
    	Stack<Character> stack = new Stack<Character>();
    	while(!StdIn.isEmpty()) {
        	char c = StdIn.readChar();
        	if(c == '(' || c == '[' || c == '{') {
        		stack.push(c);
        	} else if(c == ')') {
        		if(stack.isEmpty())
        			return false;
        		else if(stack.pop() != '(')
        			return false;
        	} else if(c == ']') {
        		if(stack.isEmpty())
        			return false;
        		else if(stack.pop() != '[')
        			return false;
        	} else if(c == '}') {
        		if(stack.isEmpty())
        			return false;
        		else if(stack.pop() != '{')
        			return false;
        	}
    	}
    	return stack.isEmpty();
    }

    public static void test(String[] args) {
        Stack<String> s = new Stack<String>();
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String item = in.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}

