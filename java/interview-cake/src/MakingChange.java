import java.util.Arrays;
import java.util.List;

public class MakingChange {

	public static void main(String[] args) {
		Integer amount = 5;
		List<Integer> denoms = Arrays.asList(1, 2, 3);
		int noOfWays = noOfWays(amount, denoms);
		System.out.println("No of ways: " + noOfWays);
		int noOfWaysDp = nofOfWaysDp(amount, denoms);
		System.out.println("No of ways by DP: " + noOfWaysDp);
	}

	private static int nofOfWaysDp(Integer amount, List<Integer> denoms) {
		int[][] table = new int[amount + 1][denoms.size() + 1];

		for (int i = 0; i < amount + 1; i++) {
			for (int j = 0; j < denoms.size() + 1; j++) {
				if (i == 0)
					table[i][j] = 1;
				else if (j == 0)
					table[i][j] = 0;
				else if (j > i)
					table[i][j] = table[i][j - 1];
				else
					table[i][j] = table[i - j][j] + table[i][j - 1];
			}
		}

		return table[amount][denoms.size()];
	}

	private static int noOfWays(Integer amount, List<Integer> denoms) {
		int amountLeft = amount;
		int numPossibilities = changePossibilitiesTopDown(amountLeft, denoms);
		return numPossibilities;
	}

	private static int changePossibilitiesTopDown(int amountLeft,
			List<Integer> denomsLeft) {
		if (amountLeft == 0)
			return 1;
		if (amountLeft < 0)
			return 0;
		if (denomsLeft.isEmpty())
			return 0;

		int numPossibilities = 0;
		int currDenom = denomsLeft.get(0);
		List<Integer> restOfDenoms = denomsLeft.subList(1, denomsLeft.size());
		while (amountLeft >= 0) {
			numPossibilities += changePossibilitiesTopDown(amountLeft,
					restOfDenoms);
			amountLeft -= currDenom;
		}

		return numPossibilities;
	}
}
