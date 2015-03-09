import data.structure.Stack;


public class Q3_5 {

	public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        int N = queue.size();
        for(int i = 0; i < N; i++) {
            System.out.println(queue.dequeue());
        }
	}

	public static class MyQueue<T> {
		Stack<T> stackNewest, stackOldest;
		
		public MyQueue() {
			stackNewest = new Stack<T>();
			stackOldest = new Stack<T>();
		}
		
		public int size() {
			return stackNewest.size() + stackOldest.size();
		}
		
		public void enqueue(T value) {
			stackNewest.push(value);
		}
		
		public T peek() {
			shiftStacks();
			return stackOldest.peek();
		}
		
		public T dequeue() {
			shiftStacks();
			return stackOldest.pop();
		}
		
		private void shiftStacks() {
			if(stackOldest.isEmpty()) {
				while(!stackNewest.isEmpty()) {
					stackOldest.push(stackNewest.pop());
				}
			}
		}
	}
}
