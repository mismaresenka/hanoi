package BST;

public abstract class bstAbstract {

    //delcaring methods

    protected abstract TreeNode insert(TreeNode root, int data);

    protected abstract boolean search(TreeNode root, int data);

    // for assigning nodes
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
