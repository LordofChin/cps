public class MyNode <E> {
    private E value;
    private MyNode<E> previous;
    private MyNode<E> next;

    public MyNode () {}
    public MyNode (E value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    public MyNode (E value, MyNode<E> previous, MyNode<E> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public void setValue(E value) {
        this.value = value;
    }
    public void setNext(MyNode<E> next) {
        this.next = next;
    }
    public void setPrevious(MyNode<E> previous) {
        this.previous = previous;
    }

    public E getValue() {
        return this.value;
    }
    public MyNode<E> getNext() {
        return this.next;
    }
    public MyNode<E> getPrevious() {
        return this.previous;
    }

    public void link(MyNode<E> nextNode) {
        this.setNext(nextNode);
        nextNode.setPrevious(this);
    }
    
    public void insert(MyNode<E> prev, MyNode<E> next) {
        if (prev != null) prev.link(this);
        if (next != null) this.link(next);
    }
    
    public void unlink() {
        MyNode<E> prev = this.getPrevious();
        MyNode<E> next = this.getNext();
    
        if (prev != null) {
            prev.setNext(next);
        }
    
        if (next != null) {
            next.setPrevious(prev);
        }
        
        this.setPrevious(null);
        this.setNext(null);
    }

        public boolean hasNext() {
            return this.getNext() != null;
        }

        public boolean hasPrevious() {
            return this.getPrevious() != null;
        }
}
