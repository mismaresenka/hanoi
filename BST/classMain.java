package BST;

public class classMain {
    public static void main(String[] args) {
        bstMethods bst = new bstMethods();

        // Insert nodes into the BST
        bst.root = bst.insert(bst.root, 90);
        bst.root = bst.insert(bst.root, 12);
        bst.root = bst.insert(bst.root, 33);
        bst.root = bst.insert(bst.root, 7);
        bst.root = bst.insert(bst.root, 63);

        // Search for a node
        System.out.println("Search for 33: " + bst.search(bst.root, 33));

        // Count nodes
        System.out.println("Total number of nodes: " + bst.countNodes());

        // Tree level
        System.out.println("Tree level: " + bst.treeLevel());

        // Height of the tree
        System.out.println("Height of the tree: " + bst.getHeight());

        // Depth of a particular node
        int dataToFind = 33;
        System.out.println("Depth of node with data " + dataToFind + ": " + bst.getDepth(dataToFind));
    }
}
