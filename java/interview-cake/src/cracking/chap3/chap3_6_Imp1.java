package cracking.chap3;

public class chap3_6_Imp1 {

	private static final int STACK_SIZE = 7;

	public static void main(String[] args) {
		Stack<Integer> stack = createNewStack();
		Stack<Integer> bufStack = new Stack<Integer>(STACK_SIZE);

		double sortIterations = Math.ceil(STACK_SIZE / 2.0);
		for (int i = 0; i < sortIterations; i++) {
			compareElemsOnStack(stack, bufStack);
			moveElements(bufStack, stack);
		}
		stack.printStack();
	}

	private static void moveElements(Stack<Integer> bufStack,
			Stack<Integer> stack) {
		while (!bufStack.isEmpty()) {
			stack.push(bufStack.pop());
		}
	}

	private static void compareElemsOnStack(Stack<Integer> stack,
			Stack<Integer> bufStack) {
		while (!stack.isEmpty()) {
			int popVal = stack.pop();
			if (stack.isEmpty()) {
				bufStack.push(popVal);
			} else {

				int currTop = stack.peek();

				if (popVal < currTop) {
					bufStack.push(popVal);
				} else {
					bufStack.push(stack.pop());
					stack.push(popVal);
				}
			}
		}
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
