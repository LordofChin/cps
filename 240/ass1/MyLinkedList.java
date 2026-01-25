public class MyLinkedList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size = 0;

    // constructor
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // helper methods
    public void add(E e) {
        MyNode<E> newNode = new MyNode<>(e);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.link(newNode);
            tail = newNode;
        }
        size++;
    }

    public void insert(int index, E e) {
        if (index == 0 && head == null) {
            add(e); // add already handles empty case
            return;
        }

        MyNode<E> prev = get(index - 1);
        MyNode<E> newNode = new MyNode<>(e);
        newNode.insert(prev);

        if (prev == null) head = newNode;
        size++;
    }

    public void set(int index, E e) {
        MyNode<E> currNode = get(index);
        currNode.setValue(e);
    }

    public void remove(int index) {
        MyNode<E> prev = get(index-1);
        MyNode<E> currNode = get(index);
        MyNode<E> next = currNode.getNext();
        
        prev.setNext(next);
        size--;
    }

    public MyNode<E> get(int index) {
        MyNode<E> currNode = head;
        for (int i = 0; i < index; ++i) {
            if (currNode == null) throw new IndexOutOfBoundsException();
            currNode = currNode.getNext();
        }
        return currNode;
    }

    // setters and getters
    public int size() {
        return size;
    }

    public MyNode<E> getHead() {
        return head;
    }
    public MyNode<E> getTail() {
        return tail;
    }

    public void setHead(MyNode<E> head) {
        this.head = head;
    }
    public void setTail(MyNode<E> tail) {
        this.tail = tail;
    }

    public void print() {
        System.out.println(this.toString()); // YAYYYYYY!
    }

    //to string method as asked
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size; i ++)
            sb.append(get(i) + ((i == this.size-1) ? "" : "\n"));
        return sb.toString();
    }
}
