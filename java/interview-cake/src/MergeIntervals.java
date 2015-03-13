import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {

	class Interval implements Comparable<Interval> {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval other) {
			if (start > other.start)
				return 1;

			if (start < other.start)
				return -1;

			return 0;
		}

		@Override
		public String toString() {
			return "(" + start + ", " + end + ")";
		}
	}

	public static void main(String[] args) {
		List<Interval> intervals = fetchSortedInterval();
		System.out.println("Initial: " + intervals);

		Stack<Interval> s = new Stack<MergeIntervals.Interval>();
		s.push(intervals.get(0));

		for (int i = 0; i < intervals.size(); i++) {
			Interval top = s.peek();
			Interval current = intervals.get(i);

			if (top.end < current.start) {
				s.push(current);
			} else {
				top.end = current.end;
				s.pop();
				s.push(top);
			}
		}

		System.out.println("Merged: " + s);
	}

	private static List<Interval> fetchSortedInterval() {
		List<Interval> intervals = new ArrayList<MergeIntervals.Interval>();
		intervals.add(constructNewInterval(1, 3));
		intervals.add(constructNewInterval(2, 4));
		intervals.add(constructNewInterval(6, 8));
		intervals.add(constructNewInterval(5, 7));
		Collections.sort(intervals);
		return intervals;
	}

	private static Interval constructNewInterval(int start, int end) {
		MergeIntervals mi = new MergeIntervals();
		return mi.new Interval(start, end);
	}
}
