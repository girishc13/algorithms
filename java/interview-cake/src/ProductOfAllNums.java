public class ProductOfAllNums {

	public static void main(String[] args) {
		int[] input = { 1, 7, 3, 4 };
		int[] output = getProductsOfAllIntsExceptAtIndex(input);
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	private static int[] getProductsOfAllIntsExceptAtIndex(int[] input) {
		int prod_so_far = 1;
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = prod_so_far;
			prod_so_far *= input[i];
		}

		prod_so_far = 1;
		for (int i = output.length - 1; i >= 0; i--) {
			output[i] = prod_so_far * output[i];
			prod_so_far *= input[i];
		}

		return output;
	}
}
