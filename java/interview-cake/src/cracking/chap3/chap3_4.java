package cracking.chap3;

public class chap3_4 {

	public static void main(String[] args) {
		int nTowers = 3;
		Tower[] towers = new Tower[nTowers];

		for (int i = 0; i < nTowers; i++) {
			towers[i] = new Tower(i);
		}

		for (int i = nTowers - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(nTowers, towers[2], towers[1]);
	}
}
