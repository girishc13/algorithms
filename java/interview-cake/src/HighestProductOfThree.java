public class HighestProductOfThree {

	public static void main(String[] args) {
		int[] inputArr = { 1, 10, -5, 1, -100 };
		int highestProdOf3 = highestProdOfThree(inputArr);
		System.out.println(highestProdOf3);
	}

	private static int highestProdOfThree(int[] inputArr) {
		if (inputArr.length < 3)
			throw new RuntimeException("Less than three items.");

		int highest = Math.max(inputArr[0], inputArr[1]);
		int lowest = Math.min(inputArr[0], inputArr[1]);

		int highestProdOf2 = inputArr[0] * inputArr[1];
		int lowestProdOf2 = inputArr[0] * inputArr[1];

		int highestProdOf3 = inputArr[0] * inputArr[1] * inputArr[2];

		for (int index = 2; index < inputArr.length; index++) {
			int current = inputArr[index];
			highestProdOf3 = Math
					.max(highestProdOf3,
							Math.max(current * highestProdOf2, current
									* lowestProdOf2));

			highestProdOf2 = Math.max(highestProdOf2,
					Math.max(current * highest, current * lowest));

			lowestProdOf2 = Math.min(lowestProdOf2,
					Math.min(current * highest, current * lowest));

			highest = Math.max(highest, current);
			lowest = Math.min(lowest, current);
		}

		return highestProdOf3;
	}
}
