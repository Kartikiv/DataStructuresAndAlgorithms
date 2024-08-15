// Node class for AVL Tree storing integer data
class AVLNode {
    int data;
    int height;
    AVLNode left;
    AVLNode right;

    public AVLNode(int data) {
        this.data = data;
        this.height = 1; // New nodes are initially added at leaf
    }
}

// AVL Tree ADT for integers
public class AVLTree {
    private AVLNode root;

    // Get the height of the node
    private int height(AVLNode node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get the balance factor of the node
    private int getBalance(AVLNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate the subtree rooted with y (LL Rotation)
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return the new root
        return x;
    }

    // Left rotate the subtree rooted with x (RR Rotation)
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return the new root
        return y;
    }

    // Insert a node into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive function to insert a node and balance the tree
    private AVLNode insert(AVLNode node, int key) {
        // 1. Perform the normal BST insert
        if (node == null)
            return new AVLNode(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else // Duplicate keys are not allowed in BST
            return node;

        // 2. Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // LL Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to print in-order traversal of the tree
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    // Recursive function to perform in-order traversal
    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Find the node with the minimum value in the tree
    private AVLNode findMin(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node from the AVL tree
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive function to delete a node and balance the tree
    private AVLNode delete(AVLNode root, int key) {
        // Perform standard BST delete
        if (root == null)
            return root;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                AVLNode temp = findMin(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = delete(root.right, temp.data);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // Update height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor of this node
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // LL Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
