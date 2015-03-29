package cracking;

public class Chap1_4 {

	public static void main(String[] args) {
		String str = " Mr John Smith      ";
		System.out.println("Solution 1: " + replaceSpaces(str, 14));
	}

	private static String replaceSpaces(String str, int sentLength) {
		char[] chars = str.toCharArray();
		int arrayIndex = chars.length - 1;
		int sentIndex = sentLength - 1;

		while (arrayIndex >= 0) {
			if (chars[sentIndex] == ' ') {
				chars[arrayIndex--] = '0';
				chars[arrayIndex--] = '2';
				chars[arrayIndex--] = '%';
				sentIndex--;
			} else {
				chars[arrayIndex--] = chars[sentIndex--];
			}
		}

		return new String(chars);
	}
}
