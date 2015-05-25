package cracking.chap3;

public class Stack<T> {

	private Node top, bottom;
	private int size;
	private int capacity;

	public Stack(int capacity) {
		top = null;
		size = 0;
		this.capacity = capacity;
	}

	public int size() {
		return size;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (top != null) {
			T item = (T) top.data;
			top = top.below;
			size--;
			return item;
		}
		return null;
	}

	public boolean push(Integer item) {
		if (isFull())
			return false;

		size++;
		Node temp = new Node(item);
		if (size == 1)
			bottom = temp;
		join(temp, top);
		top = temp;
		return true;
	}

	private void join(Node above, Node below) {
		if (below != null)
			below.above = above;
		if (above != null)
			above.below = below;
	}

	@SuppressWarnings("unchecked")
	T peek() {
		return (T) top.data;
	}

	@SuppressWarnings("unchecked")
	public T removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null)
			bottom.below = null;
		size--;
		return (T) b.data;
	}

	public void printStack() {
		Node currTop = top;
		while (currTop != null) {
			System.out.println(currTop.data);
			currTop = currTop.below;
		}
	}
}
