package Trees;

/**
 * Created by srikar on 04-06-2021.
 */

// Checking if a binary tree is height balanced in Java

// Node creation
class BalancedTreeNode {

    int data;
    BalancedTreeNode left, right;

    BalancedTreeNode(int d) {
        data = d;
        left = right = null;
    }
}

// Calculate height
class Height {
    int height = 0;
}

class BalancedBinaryTree {

    BalancedTreeNode root;

    // Check height balance
    boolean checkHeightBalance(BalancedTreeNode root, Height height) {

        // Check for emptiness
        if (root == null) {
            height.height = 0;
            return true;
        }

        Height leftHeighteight = new Height(), rightHeighteight = new Height();
        boolean l = checkHeightBalance(root.left, leftHeighteight);
        boolean r = checkHeightBalance(root.right, rightHeighteight);
        int leftHeight = leftHeighteight.height, rightHeight = rightHeighteight.height;

        height.height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

        if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2))
            return false;

        else
            return l && r;
    }

    public static void main(String args[]) {
        Height height = new Height();

        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new BalancedTreeNode(1);
        tree.root.left = new BalancedTreeNode(2);
        tree.root.right = new BalancedTreeNode(3);
        tree.root.left.left = new BalancedTreeNode(4);
        tree.root.left.right = new BalancedTreeNode(5);

        if (tree.checkHeightBalance(tree.root, height))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }
}