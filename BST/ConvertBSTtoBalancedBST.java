import java.util.ArrayList;

public class ConvertBSTtoBalancedBST {
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
    public static void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static TreeNode createBST(ArrayList<Integer> al, int st, int end){
        if (st>end) {
            return null;
        }
        int mid = st+(end-st)/2;
        TreeNode root = new TreeNode(al.get(mid));
        root.left = createBST(al, st, mid-1);
        root.right= createBST(al, mid+1, end);
        return root;
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> al){
        if (root == null) {
            return;
        }
        inOrder(root.left, al);
        al.add(root.val);
        inOrder(root.right, al);
    }

    public static TreeNode balanceBST(TreeNode root){
        //inorder sequence
        ArrayList<Integer> al = new ArrayList<>();
        inOrder(root, al);

        //inorder ( create )-> balanced BST
        root = createBST(al, 0, al.size()-1);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(12);

        root = balanceBST(root);
        preOrder(root);
    }
}
