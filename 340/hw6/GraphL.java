/*  GraphL.java
	CPS 340, HW 6
    Dr. Liao
	Implement a graph data structure using the adjacency list representation and 
	implement graph traversal algorithms: DFS and BFS, both iteratively and recursively.
 */

import java.util.*;

public class GraphL {
	public List<Node> nodes = new ArrayList<Node>(); // nodes in graph
	public Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>(); // adjacency list: srcNodeIndex --> dstNodeIndex1, dstNodeIndex2, ...

	public void addNode(Node n) {
		nodes.add(n);
	}

	// This method connects two nodes (undirected graph)
	public void connectNode(Node src, Node dst) {
		int srci = nodes.indexOf(src);
		int dsti = nodes.indexOf(dst);

		if (!adjList.containsKey(srci))
			adjList.put(srci, new ArrayList<Integer>()); // create an array list for source node if it does not exist
		if (!adjList.containsKey(dsti))
			adjList.put(dsti, new ArrayList<Integer>()); // create an array list for dest node if it does not exist
		adjList.get(srci).add(dsti);					 // add dest index to source adj list
		adjList.get(dsti).add(srci);					 // add src index to dest adj list 

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
		int i = nodes.indexOf(n);
		List<Node> neighbors = new ArrayList<Node>();
		if (adjList.containsKey(i)) {
			for (Integer neighborIndex : adjList.get(i))
				neighbors.add(nodes.get(neighborIndex));
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
		Node n0 = new Node('0');
		Node n1 = new Node('1');
		Node n2 = new Node('2');
		Node n3 = new Node('3');
		Node n4 = new Node('4');
		Node n5 = new Node('5');
		Node n6 = new Node('6');
		Node n7 = new Node('7');
		Node n8 = new Node('8');

		// Create the graph (by adding nodes and edges between nodes)
		GraphL g = new GraphL();
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