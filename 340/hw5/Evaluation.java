import java.util.*;											// because I'm gangsta.

class Evaluation 
{
    static Node buildTree(Scanner sc) {
        if (!sc.hasNext()) return null;
        // read the next value, assumed to be an integer.
		// integers are all leaf nodes.
        try {
			int value = sc.nextInt();						// non-integer values will throw an exception, which we will catch to build operator nodes.
			//System.out.println("Read number: " + value);	// debug line
            return new Node( Integer.toString(value) );
        } catch (InputMismatchException e) { 				// if it's not an integer, it must be an operator
            // when the next value is an operator, build left and right subtrees
			// all binary operators have right and left subtrees.
			String op = sc.next();
			//System.out.println("Read operator: " + op);	// debug line
            Node left = buildTree(sc);
            Node right = buildTree(sc);
            return new Node(op, left, right);
        }
    }

	// methods to print the expression in infix, prefix, and postfix notation
	static void infix(Node node) 							// left, root, right
	{
		if (node.isLeaf()) 
		{
			System.out.print(node.value + " ");				// base case: if leaf, print value
		} else {
			System.out.print("( ");
			infix(node.left);								// left
			System.out.print(node.value + " ");				// root
			infix(node.right);								// right
			System.out.print(") ");
		}
	}
	static void prefix(Node node)							// root, left, right
	{
		if (node.isLeaf()) 
		{
			System.out.print(node.value + " ");				// base case: if leaf, print value
		} else {
			System.out.print(node.value + " ");				// root
			prefix(node.left);								// left	
			prefix(node.right);								// right
		}
	}	
	static void postfix(Node node)							// left, right, root
	{
		if (node.isLeaf()) 
		{
			System.out.print(node.value + " ");				// base case: if leaf, print value
		} else {
			postfix(node.left);								// left
			postfix(node.right);							// right
			System.out.print(node.value + " ");				// root
		}
	}

	// method to evaluate the expression tree and return the result as an integer.
	static int evaluation(Node node)
	{
		if (node.isLeaf()) 
		{
			return Integer.parseInt(node.value);			// base case: if leaf, return value as integer
		} else {
			int left = evaluation(node.left);				// evaluate left subtree before evaluating root node operation.
			int right = evaluation(node.right);				// evaluate right subtree before evaulating root node operation.
			switch (node.value) {							// switch case to evaluate allowed operators.
				case "+": return left + right;	
				case "-": return left - right;
				case "*": return left * right;
				case "/": return left / right;
				case "%": return left % right;
				default: throw new IllegalArgumentException(node.value);	// throws an exception if operator is not recognized.
			}
		}
	}
	
	public static void main(String [] args)
	{
		// get user input
		System.out.println("Enter a prefix expression: ");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\\s+");					// use whitespaces. using spaces alone does not suffice for edge cases or values before line feeds ex: + 3 5\n
	
		// build the expression tree
		Node root = buildTree(sc);

		// print the expression in infix, prefix, and postfix notation, and evaluate the expression tree.
		System.out.println("\nprefix expession:");
		prefix(root);
		System.out.println("\npostfix expession:");
		postfix(root);
		System.out.println("\ninfix expession:");
		infix(root);
		System.out.println("\nResult = " + evaluation(root));
		
		//System.out.println(root);							// debug line
	}
}
