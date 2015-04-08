package cracking.chap1;

public class Chap1_1 {

	public static void main(String[] args) {
		String str = "abcde";
		Boolean isUnique = isUniqueChars(str);
		System.out.println(isUnique);
	}

	private static Boolean isUniqueChars(String str) {
		if (str.length() > 128)
			return false;

		boolean[] char_seen = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_seen[val])
				return false;

			char_seen[val] = true;
		}

		return true;
	}
}
