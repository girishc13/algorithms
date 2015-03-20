import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InFlightEntertainment {

	public static void main(String[] args) {
		int flightLength = 36;
		List<Integer> movieLengths = Arrays.asList(2, 13, 33, 23, 30, 7, 18);
		bruteForceFind(flightLength, movieLengths);
		System.out.println(checkIfTwoMoviesAreWatchable(flightLength,
				movieLengths));
	}

	private static boolean checkIfTwoMoviesAreWatchable(int flightLength,
			List<Integer> movieLengths) {
		if (movieLengths.isEmpty() || movieLengths.size() == 1)
			return false;

		Map<Integer, Boolean> movieSeen = new HashMap<Integer, Boolean>();

		for (int movieIndex = 0; movieIndex < movieLengths.size(); movieIndex++) {
			int currRunTime = movieLengths.get(movieIndex);

			int runTimeDiff = flightLength - currRunTime;

			if (movieSeen.containsKey(runTimeDiff))
				return true;

			movieSeen.put(currRunTime, true);
		}
		return false;

	}

	private static void bruteForceFind(int flightLength,
			List<Integer> movieLengths) {
		for (int i = 0; i < movieLengths.size(); i++) {
			for (int j = 0; j < movieLengths.size(); j++) {
				if (i == j)
					continue;
				if (movieLengths.get(i) + movieLengths.get(j) == flightLength) {
					System.out.println(movieLengths.get(i) + ", "
							+ movieLengths.get(j));
					break;
				}
			}
		}
	}
}
