package structures;

/**
 * To achieve a singly linked list, I employed the use a class as my node
 * With a big(O) notation of (n) when iterating through elements and less advantages compared
 * to random access of data unlike arrays
 * So the node contains the data of the element and the class of the next node, it's
 * my make do for a pointer to a new variable. These nodes are encapsulated in the class
 *
 */
public class SinglyLinkedList<T> {

    //Internal node used for each element
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    public int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Creates a new node for such data, checks if head node has been created
     * or if it is meant to append to the next node, then increases size
     */
    public void appendLast (T data) {
        Node<T> node = new Node<T>(data);
        if(isEmpty()) {
            this.head = node;
        } else {
            Node<T> n = this.head;
            while(n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        ++size;
    }

    /**
     * Appends as the first data then shifts the head to the second data
     */
    public void appendFirst (T data) {
        Node<T> node = new Node<T>(data);
        if(isEmpty()) {
            this.head = node;
        } else {
            Node<T> nextNode = this.head;
            this.head = node;
            node.next = nextNode;
        }
        ++size;
    }

    /**
     * Inserts a node into a specified index by breaking the link between two nodes
     * puts the prior nodes next direction to the newly created one and the newly created ond
     * directs to the already done next
     */
    public void insert (T data, int index) {
        if((this.size - 1 < index) || (index < 0)) {
            return;
        }
        Node<T> n = this.head;

        for(int i = 0; i < size; ++i) {
            if(i == index) {
                Node<T> newNode = new Node<T>(data);
                Node<T> nextNode = n.next;
                n.next = newNode;
                newNode.next = nextNode;
            } else {
                n = n.next;
            }
        }
        ++size;
    }

    /**
     * Swaps the head of a node for its next as the new head
     */
    public void removeHead () {
        Node<T> node = this.head;
        this.head = node.next;
        --size;
    }

    /**
     * Loops to the end node that still has a next and removes the next
     */
    public void removeTail () {
        Node<T> node = this.head;
        while(node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        --size;
    }

    /**
     * Removes a node by index, by looping through the list
     * and changing the address of prior node's next into deleted node's next
     */
    public void removeByIndex (int index) {
        Node<T> n = this.head;
        for(int i = 0; i < size; i++) {
            if(i + 1 == index) {
                Node<T> deletedNode = n.next;
                n.next = deletedNode.next;
            } else {
                n = n.next;
            }
        }
        --size;
    }

    /**
     * Gets the data in a node by its index by its index
     */
    public T getByIndex(int index) {
        Node<T> n = this.head;
        for(int i = 0; i < size; i++) {
            if(index == i) {
                return n.data;
            } else {
                n = n.next;
            }
        }
        return n.data;
    }

    public T getHead () {
        return this.head.data;
    }

    public T getTail() {
        Node<T> n = this.head;
        while(n.next != null) {
            n = n.next;
        }
        return n.data;
    }

    @Override
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
        return size == 0;
    }
}
