package cracking.chap3;

public class Tower {
	private static final int stackCapacity = 5;
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>(stackCapacity);
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to "
				+ t.index());
	}

	public void moveDisks(int n, Tower dest, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, dest);
			moveTopTo(dest);
			buffer.moveDisks(n - 1, dest, this);
		}
	}
}
