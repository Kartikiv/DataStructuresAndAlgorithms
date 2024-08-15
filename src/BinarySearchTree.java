public class BinarySearchTree {

    TreeNode root;


    public void add(int data) {

        root = addRec(root, data);
    }

    public TreeNode addRec(TreeNode node, int data) {
        if (node == null)
            node = new TreeNode(data);
        else if (data < node.data)
            node.left = addRec(node.left, data);
        else if (data > node.data)
            node.right = addRec(node.right, data);

        return node;
    }

    public int height(TreeNode node) {
        int x, y = 0;
        if (node == null) {
            return 0;
        }
        x = height(node.right);
        y = height(node.left);
        if (x > y) {
            return x + 1;
        } else {
            return y + 1;
        }

    }

    public int count (TreeNode node){
        if(node == null){
            return 0;
        }

        return count(node.left)+ count(node.right)+1;
    }

    public TreeNode delete(TreeNode node, int data){
        // Delete in the most difficult task in a binary search tree
        // there are three case of deletion
        // Case 1 : if the node is a leaf node that is node.left and node.right are null then simply remove that node.
        // Case 2 : if the node has a single child we replace the position of the child node to the position of the node
        // to be deleted and delete the child node.
        // Case 3 : if the child has two children
        if(node == null ) return null;

        if(node.left== null) return delete(node.right, data);

        if(node.right == null) return  delete(node.left, data);

        TreeNode p = null;
        if (height(root.left) > height(root.right)) {
            p = inorderPredecessor(root.left);

            root.data = p.data;
            root.left = delete(root.left, p.data);
        } else {
            p = inorderSuccessorD(root.right);
            root.data = p.data;
            root.right = delete(root.right, p.data);
        }

        if (root.data < data) {
            // find target in right subtree if root->val < key
            root.right = delete(root.right, data);
        } else {
            // find target in left subtree if root->val > key
            root.left = delete(root.left, data);
        }
        return root;
    }



    private TreeNode inorderPredecessor(TreeNode root) {
        while (root != null && root.right != null) {
            root = root.right;

        }
        return root;
    }
    public TreeNode inorderSuccessorD(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;

        }
        return root;
    }


        TreeNode prevNode=null;
    TreeNode left = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode node = preSearch(root , p);
        TreeNode lmcRight = helper(node.right);
        if(lmcRight == null){
            return prevNode;
        }else{
            return lmcRight;
        }
    }


    public TreeNode preSearch(TreeNode root ,TreeNode p){
        if(root == null ) return null;

        if(root.data == p.data){
            return root;
        }else  if(root.data >= p.data){
            prevNode=root;
            return preSearch(root.left , p);
        } else{
            return preSearch(root.right , p);

        }

    }



    public TreeNode helper (TreeNode root){
        while (root!=null){
            left = root;
            root = root.left;
        }

        return left ; }






}



