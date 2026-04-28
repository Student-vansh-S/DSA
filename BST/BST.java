import java.util.ArrayList;

public class BST {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static TreeNode insert(TreeNode root , int val){
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left =insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val +" ");
        inOrder(root.right);
    }

    public static boolean search(TreeNode root , int key){
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;    
        }
        if (root.val > key) {
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }
    public static TreeNode delete(TreeNode root , int key){
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = delete(root.right, key);
        }
        else if (root.val > key) {
            root.left = delete(root.left, key);
        }
        else{ // root == key
            // case 1 - leaf node 
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 - single child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // case 3 - both children
            TreeNode IS = findInorderSuccessor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;
    }
    public static TreeNode findInorderSuccessor(TreeNode root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(TreeNode root, int k1, int k2){
        if (root == null) {
            return;
        }
        if (k1 <= root.val && k2 >= root.val ) {
            printInRange(root.left, k1, k2);
            System.out.print(root.val+" ");
            printInRange(root.right, k1, k2);
        }
        else if (root.val < k1) {
            printInRange(root.left, k1, k2);
        } else{
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }

    public static void pathRootToLeaf(TreeNode root, ArrayList<Integer> path){
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        pathRootToLeaf(root.left,path);
        pathRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValid(TreeNode root, TreeNode min , TreeNode max){
        if (root==null) {
            return true;
        }
        if (min!= null && root.val <= min.val) {
            return false;
        }
        else if(max!= null && root.val >= max.val){
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        TreeNode root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        // inOrder(root);
        // if (!search(root, 2)) {
        //     System.out.println("Not Found");
        // }else{
        //     System.out.println("Found");
        // }
        // root = delete(root,10);
        // System.out.println();
        // inOrder(root);
        // printInRange(root, 5, 12);
        // pathRootToLeaf(root,new ArrayList<>());
        System.out.println(isValid(root, null, null));
    }
}
