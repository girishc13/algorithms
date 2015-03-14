public class GenerateIndexFromExcelColName {
	public static void main(String[] args) {
		String colLetter = "AAA";
		int index = calcColIndex(colLetter);
		System.out.println("Index: " + index);
	}

	private static int calcColIndex(String colLetter) {
		int index = 0;
		for (int i = 0; i < colLetter.length(); i++) {
			index *= 26;
			index += colLetter.charAt(i) - 'A' + 1;
		}
		return index - 1;
	}
}
