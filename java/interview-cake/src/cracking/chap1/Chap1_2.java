package cracking.chap1;

public class Chap1_2 {

	public static void main(String[] args) {
		String str = "abcde";
		String reversed = reverse(str);
		System.out.println(reversed);
	}

	private static String reverse(String str) {
		StringBuffer revBuffer = new StringBuffer();
		for (int i = str.length() - 1; i >= 0; i--) {
			revBuffer.append(str.charAt(i));
		}
		return revBuffer.toString();
	}
}
