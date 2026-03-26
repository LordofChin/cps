import java.util.*;

class Node
{	
	// constructors and fields as per instuctions.
	String value;
	Node left, right;

	public Node(String value){this.value = value;}
	public Node(String value, Node left, Node right)
	{
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() 
	{
		return this.left == null && this.right == null;	// leaf nodes have neither left nor right children.
	}

	// toString method for debugging
	@Override
	public String toString()
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(this);
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty())
		{
			int levelSize = queue.size();
				
			for (int i = 0; i < levelSize; i++) {
				Node current = queue.poll();
				sb.append(current.value + " ");

				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}

		sb.append("\n");
		}
	return sb.toString();
	}	
}
