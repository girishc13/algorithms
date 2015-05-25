package cracking.chap3;

import java.util.ArrayList;
import java.util.List;

public class SetsOfStacks {

	private static final int stackCapacity = 2;
	List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

	public void push(Object item) {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack != null && !lastStack.isFull()) {
			lastStack.push((Integer) item);
		} else {
			Stack<Integer> newStack = new Stack<Integer>(stackCapacity);
			newStack.push((Integer) item);
			stacks.add(newStack);
		}
	}

	public Integer pop() {
		Stack<Integer> lastStack = getLastStack();
		Integer item = lastStack.pop();
		if (lastStack.isEmpty()) {
			stacks.remove(stacks.size() - 1);
		}
		return item;
	}

	private Stack<Integer> getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
}
