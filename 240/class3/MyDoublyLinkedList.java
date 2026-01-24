import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private static int size = 0;

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

    public void add(int index, E e) {
        if (index == 0 && head == null) {
            add(e);
            return;
        }

        MyNode<E> currNode = get(index);
        MyNode<E> prev = currNode.getPrevious();
        MyNode<E> newNode = new MyNode<>(e);
        newNode.insert(prev, currNode);

        if (prev == null) head = newNode;
        size++;
    }

    public void set(int index, E e) {
        MyNode<E> currNode = get(index);
        currNode.setValue(e);
    }

    public void remove(int index) {
        MyNode<E> currNode = get(index);
        MyNode<E> prev = currNode.getPrevious();
        MyNode<E> next = currNode.getNext();

        if (prev != null) prev.setNext(next);
        else head = next;

        if (next != null) next.setPrevious(prev);
        else tail = prev;
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

    public int size() {
        return size;
    }

    public void removeAround(int index) {
        if (index + 1 == this.size())  { 
            for (int i = 0; i < 2; i++) { 
                if (this.size() > 0) this.remove(index-1); //remove item and surrounding items for last item 
                } 
        } else if (index == 0) { 
            this.remove(index); this.remove(index); //remove item and surrounding items for first item 
        } else { 
            this.remove(index - 1); this.remove(index- 1); this.remove(index- 1); //remove item and surrounding items for surrounded items 
        }
    }

    public ListIterator<E> iterator() {
        return new MyListIterator();
    }

    public class MyListIterator implements ListIterator<E> {
        private MyNode<E> currNode;
        public int index = -1;

        public boolean hasNext() {
            return (currNode != null) ? currNode.hasNext() : head != null;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            currNode = (currNode == null) ? head : currNode.getNext();
            index++;
            return currNode.getValue();
        }

        public boolean hasPrevious() {
            return (currNode != null && currNode.hasPrevious());
        }

        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            currNode = currNode.getPrevious();
            index--;
            return currNode.getValue();
        }

        public int nextIndex() {
            return index + 1;
        }

        public int previousIndex() {
            return index - 1;
        }


        public void remove() {
            if (currNode == null) throw new IllegalStateException("Must call next() or previous() first");

            MyNode<E> prev = currNode.getPrevious();
            MyNode<E> next = currNode.getNext();

            if (prev != null) prev.setNext(next);
            else head = next;

            if (next != null) next.setPrevious(prev);
            else tail = prev;

            currNode = prev;
            index--;
            size--;
        }

        public void set(E e) {
            if (currNode == null) throw new IllegalStateException();
            currNode.setValue(e);
        }

        public void add(E e) {
            MyNode<E> newNode = new MyNode<>(e);
            MyNode<E> next = (currNode != null) ? currNode.getNext() : head;
            newNode.insert(currNode, next);

            if (currNode == null) head = newNode;
            if (next == null) tail = newNode;

            currNode = newNode;
            index++;
            size--;
        }
    }
}
