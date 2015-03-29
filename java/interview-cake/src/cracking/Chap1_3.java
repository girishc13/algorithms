package cracking;

import java.util.Arrays;

public class Chap1_3 {

	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "abdec";

		System.out.println("Solution 1: " + checkPermutation(str1, str2));
		System.out.println("Book Solution: " + permutation(str1, str2));
	}

	private static boolean permutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] letters = new int[128];
		for (Character c : str1.toCharArray()) {
			letters[c]++;
		}

		for (Character c : str2.toCharArray()) {
			if (--letters[c] < 0)
				return false;
		}

		return true;
	}

	private static boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		return sort(str1).equals(sort(str2));
	}

	private static String sort(String str1) {
		char[] chars = str1.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
