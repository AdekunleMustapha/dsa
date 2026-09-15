package graphs.interfaces;

/**
 * IGraph that serves as a building block for how
 * Depth First Search and Breadth First Search algorithms work
 * This interface is meant to be a contract on how adjacency matrix and list
 * show their graph representation of vertices (nodes) and edges
 * @param <K>
 */
public interface IGraph<K> {

    void addNode(K Node);

    boolean addEdge(K src, K dst);

    boolean checkEdge(K src, K dst);

    boolean removeEdge(K src, K dst);

    @Override()
    String toString();
}
