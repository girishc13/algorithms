package cracking.chap3;

public class MyQueue {

	private static final int capacity = 5;
	Stack<Integer> stack = new Stack<Integer>(capacity);
	Stack<Integer> bufferStack = new Stack<Integer>(capacity);

	public void enqueue(int d) throws Exception {
		boolean success = stack.push(d);
		if (!success) {
			throw new Exception("Stack is full.");
		}
	}

	public Integer dequeue() {
		if (!bufferStack.isEmpty()) {
			return bufferStack.pop();
		} else if (stack.size() == 1) {
			return stack.pop();
		} else if (stack.isEmpty()) {
			return null;
		}

		moveItems();

		return bufferStack.pop();
	}

	private void moveItems() {
		while (!stack.isEmpty() && !bufferStack.isFull()) {
			Integer stackTop = stack.pop();
			if (stackTop != null)
				bufferStack.push(stackTop);
		}
	}
}
