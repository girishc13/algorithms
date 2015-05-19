package amazon.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Please note the approved languages:
 * 
 * Java C C++ Python Javascript Ruby C#
 * 
 * Write a method that takes an array of integers and returns the product of the
 * most frequent integer and its frequency. For example if the provided array is
 * [1, 2, 3, 3, 4] the method would return 6 because 3 is the most frequent and
 * it occurs twice (3 * 2). If your solution optimizes for time, what would you
 * change about your solution to optimize for space (or vice versa, no need to
 * code).
 * 
 * Your solution will be evaluated on correctness, runtime complexity (big-O),
 * and adherence to coding best practices.
 * 
 * [only show the following for SDE-I and intern candidates]
 * 
 * 1. Document your assumptions 2. Explain your approach and how you intend to
 * solve the problem 3. Provide code comments where applicable 4. Explain the
 * big-O run time complexity of your solution. Justify your answer. 5. List and
 * describe test cases needed to test your solution (no need to code)
 * 
 * @author girish
 *
 */
public class CodingTestImpl {

	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 3, 4 };
		int answer = findProductOfMaxFreqElem(intArray);
		System.out.println("Time Optimized Solution: " + answer);
	}

	private static int findProductOfMaxFreqElem(int[] intArray) {

		if (intArray.length == 0)
			return -1;

		if (intArray.length == 1)
			return intArray[0];

		Map<Integer, Integer> intFreqMap = new HashMap<Integer, Integer>();
		int maxFreqInt = 0, maxFreq = 0;
		int currFreq = 0;
		for (int currInt : intArray) {
			currFreq = calcFreqOfInt(intFreqMap, currInt);
			intFreqMap.put(currInt, currFreq);
			if (currFreq > maxFreq) {
				maxFreq = currFreq;
				maxFreqInt = currInt;
			}
		}

		return maxFreqInt * maxFreq;
	}

	private static int calcFreqOfInt(Map<Integer, Integer> intFreqMap,
			int currNum) {
		int currFreq;
		if (intFreqMap.containsKey(currNum)) {
			currFreq = intFreqMap.get(currNum) + 1;
		} else {
			currFreq = 1;
		}
		return currFreq;
	}
}
