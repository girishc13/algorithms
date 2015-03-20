import java.util.Arrays;
import java.util.List;

public class FindRotationPoint {

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7);
		int rotationPoint = findIndex(array, 0, array.size() - 1);
		System.out.println(rotationPoint);
	}

	private static int findIndex(List<Integer> array, int low, int high) {

		if (high < low)
			return 0;
		if (high == low)
			return low;

		int mid = low + (high - low) / 2;

		if (mid < high && array.get(mid + 1) < array.get(mid))
			return mid + 1;

		if (mid > low && array.get(mid) < array.get(mid - 1))
			return mid;

		if (array.get(high) > array.get(mid))
			return findIndex(array, low, mid - 1);
		return findIndex(array, mid + 1, high);
	}
}
