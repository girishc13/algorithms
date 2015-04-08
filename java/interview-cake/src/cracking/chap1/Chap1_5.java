package cracking.chap1;

public class Chap1_5 {

	public static void main(String[] args) {
		String str = "aabbbcccccaad";
		System.out.println("Solution 1: " + compressString(str));
	}

	private static String compressString(String str) {

		if (str == null || str.length() == 1)
			return str;

		StringBuilder builder = new StringBuilder();
		char prevChar = str.charAt(0);
		int charCount = 1;
		for (int i = 1; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == prevChar) {
				charCount++;
			} else {
				builder.append(prevChar);
				builder.append(charCount);
				prevChar = currChar;
				charCount = 1;
			}
		}

		builder.append(prevChar);
		builder.append(charCount);

		if (str.length() <= builder.toString().length())
			return str;

		return builder.toString();
	}
}
