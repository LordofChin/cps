class Node 
{
	private Object data;
	private Node next;

	public Node()
	{	
		this.data = null;
		this.next = null;
	}
	public Node(Object data)
	{	
		this.data = data;
		this.next = null;
	}

	public void setData(Object data) 
	{
		this.data = data;
	}
	public Object getData()
	{
		return this.data;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}
	public Node getNext()
	{
		return this.next;
	}

	@Override
	public String toString()
	{
		return this.data.toString();
	}
}
