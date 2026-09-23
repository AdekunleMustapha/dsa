package algorithms;

public class BinarySearchTree {

    private static class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;


    public void insert(int dst) {
        this.root = insertHelper(this.root, dst);
    }

    // recursive helper
    private Node insertHelper(Node root, int dst) {
        // return node as the very first node in the tree
        if(root == null) {
            return new Node(dst);
        }


        // dig deeper into the left branch to find a branch with an empty leaf
        if( root.value > dst) {
            root.left = insertHelper(root.left, dst);
        }

        // dig deeper into the right branch to find a branch with an empty leaf
        if (root.value < dst) {
            root.right = insertHelper(root.right, dst);
        }

        // return root node if dst equals the destination node
        return root;
    }

    public void display() {
        displayHelper(this.root);
    }

    // recursive helper, this implements in-order traversal
    private void displayHelper(Node root) {
        // got up a branch when a null leaf is met
        if(root == null) return;

        // go to the deepest value in the left branch
        displayHelper(root.left);
        //display the immediate parent
        System.out.println(root.value);
        // go to the right and display value
        displayHelper(root.right);
    }

    public boolean contains(int dst) {
        if(this.root == null) return false;

        return containsHelper(this.root, dst);
    }

    // recursive helper
    private boolean containsHelper(Node root, int dst) {

        if(root == null) return false; // base condition

        // traverse left
        if(root.value > dst) {
            return containsHelper(root.left, dst);
        }

        // traverse right
        if (root.value < dst){
            return containsHelper(root.right, dst);
        }

        // returns true when destination node has been found
        return true;
    }

    public void remove(int dst) {
        this.root = removeHelper(this.root, dst);
    }

    // recursive helper
    private Node removeHelper(Node root, int dst) {
        if(root == null) return null; // base condition

        // compares the branches
        if(root.value > dst) {
            // accepts the new reconstructed left branch as its new left branch
            root.left = removeHelper(root.left, dst);
        } else if (root.value < dst) {
            // accepts the new reconstructed right branch as its new right branch
            root.right =  removeHelper(root.right, dst);
        } else {
            // checks if it's a leaf node so as to easily swap node with null
            if ((root.left == null) && (root.right == null)) {
                root = null;
            } else if (root.right != null) {
                // gets a successor from the right branch and removes its duplicate down the branch
                root.value = successor(root.right);
                root.right = removeHelper(root.right, root.value);
            } else {
                // gets a predecessor from the left branch and removes its duplicate down the branch
                root.value = predecessor(root.left);
                root.left = removeHelper(root.left, root.value);
            }
        }

        // returns reconstructed root
        return root;
    }

    // gets the lowest value in the right branch
    private int successor(Node root) {
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    // gets the highest value in the left branch
    private int predecessor(Node root) {
        root = root.left;
        while(root.right != null) {
            root = root.right;
        }
        return root.value;
    }
}
