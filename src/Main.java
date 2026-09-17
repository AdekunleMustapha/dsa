import graphs.algorithms.AdjacencyList;
import graphs.algorithms.AdjacencyMatrix;
import graphs.interfaces.IGraph;

public class Main {

    public static void main(String[] args) {
        IGraph<Character> graph = new AdjacencyMatrix<>();

        // add nodes
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');
        graph.addNode('F');

        // create edges
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'F');
        graph.addEdge('C', 'E');
        graph.addEdge('E', 'B');

        // test results
        System.out.println(graph.checkEdge('A', 'B'));
        System.out.println(graph.checkEdge('B', 'C'));
        System.out.println(graph.checkEdge('A', 'C'));
        System.out.println(graph.checkEdge('a', 'b'));

        graph.depthFirstSearch('A');
    }

    public static int indexOf(long[] arr, long target) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(target ==  arr[i]) return i;
        }
        return -1;
    }

    /**
     * Practicing recursion, good due to simpler code but bad because it eats memory
     * Useful for learning merge sort and quick sort
     */
    public static int factorial(int number){

        if(number == 1) return 1;

        return number * factorial(number - 1);
    }
}
