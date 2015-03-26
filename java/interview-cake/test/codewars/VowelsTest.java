package codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VowelsTest {

	@Test
	public void testCase1() throws Exception {
		assertEquals("Nope!", 5, Vowels.getCount("abracadabra"));
	}
}
