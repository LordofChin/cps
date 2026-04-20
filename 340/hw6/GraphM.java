/*  GraphM.java
	CPS 340, HW 6
    Dr. Liao
    Implement a graph data structure using the adjacency matrix representation and 
	implement graph traversal algorithms: DFS and BFS, both iteratively and recursively.
*/

import java.util.*;

public class GraphM {
	public List<Node> nodes = new ArrayList<Node>(); // nodes in graph
	public int[][] adjMatrix; // adjacency Matrix

	public void addNode(Node n) {
		nodes.add(n);
	}

	// This method connects two nodes (undirected graph)
	public void connectNode(Node src, Node dst) {
		// initialize adjMatrix if it's null
		if (adjMatrix == null) {
			adjMatrix = new int[nodes.size()][nodes.size()]; // instantiate adjMatrix with size of nodes list
		}
		int srci = nodes.indexOf(src);
		int dsti = nodes.indexOf(dst);
		adjMatrix[srci][dsti] = 1;							// add dest index to source adj matrix
		adjMatrix[dsti][srci] = 1;							// add src index to dest adj matrix 
	}

	// helper method to get one unvisited neighbor node
	public Node getUnvisitedNeighbor(Node n) {
		List<Node> neighbors = getNeighbors(n);
		for (Node node : neighbors)
			if (!node.visited)
				return node;
		return null;
	}

	// get all neighboring nodes of node n.
	public List<Node> getNeighbors(Node n) {
		int i = nodes.indexOf(n);							// only search node n's column
		List<Node> neighbors = new ArrayList<Node>();
		if (adjMatrix != null) {
			for (int j = 0; j < adjMatrix[i].length; j++)
				if (adjMatrix[i][j] == 1)					// add all rows with 1m present
					neighbors.add(nodes.get(j));			
		}
		return neighbors;
		
	}

	// Helper methods for clearing visited property of node
	private void reset() {
		for (Node n : nodes)
			n.visited = false;
	}

	// Helper methods for printing the node label
	private void printNode(Node n) {
		System.out.print(n.label + " ");
	}

	// All serach methods are identical to GraphL.java

	// DFS traversal (iterative version)
	public void dfs1(Node node) {
		// DFS uses a Stack data structure		
		Stack<Node> s = new Stack<Node>();
		s.push(node);
		while (!s.isEmpty()) {
			Node n = s.pop();							// pop a node from the stack
			if (!n.visited) {							// check if it has been visited
				printNode(n);							// print popped node
				n.visited = true;						// block all visited nodes from being printed
				List<Node> neighbors = getNeighbors(n);
				for (Node neighbor : neighbors)			
					if (!neighbor.visited)				// only print unvisited neihbors
						s.push(neighbor);				// push all neighbors
			}
		}
	}

	// DFS traversal (recursive version)
	public void dfs2(Node node) {
		if (!node.visited) {							// check if node has been visited
			printNode(node);							// print node
			node.visited = true;						// block all visited nodes from being printed
			List<Node> neighbors = getNeighbors(node);
			for (Node neighbor : neighbors)
				if (!neighbor.visited)					// only print unvisited neihbors
					dfs2(neighbor);						// recursively call dfs2 on all neighbors
		}
	}

	// BFS traversal (iterative version)
	public void bfs1(Node node) {
		// BFS uses a Queue data structure
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while (!q.isEmpty()) {
			Node n = q.poll();				// poll a node from the queue
			if (!n.visited) {
				printNode(n);				
				n.visited = true;			// block all visited nodes from being printed
				List<Node> neighbors = getNeighbors(n);
				for (Node neighbor : neighbors)
					if (!neighbor.visited)
						q.add(neighbor);
			}
		}
	}

	// BFS traversal (recursive version)
	public void bfs2(Queue<Node> q) {
		if (!q.isEmpty()) {
			Node n = q.poll();
			if (!n.visited) {
				printNode(n);
				n.visited = true;
				List<Node> neighbors = getNeighbors(n);
				for (Node neighbor : neighbors)
					if (!neighbor.visited)
						q.add(neighbor);
			}
			bfs2(q); // recursively call bfs2 on the queue
		}
	}

	// A simple Node class
	static class Node {
		public char label;
		public boolean visited = false;

		public Node(char label) {
			this.label = label;
		}
	}

	// Test everything
	public static void main(String[] args) {
		// Let's create a few nodes
		Node n0 = new Node('A');
		Node n1 = new Node('B');
		Node n2 = new Node('C');
		Node n3 = new Node('D');
		Node n4 = new Node('E');
		Node n5 = new Node('F');
		Node n6 = new Node('G');
		Node n7 = new Node('H');
		Node n8 = new Node('I');

		// Create the graph (by adding nodes and edges between nodes)
		GraphM g = new GraphM();
		g.addNode(n0);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.addNode(n8);

		g.connectNode(n0, n1);
		g.connectNode(n0, n3);
		g.connectNode(n0, n8);
		g.connectNode(n1, n7);
		g.connectNode(n2, n7);
		g.connectNode(n2, n3);
		g.connectNode(n3, n4);
		g.connectNode(n4, n8);
		g.connectNode(n5, n6);
		g.connectNode(n5, n2);

		// Perform the DFS and BFS traversal of the graph
		for (Node n : g.nodes) {
			System.out.print("From node ");
			g.printNode(n);

			System.out.print("\nDFS (iterative): ");
			g.dfs1(n);
			g.reset();

			System.out.print("\nDFS (recursive): ");
			g.dfs2(n);
			g.reset();

			System.out.print("\nBFS (iterative): ");
			g.bfs1(n);
			g.reset();

			System.out.print("\nBFS (recursive): ");
			Queue<Node> q = new LinkedList<Node>();
			q.add(n);
			g.bfs2(q);
			g.reset();
			System.out.println("\n");
		}
	}
}