package graphs.algorithms;

import graphs.interfaces.IGraph;

import java.util.ArrayList;

/**
 * Adjacency matrix, a graph interface implementation that used to represent how
 * vertices / edges relationship work by using matrices, add nodes(vertices) to the
 * matrix which increases the 2 dimension size linearly, to add an edge to two nodes
 * just indicate the nodes by putting in their index and thus a connection is made, likewise
 * method for removing an edge, it is a directed graph i.e [0][3] edge is not the same as [3][0]
 *
 * It has an insertion time of O(1) and has a lookup time of O(1)
 * But has a space complexity of O(n^2), it eats up space due to the 2-d array to represent a matrix
 *
 * @param <K> vertice/node
 */
public class AdjacencyMatrix<K> implements IGraph<K> {

    private boolean matrix[][]; // C-type declaration intentional, just for fun
    private final ArrayList<K> vertices = new ArrayList<K>();
    private int size; // number of nodes (vertices)

    @Override
    public void addNode(K node) {
        this.vertices.add(node);
        ++size;
        this.matrix = new boolean[size][size];
    }

    @Override
    public boolean addEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);
        int dstIndex = this.vertices.indexOf(dst);

        if((srcIndex == -1) || (dstIndex == -1)) return false;

        this.matrix[srcIndex][dstIndex] = true;

        return true;
    }

    @Override
    public boolean checkEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);
        int dstIndex = this.vertices.indexOf(dst);

        if((srcIndex == -1) || (dstIndex == -1)) return false;

        return this.matrix[srcIndex][dstIndex];
    }

    @Override
    public boolean removeEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);
        int dstIndex = this.vertices.indexOf(dst);

        if((srcIndex == -1) || (dstIndex == -1)) return false;

        this.matrix[srcIndex][dstIndex] = false;

        return true;
    }

    @Override
    public void depthFirstSearch(K src) {
        // each index in the visited array represents the vertices
        boolean[] visited = new boolean[size];
        dfsHelper(src, visited);
    }

    /**
     * Using the advantage of call stack for search; by using
     * recursion
     */
    private void dfsHelper(K src, boolean[] visited) {
        // check if node has been visited, by checking the visited boolean array
        int indexOfSrc = vertices.indexOf(src);

        // if found as true; visited
        if(visited[indexOfSrc]) {
            return; // base case
        } else {
            // mark as visited
            visited[indexOfSrc] = true;
        }

        // tell the node visited
        System.out.println(src + " visited");

        for(int i = 0; i < matrix[indexOfSrc].length; i++) {
            if(matrix[indexOfSrc][i]) {
                K nextSrc = vertices.get(i);
                dfsHelper(nextSrc, visited);
            }
        }
    }

    @Override
    public void breadthFirstSearch(K src) {

    }
}
