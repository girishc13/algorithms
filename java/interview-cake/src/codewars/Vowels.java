package codewars;

import java.util.Arrays;
import java.util.List;

public class Vowels {

	public static int getCount(String str) {
		int vowelsCount = 0;
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
		for (Character letter : str.toCharArray()) {
			if (vowels.contains(letter)) {
				vowelsCount++;
			}
		}
		return vowelsCount;
	}

}
