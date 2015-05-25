package cracking.chap3;

public class chap3_6_Imp2 {
	private static final int STACK_SIZE = 7;

	public static void main(String[] args) {
		Stack<Integer> stack = createNewStack();
		Stack<Integer> sortedStack = new Stack<Integer>(STACK_SIZE);

		while (!stack.isEmpty()) {
			Integer temp = stack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
				stack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}

		sortedStack.printStack();

	}

	private static Stack<Integer> createNewStack() {
		Stack<Integer> stack = new Stack<Integer>(STACK_SIZE);
		stack.push(2);
		stack.push(7);
		stack.push(0);
		stack.push(5);
		stack.push(3);
		stack.push(8);
		stack.push(1);
		return stack;
	}
}
