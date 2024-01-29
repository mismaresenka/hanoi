package BST;

public class bstMethods extends bstAbstract {

    protected TreeNode root;

    //for inputing and assigning nodes

    @Override
    protected TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    //search method

    @Override
    protected boolean search(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
    //count method
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    //tree level method
    public int treeLevel() {
        return treeLevel(root);
    }

    private int treeLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftLevel = treeLevel(node.left);
        int rightLevel = treeLevel(node.right);

        return 1 + Math.max(leftLevel, rightLevel);
    }
    //getting height method
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    //getting depth method
    public int getDepth(int data) {
        return getDepth(root, data, 0);
    }

    private int getDepth(TreeNode node, int data, int depth) {
        if (node == null) {
            return -1; // Node not found
        }

        if (data == node.data) {
            return depth;
        } else if (data < node.data) {
            return getDepth(node.left, data, depth + 1);
        } else {
            return getDepth(node.right, data, depth + 1);
        }
    }
}
