import graphs.algorithms.AdjacencyList;
import graphs.algorithms.AdjacencyMatrix;
import graphs.interfaces.IGraph;
import trees.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(3);
        tree.insert(9);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);

        tree.display();
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
