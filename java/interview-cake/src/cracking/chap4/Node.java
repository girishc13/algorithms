package cracking.chap4;

public class Node {

	private Node adjacent[];
	public int adjacentCount;
	private String vertex;
	public State state;

	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}

	public Node[] getAdjacent() {
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < 30) {
			this.adjacent[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.print("No more adjacent can be added");
		}
	}
}
