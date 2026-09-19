package graphs.algorithms;

import graphs.entities.Node;
import graphs.interfaces.IGraph;

import java.util.*;

/**
 * Another directed graph that connects nodes(vertices) by implementation
 * of arraylist for dynamic resize & entry of vertices, as well as use of
 * linked list for edging of vertices, since it is used with linked list;
 * it very well helps with directional graphing
 *
 * Ideally adjacency list has:
 * Insertion - big O(v), where v represents number of vertices
 * Space complexity - big O(v + e), where e represents edges
 *
 * My implementation is not the ideal type, it's just meant to mirror
 * how the foundation of adjacency list works
 *
 * @param <K> value of node
 */
public class AdjacencyList<K> implements IGraph<K> {

    private final ArrayList<LinkedList<Node<K>>> arrayList = new ArrayList<>();
    private final ArrayList<K> vertices = new ArrayList<>();

    /** Adds edges by adding the dst node to the
     * last element in the src index-linked list
     **/
    @Override
    public boolean addEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);
        int dstIndex = this.vertices.indexOf(dst);

        if((srcIndex == -1) || (dstIndex == -1)) return false;

        LinkedList<Node<K>> currentList = this.arrayList.get(srcIndex);
        Node<K> dstNode = this.arrayList.get(dstIndex).getFirst();

        currentList.addLast(dstNode);
        return true;
    }

    /**
     * Adds a node as a new element in vertices array
     * as well as a new linked list in the array list
     */
    @Override
    public void addNode(K value) {
        //if vertice exists return nothing
        if(this.vertices.contains(value)) return;

        // create node from value
        Node<K> node = new Node<>(value);

        // create new linked list for node possible directions
        LinkedList<Node<K>> newList = new LinkedList<>();

        // make node the first node, representing the src node
        newList.add(node);

        // add linked list to array
        this.arrayList.add(newList);

        // add to vertices in array
        this.vertices.add(value);
    }

    /**
     * Check if a node has an edge by checking through the linked list
     * for a matching dst object from src linked list
     */
    @Override
    public boolean checkEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);
        int dstIndex = this.vertices.indexOf(dst);

        if((srcIndex == -1) || (dstIndex == -1)) return false;

        LinkedList<Node<K>> currentList = this.arrayList.get(srcIndex);
        Node<K> target = this.arrayList.get(dstIndex).getFirst();

        // use of java.util.Object.equals() will not work
        for(Node<K> dstNode : currentList) {
            if(dstNode == target) return true;
        }

        return false;
    }

    /**
     * Removes the last element in the linked list of the src array list index
     */
    @Override
    public boolean removeEdge(K src, K dst) {
        int srcIndex = this.vertices.indexOf(src);

        if(srcIndex == -1) return false;

        LinkedList<Node<K>> currentList = this.arrayList.get(srcIndex);

        for(Node<K> dstNode : currentList) {
            if(java.util.Objects.equals(dstNode, new Node<K>(dst))) {
                currentList.remove(dstNode);
                return true;
            }
        }

        return false;
    }

    @Override
    public void breadthFirstSearch(K src) {

    }

    /**
     * Using a stack and iterations, rather than call stack
     * with te use of hash sets to mark visited nodes
     */
    @Override
    public void depthFirstSearch(K src) {
        // return nothing for incorrect src
        if(!this.vertices.contains(src)) return;

        //use hashset for unique nodes, to keep track of visited nodes
        Set<K> visited = new HashSet<>();
        // uses stacks for backward tracking
        Stack<K> stack = new Stack<K>();
        stack.push(src);

        while(!stack.isEmpty()) {
            // takes the last element in the stack
            // giving the algorithm right depth first rather than left depth first
            K current = stack.pop();

            // ensures visited nodes are not re-visited
            if(!visited.add(current)) continue;
            visited.add(current);
            System.out.println(current + ": visited");

            // makes the visited node to be the new starting point
            LinkedList<Node<K>> currentList = this.arrayList.get(this.vertices.indexOf(current));

            // add all elements in the current list, before re-iterating
            for(Node<K> next: currentList) {
                stack.push(next.name);
            }
        }
    }
}
