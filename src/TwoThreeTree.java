class TwoThreeNode {
    int[] keys = new int[2];  // To store one or two keys
    TwoThreeNode[] children = new TwoThreeNode[3];  // To store two or three children
    int numKeys = 0;  // Number of keys in the node

    // Constructor
    public TwoThreeNode(int key) {
        keys[0] = key;
        numKeys = 1;
    }
}
public class TwoThreeTree {
    private TwoThreeNode root;

    // Insert a key into the 2-3 Tree
    public void insert(int key) {
        if (root == null) {
            root = new TwoThreeNode(key);
        } else {
            TwoThreeNode newRoot = insert(root, key);
            if (newRoot != null) {
                // Root was split, create a new root
                TwoThreeNode oldRoot = root;
                root = new TwoThreeNode(newRoot.keys[0]);
                root.children[0] = oldRoot;
                root.children[1] = newRoot;
            }
        }
    }

    // Recursive function to insert a key into the 2-3 Tree
    private TwoThreeNode insert(TwoThreeNode twoThreeNode, int key) {
        if (twoThreeNode.children[0] == null) {  // Leaf node
            return addKeyToNode(twoThreeNode, key, null);
        }

        // Determine which child to recurse into
        TwoThreeNode splitTwoThreeNode = null;
        if (key < twoThreeNode.keys[0]) {
            splitTwoThreeNode = insert(twoThreeNode.children[0], key);
        } else if (twoThreeNode.numKeys == 1 || key < twoThreeNode.keys[1]) {
            splitTwoThreeNode = insert(twoThreeNode.children[1], key);
        } else {
            splitTwoThreeNode = insert(twoThreeNode.children[2], key);
        }

        if (splitTwoThreeNode != null) {
            return addKeyToNode(twoThreeNode, splitTwoThreeNode.keys[0], splitTwoThreeNode);
        }

        return null;
    }

    // Add a key to the node; split if necessary
    private TwoThreeNode addKeyToNode(TwoThreeNode twoThreeNode, int key, TwoThreeNode child) {
        if (twoThreeNode.numKeys == 1) {
            // No need to split the node
            if (key < twoThreeNode.keys[0]) {
                twoThreeNode.keys[1] = twoThreeNode.keys[0];
                twoThreeNode.keys[0] = key;
                twoThreeNode.children[2] = twoThreeNode.children[1];
                twoThreeNode.children[1] = child;
            } else {
                twoThreeNode.keys[1] = key;
                twoThreeNode.children[2] = child;
            }
            twoThreeNode.numKeys++;
            return null;
        } else {
            // Node needs to be split
            TwoThreeNode newTwoThreeNode = new TwoThreeNode(0);
            if (key < twoThreeNode.keys[0]) {
                newTwoThreeNode.keys[0] = twoThreeNode.keys[1];
                twoThreeNode.keys[1] = 0;
                twoThreeNode.numKeys = 1;
                newTwoThreeNode.children[0] = twoThreeNode.children[1];
                newTwoThreeNode.children[1] = twoThreeNode.children[2];
                twoThreeNode.children[1] = child;
                twoThreeNode.children[2] = null;
                twoThreeNode.keys[1] = 0;
            } else if (key < twoThreeNode.keys[1]) {
                newTwoThreeNode.keys[0] = twoThreeNode.keys[1];
                twoThreeNode.keys[1] = 0;
                twoThreeNode.numKeys = 1;
                newTwoThreeNode.children[0] = child;
                newTwoThreeNode.children[1] = twoThreeNode.children[2];
                twoThreeNode.children[2] = null;
            } else {
                newTwoThreeNode.keys[0] = key;
                newTwoThreeNode.children[0] = twoThreeNode.children[2];
                newTwoThreeNode.children[1] = child;
                twoThreeNode.children[2] = null;
            }
            return newTwoThreeNode;
        }
    }

    // In-order traversal of the 2-3 Tree
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TwoThreeNode twoThreeNode) {
        if (twoThreeNode == null) return;
        if (twoThreeNode.numKeys == 1) {
            inOrder(twoThreeNode.children[0]);
            System.out.print(twoThreeNode.keys[0] + " ");
            inOrder(twoThreeNode.children[1]);
        } else if (twoThreeNode.numKeys == 2) {
            inOrder(twoThreeNode.children[0]);
            System.out.print(twoThreeNode.keys[0] + " ");
            inOrder(twoThreeNode.children[1]);
            System.out.print(twoThreeNode.keys[1] + " ");
            inOrder(twoThreeNode.children[2]);
        }
    }
}
