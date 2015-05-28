package cracking.chap4;

public class Graph {

	private Node vertices[];
	public int count;

	public Graph() {
		vertices = new Node[6];
		count = 0;
	}

	public Node[] getNodes() {
		return vertices;
	}

	public void addNode(Node n) {
		if (count < 30) {
			vertices[count] = n;
			count++;
		} else {
			System.out.println("Graph full.");
		}
	}
}
