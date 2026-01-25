// MyNode.java makes more sense being its own dedicated file
public class MyNode <E> {
    // reuired fields
    private E value;
    private MyNode<E> next;

    // constructors

    // default constructor
    public MyNode () {
        this.value = null;
        this.next = null;
    }

    // parameterized constructors
    public MyNode (E value) {
        this.value = value;
        this.next = null;
    }
    public MyNode (E value, MyNode<E> next) {
        this.value = value;
        this.next = next;
    }

    // getters and setters
    public void setValue(E value) {
        this.value = value;
    }
    public void setNext(MyNode<E> next) {
        this.next = next;
    }
    public E getValue() {
        return this.value;
    }
    public MyNode<E> getNext() {
        return this.next;
    }

    // helper methods
    public void link(MyNode<E> next) { // inserts next MyNode after this MyNode
        next.setNext(this.getNext());
        this.setNext(next);
    }
    
    public void insert(MyNode<E> previous) { // inserts this MyNode after prvious MyNode
        this.setNext(previous.getNext());
        previous.setNext(this);
    }
    
    public void unlink(MyNode<E> previous) {
        previous.setNext(this.getNext());
    }

    public boolean hasNext() {
        return this.getNext() != null;
    }

    // toString method
    @Override 
    public String toString() {
        return value.toString();
    }
}
