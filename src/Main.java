public class Main {
    public static void main(String[] args) {
        Tree myTree = new Tree();

        myTree.add(10);
        myTree.add(12);
        myTree.add(5);
        myTree.add(3);
        myTree.add(8);

        //myTree.inorderTraversal(myTree.root);
        myTree.levelOrderTraversal(myTree.root);
        System.out.println( "Height of the tree " +myTree.height(myTree.root));
        System.out.println( "count of the tree " +myTree.count(myTree.root));
    }
}
