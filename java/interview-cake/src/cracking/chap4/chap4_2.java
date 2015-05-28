package cracking.chap4;

import java.util.LinkedList;

public class chap4_2 {

	public static void main(String[] args) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}

	private static boolean search(Graph g, Node start, Node end) {
		if (start == end)
			return true;

		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(start);
		Node u;

		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v == end)
						return true;
					else {
						v.state = State.Visiting;
						queue.add(v);
					}
				}
				u.state = State.Visited;
			}
		}

		return false;
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
}
