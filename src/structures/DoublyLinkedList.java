package structures;

/**
 * Enhancement of singly linked list that now has big(O) notation of O(1)
 * when adding an element to the tail of the list, as well as being able to iterate front and back
 * through the list unlike singly linked list which can only iterate forwards and has a O(n) when
 * getting the tail; last element
 */
public class DoublyLinkedList <T>{

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node() {
            this.data = null;
            this.next = null;
            this.prev = null;
        }

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void addLast(T data) {
        Node<T> n = new Node<T>(data);
        if(isEmpty()) {
            this.head = n;
            this.tail = this.head;
        } else  {
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
        ++size;
    }

    public void addFirst(T data) {
        Node<T> n = new Node<T>(data);
        if(isEmpty()) {
            this.head = n;
            this.tail = this.head;
        } else  {
            this.head.prev = n;
            n.next = this.head;
            this.head = n;
        }
        ++size;
    }

    public boolean removeLast() {
        if(isEmpty()) return false;

        Node<T> n = this.tail.prev;
        n.next = null;
        this.tail = n;
        --size;
        return true;
    }

    public boolean removeFirst() {
        if(isEmpty()) return false;

        Node<T> n = this.head.next;
        n.prev = null;
        this.head = n;
        --size;
        return true;
    }

    public boolean removeAt(int index) {
        if(isEmpty()) return false;

        if(index == 0) return this.removeFirst();

        Node<T> n = this.head;
        for(int i = 0; i < index; i++) {
            n = n.next;
        }
        Node<T> prevNode = n.prev;
        Node<T> nextNode = n.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        --size;
        return true;
    }

    public T getLast() {
        return this.tail.data;
    }

    public T getFirst() {
        return this.head.data;
    }

    @Override()
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> n = this.head;
        while(n.next != null) {
            stringBuilder.append(n.data).append(", ");
            n = n.next;
        }
        stringBuilder.append(n.data).append("]");
        return stringBuilder.toString();
    }

    private boolean isEmpty() {
        return this.size == 0;
    }
}
