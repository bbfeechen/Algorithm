import data.structure.Stack;


public class Q3_6 {
	public static void main(String[] args) {
	    Stack<Integer> stack = new Stack<Integer>();
	    stack.push(1);
	    stack.push(3);
	    stack.push(2);
	    Stack<Integer> sortedStack = sort(stack);
	    int N = sortedStack.size();
	    for(int i = 0; i < N; i++) {
	    	System.out.println(sortedStack.pop());
	    }
	}
	
	private static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
			    s.push(r.pop());
			}
			r.push(tmp);
		}		
		return r;	        	
	}
}
