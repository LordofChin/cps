public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(8);
        list.append(10);
        list.append(12);
        list.append(14);

        System.out.println(list);

        list.remove(12);
        System.out.println("After removing 12: " + list);
    
    }
}
