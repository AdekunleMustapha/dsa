package graphs.entities;

/**
 * A node is a class that serves as a vertices
 * Basically just stores the name of the node
 */
public class Node<K> {

    public final K name;

    public Node(K value) {
        this.name = value;
    }
}
