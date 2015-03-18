public class TempTracker {

	Integer[] temps;
	Integer maxSoFar;
	Integer minSoFar;
	Double mean;
	Integer mode;
	Integer totalTemps;
	Integer maxOccurences;
	Double currSum;

	public TempTracker() {
		temps = new Integer[100 + 1];
		mode = 0;
		maxOccurences = 0;

		maxSoFar = Integer.MIN_VALUE;
		minSoFar = Integer.MAX_VALUE;

		totalTemps = 0;
		currSum = new Double(0);
		mean = new Double(0);
	}

	public void insert(int temp) {

		temps[temp] += 1;
		if (temps[temp] > maxOccurences) {
			mode = temp;
			maxOccurences = temps[temp];
		}

		currSum += temp;
		totalTemps = +1;
		mean = currSum / totalTemps;

		if (temp > maxSoFar)
			maxSoFar = temp;
		if (temp < minSoFar)
			minSoFar = temp;
	}

	public Integer getMax() {
		return maxSoFar;
	}

	public Integer getMin() {
		return minSoFar;
	}

	public Double getMean() {
		return mean;
	}

	public Integer getMode() {
		return mode;
	}
}
