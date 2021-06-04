package Trees;

/**
 * Created by srikar on 04-06-2021.
 */

// Checking if a binary tree is a full binary tree in Java

class FullTreeNode {
    int data;
    FullTreeNode leftChild, rightChild;

    FullTreeNode(int item) {
        data = item;
        leftChild = rightChild = null;
    }
}

class FullBinaryTree {
    FullTreeNode root;

    // Check for Full Binary Tree
    boolean isFullBinaryTree(FullTreeNode node) {

        // Checking tree emptiness
        if (node == null)
            return true;

        // Checking the children
        if (node.leftChild == null && node.rightChild == null)
            return true;

        if ((node.leftChild != null) && (node.rightChild != null))
            return (isFullBinaryTree(node.leftChild) && isFullBinaryTree(node.rightChild));

        return false;
    }

    public static void main(String args[]) {
        FullBinaryTree tree = new FullBinaryTree();
        tree.root = new FullTreeNode(1);
        tree.root.leftChild = new FullTreeNode(2);
        tree.root.rightChild = new FullTreeNode(3);
        tree.root.leftChild.leftChild = new FullTreeNode(4);
        tree.root.leftChild.rightChild = new FullTreeNode(5);
        tree.root.rightChild.leftChild = new FullTreeNode(6);
        tree.root.rightChild.rightChild = new FullTreeNode(7);

        if (tree.isFullBinaryTree(tree.root))
            System.out.print("The tree is a full binary tree");
        else
            System.out.print("The tree is not a full binary tree");
    }
}