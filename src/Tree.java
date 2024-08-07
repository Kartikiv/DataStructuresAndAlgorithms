import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Tree {
    TreeNode root;
   public void add(int data){

       root = addRec(root,data);
   }

    public TreeNode addRec(TreeNode node , int data){
     if(node==null)
         node = new TreeNode(data);
     else if(data< node.data)
         node.left= addRec(node.left, data);
     else if(data > node.data)
         node.right= addRec(node.right, data);

       return  node; }
    public Boolean Delete(){

   return null; }
    public void inorderTraversal(TreeNode root){
        if (root == null) {
            return ;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }
    public void preOrderTraversal(TreeNode root){

        if (root == null) {
            return ;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    public void postOrderTraversal(TreeNode root){
        if (root == null) {
            return ;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);

    }
    public void levelOrderTraversal(TreeNode node){
        Queue <TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            System.out.println(q.peek().data);
            if( q.peek()!=null && q.peek().left!=null){
              q.add(q.peek().left);
            }
            if(q.peek()!=null && q.peek().right!=null){
                q.add(q.peek().right);
            }
            q.remove();
        }


    }

    public int height(TreeNode node){
       int x , y =0;
       if(node == null){
           return 0;
       }
       x= height(node.right);
       y= height(node.left);
       if(x>y){
           return x+1;
       }else{
           return y+1;
       }

    }

    public int count (TreeNode node){
        if(node == null){
            return 0;
        }

        return count(node.left)+ count(node.right)+1;
    }
}