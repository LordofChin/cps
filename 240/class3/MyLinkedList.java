class MyLinkedList
{
	private Node head;
	private Node curr;
	private Node tail;
	private int size;

	public MyLinkedList()
	{
		this.head = null;
		this.curr = null;
		this.tail = null;
		this.size = 0;
	}
	
	public MyLinkedList(Object object)
	{
		Node node = new Node(object);
		this.head = node;
		this.curr = node;
		this.tail = node;
		this.size = 1;
	}

	public void setHead(Object object)
	{
		this.curr = this.head;
		this.head = new Node(object);
		this.head.setNext(this.curr);
		this.curr = this.head;
		if (this.tail == null)
		{
			this.tail = this.head;
		}
	}
	public Node getHead()
	{
		return this.head;
	}	
	public void setTail(Node tail)
	{
		if (this.tail != null)
		{
			this.tail.setNext(tail);
		}
		this.tail = tail;
		if (this.head == null)
		{
			this.head = this.tail;
			this.curr = this.head;
		}
	}
	public Node getTail()
	{
		return this.tail;
	}
	public void setCurr(Node curr)
	{
		this.curr = curr;
	}
	public Node getCurr()
	{
		return this.curr;
	}
	public void append(Object object)
	{
		setTail(new Node(object));
	}
	public void prepend(Node node)
	{
		setHead(node);
	}
	public void resetCurr()
	{
		this.curr = this.head;
	}

	public void moveCurrNext()
	{
		if (isCurr())
		{
			this.curr = this.curr.getNext();
		}
	}

	public boolean isCurr()
	{
		return this.curr != null;
	}
	public boolean isEmpty()
	{
		return this.head == null;
	}
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	public void incrementSize()
	{
		this.size++;
	}
	public void decrementSize()
	{
		this.size--;
	}
	public void clear()
	{
		this.head = null;
		this.curr = null;
		this.tail = null;
		this.size = 0;
	}
	public void removeHead()
	{
		if (this.curr == this.head)
		{
			this.head = this.head.getNext();
			this.curr = this.head;
			if (this.head == null)
			{
				this.tail = null;
			}
		}
		else
		{
			Node temp = this.head;
			while (temp != null && temp.getNext() != this.curr)
			{
				temp = temp.getNext();
			}
			if (temp != null)
			{
				temp.setNext(this.curr.getNext());
				if (this.curr == this.tail)
				{
					this.tail = temp;
				}
				this.curr = temp.getNext();
			}
		}
		decrementSize();
	}
	public void remove(Object object)
	{
		this.curr = this.head;
		while (this.curr != null)
		{
			if (this.curr.getData().equals(object))
			{
				removeHead();
				return;
			}
			Node temp = this.curr;
			this.curr = this.curr.getNext();
			if (this.curr.getData().equals(object))
			{
				temp.setNext(this.curr.getNext());
				if (this.curr == this.tail)
				{
					this.tail = temp;
				}
				this.curr = temp.getNext();
				decrementSize();
				return;
			}
		}
	}


	@Override
	public String toString()
	{
		String result = "";
		Node temp = this.head;
		while (temp != null)
		{
			result += temp.toString() + " ";
			temp = temp.getNext();
		}
		return result;
	}

}
