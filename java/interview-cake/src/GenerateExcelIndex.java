public class GenerateExcelIndex {

	public static void main(String[] args) {
		int index = 0;
		String colLetters = calculateColLetters(index);
		System.out.println("Index: " + index + ", ColLetters: " + colLetters);
	}

	private static String calculateColLetters(int index) {
		String colLetters = "";
		while (index >= 0) {
			colLetters = (char) ((index % 26) + 64) + colLetters;
			index = (index / 26) - 1;
		}

		return colLetters;
	}
}
