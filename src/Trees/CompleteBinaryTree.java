package Trees;

/**
 * Created by srikar on 04-06-2021.
 */

// Checking if a binary tree is a complete binary tree in Java

// Node creation
class CompleteTreeNode {
    int data;
    CompleteTreeNode left, right;

    CompleteTreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class CompleteBinaryTree {
    CompleteTreeNode root;

    // Count the number of nodes
    int countNumNodes(CompleteTreeNode root) {
        if (root == null)
            return (0);
        return (1 + countNumNodes(root.left) + countNumNodes(root.right));
    }

    // Check for complete binary tree
    boolean checkComplete(CompleteTreeNode root, int index, int numberNodes) {

        // Check if the tree is empty
        if (root == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (checkComplete(root.left, 2 * index + 1, numberNodes)
                && checkComplete(root.right, 2 * index + 2, numberNodes));
    }

    public static void main(String args[]) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        tree.root = new CompleteTreeNode(1);
        tree.root.left = new CompleteTreeNode(2);
        tree.root.right = new CompleteTreeNode(3);
        tree.root.left.right = new CompleteTreeNode(5);
        tree.root.left.left = new CompleteTreeNode(4);
        tree.root.right.left = new CompleteTreeNode(6);

        int node_count = tree.countNumNodes(tree.root);
        int index = 0;

        if (tree.checkComplete(tree.root, index, node_count))
            System.out.println("The tree is a complete binary tree");
        else
            System.out.println("The tree is not a complete binary tree");
    }
}
