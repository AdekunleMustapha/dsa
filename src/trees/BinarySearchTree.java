package trees;

import trees.node.Node;

public class BinarySearchTree {

    private Node root;

    public void insert(int dst) {
        this.root = insertHelper(this.root, dst);
    }

    private Node insertHelper(Node root, int dst) {
        if(root == null) {
            return new Node(dst);
        }

        if( root.value > dst) {
            root.left = insertHelper(root.left, dst);
        }

        if (root.value < dst) {
            root.right = insertHelper(root.right, dst);
        }

        return root;
    }

    public void display() {
        displayHelper(this.root);
    }

    private void displayHelper(Node root) {
        if(root == null) return;

        displayHelper(root.left);
        System.out.println(root.value);
        displayHelper(root.right);
    }
}
